package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import webapp.Email;

public class EmailDAO extends DAO {
	public Email salvarEmail(Email email) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO email(assunto, corpo, fk_atleta_email) VALUES(?,?,?)");
			stmt.setString(1, email.getAssunto());
			stmt.setString(2, email.getCorpo());
			stmt.setInt(3, email.getAtleta().getIdAtleta());
			stmt.execute();
			try {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					email.setIdEmail(generatedKeys.getInt(1));
				}
			} catch (Exception e) {
				System.out.println("Creating user failed, no ID obtained.");
			}
			close();
			

		} catch (Exception ex) {
			System.out.println("Erro de acesso ao banco para cad de categoria");
			return null;
		}

		return email;
	}
	public boolean enviarEmail(int idEmail, int idDestinatario){
		try {
			stmt = con.prepareStatement("INSERT INTO email_atleta(fk_email, fk_atleta, lido) VALUES(?,?,0)");
			stmt.setInt(1, idEmail);
			stmt.setInt(2, idDestinatario);
			
			stmt.execute();
			
			close();
			

		} catch (Exception ex) {
			System.out.println("Erro de acesso ao banco para cad de categoria");
			return false;
		}
		return true;
	}

	public ArrayList<Email> getEmails(int idUser){
		ArrayList<Email> emails = new ArrayList<Email>();
		Email email;
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_email, assunto, corpo, id_emailatleta from email inner join email_atleta on email.id_email=email_atleta.fk_email  where fk_atleta="+idUser +" and lido = 0;");
		
		if(rs.next())
		{
			email  = new Email();
			email.setIdEmail(rs.getInt("id_email"));
			email.setAssunto(rs.getString("assunto"));
			email.setCorpo(rs.getString("corpo"));
			//email.addEmailAtleta("id_emailatleta");
			emails.add(email);
			
			
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar as categorias");
			return null;
		}
		return emails;
		
		
	}

}
