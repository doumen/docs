package managedBeans.component;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import jfreechart.JFreeChartExporter;
import managedBeans.AbstractExporterMB;
import model.Assinante;
import model.GraficoInteracaAssinante;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.JFreeChart;
import org.omnifaces.util.Faces;

import excel.ExcelExporter;

public abstract class AbstractGraficoInteracaoAssinante<T> extends AbstractExporterMB<GraficoInteracaAssinante>{

	private List<T> barras;
	
	protected List<T> totalBarras;
	
	public abstract void loadTotalBarras();
	
	private Integer selectedZoom;
	private Map<String, Integer> selectedZooms = new HashMap<String, Integer>();

	private int maiorBarra;
	
	private int ordem;
	
	@PostConstruct
	public void init(){
		nMaxAssPp =10;
		pgAtual = 1;
		loadTotalBarras();
		if(totalBarras==null)
			throw new RuntimeException("Voce deve carregar a coleção a ser tratatado no gráfico na List<T> totalBarras pelo método loadTotalBarras"); 
		totAss = totalBarras.size();
		setTotPag(calculaTotalPaginas());
		atualizaZoom();
		initSelectZooms();
		ordeneTotalBarrasCrescenteEajusteAmaiorBarra();
		setOrdem(-1);
		popularBarras();
		jFreeChartExporter = new JFreeChartExporter();
		excelExporter = new ExcelExporter();
	}

	public abstract void ordeneTotalBarrasCrescenteEajusteAmaiorBarra();

	public abstract void ordeneTotalBarrasDeCrescenteEAjusteAmaiorBarra();
	
	public void inverteOrdem(){
		pgAtual = 1;
		setOrdem(-1*getOrdem());
		if(getOrdem()>0)
			ordeneTotalBarrasDeCrescenteEAjusteAmaiorBarra();
		else
			ordeneTotalBarrasCrescenteEajusteAmaiorBarra();

		popularBarras();
	}
	
	private void atualizaZoom(){
		zoom = Float.parseFloat(String.valueOf(nMaxAssPp))/Float.parseFloat(String.valueOf(totAss))*100;
		selectedZooms.put(getZoom()+"%", getZoom());
		pgAtual = 1;
		totPag = calculaTotalPaginas();
	}
	
	private void popularBarras(){
		barras = new ArrayList<T>();
		int k =0;
		if(pgAtual<=totPag)
			k = (pgAtual-1)*nMaxAssPp;
		for(int i = 0;i < getBarrasPorPagina();i++ ){
			barras.add(totalBarras.get(k));
			k++;
		}
	}
	
	public List<T> getBarras() {
		return barras;
	}

	public void setBarras(List<T> barras) {
		this.barras = barras;
	}
	
		protected int nMaxAssPp;
	   
	   protected int pgAtual;
	   
	   protected int totAss;
	   
	   protected int totPag;
	   
	   protected float zoom;
	   	   
	   public void irParaProximaPagina(){
	       if(pgAtual<getTotPag()){
	           pgAtual ++;
	           popularBarras();
	       }
	   }
	   
	   public void irParaPaginaAnterior(){
	       if(pgAtual>1){
	    	   pgAtual --;
	    	   popularBarras();
	       }
	   }
	      
	   private int calculaTotalPaginas(){
	       if(totAss>nMaxAssPp){
	    	   int resto = totAss%nMaxAssPp;
	    	   int aux = (totAss - resto)/nMaxAssPp;
	    	   if(resto>0)
	    		   aux = aux + 1; 
	           return  aux;
	       }
	       return 1;
	   }
	   
	   public int getBarrasPorPagina(){
	       if(pgAtual<getTotPag()){
	           if(totAss>nMaxAssPp)
	               return nMaxAssPp;
	           else{
	               return totAss;
	           }
	       }else{
	    	   int resto = totAss%nMaxAssPp;
	    	   if(resto==0)
	    		   return nMaxAssPp;
	           return resto;
	       }
	   }

	public int getTotPag() {
		return totPag;
	}

	public void setTotPag(int totPag) {
		this.totPag = totPag;
	}
	
	public int getZoom() {
		return Math.round(zoom);
	}
	
	public void setZoom(int zoom) {
		this.zoom = zoom;
	}
	
    public void diminuiZoom(){
    	if(nMaxAssPp>2){
	    	nMaxAssPp--;
	    	atualizaZoom();
	    	popularBarras();
    	}
    }
    
    public void aumentaZoom(){
    	if(nMaxAssPp<totAss){
	    	nMaxAssPp++;
	    	atualizaZoom();
	    	popularBarras();
    	}
    }
    
    public int getPaginaAtual(){
    	return pgAtual;
    }

    public void irParaUltimaPagina(){
    	this.pgAtual = getTotPag();
    	popularBarras();
    }
    
    public void irParaPrimeiraPagina(){
    	this.pgAtual = 1;
    	popularBarras();
    }
    
	public void initSelectZooms() {
		selectedZooms = new LinkedHashMap<String, Integer>();
		selectedZooms.put("10%", 10);
		selectedZooms.put("20%", 20);
		selectedZooms.put("30%", 30);
		selectedZooms.put("40%", 40);
		selectedZooms.put("50%", 50);
		selectedZooms.put("60%", 60);
		selectedZooms.put("70%", 70);
		selectedZooms.put("80%", 80);
		selectedZooms.put("90%", 90);
		selectedZooms.put("100%", 100);
	}
	
	public void zoomSelectOneMenu() {
		this.nMaxAssPp = Math.round(totAss*(zoom/100));
		atualizaZoom();
		popularBarras();
	}

	public Integer getSelectedZoom() {
		return selectedZoom;
	}

	public void setSelectedZoom(Integer selectedZoom) {
		this.selectedZoom = selectedZoom;
	}

	public Map<String, Integer> getSelectedZooms() {
		return selectedZooms;
	}

	public void setSelectedZooms(Map<String, Integer> selectedZooms) {
		this.selectedZooms = selectedZooms;
	}

	public int getMaiorBarra() {
		return maiorBarra;
	}

	public void setMaiorBarra(int maiorBarra) {
		this.maiorBarra = maiorBarra;
	}

	public int getTotalBarras(){
		return nMaxAssPp;
	}
	
	public boolean isUltimaPagina(){
		return this.pgAtual==totPag;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
	public void downloadExcel() throws IOException {
		File f = createAndPopulateCsvFile();
	    Faces.sendFile(createAndPopulateCsvFile(), true);
	    f.delete();
	}
		
	
	private String labelTitle = "Assinantes";
	private String dataTitle = "Total Doctos";
	private String sheetName = "Dados";
	private String chartTitle = "Gráfico de Interação por Assinante";
	
	private Method getLabelMethod() throws NoSuchMethodException, SecurityException{
		return Assinante.class.getMethod("getNomeFantasia");
	}	
	private Method getDataMethod() throws NoSuchMethodException, SecurityException{
		return Assinante.class.getMethod("getTotalDoctosArmazenados");
	}

	private JFreeChartExporter jFreeChartExporter;

	public File createExcelFileGraficoInteracaoAssinantes(List<T> totalBarras) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String filePath = "/home/desenv/grafico-interacao-assinante.xls";

		HSSFWorkbook workbook = excelExporter
				.createHSSFWorkbook(totalBarras, getLabelMethod(), getDataMethod(),
						labelTitle, dataTitle, sheetName);
		JFreeChart barChart = jFreeChartExporter.createBarChart(totalBarras,
				getLabelMethod(), getDataMethod(), dataTitle, labelTitle,
				chartTitle);

		excelExporter.writeJFreeChartOnHSSFWorkbook(barChart, workbook,
				sheetName, 15 * totalBarras.size(), 480, 4, 5);

		FileOutputStream out = new FileOutputStream(new File(filePath));
		workbook.write(out);
		out.close();
		return new File(filePath);
	}
	
	public BufferedImage createReportImage(List<T> totalBarras) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		return createGraficoInteracaoAssinantes(totalBarras).createBufferedImage(802, 425);
	}
	
	public JFreeChart createGraficoInteracaoAssinantes(List<T> totalBarras) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		return jFreeChartExporter.createBarChart(totalBarras,
				getLabelMethod(), getDataMethod(), dataTitle, labelTitle,
				chartTitle);
	}
	private ExcelExporter excelExporter;
	
	
	public File createAndPopulateCsvFile() {
		try {
			return createExcelFileGraficoInteracaoAssinantes(totalBarras);					 					  
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public JFreeChart createReportImage() {
		try {
			/*
			BufferedImage createReportImage = assinanteComponent.createReportImage(totalBarras);
			File f = new File("/home/desenv/createReportImage.png");
			ImageIO.write(createReportImage, "png", f);
			f.createNewFile();
			*/
			return createGraficoInteracaoAssinantes(totalBarras);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<GraficoInteracaAssinante> getReportList() {
		List<GraficoInteracaAssinante> graficoInteracaAssinante = new ArrayList<>();
		graficoInteracaAssinante.add(new GraficoInteracaAssinante());
		GraficoInteracaAssinante g = new GraficoInteracaAssinante();
		g.setGrafico(createReportImage());
		graficoInteracaAssinante.add(g);
		return graficoInteracaAssinante;
	}

	@Override
	public String getTemplateReport() {
		return "template_landscape";
	}

	@Override
	public String getReport() {
		return "grafico-interacao-assinante";
	}

}
