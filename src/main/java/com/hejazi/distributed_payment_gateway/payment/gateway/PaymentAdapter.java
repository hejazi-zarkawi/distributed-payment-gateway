package com.hejazi.distributed_payment_gateway.payment.gateway;

import com.hejazi.distributed_payment_gateway.payment.dto.request.PaymentInitRequest;
import com.hejazi.distributed_payment_gateway.payment.dto.response.PaymentResponse;
import com.hejazi.distributed_payment_gateway.payment.gateway.dto.PaymentRequest;
import com.hejazi.distributed_payment_gateway.payment.gateway.dto.PaymentResult;

public interface PaymentAdapter {

    PaymentResult initiate(PaymentRequest request);
}
