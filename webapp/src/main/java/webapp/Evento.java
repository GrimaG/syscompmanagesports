package webapp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the evento database table.
 * 
 */
public class Evento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEvento;
	private Timestamp data;
	private String descricao;
	private String nomeEvento;
	private List<AtletaEvento> atletaEventos;
	private Endereco endereco;
	private Grupo grupo;

	public Evento() {
	}


	public int getIdEvento() {
		return this.idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}


	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getNomeEvento() {
		return this.nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}


	//bi-directional many-to-one association to AtletaEvento
	
	public List<AtletaEvento> getAtletaEventos() {
		return this.atletaEventos;
	}

	public void setAtletaEventos(List<AtletaEvento> atletaEventos) {
		this.atletaEventos = atletaEventos;
	}

	public AtletaEvento addAtletaEvento(AtletaEvento atletaEvento) {
		getAtletaEventos().add(atletaEvento);
		atletaEvento.setEvento(this);

		return atletaEvento;
	}

	public AtletaEvento removeAtletaEvento(AtletaEvento atletaEvento) {
		getAtletaEventos().remove(atletaEvento);
		atletaEvento.setEvento(null);

		return atletaEvento;
	}


	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}



	public Grupo getGrupo() {
		return this.grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}