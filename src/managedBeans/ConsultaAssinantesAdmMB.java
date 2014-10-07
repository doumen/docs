package managedBeans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.TipoInclusao;

import org.primefaces.context.RequestContext;

import component.AssinanteComponent;
import component.ContabilidadeComponent;
import component.PlanoComponent;

@ManagedBean
@ViewScoped
public class ConsultaAssinantesAdmMB extends AbstractConsultaAssinantesMB {


	public void init() {
		listTable = assinanteComponent.getAssinantes();
		filteredList = assinanteComponent.getAssinantes();

		planos = planoComponent.getPlanos();
		contabilidades = contabilidadeComponent.getContabilidades();
	}

	@Inject
	private AssinanteComponent assinanteComponent;

	@Inject
	private PlanoComponent planoComponent;
	
	@Inject
	private ContabilidadeComponent contabilidadeComponent;
	
	public void carregarPopUpAlterar() {
		if ((selectedList != null) && (!selectedList.isEmpty())) {
			selected = selectedList.get(0);
			selected.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);
			login = "";
			senha = "";
		}
	}

	public void carregarPopUpIncluir() {
		selected.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);
		login = "";
		senha = "";
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
