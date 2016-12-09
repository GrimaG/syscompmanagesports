package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import webapp.Endereco;
import webapp.Esporte;
import webapp.Grupo;

public class GrupoDAO extends DAO {
	public Grupo salvar(Grupo grupo) {
		try {
			open();
			EnderecoDAO enderecoDao = new EnderecoDAO();
			//EsporteDAO	esporteDAO = new EsporteDAO();
			stmt = con.prepareStatement("INSERT INTO grupo(nome_, fk_esporte, fk_endereco, telefone, descricao,img, user_main) VALUES(?,?,?,?,?,?,?)");
			stmt.setString(1, grupo.getNome());
			stmt.setInt(2,grupo.getEsporte().getIdEsporte());
			grupo.setEndereco(enderecoDao.salvar(grupo.getEndereco()));
			stmt.setInt(3,grupo.getEndereco().getIdEndereco());
			stmt.setString(4, grupo.getTelefone());
			stmt.setString(5, grupo.getDescricao());
			stmt.setString(6, grupo.getImg());
			stmt.setInt(7, grupo.getUserMain());
			stmt.execute();
			try {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					grupo.setIdGrupo(generatedKeys.getInt(1));
				}
			} catch (Exception e) {
				System.out.println("Creating user failed, no ID obtained.");
			}
			close();

		} catch (Exception ex) {
			System.out.println("Erro de acesso ao banco para cad de esporte");
			return null;
		}

		return grupo;
	}
	public ArrayList<Grupo> getALL(){
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		Grupo grupo;
		EnderecoDAO enderecoDao = new EnderecoDAO();
		EsporteDAO	esporteDAO = new EsporteDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_grupo, nome_, fk_esporte, fk_endereco, telefone, descricao,img, user_main from grupo;");
		
		if(rs.next())
		{
			grupo = new Grupo();
			grupo.setIdGrupo(rs.getInt("id_grupo"));
			grupo.setNome(rs.getString("nome_"));
			grupo.setEsporte(esporteDAO.getEsporte(rs.getInt("fk_esporte")));
			grupo.setEndereco(enderecoDao.getEndereco(rs.getInt("fk_endereco")));
			grupo.setTelefone(rs.getString("telefone"));
			grupo.setDescricao(rs.getString("descricao"));
			grupo.setImg(rs.getString("img"));
			grupo.setUserMain(rs.getInt("user_main"));
			
			grupos.add(grupo);
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar  os grupos");
			return null;
		}
		return grupos;

	}
	public Grupo getGrupo(int idGrupo){
		Grupo grupo = new Grupo();
		EnderecoDAO enderecoDao = new EnderecoDAO();
		EsporteDAO	esporteDAO = new EsporteDAO();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_grupo, nome_, fk_esporte, fk_endereco, telefone, descricao,img, user_main from grupo where id_grupo='"+idGrupo+"';");
		
		if(rs.next())
		{
			
			grupo.setIdGrupo(rs.getInt("id_grupo"));
			grupo.setNome(rs.getString("nome_"));
			grupo.setEsporte(esporteDAO.getEsporte(rs.getInt("fk_esporte")));
			grupo.setEndereco(enderecoDao.getEndereco(rs.getInt("fk_endereco")));
			grupo.setTelefone(rs.getString("telefone"));
			grupo.setDescricao(rs.getString("descricao"));
			grupo.setImg(rs.getString("img"));
			grupo.setUserMain(rs.getInt("user_main"));
			
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar  os grupos");
			return null;
		}
		return grupo;
	}

}
