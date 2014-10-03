package managedBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
public class ConsultaAssinantesAdmMB extends AbstractConsultaAssinantesMB {

	private String login;
	private String senha;
	private UploadedFile file;
	private String mascara;
	private Plano plano;
	private List<Plano> planos;
	private Contabilidade contabilidade;
	private List<Contabilidade> contabilidades;

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

	public boolean validateUsuario() {
		return super.validateUsuario(login, senha, selected.getUsuarios());
	}

	@Override
	public void incluir() {
		/*
		 * if(assinanteValido()) assinanteComponent.incluir(selected); else
		 * mandarMensagemErro();
		 */
		upload();
		System.out.println("Incluiu Assinante!");
		listTable.add(selected);

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Assinante inserido com sucesso.");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	@Override
	public void alterar() {
		upload();
		System.out.println("Alterou Assinante!");

		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Assinante alterado com sucesso.");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
	}

	public void upload() {
		if (file != null){
			System.out.println("Uploaded file name : " + file.getFileName());
			selected.getCertificadoA1().setNome(file.getFileName());
		}
	}

	public void ajaxPlanos() {
		selected.setPlano(plano);
	}

	
	public void trocarCertificado(){
		super.setShowUpload(true);
		super.setShowUploadNome(false);
	}

}
