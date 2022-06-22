package com.zeussh.gestao_pessoas.api;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.zeussh.gestao_pessoas.domain.Profissional;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@CucumberContextConfiguration
public class ProfissionalAPITest {
	
private final static String BASE_URI = "http://localhost:8080/";
	
	private static Profissional profissional;
	
	private RequestSpecification httpRequest = RestAssured.given();

	private Response response;

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = BASE_URI;
	}
	
	@Dado("a insercao dos dados do profissional {string}, {string}, {string}, {string}, {string} e {string}")
	public void aInsercaoDosDadosDoProfissionalE(String string, String string2, String string3, String string4, String string5, String string6) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Quando("chamar o metodo POST de cadastro de profissional")
	public void chamarOMetodoPOSTDeCadastroDeProfissional() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Entao("o retorno profissional sera {int}")
	public void oRetornoProfissionalSera(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Quando("chamar o metodo GET todos profissionais")
	public void chamarOMetodoGETTodosProfissionais() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Entao("uma tabela com todos os profissionais sera apresentada")
	public void umaTabelaComTodosOsProfissionaisSeraApresentada() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Dado("que passamos o {int} do profissional")
	public void quePassamosODoProfissional(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Quando("chamar o metodo GET de busca profissional por id")
	public void chamarOMetodoGETDeBuscaProfissionalPorId() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Entao("o {int} profissional sera")
	public void oProfissionalSera(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Dado("o {int} do profissional")
	public void oDoProfissional(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Quando("chamar o metodo DELETE profissional")
	public void chamarOMetodoDELETEProfissional() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Entao("o {int} sera")
	public void oSera(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}








}
