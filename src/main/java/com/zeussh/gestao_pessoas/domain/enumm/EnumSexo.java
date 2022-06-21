package com.zeussh.gestao_pessoas.domain.enumm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum EnumSexo {

	MASCULINO("MASCULINO", "Masculino"), FEMININO("FEMININO", "Feminino");

	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	private String descricao;

}
