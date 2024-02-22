package br.com.brazilian.championship.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brazilian.championship.api.entity.Jogo;
import br.com.brazilian.championship.api.entity.Time;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

	List<Jogo> findByTime1AndEncerrado(Time time1, Boolean encerrado );
	List<Jogo> findByTime2AndEncerrado(Time time2, Boolean encerrado );
	List<Jogo> findByEncerrado(Time time1, Boolean encerrado);

}
