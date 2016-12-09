package beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import persistence.EventoDAO;
import webapp.Evento;

@ManagedBean(name="listaEventosBean", eager=true)
@RequestScoped
public class ListaEventosBean {
	private ArrayList<Evento> eventos;
	private ArrayList<Evento> todos;
	private String pesquisa;
	private EventoDAO eventoDAO;
	public ListaEventosBean() {
		eventos = (ArrayList<Evento>) eventoDAO.getALL();
		todos.addAll(eventos);
		// TODO Auto-generated constructor stub
	}
	public void procurar(){
		 ArrayList<Evento> result = new ArrayList<Evento>();
		for(Evento evento: todos){
			if(evento.getNomeEvento().equals(pesquisa) || pesquisa.equals("")){
				result.add(evento);
			}
		}
		eventos = new ArrayList<Evento>();
		eventos.addAll(result);
		
		
	}
	public ArrayList<Evento> getAtletas() {
		return eventos;
	}
	public void setAtletas(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	public String getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	

}
