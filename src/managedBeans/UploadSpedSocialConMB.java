package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import component.DoctoComponent;
import component.SpedSocialComponent;

import entity.SpedSocial;
import entity.SpedSocialArquivos;

@ViewScoped
@ManagedBean
public class UploadSpedSocialConMB extends AbstractUploadMB<SpedSocial,SpedSocialArquivos> {

	public UploadSpedSocialConMB() throws InstantiationException, IllegalAccessException {
		super(SpedSocial.class, SpedSocialArquivos.class);
	}

	@Inject
	private SpedSocialComponent spedFiscalComponent;

	@Override
	public DoctoComponent<SpedSocial, SpedSocialArquivos> getDoctoComponent() {		 
		return (DoctoComponent<SpedSocial, SpedSocialArquivos>) spedFiscalComponent;
	}
	
	
}
