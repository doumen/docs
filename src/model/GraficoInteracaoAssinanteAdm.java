package model;

import java.util.Date;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

public class GraficoInteracaoAssinanteAdm {
	private BarChartModel barChartModel;
	private Assinante assinante;

	public BarChartModel getBarChartModel() {
		return barChartModel;
	}

	public void setBarChartModel(BarChartModel barChartModel) {
		this.barChartModel = barChartModel;
	}

	public Assinante getAssinante() {
		return assinante;
	}

	public void setAssinante(Assinante assinante) {
		this.assinante = assinante;
	}
	
	public void createBarModel() {
		barChartModel = initBarModel();
         
		barChartModel.setTitle("Gráfico - Interação X Assinantes que menos Interagiram com o Sistema");
		barChartModel.setLegendPosition("ne");
         
        //Axis xAxis = barChartModel.getAxis(AxisType.X);
        //xAxis.setLabel("Gender");
         
        Axis yAxis = barChartModel.getAxis(AxisType.Y);
        //yAxis.setLabel("Births");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }
	
	private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
 
        ChartSeries assinante1 = new ChartSeries();
        assinante1.setLabel("Assinante 1");
        assinante1.set(new Date(), 50);
        
        ChartSeries assinante2 = new ChartSeries();
        assinante2.setLabel("Assinate 2");
        assinante2.set(new Date(), 52);
        
        ChartSeries assinante3 = new ChartSeries();
        assinante3.setLabel("Assinante 3");
        assinante3.set(new Date(), 25);
        
        ChartSeries assinante4 = new ChartSeries();
        assinante4.setLabel("Assinante 4");
        assinante4.set(new Date(), 10);
        
        model.addSeries(assinante1);
        model.addSeries(assinante2);
        model.addSeries(assinante3);
        model.addSeries(assinante4);
         
        return model;
    }
}
