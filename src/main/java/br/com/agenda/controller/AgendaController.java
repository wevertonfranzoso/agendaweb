package br.com.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.entity.AgendaEntity;
import br.com.agenda.service.AgendaService;

@RestController
public class AgendaController {

	
	@Autowired
	private AgendaService service;
	
	@ResponseBody
	@GetMapping(value = "/about")
	public ResponseEntity<?> about() {
		return ResponseEntity.ok("Aplicação Web AGENDA");
	}
	
	
	@ResponseBody
	@PostMapping(value="/cadastrar")
	public void save(@RequestBody AgendaEntity agenda) {
		service.save(agenda);
	}
	
	@ResponseBody
	@GetMapping(value= "/listar")
	public ResponseEntity<List<AgendaEntity>> listar() {
		return new ResponseEntity<List<AgendaEntity>>(service.listar(), HttpStatus.OK);
	}

	
	@ResponseBody
	@DeleteMapping(value= "/deletar/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ResponseBody
	@PostMapping(value="/alterar")
	public void update(@RequestBody AgendaEntity agenda) {
		service.save(agenda);
	}
	
	@ResponseBody
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<AgendaEntity> buscaPorId(@PathVariable("id") Long id) {
		return new ResponseEntity<AgendaEntity>(service.buscaPorId(id), HttpStatus.OK);
	}


}
