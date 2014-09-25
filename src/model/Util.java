package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

public class Util {
	
	public static String getMMYYYY(Calendar c){
	    String[] monthNames = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outobro", "Novembro", "Dezembro"};
	    return monthNames[c.get(Calendar.MONTH)] + "/" + c.get(Calendar.YEAR);
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
}
