package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import model.Contabilidade;

import component.ContabilidadeComponent;

@FacesConverter(value = "contabilidadeConverter", forClass = Contabilidade.class)

public class ContabilidadeConverter implements Converter{
	@Inject
	private ContabilidadeComponent contabilidadeComponent;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1,
			String descricao) {
		return contabilidadeComponent.getContabilidadeById(descricao);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object plano) {

		return plano == null ? "" : plano.toString();
	}
}
