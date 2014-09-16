package managedBeans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class CadastrarAssinanteManagedBean {
	private String cnpj;
	private String inscrEstadual;
	private String nomeFantasia;
	private String razaoSocial;
	private String endereco;
	private int numero;
	private String complemento;
	private String bairro;
	private String municipio;
	private String uf;
	private String cep;
	private String usuarioMaster;
	private String senha;
	private String planoAssinatura;
	private String contabilidade;

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscrEstadual() {
		return inscrEstadual;
	}

	public void setInscrEstadual(String inscrEstadual) {
		this.inscrEstadual = inscrEstadual;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
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

	public String getUsuarioMaster() {
		return usuarioMaster;
	}

	public void setUsuarioMaster(String usuarioMaster) {
		this.usuarioMaster = usuarioMaster;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPlanoAssinatura() {
		return planoAssinatura;
	}

	public void setPlanoAssinatura(String planoAssinatura) {
		this.planoAssinatura = planoAssinatura;
	}

	public String getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(String contabilidade) {
		this.contabilidade = contabilidade;
	}

	public void contratar() {

	}

	public void voltar() {

	}
}
