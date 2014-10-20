package component;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ContabilidadeDao;
import entity.Contabilidade;

@Stateless
public class ContabilidadeComponent {

	@EJB
	private ContabilidadeDao contabilidadeDao;
	
	public List<Contabilidade> getContabilidades() {
		/*
		List<Contabilidade> l = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			l.add(createContabiliade(i));
		}
		return l;
		*/
		try {
			return contabilidadeDao.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	private Contabilidade createContabiliade(int i) {
		Contabilidade c = new Contabilidade();
		c.setId(Long.valueOf(i));
		c.setCnpj("26879634000150");
		c.setMunicipio("municipio " + i);
		c.setUf(SiglaEstado.SP);
		c.setRazaoSocial("RZS Contabilidade " + i);
		c.setNomeFantasia("Contabildiade " + i);
		c.setDataInclusao(Calendar.getInstance().getTime());
		c.setEndereco("Endereço " + i);
		c.setEnderecoNumero(String.valueOf(i));
		c.setEnderecoComplemento("Complemento " + i);
		c.setBairro("Bairro " + i);
		c.setCep(14586960);
		c.setInscricaoEstadual("457280558835");
		c.setComissao(0.1);
		
		List<Usuario> listaUsuarios = new ArrayList<>();

		for (long j = 0l; j <= 3; j++) {
			Usuario u = new Usuario();
			
			u.setId(j);
			u.setLogin("usuário " + j);
			u.setSenha("senha " + j);
			u.setPermissaoAreaAdministrador(true);
			u.setPermissaoAreaContador(false);
			
			listaUsuarios.add(u);
		}
		
		c.setUsuarios(listaUsuarios);

		return c;
	}
*/
	public void alterar(Contabilidade selected) {
		// TODO Auto-generated method stub
		
	}

	public Contabilidade getContabilidadeById(String descricao) {
		for(Contabilidade c :getContabilidades()){
			if(c.getRazaoSocial().equals(descricao)){
				return c;
			}
		}
		return null;
	}

	public Contabilidade getContabilidadeByNomeFantasia(String nomeFantasia) {
		return contabilidadeDao.getContabilidadeByNomeFantasia(nomeFantasia);
	}
}
