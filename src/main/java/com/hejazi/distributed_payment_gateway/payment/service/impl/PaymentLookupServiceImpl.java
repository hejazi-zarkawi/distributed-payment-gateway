package com.hejazi.distributed_payment_gateway.payment.service.impl;

import com.hejazi.distributed_payment_gateway.common.enums.PaymentStatus;
import com.hejazi.distributed_payment_gateway.payment.api.PaymentLookupService;
import com.hejazi.distributed_payment_gateway.payment.entity.Payment;
import com.hejazi.distributed_payment_gateway.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentLookupServiceImpl implements PaymentLookupService {
    private final PaymentRepository paymentRepository;

    @Override
    public List<Payment> findUnsettledCapturedPayments(UUID merchantId) {
        return paymentRepository.findByMerchantIdAndStatusForUpdate(merchantId, PaymentStatus.CAPTURED);
    }
}
