package com.rodrigo.previsao_safra.dtos.produtor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SigninRequestDTO {
    private String email;
    private String senha;
}