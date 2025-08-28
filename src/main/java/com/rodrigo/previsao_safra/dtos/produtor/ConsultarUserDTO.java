package com.rodrigo.previsao_safra.dtos.produtor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultarUserDTO {
    private Long id;
    private String nome;
    private String email;
}
