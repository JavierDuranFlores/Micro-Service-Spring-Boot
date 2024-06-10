package com.javier.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDTO {

    public ErrorDTO() {
    }

    public ErrorDTO(String code, String mensaje) {
        this.code = code;
        this.mensaje = mensaje;
    }

    private String code;

    private String mensaje;

}
