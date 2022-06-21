package com.zeussh.gestao_pessoas.domain.enumm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum EnumTipoProfissional {

	MEDICO("Médico"),
	FISIO("Fisioterapeuta"),
	ED_FISICO("Educador Físico"),
	ESTUDANTE("Estudante");
	
	@Setter
	@Getter
	private String descricao;
	
}
