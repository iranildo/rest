package br.unipe.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unipe.rest.domain.Time;

public interface TimeRepository extends JpaRepository<Time, Long> {

	public Time findByNome(String name);
	
}
