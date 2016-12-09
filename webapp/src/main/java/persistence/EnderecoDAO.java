package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import webapp.Endereco;

public class EnderecoDAO extends DAO {
	public Endereco salvar(Endereco endereco) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO endereco(cep, complemento, endereco,cidade,estado) VALUES(?,?,?,?,?)");
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getComplemento());
			stmt.setString(3, endereco.getEndereco());
			stmt.setString(4, endereco.getCidade());
			stmt.setString(5, endereco.getEstado());
			stmt.execute();
			try {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					endereco.setIdEndereco(generatedKeys.getInt(1));
				}
			} catch (Exception e) {
				System.out.println("Creating user failed, no ID obtained.");
			}
			close();

		} catch (Exception ex) {
			System.out.println("Erro de acesso ao banco para cad de categoria");
			return null;
		}

		return endereco;
	}

	public Endereco getEndereco(int idEndereco){
		Endereco endereco = new Endereco();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_endereco, cep, complemento, endereco, cidade, estado from endereco where id_endereco="+idEndereco +";");
		
		if(rs.next())
		{
			endereco.setIdEndereco(rs.getInt("id_categoria"));
			endereco.setCep(rs.getString("cep"));
			endereco.setComplemento(rs.getString("complemento"));
			endereco.setEndereco(rs.getString("endereco"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setEstado(rs.getString("estado"));
			
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar as categorias");
			return null;
		}
		return endereco;
		
		
	}
	

}
