package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import component.DoctoComponent;
import component.NFeComponent;
import entity.NFe;
import entity.NFeArquivos;

@ViewScoped
@ManagedBean
public class UploadCTeConMB extends AbstractUploadMB<NFe,NFeArquivos> {

	public UploadCTeConMB() throws InstantiationException, IllegalAccessException {
		super(NFe.class, NFeArquivos.class);
	}

	@Inject
	private NFeComponent nFeComponent;

	@Override
	public DoctoComponent<NFe, NFeArquivos> getDoctoComponent() {		 
		return (DoctoComponent) nFeComponent;
	}
	
	
}