package model;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.jfree.chart.JFreeChart;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class Util {
	
	public static String getMMYYYY(Calendar c){
	    String[] monthNames = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outobro", "Novembro", "Dezembro"};
	    return monthNames[c.get(Calendar.MONTH)] + "/" + c.get(Calendar.YEAR);
//	    return (c.get(Calendar.MONTH)+1) + "" ;//+ "/" + c.get(Calendar.YEAR);
	}
	
	public static Calendar getCalendar(int i){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MONTH, i);
		return c;
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setVisible(true);		
	}
	
	public static Number getMaiorNumber(Map<Object,Number> dados){
		List<Number> list = new ArrayList<Number>(dados.values());
		Collections.sort(list, new Comparator<Number>() {
	        @Override
	        public int compare(Number o1, Number o2) {
	            Double d1 = o1.doubleValue();
	            Double d2 = o2.doubleValue();
	            return d1.compareTo(d2);

	        }
	    });		
		return list.get(dados.size()-1);
	}
	
	public static Number getMenorNumber(Map<Object,Number> dados){
		List<Number> list = new ArrayList<Number>(dados.values());
		Collections.sort(list, new Comparator<Number>() {
	        @Override
	        public int compare(Number o1, Number o2) {
	            Double d1 = o1.doubleValue();
	            Double d2 = o2.doubleValue();
	            return d1.compareTo(d2);

	        }
	    });		
		return list.get(0);
	}
		

	public static String getLabelTipoInclusao(TipoInclusao inclusao){
		return inclusao==TipoInclusao.MODULO_ADMINISTRATIVO?"Módulo Administrativo":null;
	}
	
	public static StreamedContent convertToStreamedContent(JFreeChart chart,int width,int height) throws IOException{
		if(chart != null){
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		ImageIO.write(chart.createBufferedImage(width, height), "jpeg", os);
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		return new DefaultStreamedContent(is, "image/jpeg");
		}else
			return new DefaultStreamedContent();
	}
	
	public static String formatCnpj(String cnpj){
		return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
	}
}
