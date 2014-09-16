package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import model.GraficoDoctosAssinanteAdm;
import factory.GraficoDoctosAssinanteAdmFactory;

@ManagedBean
public class GraficoDoctosAssinanteAdmMB {

	private float font = 0.9f;
	private int zoom = 100;
	private List<Integer> selectedZooms;
	private Integer selectedZoom;

	private List<GraficoDoctosAssinanteAdm> graficoDoctosAssinanteAdm;

	@Inject
	private GraficoDoctosAssinanteAdmFactory graficoDoctosAssinanteAdmFactory;

	@PostConstruct
	public void init() {
		graficoDoctosAssinanteAdm = graficoDoctosAssinanteAdmFactory.createGraficos(5);
	}

	public List<GraficoDoctosAssinanteAdm> getGraficoDoctosAssinanteAdm() {
		return graficoDoctosAssinanteAdm;
	}

	public void setGraficoDoctosAssinanteAdm(
			List<GraficoDoctosAssinanteAdm> graficoDoctosAssinanteAdm) {
		this.graficoDoctosAssinanteAdm = graficoDoctosAssinanteAdm;
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
}
