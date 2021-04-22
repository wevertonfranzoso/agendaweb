package br.com.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.agenda.entity.AgendaEntity;
import br.com.agenda.repository.AgendaRepository;

@Service
public class AgendaService {
	
	@Autowired
	private AgendaRepository repository;
	
	
	//CREATE
	public void save(AgendaEntity agenda) {
		 repository.save(agenda);
	}
	
	
	//READY
	public List<AgendaEntity> listar() {
		return repository.findAll();
	}

	
	//DELETE
	public void delete(Long id) {
		repository.deleteById(id);
		
	}



	//Find by id
	public AgendaEntity buscaPorId(Long id) {
		Optional<AgendaEntity> optf = repository.findById(id);
		return optf.get();

	}

}
