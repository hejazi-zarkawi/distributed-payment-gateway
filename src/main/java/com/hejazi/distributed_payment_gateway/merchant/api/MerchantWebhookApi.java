package com.hejazi.distributed_payment_gateway.merchant.api;

import com.hejazi.distributed_payment_gateway.common.dto.WebhookTarget;

import java.util.List;
import java.util.UUID;

public interface MerchantWebhookApi {
    List<WebhookTarget> getActiveConfigsForEvent(UUID merchantId, String eventType);
}
