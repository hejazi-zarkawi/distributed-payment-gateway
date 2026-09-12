package com.hejazi.distributed_payment_gateway.vault.repository;

import com.hejazi.distributed_payment_gateway.vault.entity.VaultCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VaultCardRepository extends JpaRepository<VaultCard, UUID> {
}
