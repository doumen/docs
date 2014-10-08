package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import factory.GraficoDoctosAssinanteFactory;

@ManagedBean
@ViewScoped
public class GraficoDoctosAssinanteConMB extends AbstractGraficoDoctosAssinanteMB {
		
	@Override
	public void postConstructAndLoadTotPag() {
		assinantes = assinanteComponent.getAssinantes(getLoginBean().getUsuario().getContabilidade());
		setTotPag(assinantes.size());
		graficoDoctosAssinanteAdmFactory = new GraficoDoctosAssinanteFactory();
	}
}
