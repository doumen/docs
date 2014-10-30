package managedBeans;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import dao.AssinanteDao;
import entity.Contabilidade;
import model.GraficosPainel;

@ManagedBean
public class PainelContabilidadeMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private AssinanteDao assinanteDao;
	
	private PieChartModel pieArmaz;
	private LineChartModel lineNumDocs;
	private LineChartModel lineAssinaturas;
	private LineChartModel lineCancelamento;
	private GraficosPainel graficosPainel;
	private Contabilidade contabilidade;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}
		
	public LineChartModel getLineAssinaturas() {
		return lineAssinaturas;
	}
	
	public LineChartModel getLineCancelamento() {
		return lineCancelamento;
	}
		
	@PostConstruct
	public void init() {
		contabilidade = loginBean.getUsuario().getContabilidade();
		graficosPainel = new GraficosPainel(assinanteDao.getAssinantesComTodosOsDoctos(contabilidade));		
		createPieModel();
		createLineModels();
		System.out.println("A contabilidade é: " + contabilidade);
	}

	private void createPieModel() {
		pieArmaz = new PieChartModel();
		pieArmaz.set("NFe", graficosPainel.getTotalNfe());
		pieArmaz.set("CTe", graficosPainel.getTotalCte());
		pieArmaz.set("Speds", graficosPainel.getTotalSpedCont() + graficosPainel.getTotalSpedFiscal() + graficosPainel.getTotalSpedSocial());
		pieArmaz.setTitle("Armazenamento NFe x CTe x SPEDs");
	}

	private void createLineModels() {
		LineChartSeries numDocs = new LineChartSeries();
		LineChartSeries ass = new LineChartSeries();
		LineChartSeries canc = new LineChartSeries();

		for(int i=0;i<30;i++){
			numDocs.set(-i, graficosPainel.getUltimosTotaisArmazenados().get(i));
			ass.set(-i, graficosPainel.getAssinaturas().get(i));
			canc.set(-i, graficosPainel.getCancelamentos().get(i));
		}
		
		setLineNumDocs(initLinearModel(numDocs));
		getLineNumDocs().setTitle("N Documentos Armazenados pela Contabilidade");
		Axis yAxis = getLineNumDocs().getAxis(AxisType.X);
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

	public PieChartModel getPieArmaz() {
		return pieArmaz;
	}

	public LineChartModel getLineNumDocs() {
		return lineNumDocs;
	}

	public void setLineNumDocs(LineChartModel lineNumDocs) {
		this.lineNumDocs = lineNumDocs;
	}

}
