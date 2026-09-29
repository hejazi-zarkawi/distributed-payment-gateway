package com.hejazi.distributed_payment_gateway.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.AesGcmBytesEncryptor;
import org.springframework.security.crypto.encrypt.BytesEncryptor;

import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Configuration
public class AesEncryptionConfig {
    @Value("${vault.master-key}")
    private String masterKey;

    @Bean
    public BytesEncryptor dekEncrypter() {
        byte[] masterKeyBytes = Base64.getDecoder().decode(masterKey);
        SecretKeySpec masterDecKey = new SecretKeySpec(masterKeyBytes, "AES");
        return AesGcmBytesEncryptor.withSecretKey(masterDecKey).build();
    }
}
