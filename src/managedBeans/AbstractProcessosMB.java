package managedBeans;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import dao.GenericConfiguracoesDao;
import dao.GenericDoctosDao;
import entity.Config;



public abstract class AbstractProcessosMB<C,D> extends ConfiguracoesManagedBeans{
	
	private C config; 
	private List<D> doctos;
	private Class<C> classeConfig;
//	private Class<D> classeDocto;
	
	public abstract GenericConfiguracoesDao<C> getDaoConfig();
	public abstract GenericDoctosDao<D> getDaoDoctos();
	
	public AbstractProcessosMB(Class<C> classeConfig,Class<D> classeDocto){
		this.classeConfig=classeConfig;
//		this.classeDocto = classeDocto;
	}
	
	@SuppressWarnings("unchecked")
	public void salvarConfiguracoes() throws Exception{
		if(config==null)
			config = classeConfig.newInstance();
		setCamposDoConfiguracoesManagedBeansParaOConfig(config);
		Config c = (Config) config;
		c.setDataInclusao(Calendar.getInstance().getTime());
		c.setAssinante(getLoginBean().getAssinante());
		getDaoConfig().merge((C) c);
	}
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}
		
	public LoginBean getLoginBean(){
		return this.loginBean;
	}
	
//	public ConfiguracoesManagedBeans getConfiguracoesManagedBeans(){
//		return this.configuracoesManagedBeans;
//	}
	
	public void loadConfig(){
		if(config!=null)
			setCamposDoConfigParaOConfiguracoesManagedBeans(config);		
	}
	
	public abstract void setCamposDoConfiguracoesManagedBeansParaOConfig(C config);
	public abstract void setCamposDoConfigParaOConfiguracoesManagedBeans(C config);
	
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
