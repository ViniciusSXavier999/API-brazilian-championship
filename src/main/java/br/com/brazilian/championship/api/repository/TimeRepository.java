package br.com.brazilian.championship.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.brazilian.championship.api.entity.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {

}
