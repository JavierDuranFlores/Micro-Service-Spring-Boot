package com.javier.user.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class NoFoundException extends RuntimeException{

    private HttpStatus status;
    private String code;

    public NoFoundException(String code, String mensaje) {
        super(mensaje);
        this.code = code;
        this.status = HttpStatus.NOT_FOUND;
    }

}