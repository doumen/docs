package component;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.GenericDao;
import dao.NFeArquivosDao;
import dao.NFeDao;
import entity.NFe;
import entity.NFeArquivos;

@Stateless
public class NFeComponent extends DoctoComponent<NFe,NFeArquivos>{

	@EJB
	private NFeDao nfeDao;

	@EJB
	private NFeArquivosDao nfeArquivo;
	
	@Override
	public GenericDao<NFe> getDaoDocto() {
		return (GenericDao<NFe>) nfeDao;
	}

	@Override
	public GenericDao<NFeArquivos> getDaoArq() {
		return (GenericDao<NFeArquivos>) nfeArquivo;
	}

}
