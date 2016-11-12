package br.unipe.rest.service;

import java.util.List;

import br.unipe.rest.domain.Time;

public interface TimeService {

	Time save(Time time);

	Time getById(Long id);

	void delete(Time time);
	
	List<Time> listAllTimes();
}
