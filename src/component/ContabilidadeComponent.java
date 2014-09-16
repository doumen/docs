package component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import model.Contabilidade;
import model.SiglaEstado;

@Stateless
public class ContabilidadeComponent {
	public List<Contabilidade> getContabilidades() {
		ArrayList<Contabilidade> contabilidades = new ArrayList<>();
		for (Long i = 0l; i < 10; i++) {
			Contabilidade c = new Contabilidade();
			c.setId(i);
			c.setCnpj("CNPJ " + i + 10);
			c.setRazaoSocial("Contabilidade " + i);
			c.setEndereco("End. " + i);
			c.setEnderecoNumero("N " + i);
			c.setEnderecoComplemento("Complemento " + i);
			c.setBairro("Bairro " + i);
			c.setMunicipio("Município " + i);
			c.setUf(SiglaEstado.SP);
			c.setCep(Integer.valueOf(i.intValue()));
			c.setComissao(Integer.valueOf(i.intValue()));
			c.setDataInclusao(new Date());
			c.setInscricaoEstadual("Insc. Estadual " + i);
			c.setTipoInclusao("Módulo Administrativo");
			contabilidades.add(c);
		}
		return contabilidades;
	}
}
