package com.hejazi.distributed_payment_gateway.common.dto;

public record SettlementBankDetails(
        String accountNumber, String ifsc, String accountHolderName
) {
}
