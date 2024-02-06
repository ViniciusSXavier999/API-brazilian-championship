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
	
	public void cadastrarTime(TimeDTO time) {
		Time entity = toEntity(time);
		repository.save(entity);
	}

	// criando o método que converte time para DTO
	private Time toEntity(TimeDTO time) {
		Time entity = new Time();
		entity.setEstadio(time.getEstadio());
		entity.setSigla(time.getSigla());
		entity.setNome(time.getNome());
		entity.setUf(time.getUf());
		return entity;
	}
	
	private TimeDTO toDto(Time entity) {
		TimeDTO dto = new TimeDTO();
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
	
	
	
}
