package br.com.brazilian.championship.api.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.brazilian.championship.api.dto.JogoDTO;
import br.com.brazilian.championship.api.entity.Jogo;
import br.com.brazilian.championship.api.entity.Time;
import br.com.brazilian.championship.api.repository.JogoRepository;
import br.com.brazilian.championship.api.repository.TimeRepository;

@Service
public class JogoService {
	
	@Autowired
	JogoRepository jogoRepository;
	
	@Autowired
	TimeService timeService;
	
	
	//método para gerar jogos automaticamente, para que não seja preciso ficar gerando os jogos
	// lógica para todo mundo jogar contra todo mundo
	public void gerarJogos(LocalDateTime primeiraRodada) {
		final List<Time> times = timeService.findAll(); // estou pegando todos os times
		List<Time> all1 = new ArrayList<>(); // monto duas listas // primeira lista é o 1 turno e a 2 lista o 2 turno
		List<Time> all2 = new ArrayList<>(); 
		
		// depois eu adiciono os dois times nas duas listas
		all1.addAll(times);
		all2.addAll(times);
		
		jogoRepository.deleteAll();
		
		// aqui eu tenho uma lista de jogos 
		List<Jogo> jogos = new ArrayList<>();
		
		int t = times.size();
		int m = times.size() / 2;
		LocalDateTime dataJogo = primeiraRodada;
		Integer rodada = 0;
		
		for(int i = 0; i < t - 1; i++) {
			rodada = i + 1;
			for(int j = 0; j < m; j++) {
				//teste para ajustar o mando de campo
				Time time1;
				Time time2;
				if(j % 2 == 1 || i % 2 == 1 && j == 0) {
					time1 = times.get(t - j - 1);
					time2 = times.get(j);
					
				} else {
					time1 = times.get(j);
					time2 = times.get(t - j - 1);
				}
				if (time1 == null) {
					System.out.println("Time 1 null");
				}
				jogos.add(gerarJogo(dataJogo, rodada, time1, time2));
				dataJogo = dataJogo.plusDays(7);
			}
			
			// gira os times no sentido horario, mantendo o primeiro no lugar
			times.add(1, times.remove(times.size() -1 ));
		}
		
		jogos.forEach(jogo -> System.out.println(jogo));
		jogoRepository.saveAll(jogos);
		
		List<Jogo> jogos2 = new ArrayList<Jogo>();
		
		jogos.forEach(jogo -> {
			Time time1 = jogo.getTime2();
			Time time2 = jogo.getTime1();
			jogos2.add(gerarJogo(jogo.getData().plusDays(7 * jogos.size()), jogo.getRodada() + jogos.size(), time1, time2));
			
		});
		jogoRepository.saveAll(jogos2);
	}
	
	
	
	private Jogo gerarJogo(LocalDateTime dataJogo, Integer rodada, Time time1, Time time2) {
		Jogo jogo = new Jogo();
		jogo.setTime1(time1);
		jogo.setTime2(time2);
		jogo.setRodada(rodada);
		jogo.setData(dataJogo);
		jogo.setEncerrado(false);
		jogo.setGolsTime1(0);
		jogo.setGolsTime2(0);
		jogo.setPublicoPagante(0);
		return jogo;
	}
	
	// convertendo JOGO PARA JOGODTO
	public JogoDTO toDto(Jogo entity) {
		JogoDTO dto = new JogoDTO();
		dto.setId(entity.getId());
		dto.setData(entity.getData());
		dto.setEncerrado(entity.getEncerrado());
		dto.setGolsTime1(entity.getGolsTime1());
		dto.setGolsTime2(entity.getGolsTime2());
		dto.setPublicoPagante(entity.getPublicoPagante());
		dto.setRodada(entity.getRodada());
		dto.setTime1(timeService.toDto(entity.getTime1()));
		dto.setTime2(timeService.toDto(entity.getTime2()));
		return dto;
	}

	public List<JogoDTO> listarJogos() {
		return jogoRepository.findAll().stream().
				map(entity -> toDto(entity)).collect(Collectors.toList());
	}

// ------------------------------

	public JogoDTO finalizarJogo(Long id, JogoDTO jogoDTO) throws Exception {
		Optional<Jogo> optionalJogo = jogoRepository.findById(id);
		
		if (optionalJogo.isPresent()) {
			final Jogo jogo = optionalJogo.get();
			jogo.setGolsTime1(jogoDTO.getGolsTime1());
			jogo.setGolsTime2(jogoDTO.getGolsTime2());
			jogo.setEncerrado(true);
			jogo.setPublicoPagante(jogoDTO.getPublicoPagante());
			return toDto(jogoRepository.save(jogo));
		} else {
			throw new Exception("Jogo não existe!");
		}
		
	}

// ------------------------------

/*
	public Object obterClassificacao() {
		// TODO Auto-generated method stub
		return null;
	}
*/

// -----------------------------

	public JogoDTO obterJogo(Long id) {
		return toDto(jogoRepository.findById(id).get());
	}

}
