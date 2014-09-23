package component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import jfreechart.JFreeChartExporter;
import model.Assinante;
import model.Contabilidade;
import model.Plano;
import model.Usuario;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.JFreeChart;

import excel.ExcelExporter;

@Stateless
public class AssinanteComponent {
	
	public List<Assinante> getAssinantes() {
		ArrayList<Assinante> assinantes = new ArrayList<>();
		int j = 0;
		for (Long i = 0l; i < 100; i++) {
			Assinante a = new Assinante();
			a.setDataInclusao(Calendar.getInstance());
			a.setId(i);
			a.setCnpj("CNPJ " + i);
			a.setNomeFantasia("Nome Assinante " + i);
			a.setPlano(planos[j%4]);
			a.setTipoInclusao("Módulo Administrativo");
			Random rand = new Random();

			// nextInt is normally exclusive of the top value,
			// so add 1 to make it inclusive
			int max = a.getPlano().getFaixaFinal();
			int min = a.getPlano().getFaixaInicial();
			int randomNum = rand.nextInt((max - min) + 1) + min;
			a.setTotalDoctosArmazenados(randomNum);
			a.setContabilidade(contabilidades[j%3]);
			assinantes.add(a);
			j++;
		}
		
		return assinantes;
	}

	private ExcelExporter excelExporter;
	
	private JFreeChartExporter jFreeChartExporter;
	
	private Contabilidade[] contabilidades = new Contabilidade[3];
	private Plano[] planos = new Plano[4];
	
	public AssinanteComponent() {
		init();
	}
	
	@PostConstruct
	public void init(){
		int j=0;
		for(Long i=0l;i<3l;i++){
			contabilidades[j] = createContabilidade(i);
			j++;
		}
		j=0;
		for(Long i=0l;i<4l;i++){
			planos[j] = createPlano(i);
			j++;
		}
		jFreeChartExporter = new JFreeChartExporter();
		excelExporter = new ExcelExporter();
	}

	private Contabilidade createContabilidade(long i){
		Contabilidade c = new Contabilidade();
		c.setId(i+10);
		c.setCnpj("CNPJ " + i + 10);
		c.setNomeFantasia("Contabilidade " + i);
		c.setComissao(0.1d);
		return c;
	}
	
	private Plano createPlano(long i){
		int j = Integer.valueOf(String.valueOf(i));
		Plano p = new Plano();
		p.setId(i);
		p.setDescricao("plano " + i);
		p.setValorMensal(i*1.2);
		p.setFaixaInicial(j*1000+1);
		p.setFaixaFinal((j+1)*1000);
		return p;
	}
	public List<Assinante> getAssinantes(Usuario usuario) {
		ArrayList<Assinante> assinantes = new ArrayList<>();
		if("contador".equals(usuario.getLogin())){
			assinantes.add(new Assinante("assinante 1 do contador"));
			assinantes.add(new Assinante("assinante 2 do contador"));
		}
		else if("assinante".equals(usuario.getLogin())){
			assinantes.add(new Assinante("assinante 1 do usuario assinante"));
			assinantes.add(new Assinante("assinante 2 do usuario assinante"));			
		}
		return assinantes;
	}

	public List<Assinante> getRelatorioConsumoAssinantes() {
		return getAssinantes();
	}

	public List<Assinante> getAssinantesOrdenadosPorInteracao() {
		List<Assinante> a = getAssinantes();
		Collections.sort(a);
		return a;
	}

	public List<Assinante> getRelatorioContratacaoConsumo() {
		List<Assinante> as = getAssinantes();
		return as;
	}
	
	public File createExcelFileGraficoInteracaoAssinantes(List<Assinante> totalBarras) throws IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String filePath = "/home/desenv/grafico-interacao-assinante.xls";
		String labelTitle = "Assinantes";
		String dataTitle = "Total Doctos";
		String sheetName = "Dados";
		String chartTitle = "Gráfico de Interação por Assinante";
		Method getLabelMethod = Assinante.class.getMethod("getNomeFantasia");
		Method getDataMethod = Assinante.class.getMethod("getTotalDoctosArmazenados");
		
		HSSFWorkbook workbook = excelExporter.createHSSFWorkbook(totalBarras,getLabelMethod,getDataMethod,labelTitle,dataTitle,sheetName);
		JFreeChart barChart = jFreeChartExporter.createBarChart(totalBarras,getLabelMethod,getDataMethod, dataTitle, labelTitle, chartTitle);
		
		excelExporter.writeJFreeChartOnHSSFWorkbook(barChart, workbook, sheetName, 15*totalBarras.size(), 480, 4, 5);
		
		FileOutputStream out = new FileOutputStream(new File(filePath));
		workbook.write(out);
		out.close();
		return null;
	}

	public Map<Object, Number> getHistoricoConsumoTotalDoAssinante(
			Assinante a, Calendar inicio, Calendar fim) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
