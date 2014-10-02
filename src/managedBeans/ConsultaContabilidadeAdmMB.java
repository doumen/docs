package managedBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Contabilidade;
import model.TipoInclusao;
import model.Usuario;
import model.Util;

import org.primefaces.context.RequestContext;

import component.ContabilidadeComponent;

@ManagedBean
@ViewScoped
public class ConsultaContabilidadeAdmMB extends AbstractConsultaMB<Contabilidade> {
	private String login;
	private String senha;
	private boolean permissaoAreaContador;
	private boolean permissaoAreaAssinante;
	private List<Contabilidade> filteredList = new ArrayList<>();
	private String mascara;

	public ConsultaContabilidadeAdmMB() throws InstantiationException,
			IllegalAccessException {
		super(Contabilidade.class);
		System.out.println("Instanciou o ConsultaContabiliadeAdmMB!!");
	}

	@PostConstruct
	public void init() {
		listTable = contabilidadeComponent.getContabilidades();
		filteredList = contabilidadeComponent.getContabilidades();
	}

	@Inject
	private ContabilidadeComponent contabilidadeComponent;

	@Override
	public String getAvisoExcluir() {
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}

	@Override
	public String getPdfReportName() {
		return "contabilidades";
	}

	public void adicionaUsuario() {
		if (validateUsuario()) {
			Usuario u = new Usuario();
			u.setContabilidade(selected);
			u.setDataInclusao(Calendar.getInstance());
			u.setLogin(login.trim());
			u.setSenha(senha.trim());
			u.setPermissaoAreaContador(permissaoAreaContador);
			u.setPermissaoAreaAssinante(permissaoAreaAssinante);
			selected.addUsuario(u);
		}
	}

	public void removeUsuario() {
		selected.removeUsuario(selected.getUsuarios().get(
				selected.getUsuarios().size() - 1));
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
	
	public List<Contabilidade> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Contabilidade> filteredList) {
		this.filteredList = filteredList;
	}

	public String mascaraInscrEstadual() {
		return Util.getMascaraCnpj(selected.getUf());		
	}
	
	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public void carregarPopUpAlterar() {
		if ((selectedList != null) && (!selectedList.isEmpty())) {
			selected = selectedList.get(0);
			login = "";
			senha = "";
			permissaoAreaAssinante = false;
			permissaoAreaContador = false;
		}
	}

	public void carregarPopUpIncluir() {
		selected.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);
		login = "";
		senha = "";
		permissaoAreaAssinante = false;
		permissaoAreaContador = false;
	}

	@Override
	public void setSelected(Contabilidade selected) {
		if (selected != null && selected.getUf() != null)
			this.selected = selected;
		else if (selectedList != null && !selectedList.isEmpty())
			this.selected = selectedList.get(0);
		setMascara(this.mascaraInscrEstadual());
	}

	public boolean validateUsuario() {
		return super.validateUsuario(login, senha, selected.getUsuarios());
	}
	
	@Override
	public void incluir() {
		System.out.println("Incluiu Contabilidade!");
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"", "Contabilidade inserida com sucesso.");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}
	
	@Override
	public void alterar(){
		System.out.println("Alterou Contabilidade!");
		
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"", "Contabilidade alterada com sucesso.");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public String getPdfTemplateName() {		
		return "template_portrait";
	}

}
