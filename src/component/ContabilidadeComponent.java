package component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;

import model.Contabilidade;
import model.SiglaEstado;
import model.Usuario;

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
		c.setCnpj("26879634000150");
		c.setMunicipio("municipio " + i);
		c.setUf(SiglaEstado.SP);
		c.setRazaoSocial("RZS Contabilidade " + i);
		c.setNomeFantasia("Contabildiade " + i);
		c.setDataInclusao(Calendar.getInstance());
		c.setEndereco("Endereço " + i);
		c.setEnderecoNumero(String.valueOf(i));
		c.setEnderecoComplemento("Complemento " + i);
		c.setBairro("Bairro " + i);
		c.setCep("14586960");
		c.setInscricaoEstadual("457280558835");
		c.setComissao(0.1);
		
		List<Usuario> listaUsuarios = new ArrayList<>();

		for (long j = 0l; j <= 3; j++) {
			Usuario u = new Usuario();
			
			u.setId(j);
			u.setLogin("usuário " + j);
			u.setSenha("senha " + j);
			u.setPermissaoAreaAssinante(true);
			u.setPermissaoAreaContador(false);
			
			listaUsuarios.add(u);
		}
		
		c.setUsuarios(listaUsuarios);

		return c;
	}

	public void alterar(Contabilidade selected) {
		// TODO Auto-generated method stub
		
	}

	public Object getContabilidadeById(String descricao) {
		for(Contabilidade c :getContabilidades()){
			if(c.getRazaoSocial().equals(descricao)){
				return c;
			}
		}
		return null;
	}
}
