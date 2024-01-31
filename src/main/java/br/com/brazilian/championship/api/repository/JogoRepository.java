package br.com.brazilian.championship.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brazilian.championship.api.entity.Jogo;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

}
