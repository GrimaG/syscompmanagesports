package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;

import webapp.Evento;

public class EventoDAO extends DAO{
	public Evento salvar(Evento evento) {
		try {
			open();
			EnderecoDAO enderecoDao = new EnderecoDAO();
			//GrupoDAO grupoDAO = new GrupoDAO();
			stmt = con.prepareStatement("INSERT INTO evento(nome_evento, descricao, fk_endereco_evento, data, fk_grupo_evento) VALUES(?,?,?,?,?)");
			stmt.setString(1, evento.getNomeEvento());
			stmt.setString(2, evento.getDescricao());
			evento.setEndereco(enderecoDao.salvar(evento.getEndereco()));
			stmt.setInt(3,evento.getEndereco().getIdEndereco());
			stmt.setTimestamp(4, evento.getData());
			stmt.setInt(5, evento.getGrupo().getIdGrupo());
			
			stmt.execute();
			try {
				ResultSet generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					evento.setIdEvento(generatedKeys.getInt(1));
				}
			} catch (Exception e) {
				System.out.println("Creating user failed, no ID obtained.");
			}
			close();

		} catch (Exception ex) {
			System.out.println("Erro de acesso ao banco para cad de esporte");
			return null;
		}

		return evento;
	}
	public ArrayList<Evento> getALL(){
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		Evento evento;
		EnderecoDAO enderecoDao = new EnderecoDAO();
		GrupoDAO grupoDAO = new GrupoDAO();
		//CategoriaDAO categoriaDAO = new CategoriaDAO();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_evento, nome_evento, descricao, fk_endereco_evento, data, fk_grupo_evento from evento;");
		
		if(rs.next())
		{
			evento = new Evento();
			evento.setIdEvento(rs.getInt("id_evento"));
			evento.setNomeEvento(rs.getString("nome_evento"));
			evento.setDescricao(rs.getString("descricao"));
			evento.setEndereco(enderecoDao.getEndereco(rs.getInt("fk_endereco_evento")));
			evento.setData(rs.getTimestamp("data"));
			evento.setGrupo(grupoDAO.getGrupo(rs.getInt("fk_grupo_evento")));			
			eventos.add(evento);
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar  os grupos");
			return null;
		}
		return eventos;

	}
	public Evento getEvento(int idEvento){
		Evento evento = new Evento();
		EnderecoDAO enderecoDao = new EnderecoDAO();
		GrupoDAO grupoDAO = new GrupoDAO();
		//CategoriaDAO categoriaDAO = new CategoriaDAO();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_evento, nome_evento, descricao, fk_endereco_evento, data, fk_grupo_evento from evento where id_evento = "+ idEvento +";");
		
		if(rs.next())
		{
			
			evento.setIdEvento(rs.getInt("id_evento"));
			evento.setNomeEvento(rs.getString("nome_evento"));
			evento.setDescricao(rs.getString("descricao"));
			evento.setEndereco(enderecoDao.getEndereco(rs.getInt("fk_endereco_evento")));
			evento.setData(rs.getTimestamp("data"));
			evento.setGrupo(grupoDAO.getGrupo(rs.getInt("fk_grupo_evento")));			
		
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar  os grupos");
			return null;
		}
		return evento;

	}
	public ArrayList<Evento> getAllFromUser(int idUser){
		ArrayList<Evento> eventos = new ArrayList<Evento>();
		Evento evento;
		EnderecoDAO enderecoDao = new EnderecoDAO();
		GrupoDAO grupoDAO = new GrupoDAO();
		//CategoriaDAO categoriaDAO = new CategoriaDAO();
		try{
		open();
		st = con.createStatement();
		rs = st.executeQuery("SELECT id_evento, nome_evento, descricao, fk_endereco_evento, data, fk_grupo_evento from atleta_evento inner join evento on atleta_evento.fk_evento_rel=evento.id_evento where atleta_evento.fk_atleta_rel="+ idUser+";");
		
		if(rs.next())
		{
			evento = new Evento();
			evento.setIdEvento(rs.getInt("id_evento"));
			evento.setNomeEvento(rs.getString("nome_evento"));
			evento.setDescricao(rs.getString("descricao"));
			evento.setEndereco(enderecoDao.getEndereco(rs.getInt("fk_endereco_evento")));
			evento.setData(rs.getTimestamp("data"));
			evento.setGrupo(grupoDAO.getGrupo(rs.getInt("fk_grupo_evento")));			
			eventos.add(evento);
		}
		}catch(Exception ex){
			System.out.println("Não foi possivel acessar o banco para buscar  os grupos");
			return null;
		}
		return eventos;

	}

}
