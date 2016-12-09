package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import webapp.Categoria;

public class CategoriaDAO extends DAO {
	public Categoria salvar(Categoria categoria, int idEsporte) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO categoria(nome_categoria) VALUES(?)");
			stmt.setString(1, categoria.getNomeCategoria());
			stmt.execute();
			try {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					categoria.setIdCategoria(generatedKeys.getInt(1));
				}
			} catch (Exception e) {
				System.out.println("Creating user failed, no ID obtained.");
			}
			stmt = con.prepareStatement("INSERT INTO esporte_categoria(fk_categoria_rel, fk_esporte_rel) VALUES(?,?)");
			stmt.setInt(1, categoria.getIdCategoria());
			stmt.setInt(2, idEsporte);
			stmt.execute();
			close();

		} catch (Exception ex) {
			System.out.println("Erro de acesso ao banco para cad de categoria");
			return null;
		}

		return categoria;
	}
	public ArrayList<Categoria> getALL(int idEsporte){
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		Categoria categoria;
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_categoria, nome_categoria from esporte_categoria left join categoria on esporte_categoria.fk_categoria_rel=categoria.id_categoria where esporte_categoria.fk_esporte_rel="+idEsporte +";");
		
		if(rs.next())
		{
			categoria = new Categoria();
			categoria.setIdCategoria(rs.getInt("id_categoria"));
			categoria.setNomeCategoria(rs.getString("nome_categoria"));
			categorias.add(categoria);
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar as categorias");
			return null;
		}
		return categorias;
		
		
	}
	public Categoria getCategoria(int idCategoria){
		Categoria categoria = new Categoria();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_categoria, nome_categoria from categoria where id_categoria="+idCategoria +";");
		
		if(rs.next())
		{
			categoria.setIdCategoria(rs.getInt("id_categoria"));
			categoria.setNomeCategoria(rs.getString("nome_categoria"));
			
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar as categorias");
			return null;
		}
		return categoria;
		
		
	}
	

}
