package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Map;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

public class GraficoDoctosAssinante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private PieChartModel pieChartModel;
	private LineChartModel lineChartModel;

	private String assinante;	
	private String contador;	
	private BufferedImage graficoPizza;	
	private BufferedImage graficoLinha;
	private String planoContratado;
	private String consumoRestante;
			
	public String getAssinante() {
		return assinante;
	}

	public void setAssinante(String assinante) {
		this.assinante = assinante;
	}

	public BufferedImage getGraficoPizza() {
		return graficoPizza;
	}

	public void setGraficoPizza(BufferedImage graficoPizza) {
		this.graficoPizza = graficoPizza;
	}

	public BufferedImage getGraficoLinha() {
		return graficoLinha;
	}

	public void setGraficoLinha(BufferedImage graficoLinha) {
		this.graficoLinha = graficoLinha;
	}

	public String getPlanoContratado() {
		return planoContratado;
	}

	public void setPlanoContratado(String planoContratado) {
		this.planoContratado = planoContratado;
	}

	public String getConsumoRestante() {
		return consumoRestante;
	}

	public void setConsumoRestante(String consumoRestante) {
		this.consumoRestante = consumoRestante;
	}

	public PieChartModel getPieChartModel() {
		return pieChartModel;
	}

	public void setPieChartModel(PieChartModel pieChartModel) {
		this.pieChartModel = pieChartModel;
	}

	public LineChartModel getLineChartModel() {
		return lineChartModel;
	}

	public void setLineChartModel(LineChartModel lineChartModel) {
		this.lineChartModel = lineChartModel;
	}


	public PieChartModel createPieModel(Assinante a) {
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

	public LineChartModel createLineModels(Map<Object,Number> dados) {
		LineChartModel lineChartModel =new LineChartModel();
		lineChartModel = initLinearModel(dados);
		lineChartModel.setTitle("Histórico Consumo");
		lineChartModel.setLegendPosition("s");
//		lineChartModel.setShowPointLabels(true);
//		lineChartModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		Axis yAxis = lineChartModel.getAxis(AxisType.Y);
//        yAxis.setLabel("Births");
        yAxis.setMin(Util.getMenorNumber(dados));
        yAxis.setMax(Util.getMaiorNumber(dados));
		return lineChartModel;
	}

	private LineChartModel initLinearModel(Map<Object,Number> dados) {
        LineChartModel model = new LineChartModel();
        ChartSeries cs = new ChartSeries();
        cs.setLabel("Consumo");
        for(Object o:dados.keySet()){
        	cs.set(o, dados.get(o));
        }
        /*
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Boys");
        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Girls");
        girls.set("2004", 52);
        girls.set("2005", 60);
        girls.set("2006", 110);
        girls.set("2007", 90);
        girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         */
        model.addSeries(cs);
        return model;	
        }

	public String getContador() {
		return contador;
	}

	public void setContador(String contador) {
		this.contador = contador;
	}

}
