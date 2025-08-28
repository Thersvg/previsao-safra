package com.rodrigo.previsao_safra.service;

import com.rodrigo.previsao_safra.dtos.produtor.SigninResponseDTO;
import com.rodrigo.previsao_safra.util.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.rodrigo.previsao_safra.dtos.produtor.AtualizarUserDTO;
import org.springframework.stereotype.Service;

import com.rodrigo.previsao_safra.dtos.produtor.CriarUserDTO;
import com.rodrigo.previsao_safra.model.User;
import com.rodrigo.previsao_safra.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

     public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

     public SigninResponseDTO login (String email, String senha) {
        User user = userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    
        if (passwordEncoder.matches(senha, user.getSenha())){
            String token = jwtUtil.generateToken(user.getEmail());
            return new SigninResponseDTO(token);
        } else {
            throw new RuntimeException("Senha incorreta");
        }
    }

    public User criar (CriarUserDTO dto){
        
        if(userRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Já existe um usuário com esse e-mail");
        }

        User user = new User();
        user.setNome(dto.getNome());
        user.setEmail(dto.getEmail());
        user.setTelefone(dto.getTelefone());

        user.setSenha(passwordEncoder.encode(dto.getSenha()));

        return userRepository.save(user);
    }

    public void excluir (Long id){
        if(!userRepository.existsById(id)){
            throw new RuntimeException("Usuário não existente");
        }
        userRepository.deleteById(id);
    }

    public User atualizar(Long id, AtualizarUserDTO dto){
        
        User user = userRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if(dto.getNome() != null) user.setNome(dto.getNome());
        if(dto.getTelefone() != null) user.setTelefone(dto.getTelefone());
        if(dto.getSenha() != null) user.setSenha(dto.getSenha());
        if(dto.getDocumento() != null) user.setDocumento(dto.getDocumento());
        if(dto.getEndereco() != null) user.setEndereco(dto.getEndereco());
        if(dto.getFazendas() != null) user.setFazendas(dto.getFazendas());
        if(dto.getPreferencias() != null) user.setPreferencias(dto.getPreferencias());

        return userRepository.save(user);
    }

    public User buscarPorEmail(String email){
        return userRepository.findByEmail(email)
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
