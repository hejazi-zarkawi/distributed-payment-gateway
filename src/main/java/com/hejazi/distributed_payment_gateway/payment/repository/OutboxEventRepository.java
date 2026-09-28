package com.hejazi.distributed_payment_gateway.payment.repository;

import com.hejazi.distributed_payment_gateway.common.enums.OutboxStatus;
import com.hejazi.distributed_payment_gateway.payment.entity.OutboxEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OutboxEventRepository extends JpaRepository<OutboxEvent, UUID> {
    List<OutboxEvent> findByStatusOrderByCreatedAtAsc(OutboxStatus status);
}
