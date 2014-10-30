package component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Assinante;
import model.NFe;
import dao.GenericDao;
import dao.NFeArquivosDao;
import dao.NFeDao;
import entity.NFeArquivos;

@Stateless
public class NFeComponent extends DoctoComponent<NFe,NFeArquivos>{

	public List<NFe> getNFes(Assinante a) {
		List<NFe> nfes = new ArrayList<NFe>();
		for(int i=0;i<10;i++){
			nfes.add(createNfe(i));
		}
		return nfes;
	}

	private NFe createNfe(int i) {
		NFe nfe = new NFe();
			nfe.setEmissaoNFe(Calendar.getInstance());
			nfe.setAutorizacaoDataHoraNFe(Calendar.getInstance());
		return nfe;
	}

	@EJB
	private NFeDao nfeDao;

	@EJB
	private NFeArquivosDao nfeArquivo;
	
	@Override
	public GenericDao<NFe> getDaoDocto() {
		return (GenericDao) nfeDao;
	}

	@Override
	public GenericDao<NFeArquivos> getDaoArq() {
		return (GenericDao) nfeArquivo;
	}

}
