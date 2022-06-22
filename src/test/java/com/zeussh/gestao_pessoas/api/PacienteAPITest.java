package com.zeussh.gestao_pessoas.api;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.zeussh.gestao_pessoas.domain.Paciente;

import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Entao;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
@CucumberContextConfiguration
public class PacienteAPITest {

	private final static String BASE_URI = "http://localhost:8080/";
	
	private static Paciente paciente;
	
	private RequestSpecification httpRequest = RestAssured.given();

	private Response response;

	@BeforeAll
	public static void setup() {
		RestAssured.baseURI = BASE_URI;
	}
	
	//------------------------------------CADASTRAR PACIENTE-------------------------------------------------------------------------
	@Test
	@Order(10)
	@Dado("a insercao dos dados do paciente {string}, {string}, {string}, {string}, {string}, {string}")
	public void aInsercaoDosDadosDoPacienteE(String nome, String email, String telefone, String dataNascimento, String cpf, String sexo) {
	    log.info("** REST API PacienteAPITest - aInsercaoDosDadosDoPacienteE");
	    httpRequest.body("{\"nome\": \"" + nome + "\", \"email\": \"" + email + "\", \"telefone\": \"" + telefone + "\", \"dataNascimento\": \"" + dataNascimento
	    		+ "\", \"cpf\": \"" + cpf + "\", \"sexo\": \"" + sexo +"\"}").contentType(ContentType.JSON);
	}
	
	@Test
	@Order(11)
	@Quando("chamar o metodo POST de cadastro de paciente")
	public void chamarOMetodoPOSTDeCadastroDePaciente() {
		log.info("** REST API PacienteAPITest - chamarOMetodoPOSTDeCadastroDePaciente");
		response = httpRequest.post("paciente");
	}
	
	@Test
	@Order(12)
	@Entao("o retorno paciente sera {int}")
	public void oRetornoPacienteSera(Integer status) {
		log.info("** REST API PacienteAPITest - oRetornoPacienteSera");
		response.then().log().all().statusCode(status);
	}

	//------------------------------------BUSCAR TODOS PACIENTES----------------------------------------------------------------------
	@Test
	@Order(20)
	@Quando("chamar o metodo GET todos pacientes")
	public void chamarOMetodoGETTodosPacientes() {
		log.info("** REST API PacienteAPITest - chamarOMetodoGETTodosPacientes");
		
		RequestSpecification httpRequest = RestAssured.given();

		Response response = httpRequest.get("paciente/todos");
			     response.then().log().all().
			              statusCode(200);
		JsonPath jsonPathEvaluator = response.jsonPath();
		List<Paciente> lista = jsonPathEvaluator.getList("", Paciente.class);
		paciente = lista.get(lista.size() - 1);
		
	}
	@Test
	@Order(21)
	@Entao("uma tabela com todos os pacientes sera apresentada")
	public void umaTabelaComTodosOsPacientesSeraApresentada() {
	    log.info("** REST API PacienteAPITest - umaTabelaComTodosOsPacientesSeraApresentada");
	}

	//------------------------------------BUSCAR PACIENTE PELO ID---------------------------------------------------------------------
	@Test
	@Order(30)
	@Dado("que passamos o {long} do paciente")
	public void quePassamosODoPaciente(Long id) {
		log.info("** REST API PacienteAPITest - quePassamosODoPaciente");
		httpRequest.params("id", id);
	}
	
	@Test
	@Order(31)
	@Quando("chamar o metodo GET de busca paciente por id")
	public void chamarOMetodoGETDeBuscaPacientePorId() {
		log.info("** REST API PacienteAPITest - chamarOMetodoGETDeBuscaPacientePorId");
		response = httpRequest.get("paciente?" + paciente.getId());
	}
	
	@Test
	@Order(32)
	@Entao("o {int} paciente sera")
	public void oPacienteSera(Integer status) {
		log.info("** REST API PacienteAPITest - oRetornoPacienteSera");
		response.then().log().all().statusCode(status);
	}

	//------------------------------------DESABILITAR PACIENTE-----------------------------------------------------------------------
	@Test
	@Order(40)
	@Dado("que passamos o {long} do paciente para desabilitar")
	public void quePassamosODoPacienteParaDesabilitar(Long id) {
		log.info("** REST API PacienteAPITest - quePassamosODoPacienteParaDesabilitar");
		httpRequest.params("id", id);
	}
	
	@Test
	@Order(41)
	@Quando("chamar o metodo DELETE paciente")
	public void chamarOMetodoDELETEPaciente() {
		log.info("** REST API PacienteAPITest - chamarOMetodoDELETEPaciente");
		response = httpRequest.delete("paciente/desabilitar?" + paciente.getId());
	}
	
	@Test
	@Order(42)
	@Entao("o {int} sera")
	public void oSera(Integer status) {
		log.info("** REST API PacienteAPITest - oSera");
		response.then().log().all().statusCode(status);
	}








}
