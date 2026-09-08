package com.hejazi.distributed_payment_gateway.payment.processor;

import com.hejazi.distributed_payment_gateway.payment.processor.dto.PaymentProcessorRequest;
import com.hejazi.distributed_payment_gateway.payment.processor.dto.PaymentProcessorResponse;

public interface PaymentProcessor {

    PaymentProcessorResponse charge(PaymentProcessorRequest request);
}
