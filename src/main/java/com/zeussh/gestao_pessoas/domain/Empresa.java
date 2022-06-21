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
public class Empresa implements Serializable {

	@Id
	@Column(name = "id_empresa")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_empresa")
	@SequenceGenerator(allocationSize = 1, name = "seq_empresa", sequenceName = "seq_empresa")
	private Long id;

	@Column
	private String nomeEmpresa;

	@Column
	private String cnpj;

	@Column
	private String logoEmpresa;

	@Transient
	private String file;
	
	@ManyToOne
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "id_responsavel")
	private Responsavel responsavel;

}
