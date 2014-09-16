package model;

import java.util.Date;

public class Plano {

	private Long id;
	private String descricao;
	private int faixaInicial;
	private int faixaFinal;
	private double valorMensal;
	private double valorNfeAdicional;
	private Date dataInclusao;
	private String tipoInclusao;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFaixaInicial() {
		return faixaInicial;
	}

	public void setFaixaInicial(int faixaInicial) {
		this.faixaInicial = faixaInicial;
	}

	public int getFaixaFinal() {
		return faixaFinal;
	}

	public void setFaixaFinal(int faixaFinal) {
		this.faixaFinal = faixaFinal;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public double getValorNfeAdicional() {
		return valorNfeAdicional;
	}

	public void setValorNfeAdicional(double valorNfeAdicional) {
		this.valorNfeAdicional = valorNfeAdicional;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public String getTipoInclusao() {
		return tipoInclusao;
	}

	public void setTipoInclusao(String tipoInclusao) {
		this.tipoInclusao = tipoInclusao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
	public void setDataInclusao(Date dataInclusao){
		this.dataInclusao = dataInclusao;
	}
}