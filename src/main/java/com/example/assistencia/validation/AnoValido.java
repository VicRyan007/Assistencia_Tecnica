package com.example.assistencia.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = AnoValidoValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnoValido {

    String message() default "O ano não pode ser maior que o ano atual.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
