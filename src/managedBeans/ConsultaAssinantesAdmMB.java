package managedBeans;

import java.util.Calendar;
import java.util.Properties;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import model.Assinante;
import model.Usuario;

import org.primefaces.model.UploadedFile;

import component.AssinanteComponent;

@ManagedBean
@ViewScoped
public class ConsultaAssinantesAdmMB extends AbstractConsultaMB<Assinante>{

	private String login;
	private String senha;
	private UploadedFile file;
	
	public ConsultaAssinantesAdmMB() {
		super(Assinante.class);
		System.out.println("Instanciou o ConsultaAssinantesAdmMB!!");
	}

	public void init(){
		listTable = assinanteComponent.getAssinantes();
	}

	@Inject
	private AssinanteComponent assinanteComponent;
	
	@Override
	public String getAvisoExcluir() {		
		return "os itens serão excluídos tem certeza disso?";
	}

	@Override
	public String getAvisoPreExcluir() {
		return "Os itens serão excluídos";
	}

	public void adicionaUsuario(){
		Usuario u = new Usuario();
		u.setAssinante(selected);
		u.setDataInclusao(Calendar.getInstance());
		u.setLogin(login);
		u.setSenha(senha);
		selected.addUsuario(u);
	}

	public void removeUsuario(){
		selected.removeUsuario(selected.getUsuarios().get(selected.getUsuarios().size()-1));
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
	
	public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
		
	@Override
	public String getPdfFileName() {
		return "assinantes.pdf";
	}

	@Override
	public String[] getArgs() {
		String[] s = {"dataInclusao",
				"plano.id",
				"plano.descricao",
				"plano.valorMensal",
				"id",
				"cnpj",
				"nomeFantasia",
				"contabilidade.id",
				"contabilidade.cnpj",
				"contabilidade.nomeFantasia"};
		return s;
	}

	@Override
	public Properties getProperties() {
		Properties p = new Properties();
			p.put("dataInclusao", "Vencimento");
			p.put("plano.id", "Cod.plano");
			p.put("plano.descricao", "Descrição");
			p.put("plano.valorMensal", "Valor Mensal");
			p.put("assinante.id", "Cod. Ass");
			p.put("cnpj", "CNPJ");
			p.put("nomeFantasia", "Assinante");
			p.put("contabilidade.id", "Cod. Cont");
			p.put("contabilidade.cnpj", "CNPJ");
			p.put("contabilidade.nomeFantasia", "Contabilidade");
		return p;
	}
}
