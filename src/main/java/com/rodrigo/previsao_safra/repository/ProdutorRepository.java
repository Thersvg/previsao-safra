package com.rodrigo.previsao_safra.repository;

import org.springframework.stereotype.Repository;

import com.rodrigo.previsao_safra.model.Produtor;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long>{

    Optional<Produtor> findByEmail(String email);
    boolean existsByEmail(String email);

}
