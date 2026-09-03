package com.hejazi.distributed_payment_gateway.merchant.repository;

import com.hejazi.distributed_payment_gateway.merchant.entity.ApiKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
}
