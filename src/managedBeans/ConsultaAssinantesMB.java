package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import model.Assinante;

@ManagedBean
public class ConsultaAssinantesMB {
	
	public ConsultaAssinantesMB(){
	}
	
	public List<Assinante> getAssinantes(){
		List<Assinante> a = new ArrayList<>();
		a.add(new Assinante("assinante 1"));
		a.add(new Assinante("assinante 2"));
		a.add(new Assinante("assinante 3"));
		a.add(new Assinante("assinante 4"));
		a.add(new Assinante("assinante 5"));
		return a;
	}
	
	public String escreve(){
		return "escreve";
	}

}
