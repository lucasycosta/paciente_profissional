#language: pt

Funcionalidade: Manter profissional
		
	@unitario
	Esquema do Cenario: Cadastrar um profissional
		Dado a insercao de dados do profissional <nome>, <email>, <telefone>, <tipoProfissional>, <especialidade> e <credencial>
		Quando chamar o metodo GRAVAR profissional
		Entao verificar se <id> foi criado
		
	Exemplos:
		| nome        | email           | telefone         |tipoProfissional |especialidade   |credencial | id |
		| 'TesteUNT1' | 'unt1@mail.com' | '(61)99999-9999' |'MEDICO'         |'Ortopedista'   |'CRM'      | 1  |
		| 'TesteUNT2' | 'unt2@mail.com' | '(61)99999-9999' |'MEDICO'         |'Ortopedista'   |'CRM'      | 2  |
		| 'TesteUNT3' | 'unt3@mail.com' | '(61)99999-9999' |'MEDICO'         |'Ortopedista'   |'CRM'      | 3  |
		| 'TesteUNT4' | 'unt4@mail.com' | '(61)99999-9999' |'MEDICO'         |'Ortopedista'   |'CRM'      | 4  |
		| 'TesteUNT5' | 'unt5@mail.com' | '(61)99999-9999' |'MEDICO'         |'Ortopedista'   |'CRM'      | 5  |

	@unitario
	Cenario: Listar todos os profissionais 
		Dado acesso a tela de cadastro de profissionais 
		Quando chamar o metodo GET TODOS profissionais
	 	Entao todos os profissionais serao listados na tabela abaixo 
	 	
	@unitario
	Esquema do Cenario: Buscar profissional pelo id
		Dado acesso a tela de cadastro de profissionais 
	 	Quando chamar o metodo GET profissional por <id>
	 	Entao as informacoes do profissional serao apresentadas 
	 	
	 Exemplos:
		| id |
		| 1  |
		| 2  |
		| 3  |
		| 4  |
		| 5  |
	 
	@unitario
	Esquema do Cenario: Desabilitar um profissional
		Dado acesso a tela de cadastro de profissionais 
	 	Quando chamar o metodo DELETE profissional por <id>
		Entao o profissional sera desabilitado
		
	Exemplos:
		| id |
		| 1  |
		| 2  |
		| 3  |
		| 4  |
		| 5  |
		
	@unitario
	Esquema do Cenario: Habilitar usuario
		Dado que seja passado o <id> do profissional desabilitado
		Quando chamar o metodo GET para habilitar profissional
		Entao o profissional sera habilitado novamente
		
	Exemplos:
		| id |
		| 1  |
		| 2  |
		| 3  |
		| 4  |
		| 5  |
		
	@apirest
	Esquema do Cenario: Cadastrar Profissional 
		Dado a insercao dos dados do profissional <nome>, <email>, <telefone>, <tipoProfissional>, <especialidade> e <credencial>
		Quando chamar o metodo POST de cadastro de profissional
		Entao o retorno profissional sera <status> 

	Exemplos:
		| nome        | email           | telefone         |tipoProfissional |especialidade   |credencial |status |
		| 'TesteAPI1' | 'api1@mail.com' | '(61)99999-9999' |'MEDICO'         |'Ortopedista'   |'1234'     |200    |
		| 'TesteAPI2' | 'api2@mail.com' | '(61)99999-9999' |'MEDICO'         |'Ortopedista'   |'1234'     |200    |
		| 'TesteAPI3' | 'api3@mail.com' | '(61)99999-9999' |'MEDICO'         |'Ortopedista'   |'1234'     |200    |
		
	@apirest
	Cenario: Listar Profissional 
		Quando chamar o metodo GET todos profissionais
		Entao uma tabela com todos os profissionais sera apresentada
		
	@apirest
	Esquema do Cenario: Buscar profissionais pelo id 
		Dado que passamos o <id> do profissional
		Quando chamar o metodo GET de busca profissional por id
		Entao o <status> profissional sera
		
	Exemplos:
		|id |status|
		|1  |200   |
		|2  |200   |
		|3  |200   |
		|4  |400   |
		
	@apirest
	Esquema do Cenario: Desabilitar profissional pelo id 
		Dado o <id> do profissional
		Quando chamar o metodo DELETE profissional
		Entao o <status> sera
		
	Exemplos:
		|id |status|
		|1  |200   |
		|2  |200   |
		|3  |200   |
		|4  |400   |
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
