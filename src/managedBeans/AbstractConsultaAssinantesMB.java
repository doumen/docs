package managedBeans;

import java.util.Calendar;
import java.util.List;

import org.primefaces.model.UploadedFile;

import model.Assinante;
import model.Contabilidade;
import model.Plano;
import model.Usuario;
import model.Util;

public abstract class AbstractConsultaAssinantesMB extends AbstractConsultaMB<Assinante>{
	
	protected String login;
	protected String senha;
	protected UploadedFile file;
	protected String mascara;
	protected Plano plano;
	protected List<Plano> planos;
	protected Contabilidade contabilidade;
	protected List<Contabilidade> contabilidades;

	public AbstractConsultaAssinantesMB() {
		super(Assinante.class);
	}

	@Override
	public String getAvisoExcluir() {
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}
	
	@Override
	public String getPdfTemplateName() {
		return "template_landscape";
	}

	@Override
	public String getPdfReportName() {
		return "assinantes";
	}

	public boolean validateUsuario() {
		return super.validateUsuario(login, senha, selected.getUsuarios());
	}

	
	public void adicionaUsuario() {
		if (validateUsuario()) {
			Usuario u = new Usuario();
			u.setAssinante(selected);
			u.setDataInclusao(Calendar.getInstance());
			u.setLogin(login.trim());
			u.setSenha(senha.trim());
			selected.addUsuario(u);
		}
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

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public String mascaraInscrEstadual() {
		mascara = Util.getMascaraCnpj(selected.getUf());
		return mascara;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	@Override
	public void setSelected(Assinante selected) {
		if (selected != null && selected.getUf() != null)
			this.selected = selected;
		else if (selectedList != null && !selectedList.isEmpty())
			this.selected = selectedList.get(0);
		setMascara(this.mascaraInscrEstadual());
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public List<Plano> getPlanos() {
		return planos;
	}

	public void setPlanos(List<Plano> planos) {
		this.planos = planos;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}
			
	public List<Contabilidade> getContabilidades() {
		return contabilidades;
	}

	public void setContabilidades(List<Contabilidade> contabilidades) {
		this.contabilidades = contabilidades;
	}

}
