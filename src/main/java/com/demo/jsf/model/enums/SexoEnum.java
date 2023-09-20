package com.demo.jsf.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexoEnum {
	
	MASCULINO("MASCULINO"),
	FEMININO("FEMININO"),
	OUTROS("OUTROS");
	
	private String descricao;
	
}
