package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import webapp.Atleta;
import webapp.Grupo;


public class AtletaDAO extends DAO{
	
	public boolean verifyLogin (String name, String password){
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT * from atleta where usuario = '"+name +"' and senha = '"+password+"'");
		
		if(rs.next())
		{
			close();
			return true;
		}
		close();
		}
		catch(Exception ex){
			System.out.println("Não foi possivel conectar com o banco de dados");
		}
		return false;
	}
	public List<Atleta> selectALL(){
		ArrayList<Atleta>atletas = new ArrayList<Atleta>();
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		GrupoDAO grupoDAO = new GrupoDAO();
		Atleta atleta;
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_atleta, fk_endereco_atleta, nome_atleta, senha, sexo, idade, fk_grupo_atleta, fk_categoria_atleta, foto, descricao, usuario FROM atleta;");
		
		if(rs.next())
		{
			atleta = new Atleta();
			atleta.setIdAtleta(rs.getInt("id_atleta"));
			atleta.setEndereco(enderecoDAO.getEndereco(rs.getInt("fk_endereco_atleta")));
			atleta.setNomeAtleta(rs.getString("nome_atleta"));
			atleta.setSenha(rs.getString("senha"));
			atleta.setSexo(rs.getString("sexo"));
			atleta.setIdade(rs.getInt("idade"));
			atleta.setGrupo(grupoDAO.getGrupo(rs.getInt("fk_grupo_atleta")));
			atleta.setCategoria(categoriaDAO.getCategoria(rs.getInt("fk_categoria_atleta")));
			atleta.setFoto(rs.getString("foto"));
			atleta.setDescricao(rs.getString("descricao"));
			atleta.setUsuario(rs.getString("usuario"));
			
			atletas.add(atleta);
		}
		
		close();
		}
		catch(Exception ex){
			System.out.println("Não foi possivel conectar com o banco de dados");
		}
		return atletas;
	}
	public Atleta salvar(Atleta atleta) {
		try {
			EnderecoDAO enderecoDao = new EnderecoDAO();
			//EsporteDAO	esporteDAO = new EsporteDAO();
			stmt = con.prepareStatement("INSERT INTO atleta(fk_endereco_atleta, nome_atleta, senha, sexo, idade, fk_grupo_atleta, fk_categoria_atleta, foto, descricao, usuario) VALUES(?,?,?,?,?,?,?,?,?,?)");
			atleta.setEndereco(enderecoDao.salvar(atleta.getEndereco()));
			stmt.setInt(1,atleta.getEndereco().getIdEndereco());
			stmt.setString(2, atleta.getNomeAtleta());
			stmt.setString(3,atleta.getSenha());
			stmt.setString(4,atleta.getSexo());
			stmt.setInt(5,atleta.getIdade());
			stmt.setInt(6,atleta.getGrupo().getIdGrupo());
			stmt.setInt(7,atleta.getCategoria().getIdCategoria());
			stmt.setString(8,atleta.getFoto());
			stmt.setString(9,atleta.getDescricao());
			stmt.setString(10,atleta.getUsuario());
			
			stmt.execute();
			try {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					atleta.setIdAtleta(generatedKeys.getInt(1));
				}
			} catch (Exception e) {
				System.out.println("Creating user failed, no ID obtained.");
			}
			close();

		} catch (Exception ex) {
			System.out.println("Erro de acesso ao banco para cad de esporte");
			return null;
		}

		return atleta;
	}
	

}
