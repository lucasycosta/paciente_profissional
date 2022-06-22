package com.zeussh.gestao_pessoas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.zeussh.gestao_pessoas.domain.enumm.EnumCredencial;
import com.zeussh.gestao_pessoas.domain.enumm.EnumTipoProfissional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
@Data @AllArgsConstructor @NoArgsConstructor
public class Profissional implements Serializable {
	
	@Id
	@Column(name = "id_profissional")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_profissional")
	@SequenceGenerator(allocationSize = 1, name = "seq_profissional", sequenceName = "seq_profissional")
	private Long id;

	@Column
	private String nome;

	@Column
	private String email;

	@Column
	private String telefone;

	@Column
	private String cpf;
	
	@Column
	@Enumerated(EnumType.STRING)
	private EnumTipoProfissional tipoProfissional;
	
	@Column
	@Enumerated(EnumType.STRING)
	private EnumCredencial credencial;
	
	@Column
	private String especialidade;
	
	@Column
	private String imagemAssinatura;
	
	@Column
	private Boolean desabilitado;

	@Transient
	private String file;

}
