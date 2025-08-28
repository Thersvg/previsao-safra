package com.rodrigo.previsao_safra.repository;

import org.springframework.stereotype.Repository;

import com.rodrigo.previsao_safra.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);

}
