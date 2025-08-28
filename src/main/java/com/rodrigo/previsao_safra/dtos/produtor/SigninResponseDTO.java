package com.rodrigo.previsao_safra.dtos.produtor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninResponseDTO {

    private String token;

    public SigninResponseDTO(String token) {
        this.token = token;
    }
}
