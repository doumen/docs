package managedBeans;

import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import component.ContabilidadeComponent;
import model.Contabilidade;

@ManagedBean
public class ConsultaContabilidadesAdmMB extends AbstractConsultaMB<Contabilidade> {

	public ConsultaContabilidadesAdmMB() {
		super(Contabilidade.class);
	}

	@Inject
	private ContabilidadeComponent contabilidadeComponent;
	
	@Override
	public String getAvisoExcluir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAvisoPreExcluir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPdfFileName() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public String[] getArgs() {
		return new String[]{
				"id",
				"cnpj",
				"nomeFantasia",
				"municipio",
				"uf"
				
		};
	}

	@Override
	public Properties getProperties() {
		Properties p = new Properties();
			p.put("id", "Cod.Cont");
			p.put("cnpj", "CNPJ");
			p.put("nomeFantasia", "Contabilidade");
			p.put("municipio", "Município");
			p.put("uf", "UF");
		return p;
	}

	@Override
	public void init() {
		listTable = contabilidadeComponent.getContabilidades();
	}

}
