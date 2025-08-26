package com.rodrigo.previsao_safra.model.vo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Endereco {
    private String rua;
    private String numeroEndereco;
    private String cidade;
    private String estado;
    private String cep;
}
