package converter;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import entity.Assinante;
import dao.AssinanteDao;
import dao.GenericDao;

@FacesConverter(value = "assinanteConverter", forClass = Assinante.class)
public class AssinanteConverter extends GenericConverter<Assinante>{

	@Inject
	private AssinanteDao dao;
	
	@Override
	public GenericDao<Assinante> getDao() {
		return dao;
	}

}
