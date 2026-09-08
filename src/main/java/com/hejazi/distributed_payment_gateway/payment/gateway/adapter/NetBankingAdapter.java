package com.hejazi.distributed_payment_gateway.payment.gateway.adapter;

import com.hejazi.distributed_payment_gateway.payment.dto.response.PaymentResponse;
import com.hejazi.distributed_payment_gateway.payment.gateway.PaymentAdapter;
import com.hejazi.distributed_payment_gateway.payment.gateway.dto.PaymentRequest;

public class NetBankingAdapter implements PaymentAdapter {
    @Override
    public PaymentResponse initiate(PaymentRequest request) {
        return null;
    }
}
