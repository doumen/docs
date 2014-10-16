package converter;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.ContabilidadeDao;
import dao.GenericDao;
import entity.Contabilidade;

@FacesConverter(value = "contabilidadeConverter", forClass = Contabilidade.class)

public class ContabilidadeConverter extends GenericConverter<Contabilidade>{

	@Inject
	private ContabilidadeDao dao;
	
	@Override
	public GenericDao<Contabilidade> getDao() {
		return dao;
	}
}
