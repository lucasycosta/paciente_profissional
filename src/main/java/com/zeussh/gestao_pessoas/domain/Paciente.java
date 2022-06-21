package com.zeussh.gestao_pessoas.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.zeussh.gestao_pessoas.domain.enumm.EnumSexo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
@Data @AllArgsConstructor @NoArgsConstructor
public class Paciente implements Serializable {

	@Id
	@Column(name = "id_paciente")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
	@SequenceGenerator(allocationSize = 1, name = "seq_paciente", sequenceName = "seq_paciente")
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
	private Date dataNascimento;

	@Column
	@Enumerated(EnumType.STRING)
	private EnumSexo sexo;

}
