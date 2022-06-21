package com.zeussh.gestao_pessoas.domain.enumm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum EnumUF {
	
	AC("AC","Acre"),
	AL("AL","Alagoas"),
	AM("AM","Amazonas"),
	AP("AP","Amapá"),
	BA("BA","Bahia"),
	CE("CE","Ceará"),
	DF("DF","Distrito Federal"),
	ES("ES","Espírito Santo"),
	GO("GO","Goiás"),
	MA("MA","Maranhão"),
	MG("MG","Minas Gerais"),
	MS("MS","Mato Grosso do Sul"),
	MT("MT","Mato Grosso"),
	PA("PA","Pará"),
	PB("PB","Paraíba"),
	PE("PE","Pernambuco"),
	PI("PI","Piauí"),
	PR("PR","Paraná"),
	RJ("RJ","Rio de Janeiro"),
	RN("RN","Rio Grande do Norte"),
	RO("RO","Rondônia"),
	RR("RR","Roraima"),
	RS("RS","Rio Grande do Sul"),
	SC("SC","Santa Catarina"),
	SE("SE","Sergipe"),
	SP("SP","São Paulo"),
	TO("TO","Tocantins");
	
	@Getter
	@Setter
	private String id;

	@Getter
	@Setter
	private String descricao;


}
