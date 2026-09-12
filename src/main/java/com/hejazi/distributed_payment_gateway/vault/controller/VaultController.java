package com.hejazi.distributed_payment_gateway.vault.controller;

import com.hejazi.distributed_payment_gateway.vault.dto.request.TokenizeRequest;
import com.hejazi.distributed_payment_gateway.vault.dto.response.TokenizeResponse;
import com.hejazi.distributed_payment_gateway.vault.service.VaultService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("v1/vault")
@RequiredArgsConstructor
public class VaultController {

    private final VaultService vaultService;
    UUID merchantId = UUID.fromString("5b162c2a-7b6c-42d9-bb38-2eec4856c1e4"); //TODO: replace it with MerchantContext


    @PostMapping("/tokenize")
    public ResponseEntity<TokenizeResponse> tokenize(@Valid @RequestBody TokenizeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vaultService.tokenize(request, merchantId));
    }
}
