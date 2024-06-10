package com.javier.book.constraint;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ISBNValidator implements ConstraintValidator<ISBNValidation, String> {

    private static final String ISBN_REGEX = "^(?:\\d{9}X|\\d{10}|\\d{13})$";

    @Override
    public void initialize(ISBNValidation isbnValidation) {
        // Aquí puedes inicializar alguna lógica si es necesario
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        Pattern pattern = Pattern.compile(ISBN_REGEX);
        Matcher matcher = pattern.matcher(value);
        System.out.println("isvalid: " + matcher.matches());
        return matcher.matches();
    }

}
