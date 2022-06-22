package com.zeussh.gestao_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zeussh.gestao_pessoas.domain.Profissional;
import com.zeussh.gestao_pessoas.service.ProfissionalService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("profissional")
public class ProfissionalController {

	@Autowired
	private ProfissionalService profissionalService;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Profissional cadastrar(@RequestBody Profissional profissional) {
		log.info("**CONTROLLER PROFISSIONAL - CADASTRAR");
		return profissionalService.cadastrar(profissional);
	}
	
	@GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profissional> buscarTodos(){
		log.info("**CONTROLLER PROFISSIONAL - BUSCAR TODOS");
		return profissionalService.buscarTodos();
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profissional> buscarPorId(@RequestParam(value = "id") Long id){
		log.info("**CONTROLLER PROFISSIONAL - BUSCAR POR ID");
		return profissionalService.buscarPorId(id);
	}
	
	@DeleteMapping(value = "/desabilitar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Profissional desabilitar(@RequestParam(value = "id") Long id) {
		log.info("**CONTROLLER PROFISSIONAL - DESABILITAR");
		return profissionalService.desabilitar(id);
	}
	
	@DeleteMapping(value = "/habilitar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Profissional habilitar(@RequestParam(value = "id") Long id) {
		log.info("**CONTROLLER PROFISSIONAL - HABILITAR");
		return profissionalService.habilitar(id);
	}
	
	
	
	
	
	
	
	
 }
