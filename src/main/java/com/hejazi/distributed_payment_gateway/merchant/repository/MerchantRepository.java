package com.hejazi.distributed_payment_gateway.merchant.repository;

import com.hejazi.distributed_payment_gateway.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MerchantRepository extends JpaRepository<Merchant, UUID> {

    boolean existsByEmail(String email);
}
