package com.hejazi.distributed_payment_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DistributedPaymentGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DistributedPaymentGatewayApplication.class, args);
	}

}
