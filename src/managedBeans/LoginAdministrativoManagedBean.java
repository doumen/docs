package managedBeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginAdministrativoManagedBean {
	private String usuario;
	private String senha;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void conectar(){
		System.out.println("Conectou Administrativo!");
	}
	
	public void limpar(){
		System.out.println("Limpou Administrativo!");
	}
}
