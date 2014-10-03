package jfreechart;

import java.awt.Font;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

public class JFreeChartExporter {
	

	public <T> JFreeChart createBarChart(List<T> totalBarras,
			Method getLabelMethod, Method getDataMethod,String dataTitle,String labelTitle,String chartTitle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		DefaultCategoryDataset my_bar_chart_dataset = new DefaultCategoryDataset();
		for(T t:totalBarras){
			String label = (String) getLabelMethod.invoke(t);
			Number data = (Number) getDataMethod.invoke(t);
			my_bar_chart_dataset.addValue(data.doubleValue(), dataTitle,label);			
		}
		
		JFreeChart barChartObject = ChartFactory.createBarChart(
				chartTitle, labelTitle, dataTitle, my_bar_chart_dataset,
				PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = (CategoryPlot) barChartObject.getPlot();
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
		
//		domainAxis.setTickLabelFont(new Font(Font.SANS_SERIF,Font.PLAIN,calculaFont(domainAxis.getFixedDimension()/totalBarras.size())));
		
		return barChartObject;
	}

	public int calculaFont(Number barWidth) {
		return Math.min(16, barWidth.intValue() / 2);
	}

	public JFreeChart createLineChart(Map<Object, Number> data,String chartTitle,String dataLabel,String xLabel,String yLabel) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Set<Object> keys = data.keySet();		
		for(Object o:keys){
//			Calendar c = (Calendar) o;			
			dataset.addValue(data.get(o).doubleValue(), dataLabel, o.toString());
		}
		JFreeChart chart = ChartFactory.createLineChart(chartTitle, xLabel, null, dataset, PlotOrientation.VERTICAL, true, false, false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		TextTitle tx = new TextTitle(chartTitle, new Font("Dialog", Font.BOLD, 18));
		chart.setTitle(tx);
		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);							
		Font font = new Font("Dialog", Font.PLAIN, 9);
		domainAxis.setTickLabelFont(font);
		return 	chart;
	}

	public JFreeChart createPieChart(PieDataset pieDataset,String chartTitle) {
	    JFreeChart chart = ChartFactory.createPieChart3D(chartTitle,          // chart title
	    		pieDataset,                // data
	            true,                   // include legend
	            true,
	            false);
	    
		TextTitle tx = new TextTitle(chartTitle, new Font("Dialog", Font.BOLD, 18));
		chart.setTitle(tx);

	        PiePlot3D plot = (PiePlot3D) chart.getPlot();
	        plot.setStartAngle(290);
	        plot.setDirection(Rotation.CLOCKWISE);
	        plot.setForegroundAlpha(0.5f);
	        plot.setLabelFont(new Font("Dialog", Font.PLAIN, 9));
	        return chart;
	}
}
