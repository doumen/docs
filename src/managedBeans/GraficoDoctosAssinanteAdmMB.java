package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import managedBeans.components.RelatorioDataTableMB;
import model.Assinante;
import model.GraficoDoctosAssinante;

import component.AssinanteComponent;

import factory.GraficoDoctosAssinanteFactory;

@ManagedBean
public class GraficoDoctosAssinanteAdmMB extends RelatorioDataTableMB{

	private List<GraficoDoctosAssinante> graficosDoctosAssinante;

	@Inject
	private GraficoDoctosAssinanteFactory graficoDoctosAssinanteAdmFactory;

	@Inject 
	private AssinanteComponent assinanteComponent;
	
	@PostConstruct
	public void init() {
		graficosDoctosAssinante = new ArrayList<>();
		List<Assinante> assinantes = assinanteComponent.getAssinantes();
		for(Assinante a:assinantes)
			graficosDoctosAssinante.add(graficoDoctosAssinanteAdmFactory.createGrafico(a));
		setFont(0.9f);
		setZoom(100);
		super.init();
	}

	public List<GraficoDoctosAssinante> getGraficosDoctosAssinante() {
		return graficosDoctosAssinante;
	}

	public void setGraficosDoctosAssinante(
			List<GraficoDoctosAssinante> graficoDoctosAssinanteAdm) {
		this.graficosDoctosAssinante = graficoDoctosAssinanteAdm;
	}
	

}
