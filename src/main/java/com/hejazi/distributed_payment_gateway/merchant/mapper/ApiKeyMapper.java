package com.hejazi.distributed_payment_gateway.merchant.mapper;

import com.hejazi.distributed_payment_gateway.merchant.dto.response.ApiKeyResponse;
import com.hejazi.distributed_payment_gateway.merchant.dto.response.CreateApiKeyResponse;
import com.hejazi.distributed_payment_gateway.merchant.entity.ApiKey;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ApiKeyMapper {
    List<ApiKeyResponse> toResponseList(List<ApiKey> apiKeyList);
}
