package managedBeans;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

public class AbstractZoomFontMB {
	
	private float font = 1.0f;
	private int zoom = 100;
	private Integer selectedZoom;
	private Map<String, Integer> selectedZooms = new LinkedHashMap<String, Integer>();

	public float getFont() {
		return font;
	}

	public void setFont(float font) {
		this.font = font;
	}

	public void aumentaZoom() {
		if (getZoom() < 200) {
			setZoom(getZoom() + 10);
			font += 0.1f;
		}
	}

	public void diminuiZoom() {
		if (getZoom() > 0) {
			setZoom(getZoom() - 10);
			font -= 0.1f;
		}
	}

	public Integer getSelectedZoom() {
		return selectedZoom;
	}

	public void setSelectedZoom(Integer selectedZoom) {
		this.selectedZoom = selectedZoom;
	}

	public Map<String, Integer> getSelectedZooms() {
		return selectedZooms;
	}

	public void setSelectedZooms(Map<String, Integer> selectedZooms) {
		this.selectedZooms = selectedZooms;
	}

	public void initSelectZooms() {
		selectedZooms = new LinkedHashMap<String, Integer>();
		selectedZooms.put("10%", 10);
		selectedZooms.put("20%", 20);
		selectedZooms.put("30%", 30);
		selectedZooms.put("40%", 40);
		selectedZooms.put("50%", 50);
		selectedZooms.put("60%", 60);
		selectedZooms.put("70%", 70);
		selectedZooms.put("80%", 80);
		selectedZooms.put("90%", 90);
		selectedZooms.put("100%", 100);
		selectedZooms.put("110%", 110);
		selectedZooms.put("120%", 120);
		selectedZooms.put("130%", 130);
		selectedZooms.put("140%", 140);
		selectedZooms.put("150%", 150);
		selectedZooms.put("160%", 160);
		selectedZooms.put("170%", 170);
		selectedZooms.put("180%", 180);
		selectedZooms.put("190%", 190);
		selectedZooms.put("200%", 200);
	}

	public void zoomSelectOneMenu() {
		font = ((float) getZoom()) / 100;
	}
	
	@PostConstruct
	public void init() {
		initSelectZooms();
	}

	public int getZoom() {
		return zoom;
	}

	public void setZoom(int zoom) {
		this.zoom = zoom;
	}


}
