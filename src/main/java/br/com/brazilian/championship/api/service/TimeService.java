package br.com.brazilian.championship.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brazilian.championship.api.dto.TimeDTO;
import br.com.brazilian.championship.api.entity.Time;
import br.com.brazilian.championship.api.repository.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repository;
	
	public TimeDTO cadastrarTime(TimeDTO time) throws Exception {
		Time entity = toEntity(time);
		if (time.getId() == null) {
		entity = repository.save(entity);
		return toDto(entity);
		} else {
			throw new Exception("Time já existe");
		}
	}
	
		

	// método que recebe um dto e converte para entity
	private Time toEntity(TimeDTO time) {
		Time entity = new Time();
		entity.setId(time.getId());
		entity.setEstadio(time.getEstadio());
		entity.setSigla(time.getSigla());
		entity.setNome(time.getNome());
		entity.setUf(time.getUf());
		return entity;
	}
	
	// convertendo entity para dto
	public TimeDTO toDto(Time entity) {
		TimeDTO dto = new TimeDTO();
		// resolvi o problema que o id estava null.
		dto.setId(entity.getId());
		dto.setEstadio(entity.getEstadio());
		dto.setSigla(entity.getSigla());
		dto.setNome(entity.getNome());
		dto.setUf(entity.getUf());
		return dto;
	}


	// convertendo dto para entity
	public List<TimeDTO> listarTimes() {
		return repository.findAll().stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}
	
	
	
	public TimeDTO obterTime(Long id) {
	return	toDto(repository.findById(id).get());
	}
	
	public List<Time> findAll() {
		return repository.findAll();
	}
	
	
	
}
