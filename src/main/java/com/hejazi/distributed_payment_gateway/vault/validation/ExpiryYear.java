package com.hejazi.distributed_payment_gateway.vault.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;
import java.lang.annotation.ElementType.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = { ExpiryYearValidator.class})
public @interface ExpiryYear {
    String message() default "Expiry Year cannot be in Past";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
