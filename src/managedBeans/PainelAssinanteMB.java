package managedBeans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import model.GraficosPainel;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import dao.AssinanteDao;

@ManagedBean
public class PainelAssinanteMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AssinanteDao assinanteDao;
	
	private PieChartModel pieCliente;
	private LineChartModel lineFaturamento;
	private LineChartModel lineAssinaturas;
	private LineChartModel lineCancelamento;
	private GraficosPainel graficosPainel;

	
	public PieChartModel getPieCliente() {
		System.out.println("Chamou o getPieCliente()");
		return pieCliente;
	}

	public LineChartModel getLineFaturamento() {
		return lineFaturamento;
	}
	
	public LineChartModel getLineAssinaturas() {
		return lineAssinaturas;
	}
	
	public LineChartModel getLineCancelamento() {
		return lineCancelamento;
	}

	public PainelAssinanteMB() {
		System.out.println("Instanciou o PainelAssinanteMB!");
	}
	
	
	@PostConstruct
	public void init() {
		graficosPainel = new GraficosPainel(assinanteDao.getAssinantesComTodosOsDoctos());		
		createPieModel();
		createLineModels();		
	}

	private void createPieModel() {
		
		pieCliente = new PieChartModel();
		
		pieCliente.set("Contabilidade", graficosPainel.getTotalContratacaoContabilidade());
		pieCliente.set("Direta", graficosPainel.getTotalContratacaoDireta());
		pieCliente.setTitle("Clientes de Contabilidade X Clientes Contratação Direta");
	}

	private void createLineModels() {
		LineChartSeries fat = new LineChartSeries();
		LineChartSeries ass = new LineChartSeries();
		LineChartSeries canc = new LineChartSeries();

		for(int i=0;i<30;i++){
			fat.set(-i, graficosPainel.getFaturamentos().get(i));
			ass.set(-i, graficosPainel.getAssinaturas().get(i));
			canc.set(-i, graficosPainel.getCancelamentos().get(i));
		}
		
		lineFaturamento = initLinearModel(fat);
		lineFaturamento.setTitle("Faturamento Últimos 30 Dias");
		Axis yAxis = lineFaturamento.getAxis(AxisType.X);
		yAxis.setMin(-30);
		yAxis.setMax(1);
		
		lineAssinaturas = initLinearModel(ass);
		lineAssinaturas.setTitle("Assinaturas Últimos 30 Dias");
		yAxis = lineAssinaturas.getAxis(AxisType.X);
		yAxis.setMin(-30);
		yAxis.setMax(1);
		
		lineCancelamento = initLinearModel(canc);
		lineCancelamento.setTitle("Cancelamento Últimos 30 Dias");
		yAxis = lineCancelamento.getAxis(AxisType.X);
		yAxis.setMin(-30);
		yAxis.setMax(1);
	}

	private LineChartModel initLinearModel(LineChartSeries series1) {
		LineChartModel model = new LineChartModel();
		model.addSeries(series1);
		return model;
	}

	public String getAnalise(){
		return graficosPainel.getAnalise();
	}

}
