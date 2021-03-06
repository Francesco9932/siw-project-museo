package it.uniroma3.siw.museo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.museo.model.Collezione;

public interface CollezioneRepository extends CrudRepository<Collezione,Long>{
	public List<Collezione> findByNome(String nome);
}
