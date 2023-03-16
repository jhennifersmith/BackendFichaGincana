package com.api.fichagincana.dtos;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticipanteDTO {
	
	private EquipeDTO equipe;

	@NotBlank
	private String nome;
	
	@NotBlank
	private String telefone;
}
