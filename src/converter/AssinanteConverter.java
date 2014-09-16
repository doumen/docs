package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import model.Assinante;

@FacesConverter(value = "assinanteConverter", forClass = Assinante.class)
public class AssinanteConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1,
			String nomeFantasia) {
		Assinante a = new Assinante(nomeFantasia);
		return a;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object assinante) {

		return assinante == null ? "" : assinante.toString();
	}
}
