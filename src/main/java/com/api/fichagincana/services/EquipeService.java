package com.api.fichagincana.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.api.fichagincana.models.EquipeModel;
import com.api.fichagincana.repositories.EquipeRepository;
import com.api.fichagincana.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {

	@Autowired
	private EquipeRepository equipeRepository;

	public Optional<EquipeModel> getById(Long id){
		return equipeRepository.findById(id);
	}
	
	public List<EquipeModel> findAll() {
		return equipeRepository.findAll();
	}

	@Transactional
	public EquipeModel save (EquipeModel equipeModel) throws Exception {
		validate(equipeModel);
		return equipeRepository.save(equipeModel);
	}
	
	@Transactional
	public void delete(EquipeModel equipeModel) {
		equipeRepository.delete(equipeModel);
	}
	
	public void validate(EquipeModel equipeModel) throws Exception {
		if (!AppUtil.isNotNullAndNotEmpty(equipeModel)) {
			throw new Exception("Equipe é nula ou inválida!");
		}
		
		if (!AppUtil.isNotNullAndNotEmpty(equipeModel.getNome())) {
			throw new Exception("Nome da equipe é nulo ou inválido!");
		}
		if (!AppUtil.isNotNullAndNotEmpty(equipeModel.getCurso())) {
			throw new Exception("Curso da equipe é nulo ou inválido!");
		}
		if (!AppUtil.isNotNullAndNotEmpty(equipeModel.getParticipantes())) {
			throw new Exception("Participantes da equipe está nulo ou inválido!");
		}
	}
	
}
