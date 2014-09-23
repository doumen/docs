package jfreechart;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

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

	public BufferedImage createLineChart(Map<Object, Number> data,String chartTitle,String dataLabel,String xLabel,String yLabel,int width,int height) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		Set<Object> keys = data.keySet();		
		for(Object o:keys){
			Calendar c = (Calendar) o;			
			dataset.addValue(data.get(o).doubleValue(), chartTitle, c);
		}
		BufferedImage image = new BufferedImage(422, 230, BufferedImage.TYPE_INT_RGB);
		return image;
	}

	public BufferedImage createPieChart(PieDataset pieDataset,String chartTitle, int width, int height) {
		BufferedImage image = new BufferedImage(422, 230, BufferedImage.TYPE_INT_RGB);
		
		try {
			  
            image = ImageIO.read(new File("/home/desenv/mac.jpg"));
 
        } catch (IOException e) {
        	e.printStackTrace();
        }
		
		return image;
	}
}
