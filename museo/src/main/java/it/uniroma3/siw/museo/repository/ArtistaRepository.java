package it.uniroma3.siw.museo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.museo.model.Artista;

public interface ArtistaRepository extends CrudRepository<Artista,Long>{
	public List<Artista> findByNome(String nome);
	
	public Optional<Artista> findByNomeAndCognome(String nome, String cognome);
}
