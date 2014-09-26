package managedBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Plano;

import component.PlanoComponent;

@ManagedBean
@ViewScoped
public class ConsultaPlanoAdmMB extends AbstractConsultaMB<Plano> {

	public ConsultaPlanoAdmMB() throws InstantiationException,
			IllegalAccessException {
		super(Plano.class);
		System.out.println("Instanciou o ConsultaPlanoAdmMB!!");
	}

	@PostConstruct
	public void init() {
		listTable = planoComponent.getPlanos();
	}

	@Inject
	private PlanoComponent planoComponent;

	@Override
	public String getAvisoExcluir() {
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}

	@Override
	public String getPdfFileName() {
		return "assinantes.pdf";
	}
}
