#language: pt

Funcionalidade: Manter Paciente

	@unitario
	Esquema do Cenario: Cadastrar um paciente 
		Dado a insercao dos dados do paciente <nome>, <email>, <telefone>, <dataNascimento>, <cpf> e <sexo>  
		Quando chamar o metodo GRAVAR paciente
		Entao verificar se <id> foir criado
		
	Exemplos:
		| nome        | email           | telefone          |dataNascimento | cpf       |id	| sexo      |
		| 'TesteUNT1' | 'unt1@mail.com' | '(61)99999-9999'  |'01/01/2022'   | '123456'  |1  |'MASCULINO'|
		| 'TesteUNT2' | 'unt2@mail.com' | '(61)99999-9999'  |'01/01/2022'   | '123456'  |2  |'MASCULINO'|
		| 'TesteUNT3' | 'unt3@mail.com' | '(61)99999-9999'  |'01/01/2022'   | '123456'  |3  |'MASCULINO'|
		| 'TesteUNT4' | 'unt4@mail.com' | '(61)99999-9999'  |'01/01/2022'   | '123456'  |4  |'MASCULINO'|
		| 'TesteUNT5' | 'unt5@mail.com' | '(61)99999-9999'  |'01/01/2022'   | '123456'  |5  |'MASCULINO'|
	
	@unitario 
	Cenario: Listar todos paciente 
		Quando chamar o metodo GET TODOS pacientes
		Entao todos os paciente sao listados na tabela abaixo
		
	@unitario
	Esquema do Cenario: Buscar paciente pelo id 
		Quando chamar o metodo GET paciente por <id>
		Entao as informacoes do paciente serao apresentadas
		
	Exemplos:
		| id |
		| 1  |
		| 2  |
		| 3  |
		| 4  |
		| 5  |
		
	@unitario
	Esquema do Cenario: Desabilitar paciente 
		Quando chamar o metodo DELETE paciente pelo <id>
		Entao o paciente sera desabilitado
		
	Exemplos:
		| id  |
		| 1   |
		| 2   |
		| 3   |
		| 4   |
		| 5   |
		
		
	@apirest
	Esquema do Cenario: Cadastrar Paciente 
		Dado a insercao dos dados do paciente <nome>, <email>, <telefone>, <dataNascimento>, <cpf>, <sexo>
		Quando chamar o metodo POST de cadastro de paciente
		Entao o retorno paciente sera <status> 
	
	Exemplos:
		| nome        | email           | telefone         |dataNascimento | cpf       |status | sexo |
		| 'TesteAPI1' | 'api1@mail.com' | '(61)99999-9999' |'01/01/2022'   | '123456'  |200    |'MASCULINO'|
		| 'TesteAPI2' | 'api2@mail.com' | '(61)99999-9999' |'01/01/2022'   | '123456'  |200    |'MASCULINO'|
		| 'TesteAPI3' | 'api3@mail.com' | '(61)99999-9999' |'01/01/2022'   | '123456'  |200    |'MASCULINO'|
		
	@apirest
	Cenario: Listar Pacientes 
		Quando chamar o metodo GET todos pacientes
		Entao uma tabela com todos os pacientes sera apresentada
	
	@apirest
	Esquema do Cenario: Buscar paciente pelo id 
		Dado que passamos o <id> do paciente
		Quando chamar o metodo GET de busca paciente por id
		Entao o <status> paciente sera
		
	Exemplos:
		|id |status|
		|1  |200   |
		|2  |200   |
	
	@apirest
	Esquema do Cenario: Desabilitar paciente pelo id 
		Dado que passamos o <id> do paciente para desabilitar
		Quando chamar o metodo DELETE paciente
		Entao o <status> sera
		
	Exemplos:
		|id |status|
		|1  |200   |
		|2  |200   |
		|12 |500   |
		
		
	
		
		
		
		