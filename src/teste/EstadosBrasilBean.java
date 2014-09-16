package teste;

import java.util.ArrayList;
import java.util.List;

public class EstadosBrasilBean {

	private List<String> estados;

	public List<String> getEstados() {
		List<String> estadosList = new ArrayList<String>();

		for (EstadosBrasilEnum e : EstadosBrasilEnum.values()) {
			estadosList.add(e.toString());
		}
		return estadosList;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}
}