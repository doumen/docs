package managedBeans;

import java.util.Properties;

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

	@Override
	public String[] getArgs() {
		String[] s = { "id", 
				"descricao", 
				"faixaInicial", 
				"faixaFinal",
				"valorMensal", 
				"valorNfeAdicional" };
		return s;
	}

	@Override
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("id", "Cod.Plano");
		p.put("descricao", "Descrição");
		p.put("faixaInicial", "Faixa Inicial");
		p.put("faixaFinal", "Faixa Final");
		p.put("valorMensal", "Valor Mensalidade");
		p.put("valorNfeAdicional", "Valor NFe Adicional");

		return p;
	}

	@Override
	public void removeSelectedList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void incluir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar() {
		// TODO Auto-generated method stub
		
	}
}
