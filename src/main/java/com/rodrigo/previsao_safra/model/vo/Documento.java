package com.rodrigo.previsao_safra.model.vo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Documento {
    private String tipo;
    private String numero;
}
