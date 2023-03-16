package com.api.fichagincana.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_PARTICIPANTES")
public class ParticipanteModel {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "ID_PARTICIPANTE", nullable = false )
	private Long id;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "ID_EQUIPE", nullable = false )
	@JsonBackReference
	private EquipeModel equipe;
	
	@Column( name = "NOME_PARTICIPANTE", nullable = false )
	private String nome;
	
	@Column( name = "TELEFONE_PARTICIPANTE", nullable = false )
	private String telefone;
	
}
