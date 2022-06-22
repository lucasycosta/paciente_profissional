package com.zeussh.gestao_pessoas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeussh.gestao_pessoas.domain.Paciente;
import com.zeussh.gestao_pessoas.repository.PacienteRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;
	
	public Paciente cadastrar(Paciente paciente) {
		log.info("**SERVICE PACIENTE - CADASTRO DE PACIENTE");
		paciente.setDesabilitado(Boolean.FALSE);
		return pacienteRepository.save(paciente);
	}
	
	public List<Paciente> buscarTodos(){
		log.info("**SERVICE PACIENTE - BUSCAR TODOS PACIENTES");
		return pacienteRepository.buscarTodos();
	}
	
	public List<Paciente> buscarPorId(Long id) {
		return pacienteRepository.buscarPorId(id);
	}
	
	public Paciente desabilitar(Long id) {
		log.info("** SERVICE USUARIO - Desabilitar");
		Paciente paciente = pacienteRepository.findById(id).orElse(null);
		paciente.setDesabilitado(Boolean.TRUE);
		return pacienteRepository.save(paciente);
	}

	public Paciente habilitar(Long id) {
		log.info("** SERVICE USUARIO - Desabilitar");
		Paciente paciente = pacienteRepository.findById(id).orElse(null);
		paciente.setDesabilitado(Boolean.FALSE);
		return pacienteRepository.save(paciente);
	}

}
