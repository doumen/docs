package managedBeans;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Contabilidade;
import model.Plano;
import model.TipoInclusao;

import org.primefaces.context.RequestContext;

import component.AssinanteComponent;

@ManagedBean
@ViewScoped
public class ConsultaAssinantesAdmMB extends AbstractConsultaAssinantesMB {


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
