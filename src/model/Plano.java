package model;

import java.util.Calendar;
import java.util.Date;

public class Plano {

	private Long id;
	private String descricao;
	private int faixaInicial;
	private int faixaFinal;
	private double valorMensal;
	private double valorNfeAdicional;
	private Calendar dataInclusao;
	private TipoInclusao tipoInclusao;

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

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public String getTipoInclusao() {
		return Util.getLabelTipoInclusao(tipoInclusao);
	}

	public void setTipoInclusao(TipoInclusao tipoInclusao) {
		this.tipoInclusao = tipoInclusao;
	}

	@Override
	public String toString() {
		return descricao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataInclusaoTela() {
		return getDataInclusao() == null ? null : getDataInclusao().getTime();
	}

	public void setDataInclusaoTela(Date d) {
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		setDataInclusao(c);
	}

	public Plano() {
		this.dataInclusao = Calendar.getInstance();
	}

	public Plano(Long id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
}