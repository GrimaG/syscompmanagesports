package beans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import persistence.AtletaDAO;
@ManagedBean(name="loginBean", eager=true)
@RequestScoped
public class LoginBean {
	private String senha;
	private String usuario;
	private AtletaDAO atletaDAO;
	public LoginBean() {
		 atletaDAO = new AtletaDAO();
		// TODO Auto-generated constructor stub
	}
	public void login(){
		if(this.atletaDAO.verifyLogin(this.usuario, this.senha)){
			//armazena variavel de sessao
		}else{
			//redireciona pra algum lugar
		}
		
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha.trim();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario.trim();
	}
	

}
