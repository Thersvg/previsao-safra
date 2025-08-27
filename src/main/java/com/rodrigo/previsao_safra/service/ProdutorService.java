package com.rodrigo.previsao_safra.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rodrigo.previsao_safra.dtos.produtor.AtualizarProdutorDTO;
import com.rodrigo.previsao_safra.dtos.produtor.ConsultarProdutorDTO;
import com.rodrigo.previsao_safra.dtos.produtor.CriarProdutorDTO;
import com.rodrigo.previsao_safra.model.Produtor;
import com.rodrigo.previsao_safra.repository.ProdutorRepository;

@Service
public class ProdutorService {

    private final ProdutorRepository produtorRepository;

    public ProdutorService (ProdutorRepository produtorRepository){
        this.produtorRepository = produtorRepository;
    }

    public Produtor criar (CriarProdutorDTO dto){
        
        if(produtorRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Já existe um usuário com esse e-mail");
        }

        Produtor produtor = new Produtor();
        produtor.setNome(dto.getNome());
        produtor.setEmail(dto.getEmail());
        produtor.setTelefone(dto.getTelefone());
        produtor.setSenha(dto.getSenha());

        return produtorRepository.save(produtor);
    }

    public void excluir (Long id){
        if(!produtorRepository.existsById(id)){
            throw new RuntimeException("Usuário não existente");
        }
        produtorRepository.deleteById(id);
    }

    public Produtor atualizar(Long id, AtualizarProdutorDTO dto){
        
        Produtor produtor = produtorRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));;

        if(dto.getNome() != null) produtor.setNome(dto.getNome());
        if(dto.getTelefone() != null) produtor.setTelefone(dto.getTelefone());
        if(dto.getSenha() != null) produtor.setSenha(dto.getSenha());
        if(dto.getDocumento() != null) produtor.setDocumento(dto.getDocumento());
        if(dto.getEndereco() != null) produtor.setEndereco(dto.getEndereco());
        if(dto.getFazendas() != null) produtor.setFazendas(dto.getFazendas());
        if(dto.getPreferencias() != null) produtor.setPreferencias(dto.getPreferencias());

        return produtorRepository.save(produtor);
    }

    public Produtor buscarPorEmail(String email){
        return produtorRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
