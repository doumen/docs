package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Contabilidade implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String municipio;
	private SiglaEstado uf;
	private String endereco;
	private String enderecoNumero;
	private String enderecoComplemento;
	private String bairro;
	private int cep;
	private double comissao;
	private Calendar dataInclusao;
	private TipoInclusao tipoInclusao;
	private String inscricaoEstadual;
	private Usuario usuario;
	private List<Usuario> usuarios;

	public Contabilidade(String cnpj, String razaoSocial) {
		this.setCnpj(cnpj);
		this.setRazaoSocial(razaoSocial);
	}

	public Contabilidade() {
		this.usuario = new Usuario();
		this.usuarios = new ArrayList<>();
		this.dataInclusao = Calendar.getInstance();
	}

	public String getCnpj() {
		return cnpj == null ? "" : cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String toString() {
		return razaoSocial;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
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

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getTipoInclusao() {
		return Util.getLabelTipoInclusao(tipoInclusao);
	}

	public void setTipoInclusao(TipoInclusao tipoInclusao) {
		this.tipoInclusao = tipoInclusao;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void addUsuario(Usuario u) {
		usuarios.add(u);
	}

	public void removeUsuario(Usuario u) {
		usuarios.remove(u);
	}
	
	public List<SiglaEstado> getEstados() {
		return Arrays.asList(SiglaEstado.values());
	}

	public void setEstados(List<SiglaEstado> estados) {
	}

	public SiglaEstado getUf() {
		return uf;
	}

	public void setUf(SiglaEstado uf) {
		this.uf = uf;
	}
	
	public Date getDataInclusaoTela(){
		return getDataInclusao()==null?null:getDataInclusao().getTime();
	}
	
	public void setDataInclusaoTela(Date d){
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		setDataInclusao(c);
	}
	
	public Contabilidade(Long id, String razaoSocial){
		this.id = id;
		this.razaoSocial = razaoSocial;
	}
	
	public String getCodigo(){
		return id==null?null:id.toString();
	}

	public String getCnpjFormatado() {
		return Util.formatCnpj(cnpj);
	}
	
	}
