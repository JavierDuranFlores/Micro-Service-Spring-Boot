package com.javier.user.controller;


import com.javier.user.model.dto.ErrorDTO;
import com.javier.user.exception.BadRequestException;
import com.javier.user.exception.NoFoundException;
import com.javier.user.exception.UnprocessableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = NoFoundException.class)
    public ResponseEntity<ErrorDTO> noFoundExceptionHandler(NoFoundException ex) {
        ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).mensaje(ex.getMessage()).build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UnprocessableException.class)
    public ResponseEntity<ErrorDTO> unprocessableExceptionHandler(UnprocessableException ex) {
        ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).mensaje(ex.getMessage()).build();

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<ErrorDTO> badRequestExceptionHandler(BadRequestException ex) {
        ErrorDTO error = ErrorDTO.builder().code(ex.getCode()).mensaje(ex.getMessage()).build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
