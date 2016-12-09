package webapp;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the endereco database table.
 * 
 */

public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEndereco;
	private String cep;
	private String cidade;
	private String complemento;
	private String endereco;
	private String estado;
	private List<Atleta> atletas;
	private List<Evento> eventos;
	private List<Grupo> grupos;

	public Endereco() {
	}


	
	public int getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}


	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	public List<Atleta> getAtletas() {
		return this.atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

	public Atleta addAtleta(Atleta atleta) {
		getAtletas().add(atleta);
		atleta.setEndereco(this);

		return atleta;
	}

	public Atleta removeAtleta(Atleta atleta) {
		getAtletas().remove(atleta);
		atleta.setEndereco(null);

		return atleta;
	}


	
	public List<Evento> getEventos() {
		return this.eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public Evento addEvento(Evento evento) {
		getEventos().add(evento);
		evento.setEndereco(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setEndereco(null);

		return evento;
	}


	
	public List<Grupo> getGrupos() {
		return this.grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	public Grupo addGrupo(Grupo grupo) {
		getGrupos().add(grupo);
		grupo.setEndereco(this);

		return grupo;
	}

	public Grupo removeGrupo(Grupo grupo) {
		getGrupos().remove(grupo);
		grupo.setEndereco(null);

		return grupo;
	}

}