package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import webapp.Esporte;

public class EsporteDAO extends DAO {
	public Esporte salvar(Esporte esporte) {
		try {
			open();
			stmt = con.prepareStatement("INSERT INTO esporte(nome_esporte) VALUES(?)");
			stmt.setString(1, esporte.getNomeEsporte());
			stmt.execute();
			try {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					esporte.setIdEsporte(generatedKeys.getInt(1));
				}
			} catch (Exception e) {
				System.out.println("Creating user failed, no ID obtained.");
			}
			close();

		} catch (Exception ex) {
			System.out.println("Erro de acesso ao banco para cad de esporte");
			return null;
		}

		return esporte;
	}
	public ArrayList<Esporte> getALL(){
		ArrayList<Esporte> esportes = new ArrayList<Esporte>();
		Esporte esporte;
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_esporte, nome_esporte from esporte;");
		
		if(rs.next())
		{
			esporte = new Esporte();
			esporte.setIdEsporte(rs.getInt("id_categoria"));
			esporte.setNomeEsporte(rs.getString("nome_categoria"));
			esporte.setCategorias(categoriaDAO.getALL(esporte.getIdEsporte()));
			esportes.add(esporte);
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar  os esportes");
			return null;
		}
		return esportes;

	}
	public Esporte getEsporte(int idEsporte){
		Esporte esporte = new Esporte();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_esporte, nome_esporte from esporte where id_esporte="+idEsporte+";");
		
		if(rs.next())
		{
			
			esporte.setIdEsporte(rs.getInt("id_categoria"));
			esporte.setNomeEsporte(rs.getString("nome_categoria"));
			esporte.setCategorias(categoriaDAO.getALL(esporte.getIdEsporte()));
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar o esporte");
			return null;
		}
		return esporte;
	}
		
	

}
