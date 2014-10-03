package managedBeans;

import model.Assinante;

public abstract class AbstractConsultaAssinantesMB extends AbstractConsultaMB<Assinante>{
	
	public AbstractConsultaAssinantesMB() {
		super(Assinante.class);
	}

	@Override
	public String getAvisoExcluir() {
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}
	
	@Override
	public String getPdfTemplateName() {
		return "template_landscape";
	}

	@Override
	public String getPdfReportName() {
		return "assinantes";
	}


}
