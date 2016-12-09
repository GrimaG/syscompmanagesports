package beans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import persistence.AtletaDAO;
import persistence.EventoDAO;
import webapp.Atleta;
import webapp.Evento;

@ManagedBean(name="cadEventoBean", eager=true)
@RequestScoped
public class CadEventoBean {
	private Atleta atleta;
	private Evento evento;
	private AtletaDAO atletaDAO;
	private EventoDAO eventoDAO;
	public CadEventoBean() {
		
		atletaDAO = new AtletaDAO();
		atleta = new Atleta();// pegar o usuario logado e colocar aqui
		eventoDAO = new EventoDAO();
		// TODO Auto-generated constructor stub
	}
	

	public void salvarAtleta(){
		evento.setGrupo(atleta.getGrupo());
		eventoDAO.salvar(evento);
	}
	
	

	public Atleta getAtleta() {
		return atleta;
	}
	
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}


	

}
