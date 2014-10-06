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
		return getMaiorNumber(list);
	}
	
	public static Number getMaiorNumber(List<Number> dados){
		Collections.sort(dados, new Comparator<Number>() {
	        @Override
	        public int compare(Number o1, Number o2) {
	            Double d1 = o1.doubleValue();
	            Double d2 = o2.doubleValue();
	            return d1.compareTo(d2);

	        }
	    });		
		return dados.get(dados.size()-1);		
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
		if(TipoInclusao.MODULO_ADMINISTRATIVO.equals(inclusao)) {		
			return "Módulo Administrativo";
		}	
		else if(TipoInclusao.MODULO_CONTABILIDADE.equals(inclusao)){			
			return "Módulo Contabilidade";
		}
		else{
			return "";
		}
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
		if (cnpj != null)
			return cnpj.substring(0, 2) + "." + cnpj.substring(2, 5) + "." + cnpj.substring(5, 8) + "/" + cnpj.substring(8, 12) + "-" + cnpj.substring(12, 14);
		else
			return cnpj;
	}
	
	public static String getMascaraCnpj(SiglaEstado uf){
		if (uf != null) {
			switch (uf) {
			case AC:
				return "99.999.999/999-99";
			case AL:
				return "999999999";
			case AP:
				return "999999999";
			case AM:
				return "99.999.999-9";
			case BA:
				return "999.999.99-9";
			case CE:
				return"99999999-9";
			case DF:
				return "99999999999-99";
			case ES:
				return "999.999.99-9";
			case GO:
				return "99.999.999-9";
			case MA:
				return "999999999";
			case MT:
				return "999999999";
			case MS:
				return "999999999";
			case MG:
				return "999.999.999/9999";
			case PA:
				return "99-999999-9";
			case PB:
				return "99999999-9";
			case PR:
				return "99999999-99";
			case PE:
				return"99.9.999.9999999-9";
			case PI:
				return "999999999";
			case RJ:
				return"99.999.99-9";
			case RN:
				return "99.999.999-9";
			case RS:
				return "999-9999999";
			case RO:
				return "999.99999-9";
			case RR:
				return "99999999-9";
			case SC:
				return "999.999.999";
			case SP:
				return "999.999.999.999";
			case SE:
				return "999999999-9";
			default:
				break;
			}
		}
		
		return "";
	}

	public static String formatCurrency(double valor) {
		return "R$ " + String.format("%.2f", valor);
	}
}
