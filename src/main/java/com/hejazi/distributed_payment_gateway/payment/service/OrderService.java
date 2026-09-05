package com.hejazi.distributed_payment_gateway.payment.service;

import com.hejazi.distributed_payment_gateway.payment.dto.request.CreateOrderRequest;
import com.hejazi.distributed_payment_gateway.payment.dto.response.OrderResponse;

import java.util.UUID;

public interface OrderService {
    OrderResponse create(UUID merchantId, CreateOrderRequest request);
}
