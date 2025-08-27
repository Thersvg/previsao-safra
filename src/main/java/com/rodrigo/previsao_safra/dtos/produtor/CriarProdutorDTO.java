package com.rodrigo.previsao_safra.dtos.produtor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarProdutorDTO {
    private String nome;
    private String email;
    private String telefone;
    private String senha;    
}
