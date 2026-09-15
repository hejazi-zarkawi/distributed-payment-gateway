package com.hejazi.distributed_payment_gateway.payment.config;

import com.hejazi.distributed_payment_gateway.common.enums.PaymentMethod;
import com.hejazi.distributed_payment_gateway.payment.gateway.adapter.CardPaymentAdapter;
import com.hejazi.distributed_payment_gateway.payment.gateway.adapter.NetBankingAdapter;
import com.hejazi.distributed_payment_gateway.payment.gateway.adapter.UPIPaymentAdapter;
import com.hejazi.distributed_payment_gateway.payment.processor.PaymentProcessor;
import com.hejazi.distributed_payment_gateway.payment.processor.strategy.CardPaymentProcessor;
import com.hejazi.distributed_payment_gateway.payment.processor.strategy.NetBankingPaymentProcessor;
import com.hejazi.distributed_payment_gateway.payment.processor.strategy.UpiPaymentProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@RequiredArgsConstructor
public class PaymentProcessorConfig {

    private final NetBankingPaymentProcessor netBankingAdapter;
    private final CardPaymentProcessor cardPaymentAdapter;
    private final UpiPaymentProcessor upiPaymentAdapter;

    @Bean
    public Map<PaymentMethod, PaymentProcessor> paymentProcessorMap(){
       return  Map.of(
                PaymentMethod.CARD, cardPaymentAdapter,
                PaymentMethod.NETBANKING, netBankingAdapter,
                PaymentMethod.UPI, upiPaymentAdapter
        );
    }
}
