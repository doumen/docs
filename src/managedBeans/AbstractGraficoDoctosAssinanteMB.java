package managedBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import managedBeans.components.PaginatorMB;
import entity.Assinante;
import model.GraficoDoctosAssinante;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;

import component.AssinanteComponent;

import factory.GraficoDoctosAssinanteFactory;

public abstract class AbstractGraficoDoctosAssinanteMB extends PaginatorMB{
	
	protected GraficoDoctosAssinante graficoDoctosAssinante;
	
	protected GraficoDoctosAssinanteFactory graficoDoctosAssinanteAdmFactory;

	protected Assinante a;
	
	protected Map<Object,Number> historico;
		
	public GraficoDoctosAssinante getGraficoDoctosAssinante() {
		return graficoDoctosAssinante;
	}
	
	public Map<Object,Number> getHistorico() {
		return historico;
	}

	public void setHistorico(Map<Object,Number> historico) {
		this.historico = historico;
	}

	public void setGraficoDoctosAssinante(
			GraficoDoctosAssinante graficoDoctosAssinante) {
		this.graficoDoctosAssinante = graficoDoctosAssinante;
	}

	protected List<Assinante> assinantes;
	
	@Inject
	protected AssinanteComponent assinanteComponent;
	
	/*
	private RelatorioJasperMB<GraficoDoctosAssinante> createAndloadRelatorioJasperParameters(){
		RelatorioJasperMB<GraficoDoctosAssinante> r = new RelatorioJasperMB<GraficoDoctosAssinante>();
    	List<GraficoDoctosAssinante> graficosDoctosAssinante = new ArrayList<>();
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.MONTH, 0);
    	for(Assinante as:assinantes){
    		graficosDoctosAssinante.add(graficoDoctosAssinanteAdmFactory.createGrafico(as, assinanteComponent.getHistoricoConsumoTotalDoAssinante(as, c, Calendar.getInstance())));
    	}
    	r.setTemplate("template_landscape");
    	r.setBeans(graficosDoctosAssinante);
    	r.setReport("grafico-doctos-assinantes");
    	r.setModulo(getLoginBean().getModulo());
		return r;
	}
	
	public void pdf(){
		try{
			createAndloadRelatorioJasperParameters().downloadReport();	    	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	*/
	
	@Override
	public void carregaPagina(){
		a = assinantes.get(super.getPaginaAtual()-1);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH,0);
		setHistorico(a.getHistoricoConsumoTotalDoAssinante(Calendar.MONTH,12));
		graficoDoctosAssinante = graficoDoctosAssinanteAdmFactory.createLabels(a);
	}
		
	public PieChartModel getPieChartModel(){
		PieChartModel pieChartModel = new PieChartModel();
		pieChartModel = new PieChartModel();

		pieChartModel.set("NF-e", a.getTotalNfe());
		pieChartModel.set("CT-e", a.getTotalCte());
		pieChartModel.set("SPED Fiscal", a.getTotalSpedFiscal());
		pieChartModel.set("SPED Contribuições", a.getTotalSpedContribuicoes());
		pieChartModel.set("SPED Social", a.getTotalSpedSocial());

		pieChartModel.setTitle("Consumo de Recurso Contratado");
		pieChartModel.setLegendPosition("e");
		pieChartModel.setShowDataLabels(true);
		return pieChartModel;
	}
	
	public CartesianChartModel getLineChartModel() {
		CartesianChartModel model =new CartesianChartModel();
        ChartSeries cs = new ChartSeries();
        cs.setLabel("Consumo");
        
        for(Object o:historico.keySet()){
        	cs.set(o,historico.get(o));
        }
		model.addSeries(cs);
		return model;
	}
	
	public void excel(){
		
	}
	@Override
	public List<GraficoDoctosAssinante> getReportList() {
    	List<GraficoDoctosAssinante> graficosDoctosAssinante = new ArrayList<>();
    	graficosDoctosAssinante.add(new GraficoDoctosAssinante());
    	Calendar c = Calendar.getInstance();
    	c.set(Calendar.MONTH, 0);
    	for(Assinante as:assinantes){
    		graficosDoctosAssinante.add(graficoDoctosAssinanteAdmFactory.createGrafico(as, as.getHistoricoConsumoTotalDoAssinante(Calendar.MONTH,12)));
    	}
		return graficosDoctosAssinante;
	}

	@Override
	public String getTemplateReport() {
		return "template_landscape";
	}

	@Override
	public String getReport() {
		return "grafico-doctos-assinantes";
	}

}
