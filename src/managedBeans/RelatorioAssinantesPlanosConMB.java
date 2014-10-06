package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import managedBeans.components.RelatorioJasperMB;
import model.Assinante;
import component.AssinanteComponent;

@ManagedBean
@ViewScoped
public class RelatorioAssinantesPlanosConMB {
	
	private List<Assinante> filteredList = new ArrayList<>();

	private List<Assinante> assinantes;
	
	private RelatorioJasperMB<Assinante> rj;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}

	@Inject
	private AssinanteComponent assinanteComponent;

	@PostConstruct
	public void init() {
		assinantes = assinanteComponent.getRelatorioAssinantesPlanos(loginBean.getUsuario().getContabilidade());
		filteredList = assinanteComponent.getRelatorioAssinantesPlanos(loginBean.getUsuario().getContabilidade());
		rj = createRelatorioJasperMB();
	}

	public List<Assinante> getAssinantes() {
		return assinantes;
	}
	
	public List<Assinante> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Assinante> filteredList) {
		this.filteredList = filteredList;
	}

	private RelatorioJasperMB<Assinante> createRelatorioJasperMB(){
		RelatorioJasperMB<Assinante> r = new RelatorioJasperMB<>();
		r.setBeans(assinantes);
		r.setReport("relatorio-assinantes-planos");
		r.setTemplate("template_landscape");
		r.setModulo(loginBean.getModulo());
		return r;
	}
	
	public void exportPdf(javax.faces.event.ActionEvent event){
		try{
			this.rj.downloadReport();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void printPdf(javax.faces.event.ActionEvent event){
		try{
			this.rj.browserReport();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
