package com.zeussh.gestao_pessoas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zeussh.gestao_pessoas.domain.Paciente;
import com.zeussh.gestao_pessoas.service.PacienteService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("paciente")
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;
	
	@PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public Paciente cadastrar(@RequestBody Paciente paciente) {
		log.info("**CONTROLLER PACIENTE - CADASTRAR");
		return pacienteService.cadastrar(paciente);
	}
	
	@GetMapping(value = "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Paciente> buscarTodos(){
		log.info("**CONTROLLER PACIENTE - BUSCAR TODOS");
		return pacienteService.buscarTodos();
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Paciente> buscarPorId(@RequestParam(value = "id") Long id) {
		log.info("**CONTROLLER PACIENTE - BUSCAR POR ID");
		return pacienteService.buscarPorId(id);
	}
	
	@DeleteMapping(value = "/desabilitar", produces = MediaType.APPLICATION_JSON_VALUE)
	public Paciente desabilitar(@RequestParam(value = "id") Long id) {
		log.info("**CONTROLLER PACIENTE - DESABILITAR");
		return pacienteService.desabilitar(id);
	}
	
	@GetMapping(value = "/habilitar", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Paciente habilitar(@RequestParam(name = "id") Long id) {
		log.info("**CONTROLLER PACIENTE - HABILITAR");
		return pacienteService.habilitar(id);
	}
}
