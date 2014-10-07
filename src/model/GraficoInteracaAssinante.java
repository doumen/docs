package model;

import java.awt.image.BufferedImage;

import org.jfree.chart.JFreeChart;

public class GraficoInteracaAssinante {
private JFreeChart grafico;


public BufferedImage getGraficoPizza() {
	return grafico.createBufferedImage(802,425);
}

public void setGrafico(JFreeChart grafico) {
	this.grafico = grafico;
}

public String getConsumoRestante() {
	return "Este texto deveria aparecer!!";
}

}
