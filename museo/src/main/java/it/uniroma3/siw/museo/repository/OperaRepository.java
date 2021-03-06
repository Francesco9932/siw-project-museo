package it.uniroma3.siw.museo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.museo.model.Opera;

public interface OperaRepository extends CrudRepository<Opera,Long>{
	public Optional<Opera> getOperaByTitolo(String titolo);
	
	public List<Opera> findByTitolo(String nome);
}
