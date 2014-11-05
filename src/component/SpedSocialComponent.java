package component;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.GenericDao;
import dao.SpedSocialArquivosDao;
import dao.SpedSocialDao;
import entity.Arquivo;
import entity.Docto;
import entity.SpedSocial;
import entity.SpedSocialArquivos;

@Stateless
public class SpedSocialComponent extends DoctoComponent<SpedSocial,SpedSocialArquivos>{
	
	@EJB
	private SpedSocialDao spedContribuicoesDao;
	
	@EJB
	private SpedSocialArquivosDao spedContribuicoesArquivosDao;
	
	@Override
	public GenericDao<SpedSocial> getDaoDocto() {
		return spedContribuicoesDao;
	}

	@Override
	public GenericDao<SpedSocialArquivos> getDaoArq() {
		return spedContribuicoesArquivosDao;
	}

	@Override
	public Docto coletaDadosDoXml(Arquivo a) {
		return new SpedSocial();
	}

}
