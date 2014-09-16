package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import model.Assinante;
import model.GraficoInteracaoAssinanteAdm;

import component.AssinanteComponent;

import factory.GraficoInteracaoAssinanteAdmFactory;

@ManagedBean
public class GraficoInteracaoAssinanteAdmMB {

	private List<Assinante> assinantes;
	
	@Inject
	private AssinanteComponent assinanteComponent;

	/*@PostConstruct
	public void init(){
		assinantes = assinanteComponent.getAssinantes();
		BarChartModel model = new BarChartModel();
		
		for(Assinante a : assinantes){
			ChartSeries cs = new ChartSeries();
			cs.set(x, y);	
		}
	}*/
	
	public List<Assinante> getAssinantes() {
		return assinantes==null?assinanteComponent.getAssinantes():assinantes;
	}

	public void setAssinantes(List<Assinante> assinantes) {
		this.assinantes = assinantes;
	}
	
	public List<GraficoInteracaoAssinanteAdm> getGraficoInteracaoAssinanteAdms() {
		return graficoInteracaoAssinanteAdms;
	}

	public void setGraficoInteracaoAssinanteAdms(
			List<GraficoInteracaoAssinanteAdm> graficoInteracaoAssinanteAdms) {
		this.graficoInteracaoAssinanteAdms = graficoInteracaoAssinanteAdms;
	}

	private List<GraficoInteracaoAssinanteAdm> graficoInteracaoAssinanteAdms;
	
	@Inject
	private GraficoInteracaoAssinanteAdmFactory graficoInteracaoAssinanteAdmFactory;
	
	@PostConstruct
	public void init() {
		graficoInteracaoAssinanteAdms = graficoInteracaoAssinanteAdmFactory.createGraficos(5);
	}
}
