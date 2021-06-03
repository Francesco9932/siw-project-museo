package it.uniroma3.siw.museo.model;

import javax.persistence.*;

@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String titolo;
	
	@Column(nullable = false)
	private int annoDiRealizzazione;
	
	@Column(nullable = false)
	private String descrizione;
	
	@ManyToOne
	private Collezione collezione;
	
	@ManyToOne
	private Artista artista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnoDiRealizzazione() {
		return annoDiRealizzazione;
	}

	public void setAnnoDiRealizzazione(int annoDiRealizzazione) {
		this.annoDiRealizzazione = annoDiRealizzazione;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Collezione getCollezione() {
		return collezione;
	}

	public void setCollezione(Collezione collezione) {
		this.collezione = collezione;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
}
