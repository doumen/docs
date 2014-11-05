package component;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.CTeArquivosDao;
import dao.CTeDao;
import dao.GenericDao;
import entity.Arquivo;
import entity.CTe;
import entity.CTeArquivos;
import entity.Docto;

@Stateless
public class CTeComponent extends DoctoComponent<CTe,CTeArquivos>{

	@EJB
	private CTeDao cTeDao;
	
	@EJB
	private CTeArquivosDao cTeArquivosDao;
	
	@Override
	public GenericDao<CTe> getDaoDocto() {
		return cTeDao;
	}

	@Override
	public GenericDao<CTeArquivos> getDaoArq() {
		return cTeArquivosDao;
	}

	@Override
	public Docto coletaDadosDoXml(Arquivo a) {
		Docto cTe = new CTe();
		return cTe;
	}

}
