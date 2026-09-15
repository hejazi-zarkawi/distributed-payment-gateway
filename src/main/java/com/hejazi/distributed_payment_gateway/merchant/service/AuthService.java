package com.hejazi.distributed_payment_gateway.merchant.service;

import com.hejazi.distributed_payment_gateway.merchant.dto.request.LoginRequest;
import com.hejazi.distributed_payment_gateway.merchant.dto.request.MerchantSignupRequest;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.LoginResponse;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.MerchantResponse;
import jakarta.validation.Valid;

public interface AuthService {
     MerchantResponse signup(MerchantSignupRequest request);

    LoginResponse login( LoginRequest request);
}
