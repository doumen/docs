package managedBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;

import model.Util;

import org.primefaces.context.RequestContext;

import component.ContabilidadeComponent;

import entity.Contabilidade;
import entity.Usuario;

@ManagedBean
@ViewScoped
public class CadastroContabilidadeConMB {

	private Contabilidade selected;
	protected String mascara;
	private String script;
	private String login;
	private String senha;
	private boolean permissaoAreaContador;
	private boolean permissaoAreaAssinante;
	private String tipo;
	private String headerInclude;
	private boolean botaoAlterar;
	private boolean botaoIncluir;
	private boolean showUploadNome;
	private boolean showUpload;
	
	public void alterar(){
		try {
//			usuarioComponent.remove(usuariosRemovidos);
//			selected.getUsuarios().removeAll(usuariosRemovidos);
			contabilidadeComponent.alterar(selected,usuarios);
			clean();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Inject
	private ContabilidadeComponent contabilidadeComponent;
	
//	@Inject 
//	private UsuarioComponent usuarioComponent;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}

	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init(){
		setSelected(contabilidadeComponent.getContabilidadeById(loginBean.getUsuario().getContabilidade()));
		setMascara(Util.getMascaraCnpj(selected.getUf()));
		setTipo("alterar");
		setHeaderInclude("Alterar");
		setBotaoIncluir(false);
		setBotaoAlterar(true);
		setShowUpload(false);
		setShowUploadNome(true);
		setUsuarios(selected.getUsuarios());
		clean();
	}
	
	public void adicionaUsuario() {
		if (validateUsuario()) {
			Usuario u = new Usuario();
			u.setContabilidade(selected);
			u.setDataInclusao(Calendar.getInstance().getTime());
			u.setLogin(login.trim());
			u.setSenha(senha.trim());
			u.setPermissaoAreaContador(permissaoAreaContador);
			u.setPermissaoAreaUsuario(permissaoAreaAssinante);
			if(usuarios==null)
				usuarios = new ArrayList<>();
			usuarios.add(u);
			clean();
		}
	}

	private void clean(){
		this.login = "";
		this.senha = "";
		this.permissaoAreaAssinante = false;
		this.permissaoAreaContador = false;
	}
	
	public void removeUsuario() {
		if(getUsuarios()!=null){
			int u = getUsuarios().size(); 
			if(u>0){
				getUsuarios().remove(u-1);
			}
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isPermissaoAreaContador() {
		return permissaoAreaContador;
	}

	public void setPermissaoAreaContador(boolean permissaoAreaContador) {
		this.permissaoAreaContador = permissaoAreaContador;
	}

	public boolean isPermissaoAreaAssinante() {
		return permissaoAreaAssinante;
	}

	public void setPermissaoAreaAssinante(boolean permissaoAreaAssinante) {
		this.permissaoAreaAssinante = permissaoAreaAssinante;
	}

	public Contabilidade getSelected() {
		return selected;
	}

	public void setSelected(Contabilidade selected) {
		this.selected = selected;
	}
	
	public String mascaraInscrEstadual() {
		mascara = Util.getMascaraCnpj(selected.getUf());
		return mascara;
	}

	public void changeUfEvent(AjaxBehaviorEvent ev) {
		mascara = Util.getMascaraCnpj(selected.getUf());
		script = "function mascara(id){jQuery(id).mask('" + mascara + "');}";
		System.out.println(script);
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}
	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}
	
	public boolean validateUsuario(String login, String senha, List<Usuario> usuarios) {
		if(usuarios!=null){
			if (login.isEmpty() || senha.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Usuário e Senha são obrigatórios.", ""));
				return false;
			} else {
				if (!usuarios.isEmpty()) {
					for (int i = 0; i < usuarios.size(); i++) {
						if (login.trim()
								.equals(usuarios.get(i).getLogin()
										.toString())) {
							FacesMessage message = new FacesMessage(
									FacesMessage.SEVERITY_WARN, "Atenção!",
									"Usuário já cadastrado.");
							RequestContext.getCurrentInstance()
									.showMessageInDialog(message);
	
							return false;
						}
					}
				}
			}
		}

		return true;
	}
	
	public boolean validateUsuario() {
		return validateUsuario(login, senha, selected.getUsuarios());
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getHeaderInclude() {
		return headerInclude;
	}

	public void setHeaderInclude(String headerInclude) {
		this.headerInclude = headerInclude;
	}

	public boolean isBotaoAlterar() {
		return botaoAlterar;
	}

	public void setBotaoAlterar(boolean botaoAlterar) {
		this.botaoAlterar = botaoAlterar;
	}

	public boolean isBotaoIncluir() {
		return botaoIncluir;
	}

	public void setBotaoIncluir(boolean botaoIncluir) {
		this.botaoIncluir = botaoIncluir;
	}

	public boolean isShowUploadNome() {
		return showUploadNome;
	}

	public void setShowUploadNome(boolean showUploadNome) {
		this.showUploadNome = showUploadNome;
	}

	public boolean isShowUpload() {
		return showUpload;
	}

	public void setShowUpload(boolean showUpload) {
		this.showUpload = showUpload;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
