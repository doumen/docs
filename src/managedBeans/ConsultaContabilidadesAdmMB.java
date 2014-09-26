package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import model.Contabilidade;

import component.ContabilidadeComponent;

@ManagedBean
public class ConsultaContabilidadesAdmMB extends AbstractConsultaMB<Contabilidade> {

	public ConsultaContabilidadesAdmMB() {
		super(Contabilidade.class);
	}

	@Inject
	private ContabilidadeComponent contabilidadeComponent;
	
	@Override
	public String getAvisoExcluir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAvisoPreExcluir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPdfFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeSelectedList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void incluir() {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		listTable = contabilidadeComponent.getContabilidades();
	}

}
