package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.TipoInclusao;

@ManagedBean
@ViewScoped
public class ConsultaAssinantesAdmMB extends AbstractConsultaAssinantesMB {

	public void init() {		
		listTable.addAll(assinanteComponent.getAssinantes());
		System.out.println("listTable = " + listTable);
		//filteredList.addAll(listTable);
		selected.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);		
	}

}
