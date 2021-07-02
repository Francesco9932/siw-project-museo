package it.uniroma3.siw.museo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.museo.model.Curatore;

public interface CuratoreRepository extends CrudRepository<Curatore,Long>{
	public List<Curatore> findByNome(String nome);
}
