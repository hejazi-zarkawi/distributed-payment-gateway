package com.hejazi.distributed_payment_gateway.payment.api;

import com.hejazi.distributed_payment_gateway.payment.entity.Payment;

import java.util.List;
import java.util.UUID;

public interface PaymentLookupService {
    List<Payment> findUnsettledCapturedPayments(UUID merchantId);
}
