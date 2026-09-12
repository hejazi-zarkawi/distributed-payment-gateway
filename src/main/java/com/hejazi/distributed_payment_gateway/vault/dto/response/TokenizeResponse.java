package com.hejazi.distributed_payment_gateway.vault.dto.response;

import com.hejazi.distributed_payment_gateway.common.enums.CardBrand;

public record TokenizeResponse(
        String token,
        String lastFour,
        CardBrand brand,
        Integer expiryMonth,
        Integer expiryYear
) {
}
