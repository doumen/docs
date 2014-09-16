package managedBeans;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.chart.PieChartModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

@ManagedBean
public class PainelAdministrativo implements Serializable {

	private static final long serialVersionUID = 1L;

	private PieChartModel pieCliente;
	private LineChartModel lineFaturamento;
	private LineChartModel lineAssinaturas;
	private LineChartModel lineCancelamento;
	private String analise;

	public PieChartModel getPieCliente() {
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

	@PostConstruct
	public void init() {
		createPieModel();
		createLineModels();
	}

	private void createPieModel() {
		pieCliente = new PieChartModel();

		pieCliente.set("Brand 1", 540);
		pieCliente.set("Brand 2", 325);

		pieCliente
				.setTitle("Clientes de Contabilidade X Clientes Contratação Direta");
	}

	private void createLineModels() {
		lineFaturamento = initLinearModel();
		lineFaturamento.setTitle("Faturamento Últimos 30 Dias");
		Axis yAxis = lineFaturamento.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);

		lineAssinaturas = initLinearModel();
		lineAssinaturas.setTitle("Assinaturas Últimos 30 Dias");
		yAxis = lineAssinaturas.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);

		lineCancelamento = initLinearModel();
		lineCancelamento.setTitle("Cancelamento Últimos 30 Dias");
		yAxis = lineCancelamento.getAxis(AxisType.Y);
		yAxis.setMin(0);
		yAxis.setMax(10);
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();
		LineChartSeries series1 = new LineChartSeries();

		series1.set(1, 2);
		series1.set(2, 1);
		series1.set(3, 3);
		series1.set(4, 6);
		series1.set(5, 8);

		model.addSeries(series1);

		return model;
	}

	public String getAnalise() {
		analise = "Análise de Evolução das Vendas \n\n";
		analise += "40 Clientes\n\n";
		analise += "10 Assinantes Plano R$ 99,90 - R$ 999,90\n";
		analise += "10 Assinantes Plano R$ 79,90 - R$ 799,90\n";
		analise += "10 Assinantes Plano R$ 69,90 - R$ 699,90\n";
		analise += "10 Assinantes Plano R$ 59,90 - R$ 599,90\n\n";
		analise += "40 Clientes = R$ 3.099,60";
		return analise;
	}

	public void setAnalise(String analise) {
		this.analise = analise;
	}

	public void createPieModel2(int nfe, int cte, int spedFiscal,
			int spedContr, int spedSocial) {
		pieCliente = new PieChartModel();

		pieCliente.set("NF-e", nfe);
		pieCliente.set("CT-e", cte);
		pieCliente.set("SPED Fiscal", spedFiscal);
		pieCliente.set("SPED Contribuições", spedContr);
		pieCliente.set("SPED Social", spedSocial);

		pieCliente.setTitle("Consumo de Recurso Contratado");
		pieCliente.setLegendPosition("w");
	}
}
