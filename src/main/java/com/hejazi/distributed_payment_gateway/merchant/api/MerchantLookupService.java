package com.hejazi.distributed_payment_gateway.merchant.api;

import com.hejazi.distributed_payment_gateway.common.dto.SettlementBankDetails;
import com.hejazi.distributed_payment_gateway.common.dto.WebhookTarget;

import java.util.List;
import java.util.UUID;

public interface MerchantLookupService {
    List<WebhookTarget> getActiveConfigsForEvent(UUID merchantId, String eventType);

    List<UUID> listActiveMerchantIds();

    SettlementBankDetails getSettlementBankDetails(UUID merchantId);
}
