package managedBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import model.Assinante;
import model.Contabilidade;
import model.Plano;
import model.TipoInclusao;
import model.Usuario;
import model.Util;

import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

import component.AssinanteComponent;

@ManagedBean
@ViewScoped
public class ConsultaAssinantesAdmMB extends AbstractConsultaMB<Assinante> {

	private String login;
	private String senha;
	private UploadedFile file;
	private String mascara;
	private Plano plano;
	private List<Plano> planos;
	private Contabilidade contabilidade;
	private List<Contabilidade> contabilidades;
	private List<Assinante> filteredList = new ArrayList<>();

	public ConsultaAssinantesAdmMB() {
		super(Assinante.class);
	}

	public void init() {
		listTable = assinanteComponent.getAssinantes();
		filteredList = assinanteComponent.getAssinantes();

		planos = new ArrayList<Plano>();
		planos.add(new Plano((long) 1, "Plano 01", 99.90));
		planos.add(new Plano((long) 2, "Plano 02", 59.90));

		contabilidades = new ArrayList<Contabilidade>();
		contabilidades.add(new Contabilidade((long) 1, "Contabilidade 01"));
		contabilidades.add(new Contabilidade((long) 2, "Contabilidade 02"));
	}

	@Inject
	private AssinanteComponent assinanteComponent;

	@Override
	public String getAvisoExcluir() {
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}

	public void carregarPopUpAlterar() {
		if ((selectedList != null) && (!selectedList.isEmpty())) {
			selected = selectedList.get(0);
			login = "";
			senha = "";
		}
	}

	public void carregarPopUpIncluir() {
		selected.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);
		login = "";
		senha = "";
	}

	public void adicionaUsuario() {
		if (validateUsuario()) {
			Usuario u = new Usuario();
			u.setAssinante(selected);
			u.setDataInclusao(Calendar.getInstance());
			u.setLogin(login.trim());
			u.setSenha(senha.trim());
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		if (file != null) {
			FacesMessage message = new FacesMessage("Succesful",
					file.getFileName() + " is uploaded.");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	@Override
	public String getPdfReportName() {
		return "assinantes";
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

	@Override
	public void setSelected(Assinante selected) {
		if (selected != null && selected.getUf() != null)
			this.selected = selected;
		else if (selectedList != null && !selectedList.isEmpty())
			this.selected = selectedList.get(0);
		setMascara(this.mascaraInscrEstadual());
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

	public List<Contabilidade> getContabilidades() {
		return contabilidades;
	}

	public void setContabilidades(List<Contabilidade> contabilidades) {
		this.contabilidades = contabilidades;
	}

	public List<Assinante> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Assinante> filteredList) {
		this.filteredList = filteredList;
	}

	public boolean validateUsuario() {
		if (login.isEmpty() || senha.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário e Senha são obrigatórios.", ""));
			return false;
		} else {
			if (!selected.getUsuarios().isEmpty()) {
				for (int i = 0; i < selected.getUsuarios().size(); i++) {
					if (login.trim()
							.equals(selected.getUsuarios().get(i).getLogin()
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

		return true;
	}

	@Override
	public void incluir() {
		/*if(assinanteValido())
			assinanteComponent.incluir(selected);
		else
			mandarMensagemErro();*/
		System.out.println("Incluiu Assinante!");
	}
	
	@Override
	public void alterar(){
		System.out.println("Alterou Assinante!");
	}

	@Override
	public String getPdfTemplateName() {		
		return "template_landscape";
	}
}
