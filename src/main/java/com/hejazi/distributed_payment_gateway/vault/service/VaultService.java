package com.hejazi.distributed_payment_gateway.vault.service;

import com.hejazi.distributed_payment_gateway.common.entity.Money;
import com.hejazi.distributed_payment_gateway.payment.processor.dto.PaymentProcessorResponse;
import com.hejazi.distributed_payment_gateway.vault.dto.request.TokenizeRequest;
import com.hejazi.distributed_payment_gateway.vault.dto.response.TokenizeResponse;

import java.util.Map;
import java.util.UUID;

public interface VaultService {
    TokenizeResponse tokenize(TokenizeRequest request, UUID merchantId);
    PaymentProcessorResponse charge(UUID paymentId, String token, Money amount, Map<String, Object> methodDetails);
}
