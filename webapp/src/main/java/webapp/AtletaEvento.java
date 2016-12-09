package webapp;

import java.io.Serializable;


/**
 * The persistent class for the atleta_evento database table.
 * 
 */

public class AtletaEvento implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAtletaevento;
	private int colocacao;
	private Atleta atleta;
	private Evento evento;

	public AtletaEvento() {
	}


	
	public int getIdAtletaevento() {
		return this.idAtletaevento;
	}

	public void setIdAtletaevento(int idAtletaevento) {
		this.idAtletaevento = idAtletaevento;
	}


	public int getColocacao() {
		return this.colocacao;
	}

	public void setColocacao(int colocacao) {
		this.colocacao = colocacao;
	}


	
	public Atleta getAtleta() {
		return this.atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}



	public Evento getEvento() {
		return this.evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

}