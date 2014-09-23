package model;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Map;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
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

		pieChartModel.set("NF-e", a.getNfes().size());
		pieChartModel.set("CT-e", a.getCtes().size());
		pieChartModel.set("SPED Fiscal", a.getSpedsFiscais().size());
		pieChartModel.set("SPED Contribuições", a.getSpedsContribuicoes().size());
		pieChartModel.set("SPED Social", a.getSpedsSociais().size());

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
		Axis yAxis = lineChartModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(1200);
		return lineChartModel;
	}

	private LineChartModel initLinearModel(Map<Object,Number> dados) {
		LineChartModel model = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();
		series1.setData(dados);
		series1.setLabel("Consumo");

		model.addSeries(series1);

		return model;
	}

	public String getContador() {
		return contador;
	}

	public void setContador(String contador) {
		this.contador = contador;
	}

}
