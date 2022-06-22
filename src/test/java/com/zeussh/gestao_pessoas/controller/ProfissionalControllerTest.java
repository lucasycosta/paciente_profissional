package com.zeussh.gestao_pessoas.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zeussh.gestao_pessoas.domain.Profissional;
import com.zeussh.gestao_pessoas.domain.enumm.EnumCredencial;
import com.zeussh.gestao_pessoas.domain.enumm.EnumTipoProfissional;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@CucumberContextConfiguration
public class ProfissionalControllerTest {
	
	@Autowired
	private ProfissionalController profissionalController;
	
	private static Profissional profissional;

	//------------------------------------HABILITAR USUARIO-------------------------------------------------------------------------
	/*
	 * @Dado("que um usuario {string} for cadastrado") public void
	 * queUmUsuarioForCadastrado(String string) { // Write code here that turns the
	 * phrase above into concrete actions throw new
	 * io.cucumber.java.PendingException(); }
	 * 
	 * @Quando("o pagamento for efetivado") public void oPagamentoForEfetivado() {
	 * // Write code here that turns the phrase above into concrete actions throw
	 * new io.cucumber.java.PendingException(); }
	 * 
	 * @Entao("o acesso do usuario seria habilitado") public void
	 * oAcessoDoUsuarioSeriaHabilitado() { // Write code here that turns the phrase
	 * above into concrete actions throw new io.cucumber.java.PendingException(); }
	 */
	
	//------------------------------------CADASTRAR PROFISSIONAL---------------------------------------------------------------------
	@Test
	@Order(20)
	@Dado("a insercao de dados do profissional {string}, {string}, {string}, {string}, {string} e {string}")
	public void aInsercaoDeDadosDoProfissionalE(String nome, String email, String telefone, String tipoProfissional, String especialidade, String credencial) {
	    log.info("**TESTE CONTROLLER PROFISSIONAL - populando profissional");
	    profissional = new Profissional();
	    profissional.setNome(nome);
	    profissional.setEmail(email);
	    profissional.setTelefone(telefone);
	    profissional.setTipoProfissional(EnumTipoProfissional.MEDICO);
	    profissional.setEspecialidade(especialidade);
	    profissional.setCredencial(EnumCredencial.CRM);
	    
	}
	
	@Test
	@Order(21)
	@Quando("chamar o metodo GRAVAR profissional")
	public void chamarOMetodoGRAVARProfissional() {
		log.info("**TESTE CONTROLLER PROFISSIONAL - gravando profissional");
		profissionalController.cadastrar(profissional);
	}
	
	@Test
	@Order(22)
	@Entao("verificar se {long} foi criado")
	public void verificarSeFoiCriado(Long id) {
		log.info("**TESTE CONTROLLER PROFISSIONAL - verificar se o idProfissional foi criado");
		assertNotNull(profissional.getId());
	}

	//------------------------------------BUSCAR TODOS PROFISSIONAIS--------------------------------------------------------------------
	@Test
	@Order(30)
	@Quando("chamar o metodo GET TODOS profissionais")
	public List<Profissional> chamarOMetodoGETTODOSProfissionais() {
		log.info("**TESTE CONTROLLER PROFISSIONAL - buscar todos os profissionais");
		return profissionalController.buscarTodos();
	}
	
	@Test
	@Order(31)
	@Entao("todos os profissionais serao listados na tabela abaixo")
	public void todosOsProfissionaisSeraoListadosNaTabelaAbaixo() {
		log.info("**TESTE CONTROLLER PROFISSIONAL - tabela de profissionais populada");
		assertNotNull(profissional);	}

	//------------------------------------BUSCAR PROFISSIONAL PELO ID-------------------------------------------------------------------
	@Test
	@Order(40)
	@Quando("chamar o metodo GET profissional por {long}")
	public void chamarOMetodoGETProfissionalPor(Long id) {
		log.info("**TESTE CONTROLLER PROFISSIONAL - buscar profissional pelo id");
		profissionalController.buscarPorId(id);
	}
	
	@Test
	@Order(41)
	@Entao("as informacoes do profissional serao apresentadas")
	public void asInformacoesDoProfissionalSeraoApresentadas() {
		log.info("**TESTE CONTROLLER PROFISSIONAL - informações do profissional");
		assertNotNull(profissional.getNome());
		assertNotNull(profissional.getEmail());
		assertNotNull(profissional.getTelefone());
		assertNotNull(profissional.getTipoProfissional());
		assertNotNull(profissional.getEspecialidade());
		assertNotNull(profissional.getCredencial());
		
	}

	//------------------------------------DESABILITAR PROFISSIONAL---------------------------------------------------------------------
	@Test
	@Order(50)
	@Quando("chamar o metodo DELETE profissional por {long}")
	public void chamarOMetodoDELETEProfissionalPor(Long id) {
		log.info("**TESTE CONTROLLER PROFISSIONAL - desabilitar profissional");
		profissionalController.desabilitar(id);
	}
	
	@Test
	@Order(51)
	@Entao("o profissional sera desabilitado")
	public void oProfissionalSeraDesabilitado() {
		log.info("**TESTE CONTROLLER PROFISSIONAL - verificando se o profissional foi desabilitado");
		assertEquals(profissional.getDesabilitado().TRUE, profissional.getDesabilitado().TRUE);
	}








}
