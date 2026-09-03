package com.hejazi.distributed_payment_gateway.merchant.repository;

import com.hejazi.distributed_payment_gateway.merchant.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
}
