package com.hejazi.distributed_payment_gateway.operations.repository;

import com.hejazi.distributed_payment_gateway.common.enums.SettlementStatus;
import com.hejazi.distributed_payment_gateway.operations.entity.Settlement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SettlementRepository extends JpaRepository<Settlement, UUID> {
    List<Settlement> findByStatus(SettlementStatus settlementStatus);
}
