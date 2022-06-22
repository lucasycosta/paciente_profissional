package com.zeussh.gestao_pessoas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zeussh.gestao_pessoas.domain.Profissional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
	
	@Query(value = "FROM Profissional p WHERE p.desabilitado = false")
	List<Profissional> buscarTodos();

	@Query(value = "FROM Profissional p WHERE p.id = :id")
	List<Profissional> buscarPorId(Long id);
}
