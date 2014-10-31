package component;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.GenericDao;
import dao.SpedContribuicoesArquivosDao;
import dao.SpedContribuicoesDao;
import entity.SpedContribuicoes;
import entity.SpedContribuicoesArquivos;

@Stateless
public class SpedContribuicoesComponent extends DoctoComponent<SpedContribuicoes,SpedContribuicoesArquivos>{

	@EJB
	private SpedContribuicoesDao spedContribuicoesDao;
	
	@EJB
	private SpedContribuicoesArquivosDao spedContribuicoesArquivosDao;
	
	@Override
	public GenericDao<SpedContribuicoes> getDaoDocto() {
		return spedContribuicoesDao;
	}

	@Override
	public GenericDao<SpedContribuicoesArquivos> getDaoArq() {
		return spedContribuicoesArquivosDao;
	}

}
