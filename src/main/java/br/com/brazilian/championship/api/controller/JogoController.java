package br.com.brazilian.championship.api.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.brazilian.championship.api.dto.ClassificacaoDTO;
import br.com.brazilian.championship.api.dto.FinalizarJogoDTO;
import br.com.brazilian.championship.api.dto.JogoDTO;
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
	public ResponseEntity<List<JogoDTO>> obterJogos(){
		return ResponseEntity.ok().body(jogoService.listarJogos());
	}
	
	// POST PARA FINALIZAR O JOGO
	/*Quando eu for finalizar um jogo basicamente eu tenho que passar qual é o id dele e qual é o jogo*/
	@PostMapping(value = "/finalizar/{id}")
	public ResponseEntity<JogoDTO> finalizarJogo(@PathVariable Long id,   @RequestBody FinalizarJogoDTO jogoDTO) throws Exception {
		return ResponseEntity.ok().body(jogoService.finalizarJogo(id, jogoDTO));
	}
	
	
	// GET PARA OBTER A CLASSIFICAÇÃO DO CAMPEONATO
	@GetMapping(value = "/classificacao")
	public ResponseEntity<ClassificacaoDTO> classificacao() {
		return ResponseEntity.ok().body(jogoService.obterClassificacao());
	}
	
	
	// GET PARA BUSCAR UM JOGO ESPECIFICO POR ID 
	@GetMapping(value = "/jogo/{id}")
	public ResponseEntity<JogoDTO> obterJogo(@PathVariable Long id) {
		return ResponseEntity.ok().body(jogoService.obterJogo(id));
	}
	
	

	

}
