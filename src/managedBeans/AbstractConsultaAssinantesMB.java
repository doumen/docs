package managedBeans;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.servlet.http.Part;

import model.Modulo;
import model.SiglaEstado;
import model.Util;

import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import component.AssinanteComponent;
import component.CertificadoA1Component;
import component.ContabilidadeComponent;
import component.PlanoComponent;
import component.UsuarioComponent;
import entity.Assinante;
import entity.CertificadoA1;
import entity.Contabilidade;
import entity.Plano;
import entity.Usuario;

public abstract class AbstractConsultaAssinantesMB extends
		AbstractConsultaMB<Assinante> {

	protected String login;
	protected String senha;
	protected UploadedFile fileP;
	protected String mascara;
	protected Plano plano;
	protected List<Plano> planos;
	protected Contabilidade contabilidade;
	protected List<Contabilidade> contabilidades;
	protected CertificadoA1 certificadoA1 = new CertificadoA1();
	private String script;

	@Inject
	protected AssinanteComponent assinanteComponent;

	@Inject
	protected PlanoComponent planoComponent;

	@Inject
	protected ContabilidadeComponent contabilidadeComponent;

	@Inject
	private CertificadoA1Component certificadoA1Component;

	@Inject
	private UsuarioComponent usuarioComponent;

	public AbstractConsultaAssinantesMB() {
		super(Assinante.class);
		setEnctype("multipart/form-data");
	}

	@Override
	public String getAvisoExcluir() {
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}

	@Override
	public String getPdfTemplateName() {
		return "template_landscape";
	}

	@Override
	public String getPdfReportName() {
		return "assinantes";
	}

	public boolean validateUsuario() {
		return super.validateUsuario(login, senha, selected.getUsuarios());
	}

	public void adicionaUsuario() {
		if (validateUsuario()) {
			Usuario u = new Usuario();
			u.setAssinante(selected);
			u.setDataInclusao(Calendar.getInstance().getTime());
			u.setLogin(login.trim());
			u.setSenha(senha.trim());
			selected.addUsuario(u);
		}
	}

	public void removeUsuario() {
		if(selected.getUsuarios()!=null){
			int u = selected.getUsuarios().size(); 
			if(u>0){
				try {
					usuarioComponent.remove(selected.getUsuarios().get(u-1));
					selected.getUsuarios().remove(u-1);				
				} catch (Exception e) {
					e.printStackTrace();
				}
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

	public UploadedFile getFileP() {
		return fileP;
	}

	public void setFile(UploadedFile file) {
		this.fileP = file;
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

	public List<SiglaEstado> getEstados() {
		return Util.getEstados();
	}

	public CertificadoA1 getCertificadoA1() {
		return certificadoA1;
	}

	public void setCertificadoA1(CertificadoA1 certificadoA1) {
		this.certificadoA1 = certificadoA1;
	}

	public void carregarPopUpAlterar() {
		if ((selectedList != null) && (!selectedList.isEmpty())) {
			file = null;
			carregaPlanosContabilidades();
			selected = selectedList.get(0);
			selected.setTipoInclusao(getTipoInclusao());			
			selected.setUsuariosList(usuarioComponent.getUsuarios(selected));
			certificadoA1 = certificadoA1Component.getCertificadoA1(selected);
			setShowUpload(certificadoA1 == null);
			login = "";
			senha = "";
			mascara = Util.getMascaraCnpj(selected.getUf());
			FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().addAll(Arrays.asList(new String[]{":formIncluir:intCep"}));
		}
	}

	public void carregarPopUpIncluir() {
		carregaPlanosContabilidades();
		selected = new Assinante();
		selected.setTipoInclusao(getTipoInclusao());
		if(Modulo.CONTABILIDADE.equals(getLoginBean().getMod())){
			selected.setContabilidade(contabilidade);
		}
		certificadoA1 = new CertificadoA1();
		login = "";
		senha = "";
		setShowUpload(true);
	}

	private void carregaPlanosContabilidades() {
		planos = planoComponent.getPlanos();
		contabilidades = contabilidadeComponent.getContabilidades(false);
	}

	@Override
	public void incluir() {		
		FacesMessage message;
		if(Modulo.CONTABILIDADE.equals(getLoginBean().valueOf(getLoginBean().getModulo()))){
			selected.setContabilidade(getLoginBean().getUsuario().getContabilidade());
		}

		if(upload() && assinanteComponent.incluirNovoAssinante(this.selected, certificadoA1)){
			selected = assinanteComponent.getAssinanteByCnpj(selected);
			listTable.add(this.selected);
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Assinante inserido com sucesso.");			
		}else{
			message = new FacesMessage(FacesMessage.SEVERITY_INFO, "", "O assinante não foi inserido");						
		}
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		RequestContext.getCurrentInstance().update("formPainel:dataTable");
	}

	@Override
	public void alterar() {
		upload();
		assinanteComponent.alterarAssinante(selected, certificadoA1);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "",
				"Assinante alterado com sucesso.");
		RequestContext.getCurrentInstance().showMessageInDialog(message);
		RequestContext.getCurrentInstance().execute("PF('dlgIncluir').hide()");
	}

	public void uploadP() {
		if (fileP != null) {
			System.out.println("Uploaded file name : " + fileP.getFileName());
			certificadoA1.setArquivoPFXCertificadoA1(fileP.getContents());
			certificadoA1.setNome(fileP.getFileName());
		}
	}

	public void trocarCertificado() {
		super.setShowUpload(true);
		super.setShowUploadNome(false);
		FacesContext.getCurrentInstance().getPartialViewContext()
				.getRenderIds().add("pngParametros");
	}

	private Part file;

	private boolean upload() {
		try {
			if (file != null) {
				certificadoA1.setArquivoPFXCertificadoA1(IOUtils
						.toByteArray(file.getInputStream()));
				certificadoA1.setNome(file.getSubmittedFileName());
				return true;
			}
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public void handleFileUpload(FileUploadEvent event) {
		System.out.println(event.getFile().getFileName());
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	@Override
	public void removeSelectedList() {
		System.out.println("Chamou o void");
	}
	
	public void removeSelectedList(ActionEvent ev) {
		for (Assinante t : selectedList) {
			try {
				assinanteComponent.remove(t);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		listTable = assinanteComponent.getAssinantes();	
		selectedList = assinanteComponent.getAssinantes();
		 RequestContext.getCurrentInstance().update(":formPainel:dataTable");
		 RequestContext.getCurrentInstance().update("dataTable");
		 FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds().add("formPainel");		 
		 System.out.println("render 8");
	}
}
