package com.rodrigo.previsao_safra.repository;

import org.springframework.stereotype.Repository;

import com.rodrigo.previsao_safra.model.Produtor;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long>{
}
