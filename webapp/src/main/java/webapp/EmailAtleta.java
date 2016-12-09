package webapp;

import java.io.Serializable;


/**
 * The persistent class for the email_atleta database table.
 * 
 */

public class EmailAtleta implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idEmailatleta;
	private byte lido;
	private Atleta atleta;
	private Email email;

	public EmailAtleta() {
	}


	
	public int getIdEmailatleta() {
		return this.idEmailatleta;
	}

	public void setIdEmailatleta(int idEmailatleta) {
		this.idEmailatleta = idEmailatleta;
	}


	public byte getLido() {
		return this.lido;
	}

	public void setLido(byte lido) {
		this.lido = lido;
	}


	
	public Atleta getAtleta() {
		return this.atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}


	
	public Email getEmail() {
		return this.email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

}