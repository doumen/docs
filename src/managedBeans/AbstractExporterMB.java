package managedBeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedProperty;

import managedBeans.components.RelatorioJasperMB;

public abstract class AbstractExporterMB<T> {
	
	private RelatorioJasperMB<T> rj;
		
	public abstract void init();
	public abstract List<T> getReportList();
	public abstract String getTemplateReport();
	public abstract String getReport();
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;
	
	public void setLoginBean(LoginBean loginBean){
		this.loginBean = loginBean;
	}

	public LoginBean getLoginBean(){
		return this.loginBean;		
	}

	@PostConstruct
	public void incio(){
		init();
		rj = new RelatorioJasperMB<>();
		rj.setBeans(getReportList());
		rj.setModulo(loginBean.getModulo());
		rj.setTemplate(getTemplateReport());
		rj.setReport(getReport());
	}
	
	public void printPdf(javax.faces.event.ActionEvent event){
		try{
			this.rj.browserReport();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void exportPdf(javax.faces.event.ActionEvent event){
		try{
			this.rj.downloadReport();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void exportExcel(javax.faces.event.ActionEvent event){
		try{
			this.rj.downloadXls();
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	
}
