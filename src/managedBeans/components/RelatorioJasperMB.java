package managedBeans.components;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

@ViewScoped
@ManagedBean
public class RelatorioJasperMB<T> {

	private String report;

	private Map<String, Object> parametros;

	private List<T> beans;
	
	public void downloadReport() throws JRException, IOException{
    	final File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/"+report+".jasper")); 
    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(beans)); 
    	final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
    	response.addHeader("Content-disposition", "attachment; filename="+report+".pdf"); 
    	final ServletOutputStream stream = response.getOutputStream(); 
    	JasperExportManager.exportReportToPdfStream(jasperPrint, stream); 
    	stream.flush(); 
    	stream.close(); 
    	FacesContext.getCurrentInstance().responseComplete();	    	
	}
	
	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Map<String, Object> getParametros() {
		return parametros==null?new HashMap<String,Object>():parametros;
	}

	public void setParametros(Map<String, Object> parametros) {
		this.parametros = parametros;
	}

	public List<T> getBeans() {
		return beans;
	}

	public void setBeans(List<T> beans) {
		this.beans = beans;
	}

	public void browserReport()throws JRException, IOException{
    	final File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/template_portrait.jasper")); 
    	getParametros().put("report", getReport());
    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(beans));
    	
    	final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
    	
    	final JRPdfExporter exporter = new JRPdfExporter();
    	final SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
    	configuration.setPdfJavaScript(PdfExporterConfiguration.PROPERTY_PDF_JAVASCRIPT);
    	exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    	exporter.setConfiguration(configuration);
    	
    	final ServletOutputStream stream = response.getOutputStream();
    	exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
    	exporter.exportReport();
    	
    	stream.flush(); 
    	stream.close(); 
    	FacesContext.getCurrentInstance().responseComplete();	    	
	}
}
