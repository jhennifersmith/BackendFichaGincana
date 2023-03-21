package com.api.fichagincana.controllers;

import com.api.fichagincana.services.EquipeService;
import com.api.fichagincana.services.ParticipanteService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.api.fichagincana.dtos.EquipeDTO;
import com.api.fichagincana.models.EquipeModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
	
	@Autowired
	private EquipeService equipeService;
	
	@Autowired
	private ParticipanteService participanteService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getEquipe(@PathVariable(value = "id") Long id){
		Optional<EquipeModel> equipeModelOptional = equipeService.getById(id);
		if (!equipeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipe não encontrada");
		}
		return ResponseEntity.status(HttpStatus.OK).body(equipeModelOptional.get());
	}
	
	@GetMapping
	public ResponseEntity<List<EquipeModel>> getAllEquipes(){
		return ResponseEntity.status(HttpStatus.OK).body(equipeService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<Object>saveEquipe(@RequestBody @Valid EquipeDTO equipeDTO,UriComponentsBuilder uriBuilder) throws Exception{
		var equipeModel = new EquipeModel();
		BeanUtils.copyProperties(equipeDTO, equipeModel);
		equipeService.save(equipeModel);
		var participantes = participanteService.saveAll(equipeModel.getParticipantes(), equipeModel);
		equipeModel.setParticipantes(participantes);
		URI uri = uriBuilder.path("equipe/{id}").buildAndExpand(equipeModel.getId()).toUri();
		return ResponseEntity.created(uri).body(equipeModel);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object>updateEquipe(@PathVariable(value="id") Long id, @RequestBody @Valid EquipeDTO equipeDTO) throws Exception{
		Optional<EquipeModel> equipeModelOptional = equipeService.getById(id);
		if (!equipeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipe não encontrada");
		}
		var equipeModel = new EquipeModel();
		BeanUtils.copyProperties(equipeDTO, equipeModel);
		equipeModel.setId(equipeModelOptional.get().getId());
		return ResponseEntity.status(HttpStatus.OK).body(equipeService.save(equipeModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEquipe(@PathVariable(value = "id") Long id){
		Optional<EquipeModel> equipeModelOptional = equipeService.getById(id);
		if (!equipeModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Equipe não encontrada");
		}
		equipeService.delete(equipeModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Equipe deletada com sucesso");
	}
	
	
}