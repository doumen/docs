package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import dao.GenericDao;

public abstract class GenericConverter<T> implements Converter{

	public abstract GenericDao<T> getDao();

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String id) {
		try {
			return getDao().findByToAnnotadedField(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object obj) {
		return obj==null?"":obj.toString();
	}
	
	
}
