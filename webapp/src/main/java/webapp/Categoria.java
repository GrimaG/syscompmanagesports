package webapp;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */

public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idCategoria;
	private String nomeCategoria;
	private List<Atleta> atletas;
	private List<Esporte> esportes;

	public Categoria() {
	}


	public int getIdCategoria() {
		return this.idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}


	public String getNomeCategoria() {
		return this.nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}


	public List<Atleta> getAtletas() {
		return this.atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

	public Atleta addAtleta(Atleta atleta) {
		getAtletas().add(atleta);
		atleta.setCategoria(this);

		return atleta;
	}

	public Atleta removeAtleta(Atleta atleta) {
		getAtletas().remove(atleta);
		atleta.setCategoria(null);

		return atleta;
	}


	
	public List<Esporte> getEsportes() {
		return this.esportes;
	}

	public void setEsportes(List<Esporte> esportes) {
		this.esportes = esportes;
	}

}