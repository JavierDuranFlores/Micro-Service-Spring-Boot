package com.javier.user.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class UnprocessableException extends RuntimeException{

    private HttpStatus status;
    private String code;

    public UnprocessableException(String code, String mensaje) {
        super(mensaje);
        this.code = code;
        this.status = HttpStatus.UNPROCESSABLE_ENTITY;
    }

}