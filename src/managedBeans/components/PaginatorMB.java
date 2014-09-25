package managedBeans.components;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import model.Assinante;
import model.GraficoDoctosAssinante;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.PieChartModel;

import component.AssinanteComponent;

import factory.GraficoDoctosAssinanteFactory;

@ManagedBean
@ViewScoped
public class PaginatorMB {

	private int pgAtual;
	private int totalPg;
	private Assinante a;
	private Map<Object,Number> historico;
	public void irParaUltimaPagina(){
		pgAtual = totalPg;
		carregaPagina();
	}
	
	public void irParaProximaPagina(){
		if(pgAtual<totalPg){
			pgAtual++;
			carregaPagina();
		}
	}
	
	public void irParaPrimeiraPagina(){
		pgAtual = 1;
		carregaPagina();
	}
	
	public void irParaPaginaAnterior(){
		if(pgAtual>1){
			pgAtual --;
			carregaPagina();
		}
	}
		
	public void carregaPagina(){
		a = assinantes.get(pgAtual-1);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH,0);
		setHistorico(assinanteComponent.getHistoricoConsumoTotalDoAssinante(a, c, Calendar.getInstance()));
	}
	
	private List<Assinante> assinantes;
	
	@Inject
	private AssinanteComponent assinanteComponent;
		
	@PostConstruct
	public void init(){
		assinantes = assinanteComponent.getAssinantes();
		totalPg = assinantes.size();
		pgAtual = 1;
		carregaPagina();
	}
	
	public void pdf(){
		try{
	    	final File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("resources/reports/grafico-doctos-assinantes.jasper")); 
	    	Map<String, Object> parametros = new HashMap<String, Object>();
	    	parametros.put("total",Integer.valueOf(assinantes.size()));
	    	GraficoDoctosAssinanteFactory f = new GraficoDoctosAssinanteFactory();
	    	List<GraficoDoctosAssinante> graficosDoctosAssinante = new ArrayList<>();
	    	Calendar c = Calendar.getInstance();
	    	c.set(Calendar.MONTH, 0);
	    	for(Assinante as:assinantes){
	    		graficosDoctosAssinante.add(f.createGrafico(as, assinanteComponent.getHistoricoConsumoTotalDoAssinante(as, c, Calendar.getInstance())));
	    	}
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(graficosDoctosAssinante)); 
	    	final HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(); 
	    	response.addHeader("Content-disposition", "attachment; filename=Grafico-Manipulacao-DoctosXAssinantes.pdf"); 
	    	final ServletOutputStream stream = response.getOutputStream(); 
	    	JasperExportManager.exportReportToPdfStream(jasperPrint, stream); 
	    	stream.flush(); 
	    	stream.close(); 
	    	FacesContext.getCurrentInstance().responseComplete();	    		
		}catch(Exception e){
			
		}
	}
	
	public void excel(){
		
	}
	
	public String getAssinante(){
		return a.getCnpj() + " - " + a.getNomeFantasia();
	}
	
	public String getContador(){
		return a.getCnpj() + " - " + a.getContabilidade().getNomeFantasia();		
	}
	
	public String getPlanoContratado(){
		return a.getPlano().getId()+" - Plano " + a.getPlano().getFaixaInicial() + " à " + a.getPlano().getFaixaFinal() + " - R$ " + a.getPlano().getValorMensal(); 
	}
	
	public String getConsumoRestante(){
		return a.getPlano().getFaixaFinal()+" Doctos";
	}
	
	public PieChartModel getPieChartModel(){
		PieChartModel pieChartModel = new PieChartModel();
		pieChartModel = new PieChartModel();

		pieChartModel.set("NF-e", a.getTotalNfe());
		pieChartModel.set("CT-e", a.getTotalCte());
		pieChartModel.set("SPED Fiscal", a.getTotalSpedFiscal());
		pieChartModel.set("SPED Contribuições", a.getTotalSpedContribuicoes());
		pieChartModel.set("SPED Social", a.getTotalSpedSocial());

		pieChartModel.setTitle("Consumo de Recurso Contratado");
		pieChartModel.setLegendPosition("e");
		pieChartModel.setShowDataLabels(true);
		return pieChartModel;
	}
	
	public CartesianChartModel getLineChartModel() {
		CartesianChartModel model =new CartesianChartModel();
        ChartSeries cs = new ChartSeries();
        cs.setLabel("Consumo");
        
        for(Object o:historico.keySet()){
        	cs.set(o,historico.get(o));
        }
		model.addSeries(cs);
		return model;
	}

	public int getPaginaAtual(){
		return pgAtual;
	}
	
	public int getTotPag(){
		return totalPg;
	}

	public Map<Object,Number> getHistorico() {
		return historico;
	}

	public void setHistorico(Map<Object,Number> historico) {
		this.historico = historico;
	}
}

