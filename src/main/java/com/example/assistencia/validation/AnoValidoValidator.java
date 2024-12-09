package com.example.assistencia.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.Year;

public class AnoValidoValidator implements ConstraintValidator<AnoValido, Integer> {

    @Override
    public boolean isValid(Integer ano, ConstraintValidatorContext context) {
        if (ano == null) {
            return true; // Permite valores nulos, pois isso é tratado pelo @NotNull, se necessário.
        }
        return ano <= Year.now().getValue(); // Valida se o ano é menor ou igual ao atual.
    }
}
