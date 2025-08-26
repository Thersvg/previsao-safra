package com.rodrigo.previsao_safra.model.vo;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Localizacao {
    private Double latitude;
    private Double longitude;
}
