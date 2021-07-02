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
public class Curatore {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matricola;
	
	@Column()
	private String nome;
	
	@Column()
	private String cognome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column
	private LocalDate dataDiNascita;
	
	@Column()
	private String luogoDiNascita;
	
	@Column()
	private String email;
	
	@Column()
	private String telefono;
	
	@OneToMany(mappedBy = "curatore")
	private List<Collezione> collezioni;
	
	public Curatore() {
		collezioni = new ArrayList<Collezione>();
	}

	public Long getMatricola() {
		return matricola;
	}

	public void setMatricola(Long matricola) {
		this.matricola = matricola;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Collezione> getCollezioni() {
		return collezioni;
	}

	public void setCollezioni(List<Collezione> collezioni) {
		this.collezioni = collezioni;
	}
}
