package com.javier.book.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NotBlankValidator implements ConstraintValidator<NotBlankValidation, String> {
    @Override
    public void initialize(NotBlankValidation customValidation) {
        // Aquí puedes inicializar alguna lógica si es necesario
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // Implementa la lógica de validación
        // Por ejemplo, vamos a verificar si el valor no está vacío y tiene una longitud mínima
        if (value == null) {
            return false;
        }
        return value.length() > 0; // Ejemplo: debe se mayor a 0 caracteres
    }

}
