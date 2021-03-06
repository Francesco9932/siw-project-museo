package it.uniroma3.siw.museo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.museo.model.Artista;
import it.uniroma3.siw.museo.model.Collezione;
import it.uniroma3.siw.museo.model.Curatore;
import it.uniroma3.siw.museo.model.Opera;
import it.uniroma3.siw.museo.repository.ArtistaRepository;
import it.uniroma3.siw.museo.repository.CollezioneRepository;
import it.uniroma3.siw.museo.repository.CuratoreRepository;
import it.uniroma3.siw.museo.repository.OperaRepository;

@Service
public class MuseoService{
	@Autowired
	public CollezioneRepository collezioneRepository;
	
	@Autowired
	public ArtistaRepository artistaRepository;
	
	@Autowired 
	public OperaRepository operaRepository;
	
	@Autowired
	public CuratoreRepository curatoreRepository;

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
	public void rimuoviCollezione(Long id) {
		collezioneRepository.deleteById(id);
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
	public Artista getArtistaPerNomeECognome(String nome, String cognome){
		Optional<Artista> optional = artistaRepository.findByNomeAndCognome(nome,cognome);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
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
	public void rimuoviArtista(Long id) {
		artistaRepository.deleteById(id);
	}
	
	@Transactional
	public Opera aggiungiOpera(Opera opera) {
		return operaRepository.save(opera);
	}
	
	@Transactional
	public Opera getOperaPerId(Long id) {
		Optional<Opera> optional = operaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}
	
	@Transactional
	public void rimuoviOpera(Long id) {
		operaRepository.deleteById(id);
	}
	
	@Transactional
	public Curatore aggiungiCuratore(Curatore curatore) {
		return curatoreRepository.save(curatore);
	}
	
	@Transactional
	public void rimuoviCuratore(Long id) {
		curatoreRepository.deleteById(id);
	}
	
	@Transactional
	public List<Curatore> getCuratori(){
		return (List<Curatore>)curatoreRepository.findAll();
	}
	
	@Transactional
	public Opera getOperaPerTitolo(String titolo) {
		Optional<Opera> optional = this.operaRepository.getOperaByTitolo(titolo);
		
		if(optional.isPresent())
			return optional.get();
		else 
			return null;
 	}
	
	@Transactional
	public List<Opera> getOpere(){
		return (List<Opera>)operaRepository.findAll();
	}
	
	@Transactional
	public boolean alreadyExists(Artista artista) {
		List<Artista> artisti = this.artistaRepository.findByNome(artista.getNome());
		if (artisti.size() > 0)
			return true;
		else 
			return false;
	}
	
	@Transactional
	public boolean alreadyExists(Opera opera) {
		List<Opera> opere = this.operaRepository.findByTitolo(opera.getTitolo());
		if (opere.size() > 0)
			return true;
		else 
			return false;
	}
	
	@Transactional
	public boolean alreadyExists(Collezione collezione) {
		List<Collezione> collezioni = this.collezioneRepository.findByNome(collezione.getNome());
		if (collezioni.size() > 0)
			return true;
		else 
			return false;
	}
	
	@Transactional
	public boolean alreadyExists(Curatore curatore) {
		List<Curatore> curatori = this.curatoreRepository.findByNome(curatore.getNome());
		if (curatori.size() > 0)
			return true;
		else 
			return false;
	}
}
