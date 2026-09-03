package com.hejazi.distributed_payment_gateway.merchant.dto.request;

import com.hejazi.distributed_payment_gateway.common.enums.Environment;

public record CreateApiKeyRequest(Environment environment) {
}
