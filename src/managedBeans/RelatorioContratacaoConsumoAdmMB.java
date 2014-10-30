package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.event.data.SortEvent;

import dao.AssinanteDao;
import entity.Assinante;

@ManagedBean
@ViewScoped
public class RelatorioContratacaoConsumoAdmMB extends AbstractExporterMB<Assinante> implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Assinante> filteredList = new ArrayList<>();

	@Inject
	private AssinanteDao assinanteDao;

	@PostConstruct
	public void init() {
		assinantes = assinanteDao.getAssinantesAtivosComTodosOsDoctos();
		Collections.sort(assinantes, new Comparator<Assinante>() {

			@Override
			public int compare(Assinante o1, Assinante o2) {
				// TODO Auto-generated method stub
				return o1.getPlano().getId().compareTo(o2.getPlano().getId());
			}
		});

//		filteredList.addAll(assinantes);
	}

	public List<Assinante> getAssinantes() {
		return assinantes;
	}

	private List<Assinante> assinantes;

	private int sortColumnCase = 6;

	private int totalDocumentos = 0;
	
	public void onSort(SortEvent event) {
		String[] ids = event.getSortColumn().getClientId()
				.split(java.util.regex.Pattern.quote(":"));
		switch (ids[ids.length - 1]) {
		case "codAss":
			sortColumnCase = 0;
			break;
		case "cnpjAss":
			sortColumnCase = 1;
			break;
		case "ass":
			sortColumnCase = 2;
			break;
		case "codPlan":
			sortColumnCase = 3;
			break;
		case "nomPlan":
			sortColumnCase = 4;
			break;
		case "faixaIni":
			sortColumnCase = 5;
			break;
		case "faixaFim":
			sortColumnCase = 6;
			break;
		case "numDoctos":
			sortColumnCase = 7;
			break;
		default:
			break;
		}
	}

	private void zeraContadores() {
		this.setTotalDocumentos(0);
	}

	private void acumulaDados(Assinante p) {
		this.setTotalDocumentos(this.getTotalDocumentos() + p.getTotalDoctosArmazenados());
	}

	public void calculateTotal(Object o) {
		zeraContadores();
		if (o != null) {
			for (Assinante p : getAssinantes()) {
				switch (sortColumnCase) {
				case 0:
					if (p.getId().equals(o))
						acumulaDados(p);
					break;
				case 1:
					if (p.getCnpj().equals(o))
						acumulaDados(p);
					break;
				case 2:
					if (p.getNomeFantasia().equals(o))
						acumulaDados(p);
					break;
				case 3:
					if (p.getPlano().getId().equals(o))
						acumulaDados(p);
					break;
				case 4:
					if (p.getPlano().getDescricao().equals(o))
						acumulaDados(p);
					break;
				case 5:
					if (ehIgual(p.getPlano().getFaixaInicial(), o))
						acumulaDados(p);
					break;
				case 6:
					if (ehIgual(p.getPlano().getFaixaFinal(), o))
						acumulaDados(p);
					break;
				case 7:
					if (ehIgual(p.getTotalDoctosArmazenados(), o))
						acumulaDados(p);
					break;
				default:
					break;
				}
			}
		}
	}

	private boolean ehIgual(int faixaInicial, Object o) {
		return Integer.valueOf(faixaInicial).equals(o);
	}

	public void setAssinantes(List<Assinante> assinantes) {
		this.assinantes = assinantes;
	}

	public int getTotalDocumentos() {
		return totalDocumentos;
	}

	public void setTotalDocumentos(int totalDocumentos) {
		this.totalDocumentos = totalDocumentos;
	}

	public List<Assinante> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Assinante> filteredList) {
		this.filteredList = filteredList;
	}

	@Override
	public List<Assinante> getReportList() {
		List<Assinante> c = new ArrayList<>();
		c.add(new Assinante());
		c.addAll(getAssinantes());
		return c;
	}

	@Override
	public String getTemplateReport() {
		return "template_portrait";
	}

	@Override
	public String getReport() {
		return "relatorio-contratacao-consumo";
	}
}
