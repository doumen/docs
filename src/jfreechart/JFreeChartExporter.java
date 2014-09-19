package jfreechart;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.ejb.Stateless;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

@Stateless
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

		return barChartObject;
	}
}
