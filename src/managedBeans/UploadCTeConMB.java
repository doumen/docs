package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import component.CTeComponent;
import component.DoctoComponent;

import entity.CTe;
import entity.CTeArquivos;

@ViewScoped
@ManagedBean
public class UploadCTeConMB extends AbstractUploadMB<CTe,CTeArquivos> {

	public UploadCTeConMB() throws InstantiationException, IllegalAccessException {
		super(CTe.class, CTeArquivos.class);
	}

	@Inject
	private CTeComponent nFeComponent;

	@Override
	public DoctoComponent<CTe, CTeArquivos> getDoctoComponent() {		 
		return (DoctoComponent<CTe, CTeArquivos>) nFeComponent;
	}
	
	
}
