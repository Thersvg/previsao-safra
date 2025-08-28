package com.rodrigo.previsao_safra.controller;

import com.rodrigo.previsao_safra.dtos.produtor.SigninRequestDTO;
import com.rodrigo.previsao_safra.dtos.produtor.SigninResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigo.previsao_safra.dtos.produtor.AtualizarUserDTO;
import com.rodrigo.previsao_safra.dtos.produtor.CriarUserDTO;
import com.rodrigo.previsao_safra.model.User;
import com.rodrigo.previsao_safra.service.UserService;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create/user")
    public User criar (@Validated @RequestBody CriarUserDTO dto){
        return userService.criar(dto);
    }

    @DeleteMapping("/{id}")
    public void excluir (@PathVariable Long id){
        userService.excluir(id);
    }

    @PutMapping("/{id}")
    public User atualizar(@PathVariable Long id, @RequestBody AtualizarUserDTO dto) {
        return userService.atualizar(id, dto);
    }

    @GetMapping("/") // /produtor/?email=email@gmail.com
    public User buscaUsuarioPorEmail(@RequestParam String email) {
        return userService.buscarPorEmail(email);
    }

    @PostMapping("/login")
    public SigninResponseDTO login (@RequestBody SigninRequestDTO dto) {
        return userService.login(dto.getEmail(), dto.getSenha());
    }
    
}
