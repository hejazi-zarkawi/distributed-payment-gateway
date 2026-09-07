package com.hejazi.distributed_payment_gateway.payment.service.impl;

import com.hejazi.distributed_payment_gateway.common.enums.OrderStatus;
import com.hejazi.distributed_payment_gateway.common.exception.BusinessRuleViolationException;
import com.hejazi.distributed_payment_gateway.common.exception.DuplicateResourceException;
import com.hejazi.distributed_payment_gateway.common.exception.ResourceNotFoundException;
import com.hejazi.distributed_payment_gateway.payment.dto.request.CreateOrderRequest;
import com.hejazi.distributed_payment_gateway.payment.dto.response.OrderResponse;
import com.hejazi.distributed_payment_gateway.payment.dto.response.PaymentResponse;
import com.hejazi.distributed_payment_gateway.payment.entity.OrderRecord;
import com.hejazi.distributed_payment_gateway.payment.entity.Payment;
import com.hejazi.distributed_payment_gateway.payment.mapper.OrderMapper;
import com.hejazi.distributed_payment_gateway.payment.mapper.PaymentMapper;
import com.hejazi.distributed_payment_gateway.payment.repository.OrderRepository;
import com.hejazi.distributed_payment_gateway.payment.repository.PaymentRepository;
import com.hejazi.distributed_payment_gateway.payment.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
        private final OrderRepository orderRepository;
        private final OrderMapper orderMapper;

        private final PaymentRepository paymentRepository;
        private final PaymentMapper paymentMapper;

        @Value("${payment.order.default-order-expiry-minutes:30}")
        private int defaultOrderExpiryMinutes;

        @Override
        @Transactional
        public OrderResponse create(UUID merchantId, CreateOrderRequest request) {
            if (request.receipt() != null && orderRepository.existsByMerchantIdAndReceipt(merchantId, request.receipt())) {
                throw new DuplicateResourceException("ORDER_RECEIPT_DUPLICATE", "Order with receipt already exists: " + request.receipt());
            }

            OrderRecord order = OrderRecord.builder()
                    .receipt(request.receipt())
                    .amount(request.amount())
                    .notes(request.notes())

                    .merchantId(merchantId)
                    .orderStatus(OrderStatus.CREATED)
                    .expiresAt(request.expiresAt() != null ? request.expiresAt() :
                            LocalDateTime.now().plusMinutes(defaultOrderExpiryMinutes))
                    .build();

            order = orderRepository.save(order);

// TODO:        publish kafka event about order creation

            return new OrderResponse(order.getId(),
                    order.getMerchantId(),
                    order.getReceipt(), order.getAmount(),
                    order.getOrderStatus(), order.getAttempts(),
                    order.getNotes(), order.getExpiresAt(),
                    null);
        }

    @Override
    public OrderResponse getById(UUID merchantId, UUID orderId) {
        OrderRecord order = orderRepository.findByIdAndMerchantId(orderId, merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", orderId));
        return orderMapper.toResponse(order);
    }

    @Override
    @Transactional
    public OrderResponse cancel(UUID merchantId, UUID orderId) {
        OrderRecord order = orderRepository.findByIdAndMerchantId(orderId, merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", orderId));

        if(order.getOrderStatus() == OrderStatus.CANCELLED || order.getOrderStatus() == OrderStatus.PAID) {
            throw new BusinessRuleViolationException("ORDER_CANNOT_CANCEL",
                    "Cannot cancel order with status: "+order.getOrderStatus().name());
        }

        order.setOrderStatus(OrderStatus.CANCELLED);
        order = orderRepository.save(order);

        return orderMapper.toResponse(order);
    }

    @Override
    public List<PaymentResponse> listPayments(UUID merchantId, UUID orderId) {
        OrderRecord order = orderRepository.findByIdAndMerchantId(orderId, merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", orderId));

        List<Payment> paymentList = paymentRepository.findByOrder_Id(order);

//        return paymentList.stream().map(
//                payment -> paymentMapper.toResponse(payment)
//        ).collect(Collectors.toList());

        return paymentMapper.toResponseList(paymentList);
    }
}

