package com.rodrigo.previsao_safra.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Safra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cultura;
    private String safra;
    private LocalDate dataPlantio;
    private LocalDate dataColheitaPrevista;
    private String status;

    @ManyToOne
    @JoinColumn(name = "talhao_id")
    private Talhao talhao;
}
