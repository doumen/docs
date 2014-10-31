package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import component.DoctoComponent;
import component.SpedFiscalComponent;

import entity.SpedFiscal;
import entity.SpedFiscalArquivos;

@ViewScoped
@ManagedBean
public class UploadSpedFiscalConMB extends AbstractUploadMB<SpedFiscal,SpedFiscalArquivos> {

	public UploadSpedFiscalConMB() throws InstantiationException, IllegalAccessException {
		super(SpedFiscal.class, SpedFiscalArquivos.class);
	}

	@Inject
	private SpedFiscalComponent spedFiscalComponent;

	@Override
	public DoctoComponent<SpedFiscal, SpedFiscalArquivos> getDoctoComponent() {		 
		return (DoctoComponent<SpedFiscal, SpedFiscalArquivos>) spedFiscalComponent;
	}
	
	
}
