package com.rodrigo.previsao_safra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.previsao_safra.model.Produtor;
import com.rodrigo.previsao_safra.service.ProdutorService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/produtor")
public class ProdutorController {

    private final ProdutorService produtorService;

    public ProdutorController(ProdutorService produtorService){
        this.produtorService = produtorService;
    }

    @GetMapping("/todos")
    public List<Produtor> GetAll() {
        return produtorService.listarTodos();
    }
    
    @PostMapping("/criar")
    public Produtor Create(@RequestBody Produtor produtor) {
        return produtorService.salvar(produtor);
    }
    

}
