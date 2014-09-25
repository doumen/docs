package managedBeans;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import managedBeans.components.RelatorioDataTableMB;
import model.Assinante;
import model.GraficoDoctosAssinante;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import component.AssinanteComponent;

import factory.GraficoDoctosAssinanteFactory;

@ManagedBean
@SessionScoped
public class GraficoDoctosAssinanteAdmMB extends RelatorioDataTableMB {

	private List<GraficoDoctosAssinante> graficosDoctosAssinante;

	private GraficoDoctosAssinante graficoDoctosAssinante;
	
	private GraficoDoctosAssinanteFactory graficoDoctosAssinanteAdmFactory;

	@Inject
	private AssinanteComponent assinanteComponent;

	@PostConstruct
	public void init() {
		graficosDoctosAssinante = new ArrayList<>();
		List<Assinante> assinantes = assinanteComponent.getAssinantes();
		graficoDoctosAssinanteAdmFactory = new GraficoDoctosAssinanteFactory();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, 0);
		for (Assinante a : assinantes)
			graficosDoctosAssinante.add(graficoDoctosAssinanteAdmFactory
					.createGrafico(a,assinanteComponent.getHistoricoConsumoTotalDoAssinante(a,c,Calendar.getInstance())));
		setFont(0.9f);
		setZoom(100);
		super.init();
	}

	public void graficoDoctosAssinanteAtual() {
		setGraficoDoctosAssinante(graficoDoctosAssinante);
	}

	public List<GraficoDoctosAssinante> getGraficosDoctosAssinante() {
		return graficosDoctosAssinante;
	}

	public void setGraficosDoctosAssinante(
			List<GraficoDoctosAssinante> graficoDoctosAssinanteAdm) {
		this.graficosDoctosAssinante = graficoDoctosAssinanteAdm;
	}

	public GraficoDoctosAssinante getGraficoDoctosAssinante() {
		return graficoDoctosAssinante;
	}

	public void setGraficoDoctosAssinante(
			GraficoDoctosAssinante graficoDoctosAssinante) {
		this.graficoDoctosAssinante = graficoDoctosAssinante;
	}

	public void pdf() throws JRException, IOException {  
       
    	final File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/grafico-doctos-assinantes.jasper")); 
    	Map<String, Object> parametros = new HashMap<String, Object>();
    	parametros.put("total",Integer.valueOf(graficosDoctosAssinante.size()));
    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(graficosDoctosAssinante)); 
    	final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
    	response.addHeader("Content-disposition", "attachment; filename=Grafico-Manipulacao-DoctosXAssinantes.pdf"); 
    	final ServletOutputStream stream = response.getOutputStream(); 
    	JasperExportManager.exportReportToPdfStream(jasperPrint, stream); 
    	stream.flush(); 
    	stream.close(); 
    	FacesContext.getCurrentInstance().responseComplete();	    	
   }}
