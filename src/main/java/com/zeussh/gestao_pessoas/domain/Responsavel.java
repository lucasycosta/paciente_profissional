package com.zeussh.gestao_pessoas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
@Data @AllArgsConstructor @NoArgsConstructor
public class Responsavel implements Serializable {
	
	@Id
	@Column(name = "id_responsavel")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_responsavel")
	@SequenceGenerator(allocationSize = 1, name = "seq_responsavel", sequenceName = "seq_responsavel")
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
	private String logo;

	@Transient
	private String file;

	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

}
