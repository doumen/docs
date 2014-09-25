package factory;

import java.util.Map;

import jfreechart.JFreeChartExporter;
import model.Assinante;
import model.GraficoDoctosAssinante;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class GraficoDoctosAssinanteFactory {
	
	private JFreeChartExporter jFreeChartExporter;
	
	public GraficoDoctosAssinanteFactory(){
		jFreeChartExporter = new JFreeChartExporter();
	}
		
	public GraficoDoctosAssinante createGrafico(Assinante a,Map<Object,Number> historicoAssinante) {
		GraficoDoctosAssinante g = new GraficoDoctosAssinante();
				
		g.setAssinante(a.getCnpj() + " - " + a.getNomeFantasia());
		g.setContador(a.getCnpj() + " - " + a.getContabilidade().getNomeFantasia());
		g.setPlanoContratado(a.getPlano().getId()+" - Plano " + a.getPlano().getFaixaInicial() + " à " + a.getPlano().getFaixaFinal() + " - R$ " + a.getPlano().getValorMensal() );
		g.setConsumoRestante(a.getPlano().getFaixaFinal()+" Doctos");
		
		g.setGraficoLinha(jFreeChartExporter.createLineChart(historicoAssinante,"Histórico Consumo","consumo",null,null));
		g.setGraficoPizza(jFreeChartExporter.createPieChart(createPieDataSet(a),"Consumo de Recurso Contratado"));
		return g;
	}
	
	private PieDataset createPieDataSet(Assinante a){
		DefaultPieDataset pieChartModel = new DefaultPieDataset();

		pieChartModel.setValue("NF-e", a.getTotalNfe());
		pieChartModel.setValue("CT-e", a.getTotalCte());
		pieChartModel.setValue("SPED Fiscal", a.getTotalSpedFiscal());
		pieChartModel.setValue("SPED Contribuições", a.getTotalSpedContribuicoes());
		pieChartModel.setValue("SPED Social", a.getTotalSpedSocial());

		return pieChartModel;
	}
}
