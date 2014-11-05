package managedBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.TipoInclusao;
import model.Util;

import org.primefaces.context.RequestContext;

import component.ContabilidadeComponent;

import entity.Contabilidade;
import entity.Usuario;

@ManagedBean
@ViewScoped
public class ConsultaContabilidadeAdmMB extends
		AbstractConsultaMB<Contabilidade> {
	private String login;
	private String senha;
	private boolean permissaoAreaContador;
	private boolean permissaoAreaAssinante;
	private String mascara;
	private List<Usuario> usuarios;
		
	public ConsultaContabilidadeAdmMB(){
		super(Contabilidade.class);
		setEnctype("application/x-www-form-urlencoded");
		System.out.println("Instanciou o ConsultaContabiliadeAdmMB!!");
	}
	
	@Override
	public void init() {
		listTable = contabilidadeComponent.getContabilidades(true);
		System.out.println("listTable = " + listTable);
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
			if(getUsuarios().size()>0)
				try {
					usuarios.remove(getUsuarios().get(getUsuarios().size()-1));
				} catch (Exception e) {
					e.printStackTrace();
				}
			clean();			
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
		mascara = Util.getMascaraCnpj(selected.getUf());
		return mascara;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	private void carrega(){
		login = "";
		senha = "";
		permissaoAreaAssinante = false;
		permissaoAreaContador = false;
		
	}
	public void carregarPopUpAlterar() {
		if ((selectedList != null) && (!selectedList.isEmpty())) {
			selected = selectedList.get(0);
			usuarios = selected.getUsuarios();
			mascara = Util.getMascaraCnpj(selected.getUf());
			carrega();
		}
	}

	public void carregarPopUpIncluir() {
		this.selected = new Contabilidade(TipoInclusao.MODULO_ADMINISTRATIVO,new Date());
		usuarios = new ArrayList<>();
		carrega();
	}

	/*
	@Override
	public void setSelected(Contabilidade selected) {
		if (selected != null && selected.getUf() != null)
			this.selected = selected;
		else if (selectedList != null && !selectedList.isEmpty())
			this.selected = selectedList.get(0);
		setMascara(this.mascaraInscrEstadual());
	}
	*/
	
	public boolean validateUsuario() {
		return super.validateUsuario(login, senha, selected.getUsuarios());
	}
	
	
	@Override
	public void incluir() {
		System.out.println("Incluiu Contabilidade!");
		FacesMessage message; 
		selected.setUsuarios(usuarios);
		if(contabilidadeComponent.inserirContabilidade(this.selected)){
			selected = contabilidadeComponent.getContabilidadeByCnpj(selected);
			listTable.add(this.selected);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Contabilidade inserida com sucesso.");			
		}else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "A contabilidade não foi inserida");						
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		RequestContext.getCurrentInstance().update("formPainel:dataTable");
	}

	@Override
	public void alterar() {
		FacesMessage message;
		try {
			selected.setUsuarios(usuarios);
			contabilidadeComponent.alterar(selected);
			 message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
					"Contabilidade alterada com sucesso.");
		} catch (Exception e) {
			 message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Não foi possível alterar a Contabilidade");			
			e.printStackTrace();
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		RequestContext.getCurrentInstance().update("formPainel:dataTable");
	}

	public String getPdfTemplateName() {
		return "template_portrait";
	}

	@Override
	public void removeSelectedList() {
		FacesMessage message;
		ArrayList<Contabilidade> r = new ArrayList<>();
		for(Contabilidade c : selectedList){
			try {
				c.setAtivo(false);
				contabilidadeComponent.alterar(c);
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Contabilidade " + c.getNomeFantasia() + " excluída com sucesso.");
				r.add(c);
			} catch (Exception e) {
				message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
						"Não foi possível excluir a contabiliade " + c.getNomeFantasia());
				e.printStackTrace();
			}			
			RequestContext.getCurrentInstance().showMessageInDialog(message);			
		}
		selectedList.removeAll(r);
		RequestContext.getCurrentInstance().update("formPainel:dataTable");
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
