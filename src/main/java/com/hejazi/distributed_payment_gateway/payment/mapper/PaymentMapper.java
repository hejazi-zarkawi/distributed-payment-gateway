package com.hejazi.distributed_payment_gateway.payment.mapper;

import com.hejazi.distributed_payment_gateway.payment.dto.response.PaymentResponse;
import com.hejazi.distributed_payment_gateway.payment.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaymentMapper {
    @Mapping(target = "orderId", source = "order.id")
    PaymentResponse toResponse(Payment payment);

    @Mapping(target = "orderId", source = "order.id")
    List<PaymentResponse> toResponseList(List<Payment> paymentList);
}
