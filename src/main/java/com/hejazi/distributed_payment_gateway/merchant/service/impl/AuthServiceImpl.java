package com.hejazi.distributed_payment_gateway.merchant.service.impl;

import com.hejazi.distributed_payment_gateway.common.enums.MerchantStatus;
import com.hejazi.distributed_payment_gateway.common.enums.UserRole;
import com.hejazi.distributed_payment_gateway.common.exception.DuplicateResourceException;
import com.hejazi.distributed_payment_gateway.merchant.dto.request.MerchantSignupRequest;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.MerchantResponse;
import com.hejazi.distributed_payment_gateway.merchant.entity.AppUser;
import com.hejazi.distributed_payment_gateway.merchant.entity.Merchant;
import com.hejazi.distributed_payment_gateway.merchant.mapper.MerchantMapper;
import com.hejazi.distributed_payment_gateway.merchant.repository.AppUserRepository;
import com.hejazi.distributed_payment_gateway.merchant.repository.MerchantRepository;
import com.hejazi.distributed_payment_gateway.merchant.service.AuthService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final MerchantRepository merchantRepository;
    private final AppUserRepository appUserRepository;

    private final MerchantMapper merchantMapper;
    @Override
    @Transactional
    public MerchantResponse signup(MerchantSignupRequest request) {
        if (merchantRepository.existsByEmail(request.email())) {
            throw new DuplicateResourceException("DUPLICATE_MERCHANT_EMAIL",
                    "Merchant with email already exists: " + request.email());
        }

        Merchant merchant = merchantMapper.toEntityFromSignUpRequest(request);
        merchant.setStatus(MerchantStatus.PENDING_KYC);
        merchant = merchantRepository.save(merchant);

        AppUser appUser = AppUser.builder()
                .email(request.email())
                .merchant(merchant)
                .passwordHash(request.password()) // TODO: encrypt using Bcrypt
                .role(UserRole.OWNER)
                .build();
        appUserRepository.save(appUser);

        return merchantMapper.toResponse(merchant);
    }
}
