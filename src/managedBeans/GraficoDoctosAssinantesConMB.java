package managedBeans;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import component.AssinanteComponent;

import factory.GraficoDoctosAssinanteFactory;
import managedBeans.components.PaginatorMB;
import model.Assinante;
import model.GraficoDoctosAssinante;

@ManagedBean
@ViewScoped
public class GraficoDoctosAssinantesConMB extends PaginatorMB {
	private GraficoDoctosAssinante graficoDoctosAssinante;
	private GraficoDoctosAssinanteFactory graficoDoctosAssinanteAdmFactory;
	private Assinante assinante;
	private Map<Object,Number> historico;
	private List<Assinante> assinantes;
	
	@Inject
	private AssinanteComponent assinanteComponent;

	@Override
	public void carregaPagina() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postConstructAndLoadTotPag() {
		// TODO Auto-generated method stub
		
	}

	public GraficoDoctosAssinante getGraficoDoctosAssinante() {
		return graficoDoctosAssinante;
	}

	public void setGraficoDoctosAssinante(GraficoDoctosAssinante graficoDoctosAssinante) {
		this.graficoDoctosAssinante = graficoDoctosAssinante;
	}

	public GraficoDoctosAssinanteFactory getGraficoDoctosAssinanteAdmFactory() {
		return graficoDoctosAssinanteAdmFactory;
	}

	public void setGraficoDoctosAssinanteAdmFactory(
			GraficoDoctosAssinanteFactory graficoDoctosAssinanteAdmFactory) {
		this.graficoDoctosAssinanteAdmFactory = graficoDoctosAssinanteAdmFactory;
	}

	public Assinante getAssinante() {
		return assinante;
	}

	public void setAssinante(Assinante assinante) {
		this.assinante = assinante;
	}

	public Map<Object,Number> getHistorico() {
		return historico;
	}

	public void setHistorico(Map<Object,Number> historico) {
		this.historico = historico;
	}

	public List<Assinante> getAssinantes() {
		return assinantes;
	}

	public void setAssinantes(List<Assinante> assinantes) {
		this.assinantes = assinantes;
	}

}
