/*  * To change this template, choose Tools | Templates  * and open the template in the editor.  */

package jasperdynamic;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.general.DefaultPieDataset;

/** * * @author masoud */

public class Main extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** * @param args the command line arguments */

	public static void main(String[] args) {
		Main m = new Main();
		m.showReport(m.prepareDataSource());
	}

	public JRBeanCollectionDataSource prepareDataSource() {
		List<ChartBean> charts = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			JFreeChart chart = createChart("This is chart number: " + i);
			BufferedImage bi = extractImage(chart, 800, 600);
			ChartBean chartBean = new ChartBean(bi,
					"This is description for Chart: " + i);
			charts.add(chartBean);
		}

		return new JRBeanCollectionDataSource(charts);
	}

	public BufferedImage extractImage(JFreeChart chart, int width, int height) {
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		Graphics2D g2 = img.createGraphics();
		chart.draw(g2, new Rectangle2D.Double(0, 0, width, height));

		g2.dispose();
		return img;

	}

	public void showReport(JRBeanCollectionDataSource dataSource) {

		try {
			Map<String,Object> parameters = new HashMap<>();
			JasperDesign jasperDesign = JRXmlLoader.load(this.getClass()
					.getResourceAsStream("/jasperdynamic/report.jrxml"));
			JasperReport jasperReport = JasperCompileManager
					.compileReport(jasperDesign);
			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, dataSource);
			JRViewer viewer = new JRViewer(jasperPrint);
			viewer.setSize(850, 500);
			viewer.setMinimumSize(new Dimension(850, 510));
			viewer.setPreferredSize(new Dimension(850, 510));

			this.setLayout(new BorderLayout(10, 10));

			this.setSize(850, 500);

			this.getContentPane().add(viewer);
			this.setVisible(true);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private JFreeChart createChart(String chartTitle) {

		DefaultPieDataset piedataset = new DefaultPieDataset();
		piedataset.setValue("One", new Double(43.200000000000003D));
		piedataset.setValue("Two", new Double(10D));
		piedataset.setValue("Three", new Double(27.5D));
		piedataset.setValue("Four", new Double(17.5D));
		piedataset.setValue("Five", new Double(11D));
		piedataset.setValue("Six", new Double(19.399999999999999D));

		JFreeChart jfreechart = ChartFactory.createRingChart(chartTitle,
				piedataset, false, true, false);

		RingPlot ringplot = (RingPlot) jfreechart.getPlot();
		ringplot.setLabelFont(new Font("SansSerif", 0, 12));
		ringplot.setNoDataMessage("No data available");
		ringplot.setSectionDepth(0.34999999999999998D);
		ringplot.setCircular(false);
		ringplot.setLabelGap(0.02D);
		return jfreechart;
	}
}