package com.api.fichagincana.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.api.fichagincana.enums.CursoEnum;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table( name = "TB_EQUIPE" )
public class EquipeModel {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "ID_EQUIPE" )
	private Long id;
	
	@Column( name = "NOME_EQUIPE" )
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column( name = "CURSO", nullable = false )
	private CursoEnum curso;
	
	@OneToMany( mappedBy = "equipe", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true )
	@JsonManagedReference
	private List<ParticipanteModel> participantes;
	
	public void setParticipantes( List<ParticipanteModel> participantes) {
		if (this.participantes == null) {
			this.participantes = new ArrayList<>();
		} else {
			this.participantes.clear();
		}
		if ( participantes != null ) {
			this.participantes.addAll(participantes);
		}
		for( var participante : this.participantes ) {
			participante.setEquipe( this );
		}
	}
	
}
