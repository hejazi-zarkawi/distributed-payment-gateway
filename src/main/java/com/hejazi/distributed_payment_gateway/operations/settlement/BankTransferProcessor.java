package com.hejazi.distributed_payment_gateway.operations.settlement;

import com.hejazi.distributed_payment_gateway.common.entity.Money;
import com.hejazi.distributed_payment_gateway.operations.settlement.dto.BankTransferResult;

import java.util.UUID;

public interface BankTransferProcessor {
    BankTransferResult initiate(UUID settlementId, UUID merchantId, Money amount,
                                String bankAccount, String ifsc);
}
