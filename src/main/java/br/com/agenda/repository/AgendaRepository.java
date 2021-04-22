package br.com.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agenda.entity.AgendaEntity;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaEntity, Long>{
	

}
