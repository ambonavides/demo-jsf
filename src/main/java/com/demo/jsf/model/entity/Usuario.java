package com.demo.jsf.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	
	
	@Column( name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
}
