package br.unipe.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/time")
public class TimeController {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Time>> listarTodosTimes() {
		List<Time> listaTimesFake = new ArrayList<Time>();
		listaTimesFake.add(new Time(1,"Palmeiras","SP"));
		listaTimesFake.add(new Time(2,"Vasco","RJ"));
		return new ResponseEntity<List<Time>>(listaTimesFake, HttpStatus.OK);

	}

	@RequestMapping(value="{identificador}", method = RequestMethod.GET)
	public ResponseEntity<Time> obterInformacaoTime(@PathVariable(value="identificador") String id) {
		Time timeCampeao = new Time(1,"Palmeiras","SP");
		return timeCampeao == null ? 
				new ResponseEntity<Time>(HttpStatus.NOT_FOUND) : 
					new ResponseEntity<Time>(timeCampeao, HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Time> createTime(@RequestBody Time time) {
		try {
			return new ResponseEntity<Time>(time, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Time>(time, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Time> atualizarTime(@RequestBody Time time) {
		return new ResponseEntity<Time>(time, HttpStatus.OK);		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> excluirTime(@RequestBody Time time) {
		return new ResponseEntity<String>(HttpStatus.OK);	
	}

}
