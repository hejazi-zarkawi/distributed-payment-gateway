package com.hejazi.distributed_payment_gateway.payment.service.impl;

import com.hejazi.distributed_payment_gateway.common.enums.OrderStatus;
import com.hejazi.distributed_payment_gateway.common.enums.PaymentStatus;
import com.hejazi.distributed_payment_gateway.common.exception.BusinessRuleViolationException;
import com.hejazi.distributed_payment_gateway.common.exception.ResourceNotFoundException;
import com.hejazi.distributed_payment_gateway.payment.dto.request.PaymentInitRequest;
import com.hejazi.distributed_payment_gateway.payment.dto.response.PaymentResponse;
import com.hejazi.distributed_payment_gateway.payment.entity.OrderRecord;
import com.hejazi.distributed_payment_gateway.payment.entity.Payment;
import com.hejazi.distributed_payment_gateway.payment.gateway.PaymentGatewayRouter;
import com.hejazi.distributed_payment_gateway.payment.gateway.dto.PaymentRequest;
import com.hejazi.distributed_payment_gateway.payment.gateway.dto.PaymentResult;
import com.hejazi.distributed_payment_gateway.payment.mapper.PaymentMapper;
import com.hejazi.distributed_payment_gateway.payment.repository.OrderRepository;
import com.hejazi.distributed_payment_gateway.payment.repository.PaymentRepository;
import com.hejazi.distributed_payment_gateway.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final PaymentGatewayRouter paymentGatewayRouter;
    private final PaymentMapper paymentMapper;
    @Override
    public PaymentResponse initiate(UUID merchantId, PaymentInitRequest request) {
        OrderRecord order = orderRepository.findByIdAndMerchantId(request.orderId(), merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("Order", request.orderId()));

        if(order.getOrderStatus() != OrderStatus.CREATED && order.getOrderStatus() != OrderStatus.ATTEMPTED) {
            throw new BusinessRuleViolationException("ORDER_NOT_PAYABLE",
                    "Order cannot accept payment in status: "+order.getOrderStatus());
        }

        order.setOrderStatus(OrderStatus.ATTEMPTED);
        order.setAttempts(order.getAttempts()+1);

        Payment payment = Payment.builder()
                .order(order)
                .merchantId(merchantId)
                .amount(order.getAmount())
                .status(PaymentStatus.CREATED)
                .method(request.method())
                .methodDetails(request.methodDetails())
                .build();
        payment = paymentRepository.save(payment);

        PaymentRequest paymentRequest = new PaymentRequest(payment.getId(),
                request.orderId(), merchantId,
                order.getAmount(), request.method(),
                request.methodDetails());

        PaymentResult result = paymentGatewayRouter.initiate(paymentRequest);

        switch (result) {
            case PaymentResult.Pending pending -> payment.setProcessorReference(pending.registrationRef());
            case PaymentResult.Failure failure -> {
                payment.setStatus(PaymentStatus.FAILED);
                payment.setErrorCode(failure.errorCode());
                payment.setErrorDescription(failure.errorDescription());
            }
        }

        payment= paymentRepository.save(payment);
        orderRepository.save(order);

        return paymentMapper.toResponse(payment);
    }
}
