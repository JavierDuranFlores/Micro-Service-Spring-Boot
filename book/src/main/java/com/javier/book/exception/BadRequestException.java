package com.javier.book.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BadRequestException extends RuntimeException{

    private HttpStatus status;
    private String code;

    public BadRequestException(String code, String mensaje) {
        super(mensaje);
        this.code = code;
        this.status = HttpStatus.BAD_REQUEST;
    }
}
