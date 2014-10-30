package model;

import entity.Assinante;
import entity.Plano;

public class AssinanteReport {
	private int dia;
	private int mes;
	private int ano;
	private Long totalDoctos;
	private entity.Assinante assinante;
	private Plano plano;
	
	public AssinanteReport(int dia, int mes, int ano, Long totalDoctos,
			Assinante assinante) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.totalDoctos = totalDoctos;
		this.setAssinante(assinante);
	}

	public AssinanteReport(int dia, int mes, int ano, Long totalDoctos,
			Plano plano) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.totalDoctos = totalDoctos;
		this.setPlano(plano);
	}
	
	public AssinanteReport(int dia, int mes, int ano, Long totalDoctos) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		this.totalDoctos = totalDoctos;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Long getTotalDoctos() {
		return totalDoctos;
	}

	public void setTotalDoctos(Long totalDoctos) {
		this.totalDoctos = totalDoctos;
	}

	public entity.Assinante getAssinante() {
		return assinante;
	}

	public void setAssinante(entity.Assinante assinante) {
		this.assinante = assinante;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
}
