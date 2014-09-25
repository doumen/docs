package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import org.jfree.chart.JFreeChart;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

public class GraficoDoctosAssinante implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String assinante;	
	private String contador;	
	private JFreeChart graficoPizza;	
	private JFreeChart graficoLinha;
	private String planoContratado;
	private String consumoRestante;
			
	public String getAssinante() {
		return assinante;
	}

	public void setAssinante(String assinante) {
		this.assinante = assinante;
	}

	public BufferedImage getGraficoPizza() {
		return graficoPizza.createBufferedImage(422,230);
	}

	public void setGraficoPizza(JFreeChart graficoPizza) {
		this.graficoPizza = graficoPizza;
	}

	public BufferedImage getGraficoLinha() {
		return graficoLinha.createBufferedImage(322,230);
	}

	public void setGraficoLinha(JFreeChart graficoLinha) {
		this.graficoLinha = graficoLinha;
	}

	public String getPlanoContratado() {
		return planoContratado;
	}

	public void setPlanoContratado(String planoContratado) {
		this.planoContratado = planoContratado;
	}

	public String getConsumoRestante() {
		return consumoRestante;
	}

	public void setConsumoRestante(String consumoRestante) {
		this.consumoRestante = consumoRestante;
	}

	public String getContador() {
		return contador;
	}

	public void setContador(String contador) {
		this.contador = contador;
	}

	public StreamedContent getLineChart(){
		try {
			return Util.convertToStreamedContent(graficoLinha,500,400);
		} catch (IOException e) {
			e.printStackTrace();
			return new  DefaultStreamedContent();
		}
	}

	public StreamedContent getPieChart(){
		try {
			return Util.convertToStreamedContent(graficoPizza,500,400);
		} catch (IOException e) {
			e.printStackTrace();
			return new  DefaultStreamedContent();
		}
	}

}
