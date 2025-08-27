package com.rodrigo.previsao_safra.service;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.rodrigo.previsao_safra.dtos.produtor.AtualizarProdutorDTO;
import com.rodrigo.previsao_safra.dtos.produtor.CriarProdutorDTO;
import com.rodrigo.previsao_safra.model.Produtor;
import com.rodrigo.previsao_safra.repository.ProdutorRepository;
//import com.rodrigo.previsao_safra.util.JwtUtil;

@Service
public class ProdutorService {

    private final ProdutorRepository produtorRepository;
/*      private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;  */

     public ProdutorService (ProdutorRepository produtorRepository /* PasswordEncoder passwordEncoder, JwtUtil jwtUtil */){
        this.produtorRepository = produtorRepository;
/*         this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil; */
    }

/*     public String signin(String email, String senha){
        Produtor produtor = produtorRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    
        if(!passwordEncoder.matches(senha, produtor.getSenha())){
            throw new RuntimeException("Senha incorreta");
        }

        return jwtUtil.generateToken(email);
    
    } */

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
