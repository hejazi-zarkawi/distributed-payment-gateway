package com.hejazi.distributed_payment_gateway.merchant.service;

import com.hejazi.distributed_payment_gateway.merchant.dto.request.CreateApiKeyRequest;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.ApiKeyResponse;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.CreateApiKeyResponse;
import com.hejazi.distributed_payment_gateway.merchant.entity.ApiKey;
import org.antlr.v4.runtime.ListTokenSource;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
    CreateApiKeyResponse create(UUID merchantId, CreateApiKeyRequest request);

    List<ApiKeyResponse> listByMerchant(UUID merchantId);

    void revoke(UUID merchantId, UUID keyId);


    @Nullable CreateApiKeyResponse rotate(UUID merchantId, UUID keyId);
}
