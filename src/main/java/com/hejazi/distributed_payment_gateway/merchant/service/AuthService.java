package com.hejazi.distributed_payment_gateway.merchant.service;

import com.hejazi.distributed_payment_gateway.merchant.dto.request.MerchantSignupRequest;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.MerchantResponse;

public interface AuthService {
     MerchantResponse signup(MerchantSignupRequest request);
}
