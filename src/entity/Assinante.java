/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import model.SiglaEstado;
import model.TipoInclusao;
import model.Util;
import converter.ConvertByField;
import dao.RemoveMask;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbAssinantes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assinante.findAll", query = "SELECT a FROM Assinante a"),
    @NamedQuery(name = "Assinante.findById", query = "SELECT a FROM Assinante a WHERE a.id = :id"),
    @NamedQuery(name = "Assinante.findByCnpj", query = "SELECT a FROM Assinante a WHERE a.cnpj = :cnpj"),
    @NamedQuery(name = "Assinante.findByInscricaoEstadual", query = "SELECT a FROM Assinante a WHERE a.inscricaoEstadual = :inscricaoEstadual"),
    @NamedQuery(name = "Assinante.findByNomeFantasia", query = "SELECT a FROM Assinante a WHERE a.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Assinante.findByRazaoSocial", query = "SELECT a FROM Assinante a WHERE a.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Assinante.findByEndereco", query = "SELECT a FROM Assinante a WHERE a.endereco = :endereco"),
    @NamedQuery(name = "Assinante.findByEnderecoNumero", query = "SELECT a FROM Assinante a WHERE a.enderecoNumero = :enderecoNumero"),
    @NamedQuery(name = "Assinante.findByEnderecoComplemento", query = "SELECT a FROM Assinante a WHERE a.enderecoComplemento = :enderecoComplemento"),
    @NamedQuery(name = "Assinante.findByBairro", query = "SELECT a FROM Assinante a WHERE a.bairro = :bairro"),
    @NamedQuery(name = "Assinante.findByMunicipio", query = "SELECT a FROM Assinante a WHERE a.municipio = :municipio"),
    @NamedQuery(name = "Assinante.findByUf", query = "SELECT a FROM Assinante a WHERE a.uf = :uf"),
    @NamedQuery(name = "Assinante.findByCep", query = "SELECT a FROM Assinante a WHERE a.cep = :cep"),
    @NamedQuery(name = "Assinante.findByEmailMaster", query = "SELECT a FROM Assinante a WHERE a.emailMaster = :emailMaster"),
    @NamedQuery(name = "Assinante.findByEmailFinanceiro", query = "SELECT a FROM Assinante a WHERE a.emailFinanceiro = :emailFinanceiro"),
    @NamedQuery(name = "Assinante.findByDataInclusao", query = "SELECT a FROM Assinante a WHERE a.dataInclusao = :dataInclusao")})

public class Assinante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    
    @Basic(optional = false)
    @Column(name = "Cnpj")
    @RemoveMask
    private String cnpj;
    
    @RemoveMask
    @Basic(optional = false)
    @Column(name = "InscricaoEstadual")
    private String inscricaoEstadual;
    
    @Basic(optional = false)
    @Column(name = "NomeFantasia")
    @ConvertByField
    private String nomeFantasia;
    
    @Basic(optional = false)
    @Column(name = "RazaoSocial")
    private String razaoSocial;
    
    @Basic(optional = false)
    @Column(name = "Endereco")
    private String endereco;
    
    @Basic(optional = false)
    @Column(name = "EnderecoNumero")
    private String enderecoNumero;
    
    @Column(name = "EnderecoComplemento")
    private String enderecoComplemento;
    
    @Basic(optional = false)
    @Column(name = "Bairro")
    private String bairro;
    
    @Basic(optional = false)
    @Column(name = "Municipio")
    private String municipio;
    
    @Basic(optional = false)    
    @Column(name = "Uf")
    @Enumerated(EnumType.STRING)
    private SiglaEstado uf;
    
    @Basic(optional = false)
    @Column(name = "Cep")
    @RemoveMask
    private Integer cep;
    
    @Basic(optional = false)
    @Column(name = "EmailMaster")
    private String emailMaster;
    
    @Basic(optional = false)
    @Column(name = "EmailFinanceiro")
    private String emailFinanceiro;
    
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    
    @JoinTable(name = "tbAssinantes_tbUsuarios", joinColumns = {
        @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")}, inverseJoinColumns = {
        @JoinColumn(name = "tbUsuarios_Id", referencedColumnName = "Id")})
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)    
    private List<Usuario> usuarios;

    @Transient
    private SpedSocialConfiguracoes spedSocialConfiguracoes;

    @Transient
    private ProdutosConfiguracoes produtosConfiguracoes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private Set<SpedContribuicoes> spedsContribuicoes;

    @Transient
    private NFeConfiguracoes nFeConfiguracoes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private Set<SpedSocial> spedsSociais;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private Set<SpedFiscal> spedsFiscais;
    
    @Transient
    private CTeConfiguracoes cTeConfiguracoes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private Set<NFe> nFes;

    @Transient
    private SpedFiscalConfiguracoes spedFiscalConfiguracoes;
    
    @Transient
    private CertificadoA1 certificadoA1;
        
    @Transient
    private FaturasConfiguracoes faturasConfiguracoes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private Set<CTe> cTes;
    
    @JoinColumn(name = "tbContabilidade_Id", referencedColumnName = "Id")    
    @ManyToOne
    private Contabilidade contabilidade;
    
    @JoinColumn(name = "tbPlanos_Id", referencedColumnName = "Id")
    @ManyToOne
    private Plano plano;
    
    @Transient
    private SpedContribuicoesConfiguracoes spedContribuicoesConfiguracoes;
    
    @Column(name = "TipoInclusao")
    @Enumerated(EnumType.STRING)
    private TipoInclusao tipoInclusao;
    
    @Column(name = "ativo")
    private boolean ativo;
    
    @Column(name ="DataExclusao")
    private Date dataExclusao;
    
    @Transient
	private Integer totalDoctosArmazenados;

    public TipoInclusao getTipoInclusao() {
		return tipoInclusao;
	}

	public void setTipoInclusao(TipoInclusao tipoInclusao) {
		this.tipoInclusao = tipoInclusao;
	}

	@Transient
	private Integer totalNfe;
	
    public Integer getTotalNfe() {
		return nFes==null?totalNfe:nFes.size();
	}

	public void setTotalNfe(Integer totalNfe) {
		this.totalNfe = totalNfe;
	}

	public Integer getTotalCte() {
		return cTes==null?totalCte:cTes.size();
	}

	public void setTotalCte(Integer totalCte) {
		this.totalCte = totalCte;
	}

	public Integer getTotalSpedFiscal() {
		return spedsFiscais==null?totalSpedFiscal:spedsFiscais.size();
	}

	public void setTotalSpedFiscal(Integer totalSpedFiscal) {
		this.totalSpedFiscal = totalSpedFiscal;
	}

	public Integer getTotalSpedSocial() {
		return spedsSociais==null?totalSpedSocial:spedsSociais.size();
	}

	public void setTotalSpedSocial(Integer totalSpedSocial) {
		this.totalSpedSocial = totalSpedSocial;
	}

	public Integer getTotalSpedContribuicoes() {
		return spedsContribuicoes==null?totalSpedContribuicoes:spedsContribuicoes.size();
	}

	public void setTotalSpedContribuicoes(Integer totalSpedContribuicoes) {
		this.totalSpedContribuicoes = totalSpedContribuicoes;
	}

	@Transient
	private Integer totalCte;
    @Transient
	private Integer totalSpedFiscal;
    @Transient
	private Integer totalSpedSocial;
    @Transient
	private Integer totalSpedContribuicoes;

    public Assinante() {
		this.plano = new Plano();
		this.certificadoA1 = new CertificadoA1();
		this.contabilidade = new Contabilidade();
		this.usuarios = new ArrayList<>();
		this.dataInclusao = new Date();
    }

    public Assinante(Long id) {
        this.id = id;
    }

    public Assinante(Long id, String cnpj, String inscricaoEstadual, String nomeFantasia, String razaoSocial, String endereco, String enderecoNumero, String bairro, String municipio, SiglaEstado uf, int cep, String emailMaster, String emailFinanceiro, Date dataInclusao) {
        this.id = id;
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.enderecoNumero = enderecoNumero;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
        this.cep = cep;
        this.emailMaster = emailMaster;
        this.emailFinanceiro = emailFinanceiro;
        this.dataInclusao = dataInclusao;
    }

    public Long getId() {
        return id;
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

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
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

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    @XmlTransient
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuariosList(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @XmlTransient
    public SpedSocialConfiguracoes getSpedSocialConfiguracoes() {
        return spedSocialConfiguracoes;
    }

    public void setSpedSocialConfiguracoes(SpedSocialConfiguracoes spedSocialConfiguracoes) {
        this.spedSocialConfiguracoes = spedSocialConfiguracoes;
    }

    @XmlTransient
    public ProdutosConfiguracoes getProdutosConfiguracoes() {
        return produtosConfiguracoes;
    }

    public void setProdutosConfiguracoes(ProdutosConfiguracoes produtosConfiguracoes) {
        this.produtosConfiguracoes = produtosConfiguracoes;
    }

    @XmlTransient
    public Set<SpedContribuicoes> getSpedContribuicoes() {
        return spedsContribuicoes;
    }

    public void setSpedContribuicoes(Set<SpedContribuicoes> spedContribuicoesList) {
        this.spedsContribuicoes = spedContribuicoesList;
    }

    @XmlTransient
    public NFeConfiguracoes getNFeConfiguracoes() {
        return nFeConfiguracoes;
    }

    public void setNFeConfiguracoes(NFeConfiguracoes nFeConfiguracoesList) {
        this.nFeConfiguracoes = nFeConfiguracoesList;
    }

    @XmlTransient
    public Set<SpedSocial> getSpedsSociais() {
        return spedsSociais;
    }

    public void setSpedsSociais(Set<SpedSocial> spedSocialList) {
        this.spedsSociais = spedSocialList;
    }

    @XmlTransient
    public Set<SpedFiscal> getSpedsFiscais() {
        return spedsFiscais;
    }

    public void setSpedsFiscais(Set<SpedFiscal> spedFiscalList) {
        this.spedsFiscais = spedFiscalList;
    }

    public CTeConfiguracoes getCTeConfiguracoes() {
        return cTeConfiguracoes;
    }

    public void setCTeConfiguracoes(CTeConfiguracoes cTeConfiguracoes) {
        this.cTeConfiguracoes = cTeConfiguracoes;
    }

    @XmlTransient
    public Set<NFe> getNFes() {
        return nFes;
    }

    public void setNFes(Set<NFe> nFeList) {
        this.nFes = nFeList;
    }

    public SpedFiscalConfiguracoes getSpedFiscalConfiguracoes() {
        return spedFiscalConfiguracoes;
    }

    public void setSpedFiscalConfiguracoes(SpedFiscalConfiguracoes spedFiscalConfiguracoes) {
        this.spedFiscalConfiguracoes = spedFiscalConfiguracoes;
    }

    @XmlTransient
    public CertificadoA1 getCertificadoA1() {
        return certificadoA1;
    }

    public void setCertificadoA1(CertificadoA1 certificadoA1List) {
        this.certificadoA1 = certificadoA1List;
    }

    @XmlTransient
    public FaturasConfiguracoes getFaturasConfiguracoes() {
        return faturasConfiguracoes;
    }

    public void setFaturasConfiguracoes(FaturasConfiguracoes faturasConfiguracoesList) {
        this.faturasConfiguracoes = faturasConfiguracoesList;
    }

    @XmlTransient
    public Set<CTe> getCTes() {
        return cTes;
    }

    public void setCTes(Set<CTe> cTeList) {
        this.cTes = cTeList;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano tbPlanosId) {
        this.plano = tbPlanosId;
    }

    @XmlTransient
    public SpedContribuicoesConfiguracoes getSpedContribuicoesConfiguracoes() {
        return spedContribuicoesConfiguracoes;
    }

    public void setSpedContribuicoesConfiguracoes(SpedContribuicoesConfiguracoes spedContribuicoesConfiguracoes) {
        this.spedContribuicoesConfiguracoes = spedContribuicoesConfiguracoes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assinante)) {
            return false;
        }
        Assinante other = (Assinante) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeFantasia;
    }

	public void addUsuario(Usuario u) {
		this.usuarios.add(u);
	}

	public void removeUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}
	public String getCodigo() {
		return id == null ? null : id.toString();
	}

	public String getCnpjFormatado() {
		return Util.formatCnpj(cnpj);
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(Contabilidade tbContabilidadeId) {
		this.contabilidade = tbContabilidadeId;
	}

	public Integer getTotalDoctosArmazenados() {
		return (nFes==null && cTes==null && spedsContribuicoes==null && spedsFiscais == null && spedsSociais==null)?totalDoctosArmazenados:getTotalCte()+getTotalNfe()+getTotalSpedContribuicoes()+getTotalSpedFiscal()+getTotalSpedSocial();
	}

	public void setTotalDoctosArmazenados(Integer totalDoctosArmazenados) {
		this.totalDoctosArmazenados = totalDoctosArmazenados;
	}

	public double getComissaoMensalDouble() {
		if(TipoInclusao.MODULO_ADMINISTRATIVO.equals(this.tipoInclusao))			
			return 0;
		if(TipoInclusao.MODULO_CONTABILIDADE.equals(this.tipoInclusao)){
			return getReceita().doubleValue()*getContabilidade().getComissaoDouble();
		}
		return 0;
	}
   
	public BigDecimal getComissaoMensalBigDecimal(){
		return new BigDecimal(getComissaoMensalDouble());
	}
	
	public BigDecimal getAdicionalMonetario(){		
		return getTotalDoctosArmazenados()>getPlano().getFaixaFinal()?(new BigDecimal(getTotalDoctosArmazenados()).subtract(new BigDecimal(getPlano().getFaixaFinal()))).multiply(getPlano().getValorDoctoAdicional()):BigDecimal.ZERO;
	}
	
	public BigDecimal getReceita(){
		return getPlano().getValorMensal().add(getAdicionalMonetario());
	}
	public BigDecimal getFaturamento(){
		return getReceita().subtract(getComissaoMensalBigDecimal());
	}
	
	public void setCepFormat(String cep){
		this.cep = (cep==null||"".equals(cep))?null:Integer.valueOf(Util.removeMask(cep));
	}
	
	public String getCepFormat(){
		return this.cep==null?null:this.cep.toString();
	}
	
	public Date getDataInclusaoTela(){
		return this.dataInclusao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public double getComissaoMensal() {
		return getContabilidade().getComissaoDouble() * getPlano().getValorMensalDouble();
	}
	public String getComissaoMensalFormatada() {
		return Util.formatCurrency(getComissaoMensal());
	}

	public Calendar getDataInclusaoCalendar(){
		Calendar c = Calendar.getInstance();
		c.setTime(dataInclusao);
		return c;
	}
	
	public BigDecimal getFaturamento(Date d){		
		if(dataInclusao.after(d) || !ativo)
			return BigDecimal.ZERO;
		return getFaturamento();
	}

	public Integer getTotalDoctosAte(Date d,int calendarField){
		int r = getTotalDoctosAte(d,nFes,calendarField);
		r+=getTotalDoctosAte(d,cTes,calendarField);
		r+=getTotalDoctosAte(d,spedsFiscais,calendarField);
		r+=getTotalDoctosAte(d,spedsSociais,calendarField);
		r+=getTotalDoctosAte(d,spedsContribuicoes,calendarField);
		System.out.println("Total de Doctos do Assinante " + this + " = " + r);
		return r;
	}
	
	private <T> Integer getTotalDoctosAte(Date d,Set<T> doctos,int calendarField){
		Integer tot = 0;
		for(T docto:doctos){
			Docto doc = (Docto) docto;
			System.out.println("d = " + d);
			if(Util.comparaMesAno(doc.getDataInclusao(),d)>=0){
				tot++;
			}			
		}
		return tot;
	}

	private <T> Integer getTotalDoctosAte(Date d,Set<T> doctos){
		Integer tot = 0;
		for(T docto:doctos){
			Docto doc = (Docto) docto;
			System.out.println("d = " + d);
			if(Util.comparaDiaMesAno(doc.getDataInclusao(),d)>=0){
				tot++;
			}			
		}
		return tot;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Calendar getDataExclusaoCalendar() {
		if(dataExclusao!=null){
		Calendar c = Calendar.getInstance();
		c.setTime(dataExclusao);
		return c;
		}
		return null;
	}
	
	public Map<Object, Number> getHistoricoConsumoTotalDoAssinante(int calendarField,int dias) {
        Map<Object,Number> data = new LinkedHashMap<Object, Number>();
        Calendar inicio = Calendar.getInstance();
        inicio.add(calendarField,-dias+1);
        
        for(int dia=0;dia<dias;dia++){
        	System.out.println("Assinante ()" + this + " data.get(Util.getMMYYYY(" + inicio.getTime() + ")) " + data.get(Util.getMMYYYY(inicio)));
        	if(data.get(Util.getMMYYYY(inicio))==null)
        		data.put(Util.getMMYYYY(inicio), new Integer(0));
        	data.put(Util.getMMYYYY(inicio), (data.get(Util.getMMYYYY(inicio)).intValue() + getTotalDoctosAte(inicio.getTime(),calendarField)) );
        	inicio.add(calendarField,1);
        }
        
		return data;
	}

	public int getTotalDoctosAte(int i) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, -i);
		int r = getTotalDoctosAte(c.getTime(),nFes);
		r+=getTotalDoctosAte(c.getTime(),cTes);
		r+=getTotalDoctosAte(c.getTime(),spedsFiscais);
		r+=getTotalDoctosAte(c.getTime(),spedsSociais);
		r+=getTotalDoctosAte(c.getTime(),spedsContribuicoes);
		System.out.println("Total de Doctos do Assinante " + this + " = " + r);
		return r;
	}	
	
	public Map<Usuario,Map<Object,Number>> getHistoricoUtilizacaoPorUsuario(){
		Map<Usuario,Map<Object,Number>> h = new HashMap<Usuario, Map<Object,Number>>();		
		acumula(h,getNFes());
		acumula(h,getCTes());
		acumula(h,getSpedContribuicoes());
		acumula(h,getSpedsFiscais());
		acumula(h,getSpedsSociais());
		return h;
	}
	
	
	private <T> void acumula(Map<Usuario,Map<Object,Number>> h,Set<T> doctos){
		List<Integer> ids = new ArrayList<>();
		for(T t: doctos){
			Docto docto = (Docto) t;
			if(!ids.contains(docto.getId())){
				ids.add(docto.getId());
				Usuario u = docto.getUsuario();
				if(h.get(u)==null){
					h.put(u, new HashMap<Object,Number>());
				}
				Number tot = h.get(u).get(Util.getMMYYYY(docto.getDataInclusao()))==null?0:h.get(u).get(Util.getMMYYYY(docto.getDataInclusao()));
				h.get(u).put(Util.getMMYYYY(docto.getDataInclusao()), tot.intValue() + 1);								
			}
		}
	}
	
}
