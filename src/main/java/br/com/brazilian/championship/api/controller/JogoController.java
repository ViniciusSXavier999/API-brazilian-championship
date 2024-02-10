package br.com.brazilian.championship.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brazilian.championship.api.entity.Jogo;
import br.com.brazilian.championship.api.service.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoController {
	
	@Autowired
	private JogoService jogoService;
	
	@PostMapping(value = "/gerar-jogos")
	public ResponseEntity<Void> gerarJogos() {
		jogoService.gerarJogos(LocalDateTime.now());
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Jogo>> obterJogos(){
		return ResponseEntity.ok().body(jogoService.obterJogos());
	}

}
