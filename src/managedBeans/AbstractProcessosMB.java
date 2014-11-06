package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import dao.GenericConfiguracoesDao;
import dao.GenericDoctosDao;



public abstract class AbstractProcessosMB<C,D>{
	
	private C config; 
	private List<D> doctos;
	
	public abstract GenericConfiguracoesDao<C> getDaoConfig();
	public abstract GenericDoctosDao<D> getDaoDoctos();
	
	public void salvarConfiguracoes() throws Exception{
		setCamposDoConfiguracoesManagedBeansParaOConfig(configuracoesManagedBeans, config);
		getDaoConfig().merge(getConfig());
	}
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}
	
	@ManagedProperty(value="#{configuracoesManagedBeans}")
	private ConfiguracoesManagedBeans configuracoesManagedBeans;
	
	public void setConfiguracoesManagedBeans(ConfiguracoesManagedBeans loginBean){
		this.configuracoesManagedBeans = loginBean;
	}
	
	public LoginBean getLoginBean(){
		return this.loginBean;
	}
	
//	public ConfiguracoesManagedBeans getConfiguracoesManagedBeans(){
//		return this.configuracoesManagedBeans;
//	}
	
	public void loadConfig(){
		setCamposDoConfigParaOConfiguracoesManagedBeans(config,configuracoesManagedBeans);		
	}
	
	public abstract void setCamposDoConfiguracoesManagedBeansParaOConfig(ConfiguracoesManagedBeans configuracoesManagedBeans,C config);
	public abstract void setCamposDoConfigParaOConfiguracoesManagedBeans(C config,ConfiguracoesManagedBeans configuracoesManagedBeans);
	
	@PostConstruct
	public void init(){
		setConfig(getDaoConfig().findConfiguracoesDoAssinante(getLoginBean().getAssinante()));
		setDoctos(getDaoDoctos().findDoctosDoAssinante(getLoginBean().getAssinante()));
	}

	public C getConfig() {
		return config;
	}

	public void setConfig(C config) {
		this.config = config;
	}

	public List<D> getDoctos() {
		return doctos;
	}

	public void setDoctos(List<D> doctos) {
		this.doctos = doctos;
	}
}
