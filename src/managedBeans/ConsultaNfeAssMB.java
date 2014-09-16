package managedBeans;

import java.io.FileNotFoundException;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import model.NFe;

import component.NFeComponent;

@ManagedBean
public class ConsultaNfeAssMB extends AbstractProcessosMB<NFe>{

	public ConsultaNfeAssMB() throws FileNotFoundException {
		super(NFe.class);
	}

	@Inject
	private NFeComponent nfeComponent;
	
	@Override
	public String[] getArgs() {
		String[] s = {"emissaoNFe",
				"autorizacaoDataHoraNFe"};
		return s;
	}

	@Override
	public Properties getProperties() {
		Properties p = new Properties();
			p.put("emissaoNFe", "Emissão");
			p.put("autorizacaoDataHoraNFe", "Autorização");
			/*
			p.put("entradaSaidaNFe", "E/S");
			p.put("statusNFe", "Status");
			p.put("", "Manifesta");
			p.put("cnpj", "Num.NFe");
			p.put("nomeFantasia", "Série");
			p.put("contabilidade.id", "CNPJ Emitente");
			p.put("contabilidade.cnpj", "Emitente");
			p.put("contabilidade.nomeFantasia", "CNPJ Destinatário");
			p.put("contabilidade.nomeFantasia", "Destinatário");
			p.put("contabilidade.nomeFantasia", "Total Nota");
			*/
		return p;
	}

	@Override
	public void loadDataTables() {
		listTable = nfeComponent.getNFes();
	}
	
}
