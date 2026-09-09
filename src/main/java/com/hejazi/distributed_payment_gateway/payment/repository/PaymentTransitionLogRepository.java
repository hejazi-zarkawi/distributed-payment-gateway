package com.hejazi.distributed_payment_gateway.payment.repository;

import com.hejazi.distributed_payment_gateway.payment.entity.PaymentTransitionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentTransitionLogRepository extends JpaRepository<PaymentTransitionLog, UUID> {
}
