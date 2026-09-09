package com.hejazi.distributed_payment_gateway.payment.repository;

import com.hejazi.distributed_payment_gateway.payment.entity.OrderRecord;
import com.hejazi.distributed_payment_gateway.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    List<Payment> findByOrder_Id(OrderRecord order);

    Optional<Payment> findByIdAndMerchantId(UUID paymentId, UUID merchantId);
}
