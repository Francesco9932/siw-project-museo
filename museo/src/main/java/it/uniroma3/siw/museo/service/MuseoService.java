package it.uniroma3.siw.museo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.repository.ArtistaRepository;
import it.uniroma3.siw.museo.repository.CollezioneRepository;

@Service
public class MuseoService{
	@Autowired
	public CollezioneRepository collezioneRepository;
	
	@Autowired
	public ArtistaRepository artistaRepository;

	@Transactional
	public List<Collezione> getCollezioni(){
		return (List<Collezione>)collezioneRepository.findAll();
	}

	@Transactional
	public Collezione getCollezionePerId(Long id) {
		Optional<Collezione> optional = collezioneRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public Collezione aggiungiCollezione(Collezione collezione) {
		return collezioneRepository.save(collezione);
	}

	@Transactional
	public void rimuoviCollezione(Collezione collezione) {
		collezioneRepository.delete(collezione);
	}
	
	@Transactional
	public List<Artista> getArtisti(){
		return (List<Artista>)artistaRepository.findAll();
	}
	
	@Transactional
	public List<Artista> getArtistaPerNome(String nome){
		return artistaRepository.findByNome(nome);
	}
	
	@Transactional
	public Artista getArtistaPerId(Long id){
		Optional<Artista> optional = artistaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}
	
	@Transactional
	public Artista aggiungiArtista(Artista artista) {
		return artistaRepository.save(artista);
	}
	
	@Transactional
	public void rimuoviArtista(Artista artista) {
		artistaRepository.delete(artista);
	}
}
