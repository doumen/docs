package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ConfiguracoesManagedBeans {
	private boolean downBaixarArqXml;
	private boolean downBaixarArqPdf;
	private boolean downBaixarArqTxt;
	private boolean downCompactarArqZip;

	private String receberProvedor;
	private String receberPorta;
	private String receberEncriptacao;
	private boolean receberAutenticacao;
	private String receberEmail;
	private String receberSenha;

	private String enviarProvedor;
	private String enviarPorta;
	private String enviarEncriptacao;
	private boolean enviarAutenticacao;
	private String enviarEmailOrigem;
	private String enviarSenha;
	private String enviarEmailDestino;
	private boolean enviarArqXml;
	private boolean enviarArqXls;
	private boolean enviarArqPdf;
	private boolean enviarArqTxt;
	private boolean enviarArqCompactado;
	
	private boolean downExportArqXls;
	private boolean downExportArqPdf;
	private boolean downExportArqZip;

	public boolean isDownBaixarArqTxt() {
		return downBaixarArqTxt;
	}

	public void setDownBaixarArqTxt(boolean downBaixarArquTxt) {
		this.downBaixarArqTxt = downBaixarArquTxt;
	}

	public boolean isDownCompactarArqZip() {
		return downCompactarArqZip;
	}

	public void setDownCompactarArqZip(boolean downCompactarArqZip) {
		this.downCompactarArqZip = downCompactarArqZip;
	}

	public String getReceberProvedor() {
		return receberProvedor;
	}

	public void setReceberProvedor(String receberProvedor) {
		this.receberProvedor = receberProvedor;
	}

	public String getReceberPorta() {
		return receberPorta;
	}

	public void setReceberPorta(String receberPorta) {
		this.receberPorta = receberPorta;
	}

	public boolean isReceberAutenticacao() {
		return receberAutenticacao;
	}

	public void setReceberAutenticacao(boolean receberAutenticacao) {
		this.receberAutenticacao = receberAutenticacao;
	}

	public String getReceberEmail() {
		return receberEmail;
	}

	public void setReceberEmail(String receberEmail) {
		this.receberEmail = receberEmail;
	}

	public String getReceberSenha() {
		return receberSenha;
	}

	public void setReceberSenha(String receberSenha) {
		this.receberSenha = receberSenha;
	}

	public String getEnviarProvedor() {
		return enviarProvedor;
	}

	public void setEnviarProvedor(String enviarProvedor) {
		this.enviarProvedor = enviarProvedor;
	}

	public String getEnviarPorta() {
		return enviarPorta;
	}

	public void setEnviarPorta(String enviarPorta) {
		this.enviarPorta = enviarPorta;
	}

	public boolean isEnviarAutenticacao() {
		return enviarAutenticacao;
	}

	public void setEnviarAutenticacao(boolean enviarAutenticao) {
		this.enviarAutenticacao = enviarAutenticao;
	}

	public String getEnviarEmailOrigem() {
		return enviarEmailOrigem;
	}

	public void setEnviarEmailOrigem(String enviarEmailOrigem) {
		this.enviarEmailOrigem = enviarEmailOrigem;
	}

	public String getEnviarSenha() {
		return enviarSenha;
	}

	public void setEnviarSenha(String enviarSenhar) {
		this.enviarSenha = enviarSenhar;
	}

	public String getEnviarEmailDestino() {
		return enviarEmailDestino;
	}

	public void setEnviarEmailDestino(String enviarEmailDestino) {
		this.enviarEmailDestino = enviarEmailDestino;
	}

	public boolean isEnviarArqTxt() {
		return enviarArqTxt;
	}

	public void setEnviarArqTxt(boolean enviarArqTxt) {
		this.enviarArqTxt = enviarArqTxt;
	}

	public boolean isEnviarArqCompactado() {
		return enviarArqCompactado;
	}

	public void setEnviarArqCompactado(boolean enviarArqCompactado) {
		this.enviarArqCompactado = enviarArqCompactado;
	}

	public String getReceberEncriptacao() {
		return receberEncriptacao;
	}

	public void setReceberEncriptacao(String receberEncriptacao) {
		this.receberEncriptacao = receberEncriptacao;
	}

	public String getEnviarEncriptacao() {
		return enviarEncriptacao;
	}

	public void setEnviarEncriptacao(String enviarEncriptacao) {
		this.enviarEncriptacao = enviarEncriptacao;
	}

	public boolean isDownBaixarArqXml() {
		return downBaixarArqXml;
	}

	public void setDownBaixarArqXml(boolean downBaixarArqXml) {
		this.downBaixarArqXml = downBaixarArqXml;
	}

	public boolean isDownBaixarArqPdf() {
		return downBaixarArqPdf;
	}

	public void setDownBaixarArqPdf(boolean downBaixarArqPdf) {
		this.downBaixarArqPdf = downBaixarArqPdf;
	}

	public boolean isEnviarArqXml() {
		return enviarArqXml;
	}

	public void setEnviarArqXml(boolean enviarArqXml) {
		this.enviarArqXml = enviarArqXml;
	}

	public boolean isEnviarArqPdf() {
		return enviarArqPdf;
	}

	public void setEnviarArqPdf(boolean enviarArqPdf) {
		this.enviarArqPdf = enviarArqPdf;
	}

	public boolean isDownExportArqXls() {
		return downExportArqXls;
	}

	public void setDownExportArqXls(boolean downExportArqXls) {
		this.downExportArqXls = downExportArqXls;
	}

	public boolean isDownExportArqPdf() {
		return downExportArqPdf;
	}

	public void setDownExportArqPdf(boolean downExportArqPdf) {
		this.downExportArqPdf = downExportArqPdf;
	}

	public boolean isDownExportArqZip() {
		return downExportArqZip;
	}

	public void setDownExportArqZip(boolean downExportArqZip) {
		this.downExportArqZip = downExportArqZip;
	}

	public boolean isEnviarArqXls() {
		return enviarArqXls;
	}

	public void setEnviarArqXls(boolean enviarArqXls) {
		this.enviarArqXls = enviarArqXls;
	}
}
