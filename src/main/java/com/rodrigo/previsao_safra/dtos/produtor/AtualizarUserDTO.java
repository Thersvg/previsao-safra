package com.rodrigo.previsao_safra.dtos.produtor;

import java.util.List;

import com.rodrigo.previsao_safra.model.Fazenda;
import com.rodrigo.previsao_safra.model.vo.Documento;
import com.rodrigo.previsao_safra.model.vo.Endereco;
import com.rodrigo.previsao_safra.model.vo.Preferencias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AtualizarUserDTO {
    private String nome;
    private String telefone;
    private String senha; 
    private Documento documento;
    private Endereco endereco;
    private List<Fazenda> fazendas;
    private Preferencias preferencias;
}
