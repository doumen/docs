package managedBeans;

import java.io.FileNotFoundException;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import model.NFe;

import component.NFeComponent;

@ManagedBean
public class ConsultaNfeAssMB extends AbstractProcessosMB<NFe>{

	public ConsultaNfeAssMB() throws FileNotFoundException {
		super(NFe.class);
	}

	@Inject
	private NFeComponent nfeComponent;
	
	@Override
	public void loadDataTables() {
		listTable = nfeComponent.getNFes(null);
	}
	
}
