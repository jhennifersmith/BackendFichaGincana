package com.api.fichagincana.util;

public class BusinessError {
	private String descricao;
	
	public BusinessError(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
