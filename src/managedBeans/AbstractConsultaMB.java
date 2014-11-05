package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import managedBeans.components.RelatorioJasperMB;
import model.Modulo;
import model.TipoInclusao;

import org.primefaces.context.RequestContext;

import entity.Usuario;

public abstract class AbstractConsultaMB<T> extends AbstractListMB<T> {

	public AbstractConsultaMB(Class<T> clazz) {
		super(clazz);
	}

	private String tipo;
	private String headerInclude;
	private boolean botaoAlterar;
	private boolean botaoIncluir;
	private boolean showUploadNome;
	private boolean showUpload;
	private String enctype;
	
	List<T> filteredList; //= new ArrayList<>();

	public List<T> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<T> filteredList) {
		this.filteredList = filteredList;
	}

	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}
	
	public LoginBean getLoginBean(){
		return this.loginBean;
	}
	
	public model.TipoInclusao getTipoInclusao(){
		model.Modulo m = this.loginBean.valueOf(loginBean.getModulo());
		if(m.equals(Modulo.ADMINISTRATIVO)){
			return TipoInclusao.MODULO_ADMINISTRATIVO;
		}
		else if(m.equals(Modulo.CONTABILIDADE)){
			return TipoInclusao.MODULO_CONTABILIDADE;
		}
		return null;
	}
	
	public abstract String getAvisoExcluir();

	public abstract String getAvisoPreExcluir();

	public abstract String getPdfReportName();

	public abstract String getPdfTemplateName();
		
	public abstract void removeSelectedList(); 

	public abstract void incluir();
	
	public abstract void alterar();

	public String getTipo() {
		return tipo;
	}
	
	public boolean isUpdateEmptySelection() {
		return "alterar".equals(tipo) && selectedList.isEmpty();
	}

	public void setTipo(String tipo) {
		if ("incluir".equals(tipo)) {
			setHeaderInclude("Incluir");
			setBotaoIncluir(true);
			setBotaoAlterar(false);
			setShowUpload(true);
			setShowUploadNome(false);
		} else if ("alterar".equals(tipo)) {
			setHeaderInclude("Alterar");
			selected = listTable.get(0);
			setBotaoIncluir(false);
			setBotaoAlterar(true);
			setShowUpload(false);
			setShowUploadNome(true);
		}
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
	
	public void print(){
		try{
			createRelatorioJasperMB().browserReport();
		}catch(Exception e){
			System.out.println("errou");
			e.printStackTrace();
		}
	}
	
	private RelatorioJasperMB<T> createRelatorioJasperMB(){
		RelatorioJasperMB<T> r = new RelatorioJasperMB<T>();
		List<T> beans = new ArrayList<>();
		beans.add(selected);
		beans.addAll(listTable);
		r.setBeans(beans);
		r.setReport(getPdfReportName());
		r.setTemplate(getPdfTemplateName());
		r.setModulo(loginBean.getModulo());
		return r;
	}
	
	public void exportPdf(){
		try{
			createRelatorioJasperMB().downloadReport();
		}catch(Exception e){
			e.printStackTrace();
		}
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

	public String getEnctype() {
		return enctype;
	}

	public void setEnctype(String enctype) {
		this.enctype = enctype;
	}

}