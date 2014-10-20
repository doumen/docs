package managedBeans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import entity.Assinante;
import component.AssinanteComponent;

@ManagedBean
public class LoginContabilidadeManagedBean {
	private String usuario;
	private String senha;
	private Assinante assinante;
	private List<Assinante> assinantes;

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

	public List<Assinante> getAssinantes() {
		return assinantes == null ? (new AssinanteComponent()).getAssinantes()
				: assinantes;
	}

	public Assinante getAssinante() {
		return assinante;
	}

	public void setAssinante(Assinante assinante) {
		this.assinante = assinante;
	}
	
	public void conectar() {
		System.out.println("Conectou Contabilidade!");
	}
	
	public void limpar(){
		System.out.println("Limpou Contabilidade!");
	}
}
