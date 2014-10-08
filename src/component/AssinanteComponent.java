package component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import model.Assinante;
import model.CertificadoA1;
import model.Contabilidade;
import model.Plano;
import model.SiglaEstado;
import model.TipoInclusao;
import model.Usuario;
import model.Util;

@Stateless
public class AssinanteComponent {


	public List<Assinante> getAssinantes() {
		ArrayList<Assinante> assinantes = new ArrayList<>();
		int j = 0;
		for (Long i = 0l; i < 100; i++) {
			Assinante a = new Assinante();
			a.setDataInclusao(Calendar.getInstance());
			a.setId(i);
			a.setCnpj("CNPJ " + i);
			a.setNomeFantasia("Nome Assinante " + i);
			a.setPlano(planos[j % 4]);
			a.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);
			a.setRazaoSocial("Razão Social Ass " + i);
			a.setEndereco("Endereço " + i);
			a.setEnderecoNumero(i.toString());
			a.setEnderecoComplemento("Complemento " + i);
			a.setBairro("Bairro " + i);
			a.setCep("12569890");
			a.setMunicipio("Município " + i);
			a.setUf(SiglaEstado.SP);
			a.setCnpj("00747677000198");
			a.setInscricaoEstadual("276394048225");
			a.setEmailFinanceiro("Email financeiro " + i);
			a.setEmailMaster("Email Master " + i);

			Random rand = new Random();

			// nextInt is normally exclusive of the top value,
			// so add 1 to make it inclusive
			int max = a.getPlano().getFaixaFinal();
			int min = a.getPlano().getFaixaInicial();
			int randomNum = rand.nextInt((max - min) + 1) + min;
			a.setTotalDoctosArmazenados(randomNum);
			a.setContabilidade(contabilidades[j % 3]);

			List<Usuario> listaUsuarios = new ArrayList<>();

			for (long k = 0l; k <= 3; k++) {
				Usuario u = new Usuario();
				
				u.setId(k);
				u.setLogin("usuário " + k);
				u.setSenha("senha " + k);
				
				listaUsuarios.add(u);
			}
			
			a.setUsuarios(listaUsuarios);
			
			CertificadoA1 certificadoA1 = new CertificadoA1();
			certificadoA1.setNome("Certificado " + i + ".txt");
			certificadoA1.setDataInclusao(Calendar.getInstance());

			a.setCertificadoA1(certificadoA1);
			
			assinantes.add(a);
			j++;
			min = 0;
			a.setTotalCte(randomNum = rand.nextInt((max - min) + 1) + min);
			max = max - a.getTotalCte();
			a.setTotalNfe(randomNum = rand.nextInt((max - min) + 1) + min);
			max = max - a.getTotalNfe();
			a.setTotalSpedContribuicoes(randomNum = rand.nextInt((max - min) + 1) + min);
			max = max - a.getTotalSpedContribuicoes();
			a.setTotalSpedFiscal(randomNum = rand.nextInt((max - min) + 1) + min);
			max = max - a.getTotalSpedFiscal();
			a.setTotalSpedSocial(randomNum = rand.nextInt((max - min) + 1) + min);
		}

		return assinantes;
	}
		
	private Contabilidade[] contabilidades = new Contabilidade[3];
	private Plano[] planos = new Plano[4];

	public AssinanteComponent() {
		init();
	}

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
		c.setCnpj("1110166200017"+i);
		c.setNomeFantasia("Contabilidade " + i);
		c.setRazaoSocial("Razão Social Cont " + i);
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

	public Map<Object, Number> getHistoricoConsumoTotalDoAssinante(
			Assinante a, Calendar inicio, Calendar fim) {
        Map<Object,Number> data = new LinkedHashMap<Object, Number>();
        for(int i=0;i<12;i++){        	
        	data.put(Util.getMMYYYY(Util.getCalendar(i)), i);
        }
		return data;
	}
	
	public void incluir(Assinante a){
		
	}

	public List<Assinante> getAssinantes(Contabilidade contabilidade) {
		return getAssinantes();
	}
	
	public List<Assinante> getRelatorioAssinantesPlanos(
			Contabilidade contabilidade) {
		return getAssinantes();
	}
	
}
