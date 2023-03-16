package com.api.fichagincana.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.api.fichagincana.models.EquipeModel;
import com.api.fichagincana.models.ParticipanteModel;
import com.api.fichagincana.repositories.ParticipanteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipanteService {

	@Autowired
	private ParticipanteRepository participanteRepository;
	
	@Transactional
	public ParticipanteModel save (ParticipanteModel participanteModel) {
		return participanteRepository.save(participanteModel);
	}
	
	public List<ParticipanteModel> saveAll(List<ParticipanteModel> participantes, EquipeModel equipe){
		var participantesSalvos = new ArrayList<ParticipanteModel>();
		for(var participante : participantes) {
			participante.setEquipe ( equipe );
			participantesSalvos.add(save(participante));
		}
		return participantesSalvos;
	}
	
	@Transactional
	public void delete(ParticipanteModel participanteModel) {
		participanteRepository.delete(participanteModel);
	}
	
	
	
}
