package com.rodrigo.previsao_safra.model;

import java.time.Instant;
import java.util.List;

import com.rodrigo.previsao_safra.model.vo.Documento;
import com.rodrigo.previsao_safra.model.vo.Endereco;
import com.rodrigo.previsao_safra.model.vo.Preferencias;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "produtores")
@Getter
@Setter
public class Produtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String cpfCnpj;
    private String telefone;
    private String senha;

    @Embedded
    private Documento documento;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "produtor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Fazenda> fazendas;
    
    @Embedded
    private Preferencias preferencias;

    private Instant criadoEm;
    private Instant atualizadoEm;

    @PrePersist
    protected void onCreate() {
        this.criadoEm = Instant.now();
        this.atualizadoEm = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.atualizadoEm = Instant.now();
    }

}
