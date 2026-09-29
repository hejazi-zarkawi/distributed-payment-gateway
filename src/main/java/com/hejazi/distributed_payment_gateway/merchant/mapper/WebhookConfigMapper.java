package com.hejazi.distributed_payment_gateway.merchant.mapper;

import com.hejazi.distributed_payment_gateway.merchant.dto.response.WebhookConfigResponse;
import com.hejazi.distributed_payment_gateway.merchant.entity.MerchantWebhookConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface WebhookConfigMapper {
    @Mapping(target = "webhookSecret", source = "rawSecret")
    WebhookConfigResponse toResponse(MerchantWebhookConfig merchantWebhookConfig, String rawSecret);
}
