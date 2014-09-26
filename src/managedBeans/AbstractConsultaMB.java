package managedBeans;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

public abstract class AbstractConsultaMB<T> extends AbstractListMB<T> {

	public AbstractConsultaMB(Class<T> clazz) {
		super(clazz);
	}

	private String tipo;
	private String headerInclude;
	private boolean botaoAlterar;
	private boolean botaoIncluir;

	public abstract String getAvisoExcluir();

	public abstract String getAvisoPreExcluir();

	public abstract String getPdfFileName();

	public void removeSelectedList() {
		listTable.removeAll(selectedList);
	}

	public void incluir() {
		listTable.add(selected);
		System.out.println("incluiu!!!");
	}

	public void alterar() {
		System.out.println("alterou!!!");
	}

	public boolean isUpdateEmptySelection() {
		return "alterar".equals(tipo) && selectedList.isEmpty();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if ("incluir".equals(tipo)) {
			super.limpar();
			setHeaderInclude("Incluir");
			setBotaoIncluir(true);
			setBotaoAlterar(false);
		} else if ("alterar".equals(tipo)) {
			setHeaderInclude("Alterar");
			selected = listTable.get(0);
			setBotaoIncluir(false);
			setBotaoAlterar(true);
		}
		this.tipo = tipo;
	}

	public String getHeaderInclude() {
		return headerInclude;
	}

	public void setHeaderInclude(String headerInclude) {
		this.headerInclude = headerInclude;
	}

	public boolean isBotaoAlterar() {
		return botaoAlterar;
	}

	public void setBotaoAlterar(boolean botaoAlterar) {
		this.botaoAlterar = botaoAlterar;
	}

	public boolean isBotaoIncluir() {
		return botaoIncluir;
	}

	public void setBotaoIncluir(boolean botaoIncluir) {
		this.botaoIncluir = botaoIncluir;
	}
	
	public void print(){
		try{
	    	final File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/assinantes.jasper")); 
	    	Map<String, Object> parametros = new HashMap<String, Object>();
	//    	parametros.put("total",Integer.valueOf(graficosDoctosAssinante.size()));
	    	
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(listTable));
	    	
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
		}catch(Exception e){
			System.out.println("errou");
			e.printStackTrace();
		}
	}
	
	public void exportPdf(){
		try{
	    	final File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/assinantes-teste.jasper")); 
	    	Map<String, Object> parametros = new HashMap<String, Object>();
	//    	parametros.put("total",Integer.valueOf(graficosDoctosAssinante.size()));
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(listTable)); 
	    	final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
	    	response.addHeader("Content-disposition", "attachment; filename=Grafico-Manipulacao-DoctosXAssinantes.pdf"); 
	    	final ServletOutputStream stream = response.getOutputStream(); 
	    	JasperExportManager.exportReportToPdfStream(jasperPrint, stream); 
	    	stream.flush(); 
	    	stream.close(); 
	    	FacesContext.getCurrentInstance().responseComplete();	    			
		}catch(Exception e){
			System.out.println("falhou!");
			e.printStackTrace();
		}
	}


}