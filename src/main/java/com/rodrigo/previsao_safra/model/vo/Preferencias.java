package com.rodrigo.previsao_safra.model.vo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Preferencias {
    private Boolean notificacoes;
    private String idioma;
    private String unidadeArea;
    private String unidadeTemperatura;
}
