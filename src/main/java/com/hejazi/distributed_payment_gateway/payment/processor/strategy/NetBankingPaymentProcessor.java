package com.hejazi.distributed_payment_gateway.payment.processor.strategy;

import com.hejazi.distributed_payment_gateway.payment.processor.PaymentProcessor;
import com.hejazi.distributed_payment_gateway.payment.processor.dto.PaymentProcessorRequest;
import com.hejazi.distributed_payment_gateway.payment.processor.dto.PaymentProcessorResponse;

public class NetBankingPaymentProcessor implements PaymentProcessor {
    @Override
    public PaymentProcessorResponse charge(PaymentProcessorRequest request) {
        return null;
    }
}
