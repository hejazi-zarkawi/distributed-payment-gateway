package com.hejazi.distributed_payment_gateway.merchant.service.impl;

import com.hejazi.distributed_payment_gateway.common.exception.ResourceNotFoundException;
import com.hejazi.distributed_payment_gateway.merchant.dto.request.CreateApiKeyRequest;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.CreateApiKeyResponse;
import com.hejazi.distributed_payment_gateway.merchant.entity.ApiKey;
import com.hejazi.distributed_payment_gateway.merchant.entity.Merchant;
import com.hejazi.distributed_payment_gateway.merchant.repository.ApiKeyRepository;
import com.hejazi.distributed_payment_gateway.merchant.repository.MerchantRepository;
import com.hejazi.distributed_payment_gateway.merchant.service.ApiKeyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class ApiKeyServiceImpl implements ApiKeyService {

    private final MerchantRepository merchantRepository;
    private final ApiKeyRepository apiKeyRepository;
    @Override
    public CreateApiKeyResponse create(UUID merchantId, CreateApiKeyRequest request) {
        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new ResourceNotFoundException("merchant", merchantId));

        String keyId = "rzp_"+request.environment().name().toUpperCase()+"big_random_string";
        String rawSecret = "big_random_secret"; // TODO: replace with cryptographic random hex
//        a-z,A-Z,0-9,-,_
//        a-z,0-9

        ApiKey apiKey = ApiKey.builder()
                .merchant(merchant)
                .keyId(keyId)
                .keySecretHash(rawSecret) // TODO: encode with BcryptPasswordEncoder
                .environment(request.environment())
                .build();

        apiKey = apiKeyRepository.save(apiKey);

        return new CreateApiKeyResponse(apiKey.getId(), keyId, rawSecret, request.environment());
    }
}
