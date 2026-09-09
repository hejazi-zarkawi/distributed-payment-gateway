package com.hejazi.distributed_payment_gateway.payment.config;

import com.hejazi.distributed_payment_gateway.common.enums.PaymentMethod;
import com.hejazi.distributed_payment_gateway.payment.gateway.PaymentAdapter;
import com.hejazi.distributed_payment_gateway.payment.gateway.adapter.CardPaymentAdapter;
import com.hejazi.distributed_payment_gateway.payment.gateway.adapter.NetBankingAdapter;
import com.hejazi.distributed_payment_gateway.payment.gateway.adapter.UPIPaymentAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class PaymentAdapterConfig {

    private final NetBankingAdapter netBankingAdapter;
    private final CardPaymentAdapter cardPaymentAdapter;
    private final UPIPaymentAdapter upiPaymentAdapter;
    @Bean
    public Map<PaymentMethod, PaymentAdapter> paymentAdapterMap() {
        return Map.of(
                PaymentMethod.CARD, cardPaymentAdapter,
                PaymentMethod.NETBANKING, netBankingAdapter,
                PaymentMethod.UPI, upiPaymentAdapter
        );
    }
}
