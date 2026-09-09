package com.hejazi.distributed_payment_gateway.payment.gateway.adapter;

import com.hejazi.distributed_payment_gateway.payment.dto.response.PaymentResponse;
import com.hejazi.distributed_payment_gateway.payment.gateway.PaymentAdapter;
import com.hejazi.distributed_payment_gateway.payment.gateway.dto.PaymentRequest;
import com.hejazi.distributed_payment_gateway.payment.gateway.dto.PaymentResult;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CardPaymentAdapter implements PaymentAdapter {
    @Override
    public PaymentResult initiate(PaymentRequest request) {
        return null;
    }

    @Override
    public PaymentResult capture(UUID paymentId) {
        return null;
    }
}
