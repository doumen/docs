package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Plano;

@FacesConverter(value = "planoConverter", forClass = Plano.class)
public class PlanoConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1,
			String descricao) {
		Plano p = new Plano(descricao);
		return p;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object plano) {

		return plano == null ? "" : plano.toString();
	}
}
