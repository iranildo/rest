package br.unipe.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.unipe.rest.domain.Time;
import br.unipe.rest.service.TimeService;


@RestController
@RequestMapping(value="/time")
public class TimeController {

	private final TimeService timeService;

	@Autowired
	public TimeController(final TimeService timeService) {
		this.timeService = timeService;
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Time>> listarTodosTimes() {
		return new ResponseEntity<List<Time>>(timeService.listAllTimes(), HttpStatus.OK);

	}

	@RequestMapping(value="{identificador}", method = RequestMethod.GET)
	public ResponseEntity<Time> obterTimePorId(@PathVariable(value="identificador") Long id) {
		Time timeCampeao = timeService.getById(id);
		return timeCampeao == null ? 
				new ResponseEntity<Time>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Time>(timeCampeao, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Time> createTime(@RequestBody Time time) {
		return saveUpdate(time);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Time> atualizarTime(@RequestBody Time time) {
		return saveUpdate(time);	
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> excluirTime(@RequestBody Time time) {
		try {
			timeService.delete(time);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private ResponseEntity<Time> saveUpdate(Time time) {
		try {
			Time retorno = timeService.save(time);
			return new ResponseEntity<Time>(retorno, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Time>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
