package managedBeans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import model.Contabilidade;

@Stateless
public class ContabilidadeService {
	private final static String[] razaoSocial;
	private final static String[] cnpj;

	static {
		razaoSocial = new String[3];
		razaoSocial[0] = "Contabilidade 1";
		razaoSocial[1] = "Contabilidade 2";
		razaoSocial[2] = "Contabilidade 3";

		cnpj = new String[3];
		cnpj[0] = "09.333.234/0001-33";
		cnpj[1] = "03.353.244/0001-53";
		cnpj[2] = "17.505.151/0001-02";
	}

	public void removeContabilidade(Contabilidade c) {
		getContabilidades().remove(c);
	}

	public List<Contabilidade> createContabilidades(int size) {
		List<Contabilidade> list = new ArrayList<Contabilidade>();

		for (int i = 0; i < size; i++) {
			Contabilidade c = new Contabilidade(String.valueOf(i), "cont " + i);
			list.add(c);
		}

		return list;
	}

	public List<Contabilidade> getContabilidades() {
		ArrayList<Contabilidade> contabilidades = new ArrayList<>();
		contabilidades.add(new Contabilidade("Contabilidade 1",
				"09.333.234/0001-33"));
		contabilidades.add(new Contabilidade("Contabilidade 2",
				"09.333.234/0001-33"));
		contabilidades.add(new Contabilidade("Contabilidade 1",
				"09.333.234/0001-3"));
		return contabilidades;
	}

	public List<String> getCnpj() {
		return Arrays.asList(cnpj);
	}
}
