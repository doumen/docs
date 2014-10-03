package factory;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import model.Assinante;
import model.Contabilidade;
import model.GraficoDoctosAssinanteAdm;
import model.Plano;

@Stateless
public class GraficoDoctosAssinanteAdmFactory {
	public GraficoDoctosAssinanteAdm createGraficoDoctosAssinanteAdm(Assinante assinante, Contabilidade contabilidade, int[] pieGrafico, int[] lineGrafico) {
		GraficoDoctosAssinanteAdm g = new GraficoDoctosAssinanteAdm();
		g.setAssinante(assinante);
		g.setContabilidade(contabilidade);
		g.createPieModel(pieGrafico);
		g.createLineModels(lineGrafico);
		return g;
	}
	
	public List<GraficoDoctosAssinanteAdm> createGraficos(int size) {
		List<GraficoDoctosAssinanteAdm> list = new ArrayList<GraficoDoctosAssinanteAdm>();
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

		for (int i = 0; i < size; i++) {
			Assinante a = new Assinante();
			a.setNomeFantasia("Assinante " + i);
			
			Plano p = new Plano();
			p.setDescricao("Plano Contratado " + i);
			p.setFaixaFinal(i*3);
			
			a.setPlano(p);

			list.add(createGraficoDoctosAssinanteAdm(a, new Contabilidade(String.valueOf(i), "Contabilidade " + i), pieGrafico, lineGrafico));
		}

		return list;
	}
}
