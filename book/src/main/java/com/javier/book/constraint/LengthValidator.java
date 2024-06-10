package com.javier.book.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LengthValidator implements ConstraintValidator<LengthValidation, String> {

    private static final String ISBN_REGEX = "^(?:\\d{9}X|\\d{10}|\\d{13})$";

    @Override
    public void initialize(LengthValidation lengthValidation) {
        // Aquí puedes inicializar alguna lógica si es necesario
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Implementa la lógica de validación
        // Por ejemplo, vamos a verificar si el valor no está vacío y tiene una longitud mínima
        if (value == null) {
            return false;
        }
        return value.length() > 4; // Ejemplo: debe tener al menos 4 caracteres
    }

}