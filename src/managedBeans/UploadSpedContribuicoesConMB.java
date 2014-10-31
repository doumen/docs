package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import component.DoctoComponent;
import component.SpedContribuicoesComponent;

import entity.SpedContribuicoes;
import entity.SpedContribuicoesArquivos;

@ViewScoped
@ManagedBean
public class UploadSpedContribuicoesConMB extends AbstractUploadMB<SpedContribuicoes,SpedContribuicoesArquivos> {

	public UploadSpedContribuicoesConMB() throws InstantiationException, IllegalAccessException {
		super(SpedContribuicoes.class, SpedContribuicoesArquivos.class);
	}

	@Inject
	private SpedContribuicoesComponent spedContribuicoesComponent;

	@Override
	public DoctoComponent<SpedContribuicoes, SpedContribuicoesArquivos> getDoctoComponent() {		 
		return (DoctoComponent<SpedContribuicoes, SpedContribuicoesArquivos>) spedContribuicoesComponent;
	}
	
	
}
