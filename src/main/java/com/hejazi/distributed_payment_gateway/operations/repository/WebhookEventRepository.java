package com.hejazi.distributed_payment_gateway.operations.repository;

import com.hejazi.distributed_payment_gateway.common.enums.WebhookEventStatus;
import com.hejazi.distributed_payment_gateway.operations.entity.WebhookEvent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface WebhookEventRepository extends JpaRepository<WebhookEvent, UUID> {
    List<WebhookEvent> findByStatusAndNextRetryAtBefore(WebhookEventStatus webhookEventStatus, LocalDateTime now);
}
