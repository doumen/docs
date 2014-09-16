package component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import model.Assinante;
import model.Contabilidade;
import model.Plano;
import model.Usuario;

@Stateless
public class AssinanteComponent {
	public List<Assinante> getAssinantes() {
		ArrayList<Assinante> assinantes = new ArrayList<>();
		for (Long i = 0l; i < 10; i++) {
			Assinante a = new Assinante();
			Plano p = new Plano();
			p.setId(i);
			p.setDescricao("plano " + i);
			p.setFaixaFinal((int) (i * 1.2));

			a.setDataInclusao(new Date());
			a.setId(i);
			a.setCnpj("CNPJ " + i);
			a.setNomeFantasia("Nome Assinante " + i);
			a.setPlano(p);
			a.setTipoInclusao("Módulo Administrativo");
			a.setInscricaoEstadual("Insc.Estadual " + i);
			a.setRazaoSocial("Razão Social " + i);
			a.setEndereco("End. " + i);
			a.setEnderecoNumero("N " + i);
			a.setEnderecoComplemento("Compl. " + i);
			a.setBairro("Bairro " + i);
			a.setCep(Integer.valueOf(i.intValue()));
			a.setEmailFinanceiro("E-mail Financeiro " + i);
			a.setEmailMaster("E-mail Master " + i);

			Contabilidade c = new Contabilidade();
			c.setId(i + 10);
			c.setCnpj("CNPJ " + i + 10);
			c.setRazaoSocial("Contabilidade " + i);
			c.setNomeFantasia("Nome Contabilidade " + i);

			a.setContabilidade(c);
			assinantes.add(a);
		}
		Collections.sort(assinantes);
		return assinantes;
	}
	
	/*public List<Assinante> getAssinantes() {
		ArrayList<Assinante> assinantes = new ArrayList<>();
		int j = 0;
		for (Long i = 0l; i < 10; i++) {
			Assinante a = new Assinante();
			a.setDataInclusao(new Date());
			a.setId(i);
			a.setCnpj("CNPJ " + i);
			a.setNomeFantasia("Nome Assinante " + i);
			a.setPlano(planos[j%4]);			
			a.setContabilidade(contabilidades[j%3]);
			assinantes.add(a);
			j++;
		}
		return assinantes;
	}*/

	public List<Assinante> getAssinantes(Usuario usuario) {
		ArrayList<Assinante> assinantes = new ArrayList<>();
		if ("contador".equals(usuario.getLogin())) {
			assinantes.add(new Assinante("assinante 1 do contador"));
			assinantes.add(new Assinante("assinante 2 do contador"));
		} else if ("assinante".equals(usuario.getLogin())) {
			assinantes.add(new Assinante("assinante 1 do usuario assinante"));
			assinantes.add(new Assinante("assinante 2 do usuario assinante"));
		}
		return assinantes;
	}

	private Contabilidade[] contabilidades = new Contabilidade[3];
	private Plano[] planos = new Plano[4];

	@PostConstruct
	public void init() {
		int j = 0;
		for (Long i = 0l; i < 3l; i++) {
			contabilidades[j] = createContabilidade(i);
			j++;
		}
		j = 0;
		for (Long i = 0l; i < 4l; i++) {
			planos[j] = createPlano(i);
			j++;
		}
	}

	private Contabilidade createContabilidade(long i) {
		Contabilidade c = new Contabilidade();
		c.setId(i + 10);
		c.setCnpj("CNPJ " + i + 10);
		c.setNomeFantasia("Contabilidade " + i);
		c.setComissao(0.1d);
		return c;
	}

	private Plano createPlano(long i) {
		int j = Integer.valueOf(String.valueOf(i));
		Plano p = new Plano();
		p.setId(i);
		p.setDescricao("plano " + i);
		p.setValorMensal(i * 1.2);
		p.setFaixaInicial(j * 1000 + 1);
		p.setFaixaFinal((j + 1) * 1000);
		return p;
	}

	public List<Assinante> getRelatorioConsumoAssinantes() {
		return getAssinantes();
	}
	
	public List<Assinante> getAssinantesOrdenadosPorInteracao() {
		List<Assinante> a = getAssinantes();
		Collections.sort(a);
		return a;
	}

	public List<Assinante> getRelatorioContratacaoConsumo() {
		List<Assinante> as = getAssinantes();
		return as;
	}
}
