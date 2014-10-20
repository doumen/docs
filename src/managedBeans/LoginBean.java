package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import entity.Assinante;
import model.Modulo;
import entity.Usuario;
import component.AssinanteComponent;
import component.UsuarioComponent;


@SessionScoped
@ManagedBean
public class LoginBean {
	
	private Usuario usuario  = new Usuario();
	
	private List<Assinante> assinantes;
		
	private String modulo;
	
	private String ultimaUrl;
	
	private boolean logado=false;
	
	@Inject
	private UsuarioComponent usuarioComponent;

	@Inject
	private AssinanteComponent assinanteComponent;
	
	public String efetuaLogin(){
		boolean loginValido = usuarioComponent.validar(usuario,valueOf(getModulo()));
		if(loginValido){
			logado = true;
			if(!valueOf(modulo).equals(Modulo.ADMINISTRATIVO))
				usuario = usuarioComponent.getUsuario(usuario);
			return "painel-"+getModulo()+"?faces-redirect=true";			
		}else{
			limpar();
			logado = false;
			return "login-"+getModulo()+"?faces-redirect=true";
		}
	}
	
	public String efetuaLogout(){
		limpar();
		logado = false;
		return "login-"+getModulo()+"?faces-redirect=true"; 
	}
	
	public void inputLoginBlurHandler(){
		if(!usuarioComponent.existeUsuario(getUsuario(),valueOf(getModulo()))){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Atenção!",  "Usuário não cadastrado para o módulo " + getModulo()));
			limpar();
		}else{
			assinantes = assinanteComponent.getAssinantes(getUsuario());
		}
	}

	public void limpar(){
		usuario = new Usuario();
		assinantes = new ArrayList<>();
	}
	
	public Usuario getUsuario() {
		return usuario==null?new Usuario():usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Assinante> getAssinantes() {
		return assinantes==null?assinanteComponent.getAssinantes(getUsuario()):assinantes;
	}

	public String getModulo() {
		FacesContext context = FacesContext.getCurrentInstance();
		String url = context.getViewRoot().getViewId();
		if(url.contains("/login") && !url.equals(ultimaUrl)){
			limpar();
			ultimaUrl = url;
			switch (url) {
				case "/login-contabilidade.xhtml":
					modulo = "contabilidade";
					break;
				case "/login-assinante.xhtml":	
					modulo = "assinante";
					break;
				case "/login-administrativo.xhtml":
					modulo = "administrativo";
					break;
				}
		}
		if(modulo==null)
			modulo = "assinante";
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public boolean isLogado() {
		return logado;
	}
	
	public boolean isAssinantesRendered(){		
		return !getModulo().equals("administrativo");
	}
	
	public Modulo valueOf(String s){
		switch (s) {
		case "administrativo":
			return Modulo.ADMINISTRATIVO;
		case "contabilidade":
			return Modulo.CONTABILIDADE;
		case "assinante":
			return Modulo.ASSINANTE;
		default:
			return null;
		}
	}
	
	public boolean isModuloAdministrativo(){
		return Modulo.ADMINISTRATIVO.equals(valueOf(modulo));
	}
}
