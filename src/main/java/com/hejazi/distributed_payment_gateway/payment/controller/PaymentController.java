package com.hejazi.distributed_payment_gateway.payment.controller;

import com.hejazi.distributed_payment_gateway.payment.dto.request.PaymentInitRequest;
import com.hejazi.distributed_payment_gateway.payment.dto.response.PaymentResponse;
import com.hejazi.distributed_payment_gateway.payment.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/v1/payments")
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    UUID merchantId = UUID.fromString("5b162c2a-7b6c-42d9-bb38-2eec4856c1e4"); //TODO: replace it with MerchantContext

    @PostMapping
    public ResponseEntity<PaymentResponse> initiate(@Valid @RequestBody PaymentInitRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(paymentService.initiate(merchantId, request));
    }

    @PostMapping("/{paymentId}/capture")
    public ResponseEntity<PaymentResponse> capture(@PathVariable UUID paymentId) {
        return ResponseEntity.ok(paymentService.capture(merchantId, paymentId));
    }

}
