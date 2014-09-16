package managedBeans;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.UploadedFile;

@ManagedBean
public class AssinantesManagedBean {
	private String cnpj;
	private String inscEstadual;
	private String razaoSocial;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String uf;
	private String cep;
	private String usuario;
	private String senha;
	private String codPlano;
	private String descrPlano;
	private double valorMensal;
	private String codCont;
	private String contCnpj;
	private String contRazaoSocial;
	private UploadedFile file;
	private boolean notificarCert;
	private String emailMaster;
	private String emailFinanceiro;
	private String descricao;
	private double valorNfeAdicional;
	private int faixaInicial;
	private int faixaFinal;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCodPlano() {
		return codPlano;
	}

	public void setCodPlano(String codPlano) {
		this.codPlano = codPlano;
	}

	public String getDescrPlano() {
		return descrPlano;
	}

	public void setDescrPlano(String descrPlano) {
		this.descrPlano = descrPlano;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}

	public String getCodCont() {
		return codCont;
	}

	public void setCodCont(String codCont) {
		this.codCont = codCont;
	}

	public String getContCnpj() {
		return contCnpj;
	}

	public void setContCnpj(String contCnpj) {
		this.contCnpj = contCnpj;
	}

	public String getContRazaoSocial() {
		return contRazaoSocial;
	}

	public void setContRazaoSocial(String contRazaoSocial) {
		this.contRazaoSocial = contRazaoSocial;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public boolean isNotificarCert() {
		return notificarCert;
	}

	public void setNotificarCert(boolean notificarCert) {
		this.notificarCert = notificarCert;
	}

	public String getEmailMaster() {
		return emailMaster;
	}

	public void setEmailMaster(String emailMaster) {
		this.emailMaster = emailMaster;
	}

	public String getEmailFinanceiro() {
		return emailFinanceiro;
	}

	public void setEmailFinanceiro(String emailFinanceiro) {
		this.emailFinanceiro = emailFinanceiro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValorNfeAdicional() {
		return valorNfeAdicional;
	}

	public void setValorNfeAdicional(double valorNfeAdicional) {
		this.valorNfeAdicional = valorNfeAdicional;
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
}
