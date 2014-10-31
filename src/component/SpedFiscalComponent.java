package component;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.GenericDao;
import dao.SpedFiscalArquivosDao;
import dao.SpedFiscalDao;
import entity.SpedFiscal;
import entity.SpedFiscalArquivos;

@Stateless
public class SpedFiscalComponent extends DoctoComponent<SpedFiscal,SpedFiscalArquivos>{
	
	@EJB
	private SpedFiscalDao spedFiscalDao;

	@EJB
	private SpedFiscalArquivosDao spedFiscalArquivo;
	
	@Override
	public GenericDao<SpedFiscal> getDaoDocto() {
		return (GenericDao<SpedFiscal>) spedFiscalDao;
	}

	@Override
	public GenericDao<SpedFiscalArquivos> getDaoArq() {
		return (GenericDao<SpedFiscalArquivos>) spedFiscalArquivo;
	}

}
