package com.hejazi.distributed_payment_gateway.operations.entity;

import com.hejazi.distributed_payment_gateway.common.entity.BaseEntity;
import jakarta.persistence.Embeddable;

import java.util.UUID;
@Embeddable
public class SettlementPaymentId extends BaseEntity {
    private UUID settlementId;

    private UUID paymentId;
}
