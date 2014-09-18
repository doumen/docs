package factory;

import javax.ejb.Stateless;

import model.Assinante;
import model.GraficoDoctosAssinante;

@Stateless
public class GraficoDoctosAssinanteFactory {
	
	/*
	public GraficoDoctosAssinante createGraficoDoctosAssinanteAdm(Assinante assinante, Contabilidade contabilidade, int[] pieGrafico, int[] lineGrafico) {
		GraficoDoctosAssinante g = new GraficoDoctosAssinante();
		g.setAssinante(assinante);
		g.setContabilidade(contabilidade);
		g.createPieModel(pieGrafico);
		g.createLineModels(lineGrafico);
		return g;
	}
	*/
	
	public GraficoDoctosAssinante createGrafico(Assinante a) {
		int[] lineGrafico = new int[8];
		int[] pieGrafico = new int[5];
		
		for (int i = 0; i < 5; i++)
		{
			pieGrafico[i] = (int) (Math.random() * 100);
		}
		
		for (int i = 0; i < 8; i++)
		{
			lineGrafico[i] = (int) (Math.random() * 1000);
		}		
		GraficoDoctosAssinante g = new GraficoDoctosAssinante();
		g.setAssinante(a);
		g.setContabilidade(a.getContabilidade());
		g.setLineChartModel(g.createLineModels(lineGrafico));
		g.setPieChartModel(g.createPieModel(pieGrafico));
		return g;
	}
}
