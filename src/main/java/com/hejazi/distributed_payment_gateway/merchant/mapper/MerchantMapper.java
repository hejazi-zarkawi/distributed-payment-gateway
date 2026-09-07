package com.hejazi.distributed_payment_gateway.merchant.mapper;

import com.hejazi.distributed_payment_gateway.merchant.dto.request.MerchantSignupRequest;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.MerchantResponse;
import com.hejazi.distributed_payment_gateway.merchant.entity.Merchant;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MerchantMapper {
    Merchant toEntityFromSignUpRequest(MerchantSignupRequest request);

    MerchantResponse toResponse(Merchant merchant);
}
