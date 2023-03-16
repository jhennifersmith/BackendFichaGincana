package com.api.fichagincana.enums;

import lombok.Getter;

@Getter
public enum CursoEnum {
	AGRO("Agronomia"),
	TADS("Análise e Desenvolvimento de Sistemas"),
	BIO("Bacharelado em Ciencias Biologicas");
	
	private String descricao;
	
	private CursoEnum( String descricao ) {
		this.descricao = descricao;
	}
}
