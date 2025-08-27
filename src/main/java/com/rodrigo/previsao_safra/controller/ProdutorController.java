package com.rodrigo.previsao_safra.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.previsao_safra.dtos.produtor.AtualizarProdutorDTO;
import com.rodrigo.previsao_safra.dtos.produtor.CriarProdutorDTO;
import com.rodrigo.previsao_safra.model.Produtor;
import com.rodrigo.previsao_safra.service.ProdutorService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/produtor")
public class ProdutorController {

    private final ProdutorService produtorService;

    public ProdutorController(ProdutorService produtorService){
        this.produtorService = produtorService;
    }

    @PostMapping("/")
    public Produtor criar (@Validated @RequestBody CriarProdutorDTO dto){
        return produtorService.criar(dto);
    }

    @DeleteMapping("/{id}")
    public void excluir (@PathVariable Long id){
        produtorService.excluir(id);
    }

    @PutMapping("/{id}")
    public Produtor atualizar(@PathVariable Long id, @RequestBody AtualizarProdutorDTO dto) {
        return produtorService.atualizar(id, dto);
    }

    @GetMapping("/") // /produtor/?email=email@gmail.com
    public Produtor buscaUsuarioPorEmail(@RequestParam String email) {
        return produtorService.buscarPorEmail(email);
    }
    
}
