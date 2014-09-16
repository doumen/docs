package factory;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import model.Assinante;
import model.GraficoInteracaoAssinanteAdm;

@Stateless
public class GraficoInteracaoAssinanteAdmFactory {
	public GraficoInteracaoAssinanteAdm createGraficoInteracaoAssinanteAdm(Assinante assinante) {
		GraficoInteracaoAssinanteAdm g = new GraficoInteracaoAssinanteAdm();
		g.setAssinante(assinante);
		
		g.createBarModel();

		return g;
	}
	
	public List<GraficoInteracaoAssinanteAdm> createGraficos(int size) {
		List<GraficoInteracaoAssinanteAdm> list = new ArrayList<GraficoInteracaoAssinanteAdm>();

		for (int i = 0; i < size; i++) {
			Assinante a = new Assinante();
			a.setNomeFantasia("Assinante " + i);
			
			list.add(createGraficoInteracaoAssinanteAdm(a));
		}

		return list;
	}

}
