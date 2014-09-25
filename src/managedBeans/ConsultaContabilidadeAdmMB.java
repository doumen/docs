package managedBeans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Contabilidade;
import model.Plano;
import model.TipoInclusao;
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
	private String codPlano;
	private List<Plano> codPlanos;
	private String codContabilidade;
	private List<Contabilidade> codContabilidades;
	private List<Contabilidade> filteredList = new ArrayList<>();
	private String mascara;

	public ConsultaContabilidadeAdmMB() throws InstantiationException,
			IllegalAccessException {
		super(Contabilidade.class);
		System.out.println("Instanciou o ConsultaContabiliadeAdmMB!!");
	}

	@PostConstruct
	public void init() {
		listTable = contabilidadeComponent.getContabilidades();
		filteredList = contabilidadeComponent.getContabilidades();

		codPlanos = new ArrayList<Plano>();
		codPlanos.add(new Plano((long) 1, "Plano 01"));
		codPlanos.add(new Plano((long) 2, "Plano 02"));

		codContabilidades = new ArrayList<Contabilidade>();
		codContabilidades.add(new Contabilidade((long) 1, "Contabilidade 01"));
		codContabilidades.add(new Contabilidade((long) 2, "Contabilidade 02"));
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
	
	public String getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(String codPlano) {
		this.codPlano = codPlano;
	}

	public List<Plano> getCodPlanos() {
		return codPlanos;
	}

	public void setCodPlanos(List<Plano> codPlanos) {
		this.codPlanos = codPlanos;
	}

	public String getCodContabilidade() {
		return codContabilidade;
	}

	public void setCodContabilidade(String codContabilidade) {
		this.codContabilidade = codContabilidade;
	}

	public List<Contabilidade> getCodContabilidades() {
		return codContabilidades;
	}

	public void setCodContabilidades(List<Contabilidade> codContabilidades) {
		this.codContabilidades = codContabilidades;
	}
	
	public List<Contabilidade> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Contabilidade> filteredList) {
		this.filteredList = filteredList;
	}
	
	public String mascaraInscrEstadual() {
		if (selected.getUf() != null) {
			switch (selected.getUf().toString()) {
			case "AC":
				mascara = "99.999.999/999-99";
				break;
			case "AL":
				mascara = "999999999";
				break;
			case "AP":
				mascara = "999999999";
				break;
			case "AM":
				mascara = "99.999.999-9";
				break;
			case "BA":
				mascara = "999.999.99-9";
				break;
			case "CE":
				mascara = "99999999-9";
				break;
			case "DF":
				mascara = "99999999999-99";
				break;
			case "ES":
				mascara = "999.999.99-9";
				break;
			case "GO":
				mascara = "99.999.999-9";
				break;
			case "MA":
				mascara = "999999999";
				break;
			case "MT":
				mascara = "999999999";
				break;
			case "MS":
				mascara = "999999999";
				break;
			case "MG":
				mascara = "999.999.999/9999";
				break;
			case "PA":
				mascara = "99-999999-9";
				break;
			case "PB":
				mascara = "99999999-9";
				break;
			case "PR":
				mascara = "99999999-99";
				break;
			case "PE":
				mascara = "99.9.999.9999999-9";
				break;
			case "PI":
				mascara = "999999999";
				break;
			case "RJ":
				mascara = "99.999.99-9";
				break;
			case "RN":
				mascara = "99.999.999-9";
				break;
			case "RS":
				mascara = "999-9999999";
				break;
			case "RO":
				mascara = "999.99999-9";
				break;
			case "RR":
				mascara = "99999999-9";
				break;
			case "SC":
				mascara = "999.999.999";
				break;
			case "SP":
				mascara = "999.999.999.999";
				break;
			case "SE":
				mascara = "999999999-9";
				break;
			}
		}

		return mascara;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}
	
	public void carregarPopUpAlterar(){
		if((selectedList != null) && (!selectedList.isEmpty())){
			selected = selectedList.get(0);	
			login = "";
			senha = "";
			permissaoAreaAssinante = false;
			permissaoAreaContador = false;
		}
	}
	
	public void carregarPopUpIncluir(){
		selected.setTipoInclusao(TipoInclusao.MODULO_ADMINISTRATIVO);
	}
	
	@Override
	public void setSelected(Contabilidade selected) {
		if(selected!=null && selected.getUf()!=null)
			this.selected = selected;		
		else if(selectedList != null && !selectedList.isEmpty())
			this.selected = selectedList.get(0);		
		setMascara(this.mascaraInscrEstadual());
	}
}