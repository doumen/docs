package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import factory.GraficoDoctosAssinanteFactory;

@ManagedBean
@ViewScoped
public class GraficoDoctosAssinanteAdmMB extends AbstractGraficoDoctosAssinanteMB {
	
	@Override
	public void postConstructAndLoadTotPag() {
		assinantes = assinanteComponent.getAssinantesComTodosOsDoctos();
		setTotPag(assinantes.size());
		graficoDoctosAssinanteAdmFactory = new GraficoDoctosAssinanteFactory();
	}

}
