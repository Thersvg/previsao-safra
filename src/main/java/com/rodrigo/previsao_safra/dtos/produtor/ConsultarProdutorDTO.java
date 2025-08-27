package com.rodrigo.previsao_safra.dtos.produtor;

import com.rodrigo.previsao_safra.model.Produtor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultarProdutorDTO {

    private Long id;
    private String nome;
    private String email;

    public ConsultarProdutorDTO(){}

    public ConsultarProdutorDTO(Produtor produtor){
        this.id = produtor.getId();
        this.nome = produtor.getNome();
        this.email = produtor.getEmail();
    }
}
