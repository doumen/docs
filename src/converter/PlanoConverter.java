package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Plano;

import component.PlanoComponent;

@FacesConverter(value = "planoConverter", forClass = Plano.class)
public class PlanoConverter implements Converter{
	
	@Inject
	private PlanoComponent planoComponent;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1,
			String descricao) {
		return planoComponent.getPlanoById(descricao);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object plano) {

		return plano == null ? "" : plano.toString();
	}
}
