package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.TipoInclusao;
import component.AssinanteComponent;

@ViewScoped
@ManagedBean
public class ConsultaAssinantesConMB extends AbstractConsultaAssinantesMB{

	
	@Override
	public void incluir() {
		// TODO Auto-generated method stub		
	}

	@Inject
	AssinanteComponent assinanteComponent;
	
	@Override
	public void init() {
		listTable = assinanteComponent.getAssinantes(getLoginBean().getUsuario().getContabilidade());
		filteredList = assinanteComponent.getAssinantes();
		this.contabilidade = getLoginBean().getUsuario().getContabilidade(); 
	}

	public void carregarPopUpIncluir() {
		selected.setTipoInclusao(TipoInclusao.MODULO_CONTABILIDADE);
		login = "";
		senha = "";
	}

	public void carregarPopUpAlterar() {
		if ((selectedList != null) && (!selectedList.isEmpty())) {
			selected = selectedList.get(0);
			selected.setTipoInclusao(TipoInclusao.MODULO_CONTABILIDADE);
			login = "";
			senha = "";
		}
	}

}
