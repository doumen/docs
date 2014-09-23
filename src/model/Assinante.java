package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class Assinante implements Comparable<Assinante> {

	private Long id;
	private String cnpj;
	
	private String inscricaoEstadual;
	private String nomeFantasia;
	private String razaoSocial;
	private String endereco;
	private String enderecoNumero;
	private String enderecoComplemento;
	private String bairro;
	private String municipio;
	private SiglaEstado uf;
	private int cep;
	private String emailMaster;
	private String emailFinanceiro;
	private Calendar dataInclusao;
	private Plano plano;
	private Contabilidade contabilidade;
	private List<Usuario> usuarios;
	private CertificadoA1 certificadoA1;
	private Usuario usuario;
	private int totalDoctosArmazenados;
	private int interacao;
	private String tipoInclusao;
	private List<NFe> nfes;
	private List<CTe> ctes;
	private List<SpedFiscal> spedsFiscais;
	private List<SpedSocial> spedsSociais;
	private List<SpedContribuicoes> spedsContribuicoes;
	
	public Long getId() {
		return id;
	}

	public List<NFe> getNfes() {
		return nfes;
	}

	public void setNfes(List<NFe> nfes) {
		this.nfes = nfes;
	}

	public List<CTe> getCtes() {
		return ctes;
	}

	public void setCtes(List<CTe> ctes) {
		this.ctes = ctes;
	}

	public List<SpedFiscal> getSpedsFiscais() {
		return spedsFiscais;
	}

	public void setSpedsFiscais(List<SpedFiscal> spedsFiscais) {
		this.spedsFiscais = spedsFiscais;
	}

	public List<SpedSocial> getSpedsSociais() {
		return spedsSociais;
	}

	public void setSpedsSociais(List<SpedSocial> spedsSociais) {
		this.spedsSociais = spedsSociais;
	}

	public List<SpedContribuicoes> getSpedsContribuicoes() {
		return spedsContribuicoes;
	}

	public void setSpedsContribuicoes(List<SpedContribuicoes> spedsContribuicoes) {
		this.spedsContribuicoes = spedsContribuicoes;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
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

	public String getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
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

	public SiglaEstado getUf() {
		return uf;
	}

	public void setUf(SiglaEstado uf) {
		this.uf = uf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
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

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

	public Assinante() {
		this.plano = new Plano();
		this.usuario = new Usuario();
		this.certificadoA1 = new CertificadoA1();
		this.contabilidade = new Contabilidade();
		this.usuarios = new ArrayList<>();
		this.nfes = new ArrayList<NFe>();
		this.ctes = new ArrayList<CTe>();
		this.spedsFiscais = new ArrayList<SpedFiscal>();
		this.spedsSociais = new ArrayList<SpedSocial>();
		this.spedsContribuicoes = new ArrayList<SpedContribuicoes>();
	}

	public Assinante(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public String getNomeFantasia() {
		return nomeFantasia == null ? "" : nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	@Override
	public String toString() {
		return nomeFantasia;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Assinante))
			return false;
		Assinante a = (Assinante) obj;
		return getNomeFantasia().equals(a.getNomeFantasia());
	}

	@Override
	public int hashCode() {
		int i = 17;
		i = 31 * i + nomeFantasia.hashCode();
		return i;
	}

	public CertificadoA1 getCertificadoA1() {
		return certificadoA1;
	}

	public void setCertificadoA1(CertificadoA1 certificadoA1) {
		this.certificadoA1 = certificadoA1;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public double getComissaoMensal() {
		return getContabilidade().getComissao() * getPlano().getValorMensal();
	}

	@Override
	public int compareTo(Assinante o) {
		// TODO Auto-generated method stub
		// Ordenar pela interação
		return 0;
	}

	public int getTotalDoctosArmazenados() {
		return totalDoctosArmazenados;
	}

	public void setTotalDoctosArmazenados(int totalDoctosArmazenados) {
		this.totalDoctosArmazenados = totalDoctosArmazenados;
	}

	public int getInteracao() {
		return interacao;
	}

	public void setInteracao(int interacao) {
		this.interacao = interacao;
	}

	public String getTipoInclusao() {
		return tipoInclusao;
	}

	public void setTipoInclusao(String tipoInclusao) {
		this.tipoInclusao = tipoInclusao;
	}
	public List<SiglaEstado> getEstados() {
		return Arrays.asList(SiglaEstado.values());
	}

	public void setEstados(List<SiglaEstado> estados) {
	}
	
	public void addUsuario(Usuario u) {
		usuarios.add(u);
	}

	public void removeUsuario(Usuario u) {
		usuarios.remove(u);
	}

}