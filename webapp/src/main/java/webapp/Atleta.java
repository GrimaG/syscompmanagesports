package webapp;

import java.io.Serializable;

import java.util.List;


/**
 * The persistent class for the atleta database table.
 * 
 */

public class Atleta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idAtleta;
	private String descricao;
	private String foto;
	private int idade;
	private String nomeAtleta;
	private String senha;
	private String sexo;
	private String usuario;
	private Categoria categoria;
	private Endereco endereco;
	private Grupo grupo;
	private List<AtletaEvento> atletaEventos;
	private List<Email> emails;
	private List<EmailAtleta> emailAtletas;

	public Atleta() {
	}


	
	public int getIdAtleta() {
		return this.idAtleta;
	}

	public void setIdAtleta(int idAtleta) {
		this.idAtleta = idAtleta;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}


	public int getIdade() {
		return this.idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getNomeAtleta() {
		return this.nomeAtleta;
	}

	public void setNomeAtleta(String nomeAtleta) {
		this.nomeAtleta = nomeAtleta;
	}


	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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


	public List<AtletaEvento> getAtletaEventos() {
		return this.atletaEventos;
	}

	public void setAtletaEventos(List<AtletaEvento> atletaEventos) {
		this.atletaEventos = atletaEventos;
	}

	public AtletaEvento addAtletaEvento(AtletaEvento atletaEvento) {
		getAtletaEventos().add(atletaEvento);
		atletaEvento.setAtleta(this);

		return atletaEvento;
	}

	public AtletaEvento removeAtletaEvento(AtletaEvento atletaEvento) {
		getAtletaEventos().remove(atletaEvento);
		atletaEvento.setAtleta(null);

		return atletaEvento;
	}


	public List<Email> getEmails() {
		return this.emails;
	}

	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Email addEmail(Email email) {
		getEmails().add(email);
		email.setAtleta(this);

		return email;
	}

	public Email removeEmail(Email email) {
		getEmails().remove(email);
		email.setAtleta(null);

		return email;
	}


	
	public List<EmailAtleta> getEmailAtletas() {
		return this.emailAtletas;
	}

	public void setEmailAtletas(List<EmailAtleta> emailAtletas) {
		this.emailAtletas = emailAtletas;
	}

	public EmailAtleta addEmailAtleta(EmailAtleta emailAtleta) {
		getEmailAtletas().add(emailAtleta);
		emailAtleta.setAtleta(this);

		return emailAtleta;
	}

	public EmailAtleta removeEmailAtleta(EmailAtleta emailAtleta) {
		getEmailAtletas().remove(emailAtleta);
		emailAtleta.setAtleta(null);

		return emailAtleta;
	}

}