package webapp;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the esporte database table.
 * 
 */

public class Esporte implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEsporte;
	private String nomeEsporte;
	private List<Categoria> categorias;
	private List<Grupo> grupos;

	public Esporte() {
	}


	
	public int getIdEsporte() {
		return this.idEsporte;
	}

	public void setIdEsporte(int idEsporte) {
		this.idEsporte = idEsporte;
	}


	public String getNomeEsporte() {
		return this.nomeEsporte;
	}

	public void setNomeEsporte(String nomeEsporte) {
		this.nomeEsporte = nomeEsporte;
	}



	public List<Categoria> getCategorias() {
		return this.categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setEsporte(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setEsporte(null);

		return grupo;
	}

}