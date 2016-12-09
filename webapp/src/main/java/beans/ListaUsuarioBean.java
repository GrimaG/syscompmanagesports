package beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import persistence.AtletaDAO;
import webapp.Atleta;

@ManagedBean(name="listaUsuarioBean", eager=true)
@RequestScoped
public class ListaUsuarioBean {
	private ArrayList<Atleta> atletas;
	private ArrayList<Atleta> todos;
	private String pesquisa;
	private AtletaDAO atletaDAO;
	public ListaUsuarioBean() {
		atletas = (ArrayList<Atleta>) atletaDAO.selectALL();
		todos.addAll(atletas);
		// TODO Auto-generated constructor stub
	}
	public void procurar(){
		 ArrayList<Atleta> result = new ArrayList<Atleta>();
		for(Atleta atleta: todos){
			if(atleta.getNomeAtleta().equals(pesquisa) || pesquisa.equals("")){
				result.add(atleta);
			}
		}
		atletas = new ArrayList<Atleta>();
		atletas.addAll(result);
		
		
	}
	public ArrayList<Atleta> getAtletas() {
		return atletas;
	}
	public void setAtletas(ArrayList<Atleta> atletas) {
		this.atletas = atletas;
	}
	public String getPesquisa() {
		return pesquisa;
	}
	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}
	

}
