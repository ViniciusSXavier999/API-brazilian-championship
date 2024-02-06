package br.com.brazilian.championship.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brazilian.championship.api.dto.TimeDTO;
import br.com.brazilian.championship.api.entity.Time;
import br.com.brazilian.championship.api.service.TimeService;

@RestController
@RequestMapping(value = "/times")
public class TimeController {
	
	@Autowired
	private TimeService timeService;
	

	@GetMapping
	public ResponseEntity<List<TimeDTO>> getTimes(Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(timeService.listarTimes()); 
	}

	

	@GetMapping(value = "{id}")
	public ResponseEntity<TimeDTO> getTime( @PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(timeService.obterTime(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> cadastrarTime( @RequestBody TimeDTO time) {
		timeService.cadastrarTime(time);
		return ResponseEntity.ok().build();
	}

}
