package managedBeans;

import java.util.Collections;
import java.util.Comparator;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import managedBeans.component.AbstractGraficoInteracaoAssinante;
import dao.AssinanteDao;
import entity.Assinante;

@ManagedBean
@ViewScoped
public class GraficoInteracaoAssinantesAdmMB extends AbstractGraficoInteracaoAssinante<Assinante>{

	@Inject
	private AssinanteDao assinanteDao;
	
	@Override
	public void loadTotalBarras() {
		totalBarras = assinanteDao.getAssinantesAtivosComTodosOsDoctos();
	}

	@Override
	public void ordeneTotalBarrasCrescenteEajusteAmaiorBarra() {
		Collections.sort(totalBarras, new Comparator<Assinante>() {

			@Override
			public int compare(Assinante o1, Assinante o2) {
				return o1.getTotalDoctosArmazenados() - o2.getTotalDoctosArmazenados();
			}
			
		});
		setMaiorBarra(totalBarras.get(totalBarras.size()-1).getTotalDoctosArmazenados());		
	}

	@Override
	public void ordeneTotalBarrasDeCrescenteEAjusteAmaiorBarra() {
		Collections.sort(totalBarras, new Comparator<Assinante>() {

			@Override
			public int compare(Assinante o1, Assinante o2) {
				return o2.getTotalDoctosArmazenados() - o1.getTotalDoctosArmazenados();
			}
			
		});
		setMaiorBarra(totalBarras.get(0).getTotalDoctosArmazenados());				
	}

}
