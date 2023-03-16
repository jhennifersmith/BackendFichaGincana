package com.api.fichagincana.dtos;

import java.util.List;


import javax.validation.constraints.NotBlank;

import com.api.fichagincana.enums.CursoEnum;
import com.api.fichagincana.models.ParticipanteModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EquipeDTO {

	@NotBlank
	private String nome;

	private CursoEnum curso;
	
	private List<ParticipanteModel> participantes;
	
}
