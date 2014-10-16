package converter;

import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import dao.GenericDao;
import dao.PlanoDao;
import entity.Plano;

@FacesConverter(value = "planoConverter", forClass = Plano.class)
public class PlanoConverter extends GenericConverter<Plano>{

	@Inject
	private PlanoDao dao;
	
	@Override
	public GenericDao<Plano> getDao() {
		return dao;
	}
	
	/*
	@Inject
	private PlanoComponent planoComponent;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1,
			String descricao) {
		try {
			return planoComponent.getPlanoByDescricao(descricao);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object plano) {
		Plano p = (Plano) plano;
		return plano == null ? "" : p.getDescricao();
	}
	*/
}
