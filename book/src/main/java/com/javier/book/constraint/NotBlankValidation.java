package com.javier.book.constraint;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotBlankValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NotBlankValidation {
    String message() default "Invalid field";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
