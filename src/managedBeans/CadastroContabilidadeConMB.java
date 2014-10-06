package managedBeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import model.Contabilidade;
import model.TipoInclusao;
import component.ContabilidadeComponent;

@ManagedBean
@ViewScoped
public class CadastroContabilidadeConMB {

	private Contabilidade selected;
	
	public void alterar(){
		selected.setTipoInclusao(TipoInclusao.MODULO_CONTABILIDADE);
		contabilidadeComponent.alterar(selected);
	}
	
	@Inject
	private ContabilidadeComponent contabilidadeComponent;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}

	@PostConstruct
	public void init(){
		setSelected(loginBean.getUsuario().getAssinante().getContabilidade());		
	}

	public Contabilidade getSelected() {
		return selected;
	}

	public void setSelected(Contabilidade selected) {
		this.selected = selected;
	}
}
