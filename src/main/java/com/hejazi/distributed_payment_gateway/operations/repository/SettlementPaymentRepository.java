package com.hejazi.distributed_payment_gateway.operations.repository;

import com.hejazi.distributed_payment_gateway.operations.entity.SettlementPayment;
import com.hejazi.distributed_payment_gateway.operations.entity.SettlementPaymentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettlementPaymentRepository extends JpaRepository<SettlementPayment, SettlementPaymentId> {
}
