package it.uniroma3.siw.museo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Artista {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate dataDiNascita;
	
	@Column
	private String luogoDiNascita;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate dataDiMorte;
	
	@Column
	private String luogoDiMorte;
	
	@Column
	private String nazionalita;
	
	@Column
	private String descrzione;
	
	@OneToMany(mappedBy = "artista")
	private List<Opera> opere;
	
	public Artista() {
		opere = new ArrayList<Opera>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getLuogoDiNascita() {
		return luogoDiNascita;
	}

	public void setLuogoDiNascita(String luogoDiNascita) {
		this.luogoDiNascita = luogoDiNascita;
	}

	public LocalDate getDataDiMorte() {
		return dataDiMorte;
	}

	public void setDataDiMorte(LocalDate dataDiMorte) {
		this.dataDiMorte = dataDiMorte;
	}

	public String getLuogoDiMorte() {
		return luogoDiMorte;
	}

	public void setLuogoDiMorte(String luogoDiMorte) {
		this.luogoDiMorte = luogoDiMorte;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrzione() {
		return descrzione;
	}

	public void setDescrzione(String descrzione) {
		this.descrzione = descrzione;
	}
}
