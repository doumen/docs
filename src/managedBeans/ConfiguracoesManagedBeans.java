package managedBeans;



public class ConfiguracoesManagedBeans {
	private boolean downBaixarArqXml;
	private boolean downBaixarArqPdf;
	private boolean downBaixarArqTxt;
	private boolean downCompactarArqZip;

	private String receberProvedor;
	private String receberPorta;
	
	private String receberEncriptacao;
	private boolean receberEmailSemEncriptacao;
	private boolean receberEmailComEncriptacaoSSL;
	private boolean receberEmailComEncriptacaoTSL;
	
	private boolean receberAutenticacao;
	private String receberEmail;
	private String receberSenha;

	private String enviarProvedor;
	private String enviarPorta;
	
	private String enviarEncriptacao;
	private boolean enviarEmailSemEncriptacao;
	private boolean enviarEmailComEncriptacaoSSL;
	
	
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
		if("receberEmailSemEncriptacao".equals(receberEncriptacao)){
			setReceberEmailSemEncriptacao(true);
			setReceberEmailComEncriptacaoSSL(false);
			setReceberEmailComEncriptacaoTSL(false);
			
		}else if("receberEmailComEncriptacaoSSL".equals(receberEncriptacao)){
			setReceberEmailSemEncriptacao(false);
			setReceberEmailComEncriptacaoSSL(true);
			setReceberEmailComEncriptacaoTSL(false);
			
		}else if("receberEmailComEncriptacaoTSL".equals(receberEncriptacao)){
			setReceberEmailSemEncriptacao(false);
			setReceberEmailComEncriptacaoSSL(false);
			setReceberEmailComEncriptacaoTSL(true);
			
		}else{
			setReceberEmailSemEncriptacao(false);
			setReceberEmailComEncriptacaoSSL(false);
			setReceberEmailComEncriptacaoTSL(false);
			this.receberEncriptacao = "receberEmailSemEncriptacao";
		}
		this.receberEncriptacao = receberEncriptacao;
	}

	public String getEnviarEncriptacao() {
		return enviarEncriptacao;
	}

	public void setEnviarEncriptacao(String enviarEncriptacao) {
		if("semEncriptacao".equals(enviarEncriptacao)){
			setEnviarEmailComEncriptacaoSSL(false);
			setEnviarEmailSemEncriptacao(true);
		}
		else if("comEncriptacaoSSL".equals(enviarEncriptacao)){
			setEnviarEmailComEncriptacaoSSL(true);
			setEnviarEmailSemEncriptacao(false);			
		}else{
			setEnviarEmailComEncriptacaoSSL(false);
			setEnviarEmailSemEncriptacao(false);			
		}
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

	public boolean isEnviarEmailSemEncriptacao() {
		return enviarEmailSemEncriptacao;
	}

	public void setEnviarEmailSemEncriptacao(boolean enviarEmailSemEncriptacao) {
		if(enviarEmailSemEncriptacao)
			this.enviarEncriptacao = "semEncriptacao";
		else
			this.enviarEncriptacao = "comEncriptacaoSSL";

		this.enviarEmailSemEncriptacao = enviarEmailSemEncriptacao;
	}

	public boolean isEnviarEmailComEncriptacaoSSL() {
		return enviarEmailComEncriptacaoSSL;
	}

	public void setEnviarEmailComEncriptacaoSSL(boolean enviarEmailComEncriptacaoSSL) {
		if(enviarEmailComEncriptacaoSSL)
			this.enviarEncriptacao = "comEncriptacaoSSL";
		else
			this.enviarEncriptacao = "semEncriptacao";
		this.enviarEmailComEncriptacaoSSL = enviarEmailComEncriptacaoSSL;
	}

	public boolean isReceberEmailSemEncriptacao() {
		return receberEmailSemEncriptacao;
	}

	public void setReceberEmailSemEncriptacao(boolean receberEmailSemEncriptacao) {
		if(receberEmailSemEncriptacao)
			this.receberEncriptacao = "receberEmailSemEncriptacao";
		this.receberEmailSemEncriptacao = receberEmailSemEncriptacao;
	}

	public boolean isReceberEmailComEncriptacaoSSL() {
		return receberEmailComEncriptacaoSSL;
	}

	public void setReceberEmailComEncriptacaoSSL(boolean receberEmailComEncriptacaoSSL) {
		if(receberEmailComEncriptacaoSSL)
			this.receberEncriptacao = "receberEmailComEncriptacaoSSL";
		this.receberEmailComEncriptacaoSSL = receberEmailComEncriptacaoSSL;
	}

	public boolean isReceberEmailComEncriptacaoTSL() {
		return receberEmailComEncriptacaoTSL;
	}

	public void setReceberEmailComEncriptacaoTSL(
			boolean receberEmailComEncriptacaoTSL) {
		if(receberEmailComEncriptacaoTSL)
			this.receberEncriptacao = "receberEmailComEncriptacaoTSL";
		this.receberEmailComEncriptacaoTSL = receberEmailComEncriptacaoTSL;
	}
}
