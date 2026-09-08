package com.hejazi.distributed_payment_gateway.payment.service;

import com.hejazi.distributed_payment_gateway.payment.dto.request.PaymentInitRequest;
import com.hejazi.distributed_payment_gateway.payment.dto.response.PaymentResponse;

import java.util.UUID;

public interface PaymentService {

    PaymentResponse initiate(UUID merchantId, PaymentInitRequest request)
}
