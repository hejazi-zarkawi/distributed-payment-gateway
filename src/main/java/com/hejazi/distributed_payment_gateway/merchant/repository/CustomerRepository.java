package com.hejazi.distributed_payment_gateway.merchant.repository;

import com.hejazi.distributed_payment_gateway.merchant.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    Optional<Customer> findByMerchant_IdAndEmail(UUID merchantId, String email);
}
