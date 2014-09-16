package managedBeans;

import java.io.Serializable;
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
public class RelatorioContratacaoConsumoAdmMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private float font = 0.9f;
	private int zoom = 100;
	private List<Integer> selectedZooms;
	private Integer selectedZoom;

	@Inject
	private AssinanteComponent assinanteComponent;

	@PostConstruct
	public void init() {
		assinantes = assinanteComponent.getRelatorioContratacaoConsumo();
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

	public float getFont() {
		return font;
	}

	public void setFont(float font) {
		this.font = font;
	}

	public void aumentaZoom() {
		if (zoom < 200) {
			zoom += 10;
			font += 0.1f;
		}
	}

	public void diminuiZoom() {
		if (zoom > 0) {
			zoom -= 10;
			font -= 0.1f;
		}
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}

		public List<Integer> getSelectedZooms() {
		return selectedZooms;
	}

	public void setSelectedZooms(List<Integer> selectedZooms) {
		this.selectedZooms = selectedZooms;
	}

	public Integer getSelectedZoom() {
		return selectedZoom;
	}

	public void setSelectedZoom(Integer selectedZoom) {
		this.selectedZoom = selectedZoom;
	}

	public int getTotalDocumentos() {
		return totalDocumentos;
	}

	public void setTotalDocumentos(int totalDocumentos) {
		this.totalDocumentos = totalDocumentos;
	}
}
