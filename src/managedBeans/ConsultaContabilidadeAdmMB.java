package managedBeans;

import java.util.Calendar;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Contabilidade;
import model.Usuario;
import component.ContabilidadeComponent;

@ManagedBean
@ViewScoped
public class ConsultaContabilidadeAdmMB extends
		AbstractConsultaMB<Contabilidade> {
	private String login;
	private String senha;
	private boolean permissaoAreaContador;
	private boolean permissaoAreaAssinante;

	public ConsultaContabilidadeAdmMB() throws InstantiationException,
			IllegalAccessException {
		super(Contabilidade.class);
		System.out.println("Instanciou o ConsultaContabiliadeAdmMB!!");
	}

	@PostConstruct
	public void init() {
		listTable = contabilidadeComponent.getContabilidades();
	}

	@Inject
	private ContabilidadeComponent contabilidadeComponent;

	@Override
	public String getAvisoExcluir() {
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}

	@Override
	public String getPdfFileName() {
		return "assinantes.pdf";
	}

	@Override
	public String[] getArgs() {
		String[] s = { "id", "cnpj", "razaoSocial", "municipio", "uf" };
		return s;
	}

	@Override
	public Properties getProperties() {
		Properties p = new Properties();
		p.put("id", "Cod.Cont.");
		p.put("cnpj", "CNPJ");
		p.put("razaoSocial", "Contabilidade");
		p.put("municipio", "Município");
		p.put("uf", "UF");

		return p;
	}

	public void adicionaUsuario() {
		Usuario u = new Usuario();
		u.setContabilidade(selected);
		u.setDataInclusao(Calendar.getInstance());
		u.setLogin(login);
		u.setSenha(senha);
		u.setPermissaoAreaAssinante(permissaoAreaAssinante);
		u.setPermissaoAreaContador(permissaoAreaContador);
		selected.addUsuario(u);
	}

	public void removeUsuario() {
		selected.removeUsuario(selected.getUsuarios().get(
				selected.getUsuarios().size() - 1));
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isPermissaoAreaContador() {
		return permissaoAreaContador;
	}

	public void setPermissaoAreaContador(boolean permissaoAreaContador) {
		this.permissaoAreaContador = permissaoAreaContador;
	}

	public boolean isPermissaoAreaAssinante() {
		return permissaoAreaAssinante;
	}

	public void setPermissaoAreaAssinante(boolean permissaoAreaAssinante) {
		this.permissaoAreaAssinante = permissaoAreaAssinante;
	}
}