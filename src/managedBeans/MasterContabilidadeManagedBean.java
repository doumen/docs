package managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import model.Contabilidade;
import facade.GenericCRUDFacade;

@ManagedBean
public class MasterContabilidadeManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Contabilidade> contabilidades;
	private List<Contabilidade> selectedContabilidades;
	private boolean primeiroDialogRendered = false;
	
	@Inject
	private ContabilidadeService service;

	@PostConstruct
	public void init() {
		contabilidades = service.createContabilidades(5);
	}

	public List<Contabilidade> getContabilidades() {
		return contabilidades;
	}

	public void setService(ContabilidadeService service) {
		this.service = service;
	}

	public List<Contabilidade> getSelectedContabilidades() {
		return selectedContabilidades;
	}

	public void setSelectedContabilidades(List<Contabilidade> selectedContabilidade) {
		this.selectedContabilidades = selectedContabilidade;
	}
		
	public boolean isPrimeiroDialogRendered(){
		return primeiroDialogRendered;
	}
	
	public void mostraPrimeiroDialog(){
	    org.primefaces.context.RequestContext.getCurrentInstance().execute("dlgExcluir.show();"); 
	}

	public void setGenericCRUDFacade(
			GenericCRUDFacade<Contabilidade> genericCRUDFacade) {
		// TODO Auto-generated method stub		
	}
}
