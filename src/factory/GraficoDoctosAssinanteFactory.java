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
		
		g.setLineChartModel(g.createLineModels(historicoAssinante));
		g.setPieChartModel(g.createPieModel(a));
		
		g.setAssinante(a.getCnpj() + " - " + a.getNomeFantasia());
		g.setContador(a.getCnpj() + " - " + a.getContabilidade().getNomeFantasia());
		g.setPlanoContratado(a.getPlano().getId()+"- Plano " + a.getPlano().getFaixaInicial() + " à " + a.getPlano().getFaixaFinal() + " - R$ " + a.getPlano().getValorMensal() );
		g.setConsumoRestante(a.getPlano().getFaixaFinal()+" Doctos");
		g.setGraficoLinha(jFreeChartExporter.createLineChart(historicoAssinante,"Histórico Consumo","consumo",null,null,100,100));
		g.setGraficoPizza(jFreeChartExporter.createPieChart(createPieDataSet(a),"Consumo de Recurso Contratado",100,100));
		/*
		try {
			g.setGraficoLinha(ImageIO.read(new File("/home/desenv/mac.jpg")));
			g.setGraficoPizza(ImageIO.read(new File("/home/desenv/mac.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		return g;
	}
	
	private PieDataset createPieDataSet(Assinante a){
		DefaultPieDataset pieChartModel = new DefaultPieDataset();

		pieChartModel.setValue("NF-e", a.getNfes().size());
		pieChartModel.setValue("CT-e", a.getCtes().size());
		pieChartModel.setValue("SPED Fiscal", a.getSpedsFiscais().size());
		pieChartModel.setValue("SPED Contribuições", a.getSpedsContribuicoes().size());
		pieChartModel.setValue("SPED Social", a.getSpedsSociais().size());

		return pieChartModel;
	}
}
