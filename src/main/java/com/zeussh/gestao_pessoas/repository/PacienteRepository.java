package com.zeussh.gestao_pessoas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zeussh.gestao_pessoas.domain.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	@Query(value = "FROM Paciente p WHERE p.desabilitado = false")
	List<Paciente> buscarTodos();
	
	@Query(value = "FROM Paciente p WHERE p.id = :id")
	List<Paciente> buscarPorId(Long id);
}
