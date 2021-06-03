package it.uniroma3.siw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Collezione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String descrizione;
	
	@ManyToOne()
	private Dipendente curatore;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "collezione") //Eager = impaziente 
	private List<Opera> opere;
	
	public Collezione() {
		opere = new ArrayList<Opera>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Dipendente getCuratore() {
		return curatore;
	}

	public void setCuratore(Dipendente curatore) {
		this.curatore = curatore;
	}

	public List<Opera> getOpere() {
		return opere;
	}

	public void setOpere(List<Opera> opere) {
		this.opere = opere;
	}
	
}
