package com.zeussh.gestao_pessoas.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeussh.gestao_pessoas.domain.Profissional;
import com.zeussh.gestao_pessoas.repository.ProfissionalRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProfissionalService {

	@Autowired
	private ProfissionalRepository profissionalRepository;
	
	public Profissional cadastrar(Profissional profissional) {
		log.info("**SERVICE PROFISSIONAL - CADASTRO DE PROFISSIONAL");
		profissional.setDesabilitado(Boolean.FALSE);
		return profissionalRepository.save(profissional);
	}
	
	public List<Profissional> buscarTodos(){
		log.info("**SERVICE PROFISSIONAL - BUSCAR TODOS PROFISSIONAL");
		return profissionalRepository.buscarTodos();
	}
	
	public List<Profissional> buscarPorId(Long id){
		log.info("**SERVICE PROFISSIONAL - BUSCAR PROFISSIONAL PELO ID");
		return profissionalRepository.buscarPorId(id);
	}
	
	public Profissional desabilitar(Long id) {
		log.info("** SERVICE PROFISSIONAL - Desabilitar");
		Profissional profissional = profissionalRepository.findById(id).orElse(null);
		profissional.setDesabilitado(Boolean.TRUE);
		return profissionalRepository.save(profissional);
	}

	public Profissional habilitar(Long id) {
		log.info("** SERVICE PROFISSIONAL - Desabilitar");
		Profissional profissional = profissionalRepository.findById(id).orElse(null);
		profissional.setDesabilitado(Boolean.FALSE);
		return profissionalRepository.save(profissional);
	}
	
	
	
	
}
