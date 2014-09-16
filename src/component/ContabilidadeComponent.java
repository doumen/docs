package component;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import model.Contabilidade;
import model.SiglaEstado;

@Stateless
public class ContabilidadeComponent {

	public List<Contabilidade> getContabilidades() {
		List<Contabilidade> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l.add(createContabiliade(i));
		}
		return l;
	}

	private Contabilidade createContabiliade(int i) {
		Contabilidade c = new Contabilidade();
		c.setId(Long.valueOf(i));
		c.setCnpj("cnpj " + i);
		c.setMunicipio("municipio " + i);
		c.setUf(SiglaEstado.SP);
		c.setNomeFantasia("Contabiliade " + i);
		return c;
	}
}
