package br.com.brazilian.championship.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brazilian.championship.api.entity.Time;
import br.com.brazilian.championship.api.repository.TimeRepository;

@Service
public class TimeService {
	
	@Autowired
	private TimeRepository repository;
	
	public void cadastrarTime(Time time) {
		repository.save(time);
	}

	
	public List<Time> listarTimes() {
		return repository.findAll();
	}
	
	
	
}
