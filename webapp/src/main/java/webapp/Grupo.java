package webapp;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the grupo database table.
 * 
 */

public class Grupo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idGrupo;
	private String descricao;
	private String img;
	private String nome;
	private String telefone;
	private int userMain;
	private List<Atleta> atletas;
	private List<Evento> eventos;
	private Endereco endereco;
	private Esporte esporte;

	public Grupo() {
	}



	public int getIdGrupo() {
		return this.idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public int getUserMain() {
		return this.userMain;
	}

	public void setUserMain(int userMain) {
		this.userMain = userMain;
	}


	public List<Atleta> getAtletas() {
		return this.atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

	public Atleta addAtleta(Atleta atleta) {
		getAtletas().add(atleta);
		atleta.setGrupo(this);

		return atleta;
	}

	public Atleta removeAtleta(Atleta atleta) {
		getAtletas().remove(atleta);
		atleta.setGrupo(null);

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
		evento.setGrupo(this);

		return evento;
	}

	public Evento removeEvento(Evento evento) {
		getEventos().remove(evento);
		evento.setGrupo(null);

		return evento;
	}


	
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}


	
	public Esporte getEsporte() {
		return this.esporte;
	}

	public void setEsporte(Esporte esporte) {
		this.esporte = esporte;
	}

}