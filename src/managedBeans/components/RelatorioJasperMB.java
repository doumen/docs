package managedBeans.components;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import entity.Plano;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

import component.PlanoComponent;


public class RelatorioJasperMB<T> {

	private String report;
	private Map<String, Object> parametros;
	private List<T> beans;
	private String template;
	private String modulo;
	
	public void downloadReport() throws JRException, IOException{
    	final JasperPrint jasperPrint = getJasperPrint(); 
    	final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
    	response.addHeader("Content-disposition", "attachment; filename="+report+".pdf"); 
    	final ServletOutputStream stream = response.getOutputStream(); 
    	JasperExportManager.exportReportToPdfStream(jasperPrint, stream); 
    	stream.flush(); 
    	stream.close(); 
    	FacesContext.getCurrentInstance().responseComplete();	    	
	}
	
	public void downloadXls() throws JRException, IOException{
    	final JasperPrint jasperPrint = getJasperPrint(); 
    	final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
    	response.addHeader("Content-disposition", "attachment; filename="+report+".xls"); 
    	final ServletOutputStream stream = response.getOutputStream(); 
    	final JRXlsxExporter exporter = new JRXlsxExporter();
    	exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
    	exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
    	exporter.exportReport();
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

	private HashMap<String,Object> getParam(){
		HashMap<String,Object> param = new HashMap<String,Object>();
    	param.put("report", FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/"+this.getReport()+".jasper"));		
    	param.put("estilo", FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/"+this.getModulo()+".jrtx"));		
    	Locale locale = new Locale("pt", "BR");
    	param.put(JRParameter.REPORT_LOCALE, locale);
		return param;
	}
	
	
	private JasperPrint getJasperPrint() throws JRException{
    	final File template = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/"+this.getTemplate()+".jasper")); 
    	HashMap<String,Object> param = getParam(); 
    	JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(beans);
    	param.put("data", data);		
		return JasperFillManager.fillReport(template.getAbsolutePath(),param,data);
	}
	
	public void browserReport()throws JRException, IOException{
		

    	
    	final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
    	
    	JasperPrint fillReport = getJasperPrint();

    	final JRPdfExporter exporter = new JRPdfExporter();
    	final SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
    	configuration.setPdfJavaScript(PdfExporterConfiguration.PROPERTY_PDF_JAVASCRIPT);
    	exporter.setExporterInput(new SimpleExporterInput(fillReport));
    	exporter.setConfiguration(configuration);
    	
    	final ServletOutputStream stream = response.getOutputStream();
    	exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(stream));
    	exporter.exportReport();
    	
    	stream.flush(); 
    	stream.close(); 
    	FacesContext.getCurrentInstance().responseComplete();	    	
	}
		
	public static void main(String[] args) throws IOException {
		RelatorioJasperMB<Plano> rj = new RelatorioJasperMB<>();
		String home = "/home/desenv/reports/template_portrait";
    	try {
    		List<Plano> planos = (new PlanoComponent()).getPlanos();
        	/*
        	JasperDesign report = JRXmlLoader.load(home+".jrxml");
        	File f = new File(home+"2.jasper");
        	f.delete();
        	f.createNewFile();
        	JasperCompileManager.compileReportToFile(report,f.getAbsolutePath());
        	*/
    		
        	final File template = new File(home+".jasper"); 
        	
        	HashMap<String,Object> param = new HashMap<String,Object>(); 
        	JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(planos);
        	param.put("data", data);
        	param.put("report", "/home/desenv/reports/planos.jasper");
        	JasperPrint fillReport = JasperFillManager.fillReport(template.getAbsolutePath(),param,data);
        	
        	rj.exportToFile(fillReport);
 		} catch (JRException e) {
			e.printStackTrace();
		}		
	}
	
	private void exportToFile(JasperPrint fillReport) throws IOException, JRException{
    	File pdf = new File("/home/desenv/reports/template_portrait.pdf");
    	pdf.delete();
    	boolean createNewFile = pdf.createNewFile();
    	System.out.println("Criou novo arquivo " + createNewFile);
    	JasperExportManager.exportReportToPdfFile(fillReport, pdf.getAbsolutePath());		
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
}
