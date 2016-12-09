package beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import persistence.AtletaDAO;
import persistence.GrupoDAO;
import webapp.Atleta;
import webapp.Grupo;

@ManagedBean(name="cadAtletaBean", eager=true)
@RequestScoped
public class CadAtletaBean {
	private Atleta atleta;
	private ArrayList<Grupo> grupos;
	private AtletaDAO atletaDAO;
	private GrupoDAO grupoDAO;
	private Grupo grupoSelecionado;
	private boolean cadastraGrupo;
	private Grupo grupoCadastrado;
	public CadAtletaBean() {
		atleta = new Atleta();
		atletaDAO = new AtletaDAO();
		grupoDAO = new GrupoDAO();
		grupos = grupoDAO.getALL();
		cadastraGrupo = false;
		// TODO Auto-generated constructor stub
	}
	

	public void salvarAtleta(){
		if(cadastraGrupo){
			atleta.setGrupo(grupoDAO.salvar(grupoCadastrado));
			atletaDAO.salvar(atleta);
		}else{
			atletaDAO.salvar(atleta);		
		}
	}
	
	
	
	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}
	public Atleta getAtleta() {
		return atleta;
	}
	
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}


	public Grupo getGrupoSelecionado() {
		return grupoSelecionado;
	}


	public void setGrupoSelecionado(Grupo grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}


	public boolean isCadastraGrupo() {
		return cadastraGrupo;
	}


	public void setCadastraGrupo(boolean cadastraGrupo) {
		this.cadastraGrupo = cadastraGrupo;
	}


	public Grupo getGrupoCadastrado() {
		return grupoCadastrado;
	}


	public void setGrupoCadastrado(Grupo grupoCadastrado) {
		this.grupoCadastrado = grupoCadastrado;
	}
	

}
