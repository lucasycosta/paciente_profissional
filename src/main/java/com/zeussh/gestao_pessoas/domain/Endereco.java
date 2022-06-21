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

import com.zeussh.gestao_pessoas.domain.enumm.EnumUF;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table
@SuppressWarnings("serial")
@EqualsAndHashCode(callSuper = false)
@Data @AllArgsConstructor @NoArgsConstructor
public class Endereco implements Serializable{

	@Id
	@Column(name = "id_endereco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_endereco")
	@SequenceGenerator(allocationSize = 1, name = "seq_endereco", sequenceName = "seq_endereco")
	private Long id;
	
	@Column
	private String logradoro;

	@Column
	private String bairro;

	@Column
	private String cidade;

	@Column
	@Enumerated(EnumType.STRING)
	private EnumUF uf;
	
	private String cep;
}
