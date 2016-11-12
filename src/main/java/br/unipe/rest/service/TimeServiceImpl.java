package br.unipe.rest.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import br.unipe.rest.domain.Time;
import br.unipe.rest.repository.TimeRepository;

@Service
@Validated
public class TimeServiceImpl implements TimeService {

    private final TimeRepository repository;

    @Autowired
    public TimeServiceImpl(final TimeRepository repository) {
        this.repository = repository;
    }
    
    public Time getById(Long id) {    
    	return repository.findOne(id);
    }
    
    public void delete(Time time) {    
    	repository.delete(time);
    }
    
	public List<Time> listAllTimes() {
		return repository.findAll();
	}
	
    @Transactional
    public Time save(@NotNull @Valid final Time time) {
    	
    	Time existing = repository.findOne(time.getId());
/*        
        if (existing != null) {
            throw new UserAlreadyExistsException(String.format("There already exists a participant with email=%s", participant.getName()));
        }
 */
        
        return repository.save(time);
    }

}
