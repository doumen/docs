package managedBeans;

import java.io.FileNotFoundException;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import model.Contabilidade;
/*
@ManagedBean
public class ConsultaManagedBean extends AbstractProcessosMB<Contabilidade>{

	public ConsultaManagedBean() throws FileNotFoundException {
		super(new Contabilidade("", ""),"NFe");
		selected = new Contabilidade("","");
	}

	@PostConstruct
	public void init(){
		for(int i=0;i<10;i++){
			listTable.add(new Contabilidade("cnpj " + i,"Razao Social " + i));
		}
	}
	
	@Override
	public String getArgs() {
		
		return "cnpj,id,razaoSocial";
	}

}
*/