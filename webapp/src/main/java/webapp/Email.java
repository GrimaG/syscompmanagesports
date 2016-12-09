package webapp;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the email database table.
 * 
 */

public class Email implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEmail;
	private String assunto;
	private String corpo;
	private Atleta atleta;
	private List<EmailAtleta> emailAtletas;

	public Email() {
	}


	
	public int getIdEmail() {
		return this.idEmail;
	}

	public void setIdEmail(int idEmail) {
		this.idEmail = idEmail;
	}


	public String getAssunto() {
		return this.assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}


	public String getCorpo() {
		return this.corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}


	public Atleta getAtleta() {
		return this.atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}


	public List<EmailAtleta> getEmailAtletas() {
		return this.emailAtletas;
	}

	public void setEmailAtletas(List<EmailAtleta> emailAtletas) {
		this.emailAtletas = emailAtletas;
	}

	public EmailAtleta addEmailAtleta(EmailAtleta emailAtleta) {
		getEmailAtletas().add(emailAtleta);
		emailAtleta.setEmail(this);

		return emailAtleta;
	}

	public EmailAtleta removeEmailAtleta(EmailAtleta emailAtleta) {
		getEmailAtletas().remove(emailAtleta);
		emailAtleta.setEmail(null);

		return emailAtleta;
	}

}