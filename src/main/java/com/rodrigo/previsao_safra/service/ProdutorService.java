package com.rodrigo.previsao_safra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodrigo.previsao_safra.model.Produtor;
import com.rodrigo.previsao_safra.repository.ProdutorRepository;

@Service
public class ProdutorService {

    private final ProdutorRepository produtorRepository;

    public ProdutorService (ProdutorRepository produtorRepository){
        this.produtorRepository = produtorRepository;
    }

    public List<Produtor> listarTodos(){
        return produtorRepository.findAll();
    }

    public Produtor salvar(Produtor produtor){
        return produtorRepository.save(produtor);
    }
}
