package model;

import java.io.Serializable;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

public class GraficoDoctosAssinante implements Serializable {
	private static final long serialVersionUID = 1L;
	private PieChartModel pieChartModel;
	private LineChartModel lineChartModel;
	private Assinante assinante;
	private Contabilidade contabilidade;
	private Plano plano;

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

	public Assinante getAssinante() {
		return assinante;
	}

	public void setAssinante(Assinante assinante) {
		this.assinante = assinante;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

	public PieChartModel createPieModel(int[] linePie) {
		PieChartModel pieChartModel = new PieChartModel();
		pieChartModel = new PieChartModel();

		pieChartModel.set("NF-e", linePie[0]);
		pieChartModel.set("CT-e", linePie[1]);
		pieChartModel.set("SPED Fiscal", linePie[2]);
		pieChartModel.set("SPED Contribuições", linePie[3]);
		pieChartModel.set("SPED Social", linePie[4]);

		pieChartModel.setTitle("Consumo de Recurso Contratado");
		pieChartModel.setLegendPosition("e");
		pieChartModel.setShowDataLabels(true);
		return pieChartModel;
	}

	public LineChartModel createLineModels(int[] lineGrafico) {
		LineChartModel lineChartModel = new LineChartModel();
		lineChartModel = initLinearModel(lineGrafico);
		lineChartModel.setTitle("Histórico Consumo");
		lineChartModel.setLegendPosition("s");
		Axis yAxis = lineChartModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(1200);
		return lineChartModel;
	}

	private LineChartModel initLinearModel(int[] lineGrafico) {
		LineChartModel model = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();

		series1.set(1, lineGrafico[0]);
		series1.set(2, lineGrafico[1]);
		series1.set(3, lineGrafico[2]);
		series1.set(4, lineGrafico[3]);
		series1.set(5, lineGrafico[4]);
		series1.set(6, lineGrafico[5]);
		series1.set(7, lineGrafico[6]);
		series1.set(8, lineGrafico[7]);
		series1.setLabel("Consumo");

		model.addSeries(series1);

		return model;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof GraficoDoctosAssinante))
			return false;
		GraficoDoctosAssinante g = (GraficoDoctosAssinante) obj;
		return this.getAssinante().equals(g.getAssinante());
	}

	@Override
	public int hashCode() {
		int r = 17;
		r = 31 * r + getAssinante().hashCode();
		return r;
	}
}
