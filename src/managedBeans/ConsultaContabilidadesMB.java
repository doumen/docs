package managedBeans;

import java.util.Hashtable;
import java.util.Map;

import javax.inject.Inject;

import model.Contabilidade;
import facade.GenericCRUDFacade;

public class ConsultaContabilidadesMB extends AbstractCRUDManagedBean<Contabilidade>{

	@Override
	protected GenericCRUDFacade<Contabilidade> createGenericCRUDFacade() {
		return crudFacadeContabilidade;
		
	}

	@Override
	protected Map<String, Object> createDataTableColumnLabel() {
		Map<String,Object> tcl = new Hashtable<>();
//		tcl.put("Razão Social",);
		return tcl;
	}

	@Inject
	private GenericCRUDFacade<Contabilidade> crudFacadeContabilidade;

}
