package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import component.AssinanteComponent;

@ViewScoped
@ManagedBean
public class ConsultaAssinantesConMB extends AbstractConsultaAssinantesMB{

	@Override
	public void incluir() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub		
	}

	@Inject
	AssinanteComponent assinanteComponent;
	
	@Override
	public void init() {
		listTable = assinanteComponent.getAssinantes(getLoginBean().getUsuario().getContabilidade());
		filteredList = assinanteComponent.getAssinantes();		
	}

}
