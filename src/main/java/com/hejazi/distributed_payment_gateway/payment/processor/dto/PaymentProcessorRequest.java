package com.hejazi.distributed_payment_gateway.payment.processor.dto;

import com.hejazi.distributed_payment_gateway.common.entity.Money;
import com.hejazi.distributed_payment_gateway.common.enums.PaymentMethod;

import java.util.Map;

public record PaymentProcessorRequest(
        PaymentMethod method,
        Money amount,
        Map<String, Object> methodDetails
) {
}
