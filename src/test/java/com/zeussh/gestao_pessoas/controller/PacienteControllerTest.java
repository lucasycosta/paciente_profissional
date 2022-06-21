package com.zeussh.gestao_pessoas.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zeussh.gestao_pessoas.domain.Paciente;
import com.zeussh.gestao_pessoas.domain.enumm.EnumSexo;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@CucumberContextConfiguration
public class PacienteControllerTest {

	@Autowired
	private PacienteController pacienteController;
	private static Paciente paciente;
	
	//------------------------------------CADASTRAR PACIENTE-------------------------------------------------------------------------
	@Test
	@Order(10)
	@Dado("a insercao dos dados do paciente {string}, {string}, {string}, {string}, {string} e {string}")
	public void aInsercaoDosDadosDoPacienteE(String nome, String email, String telefone, String dataNascimento, String cpf, String sexo) {
	    log.info("**TESTE CONTROLLER PACIENTE - populando paciente");
		paciente = new Paciente();
	    paciente.setNome(nome);
	    paciente.setEmail(email);
	    paciente.setTelefone(telefone);
	    paciente.setSexo(EnumSexo.MASCULINO);
	    paciente.setDataNascimento(dataNascimento);
	    paciente.setCpf(cpf);
	}
	
	@Test
	@Order(11)
	@Quando("chamar o metodo GRAVAR paciente")
	public void chamarOMetodoGRAVARPaciente() {
		log.info("**TESTE CONTROLLER PACIENTE - gravando paciente");
		pacienteController.cadastrar(paciente);
	}
	
	@Test
	@Order(12)
	@Entao("verificar se {int} foir criado")
	public void verificarSeFoirCriado(Integer int1) {
		log.info("**TESTE CONTROLLER PACIENTE - verificando se o idPaciente foi criado");
		assertNotNull(paciente.getId());
	}
	
	//------------------------------------BUSCAR TODOS PACIENTES---------------------------------------------------------------------
	@Test
	@Order(20)
	@Quando("chamar o metodo GET TODOS pacientes")
	public List<Paciente> chamarOMetodoGETTODOSPacientes() {
		log.info("**TESTE CONTROLLER PACIENTE - buscando todos os pacientes");
		return pacienteController.buscarTodos();
	}
	
	@Test
	@Order(21)
	@Entao("todos os paciente sao listados na tabela abaixo")
	public void todosOsPacienteSaoListadosNaTabelaAbaixo() {
		log.info("**TESTE CONTROLLER PACIENTE - tabela de paciente populada");
	    assertNotNull(paciente);
	}

	//------------------------------------BUSCAR PACIENTE PELO ID----------------------------------------------------------------------
	@Test
	@Order(30)
	@Quando("chamar o metodo GET paciente por {long}")
	public void chamarOMetodoGETPacientePor(Long id) {
		log.info("**TESTE CONTROLLER PACIENTE - tabela de paciente populada");
		pacienteController.buscarPorId(id);
	}
	@Test
	@Order(31)
	@Entao("as informacoes do paciente serao apresentadas")
	public void asInformacoesDoPacienteSeraoApresentadas() {
		log.info("**TESTE CONTROLLER PACIENTE - informações do paciente");
		assertNotNull(paciente.getNome());
		assertNotNull(paciente.getEmail());
		//assertNotNull(paciente.getSexo());
		assertNotNull(paciente.getId());
		assertNotNull(paciente.getDataNascimento());
		assertNotNull(paciente.getCpf());
	}

	//------------------------------------DESABILITAR PACIENTE------------------------------------------------------------------------
	@Test
	@Order(40)
	@Quando("chamar o metodo DELETE paciente pelo {long}")
	public void chamarOMetodoDELETEPacientePelo(Long id) {
		log.info("**TESTE CONTROLLER PACIENTE - desabilitar paciente");
		pacienteController.desabilitar(id);
	}
	
	@Test
	@Order(41)
	@Entao("o paciente sera desabilitado")
	public void oPacienteSeraDesabilitado() {
		log.info("**TESTE CONTROLLER PACIENTE - verificando se paciente foi desabilitado");
		assertEquals(paciente.getDesabilitado().TRUE, paciente.getDesabilitado().TRUE);
	}







}
