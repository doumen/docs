package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Assinante;

import org.primefaces.event.data.SortEvent;

import component.AssinanteComponent;

@ManagedBean
@ViewScoped
public class RelatorioConsumoAssinanteAdmMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Assinante> filteredList = new ArrayList<>();

	@Inject
	private AssinanteComponent assinanteComponent;

	@PostConstruct
	public void init() {
		assinantes = assinanteComponent.getRelatorioConsumoAssinantes();
		filteredList = assinanteComponent.getRelatorioConsumoAssinantes();
	}

	public List<Assinante> getAssinantes() {
		return assinantes;
	}

	private List<Assinante> assinantes;

	private int sortColumnCase = 8;

	private double totalValorMensal = 0d;
	private double totalComissaoMensal = 0d;

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
		case "valMen":
			sortColumnCase = 7;
			break;
		case "cnpjCon":
			sortColumnCase = 8;
			break;
		case "con":
			sortColumnCase = 9;
			break;
		case "comissao":
			sortColumnCase = 10;
			break;
		case "comMen":
			sortColumnCase = 11;
			break;
		default:
			break;
		}
	}

	private void zeraContadores() {
		this.totalValorMensal = 0.0d;
		this.totalComissaoMensal = 0;
	}

	private void acumulaDados(Assinante p) {
		this.totalValorMensal += p.getPlano().getValorMensal();
		this.totalComissaoMensal += p.getComissaoMensal();
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
					if (ehIgual(p.getPlano().getFaixaInicial(),o))
						acumulaDados(p);
					break;
				case 6:
					if (ehIgual(p.getPlano().getFaixaFinal(),o))
						acumulaDados(p);
					break;
				case 7:
					if (ehIgual(p.getPlano().getValorMensal(),o))
						acumulaDados(p);
					break;
				case 8:
					if (p.getContabilidade().getCnpj().equals(o))
						acumulaDados(p);
					break;
				case 9:
					if (p.getContabilidade().getNomeFantasia().equals(o))
						acumulaDados(p);
					break;
				case 10:
					if (ehIgual(p.getContabilidade().getComissao(),o))
						acumulaDados(p);
					break;
				case 11:
					if (ehIgual(p.getComissaoMensal(),o))
						acumulaDados(p);
					break;
				default:
					break;
				}
			}
		}
	}

	private boolean ehIgual(double valorMensal, Object o) {
		return Double.valueOf(valorMensal).equals(o);
	}

	private boolean ehIgual(int faixaInicial, Object o) {
		return Integer.valueOf(faixaInicial).equals(o);
	}

	public double getTotalValorMensal() {
		return totalValorMensal;
	}

	public void setTotalValorMensal(double total) {
		this.totalValorMensal = total;
	}

	public void setAssinantes(List<Assinante> assinantes) {
		this.assinantes = assinantes;
	}

	public double getTotalComissaoMensal() {
		return totalComissaoMensal;
	}

	public void setTotalComissaoMensal(double totalComissaoMensal) {
		this.totalComissaoMensal = totalComissaoMensal;
	}

	public double getComissaoMedia() {
		return getTotalValorMensal()!=0?getTotalComissaoMensal() / getTotalValorMensal():0;
	}

	public List<Assinante> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Assinante> filteredList) {
		this.filteredList = filteredList;
	}

}
