/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import model.SiglaEstado;
import model.TipoInclusao;
import model.Util;

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
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Cnpj")
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "InscricaoEstadual")
    private String inscricaoEstadual;
    @Basic(optional = false)
    @Column(name = "NomeFantasia")
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
    private int cep;
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
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Usuario> usuarios;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="tbAssinantesId")
    private SpedSocialConfiguracoes spedSocialConfiguracoesList;

    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<ProdutosConfiguracoes> produtosConfiguracoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<SpedContribuicoes> spedContribuicoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<NFeConfiguracoes> nFeConfiguracoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<SpedSocial> spedSocialList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<SpedFiscal> spedFiscalList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private CTeConfiguracoes cTeConfiguracoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<NFe> nFeList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private SpedFiscalConfiguracoes spedFiscalConfiguracoes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<CertificadoA1> certificadoA1List;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<FaturasConfiguracoes> faturasConfiguracoesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<CTe> cTeList;	
    @JoinColumn(name = "tbContabilidade_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contabilidade tbContabilidadeId;
    @JoinColumn(name = "tbPlanos_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Plano tbPlanosId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbAssinantesId", fetch = FetchType.LAZY)
    private List<SpedContribuicoesConfiguracoes> spedContribuicoesConfiguracoesList;
    
    @Column(name = "TipoInclusao")
    @Enumerated(EnumType.STRING)
    private TipoInclusao tipoInclusao;

    public TipoInclusao getTipoInclusao() {
		return tipoInclusao;
	}

	public void setTipoInclusao(TipoInclusao tipoInclusao) {
		this.tipoInclusao = tipoInclusao;
	}

	@Transient
	private Integer totalNfe;
    public Integer getTotalNfe() {
		return totalNfe;
	}

	public void setTotalNfe(Integer totalNfe) {
		this.totalNfe = totalNfe;
	}

	public Integer getTotalCte() {
		return totalCte;
	}

	public void setTotalCte(Integer totalCte) {
		this.totalCte = totalCte;
	}

	public Integer getTotalSpedFiscal() {
		return totalSpedFiscal;
	}

	public void setTotalSpedFiscal(Integer totalSpedFiscal) {
		this.totalSpedFiscal = totalSpedFiscal;
	}

	public Integer getTotalSpedSocial() {
		return totalSpedSocial;
	}

	public void setTotalSpedSocial(Integer totalSpedSocial) {
		this.totalSpedSocial = totalSpedSocial;
	}

	public Integer getTotalSpedContribuicoes() {
		return totalSpedContribuicoes;
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
    }

    public Assinante(Integer id) {
        this.id = id;
    }

    public Assinante(Integer id, String cnpj, String inscricaoEstadual, String nomeFantasia, String razaoSocial, String endereco, String enderecoNumero, String bairro, String municipio, SiglaEstado uf, int cep, String emailMaster, String emailFinanceiro, Date dataInclusao) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    public SpedSocialConfiguracoes getSpedSocialConfiguracoesList() {
        return spedSocialConfiguracoesList;
    }

    public void setSpedSocialConfiguracoesList(SpedSocialConfiguracoes spedSocialConfiguracoesList) {
        this.spedSocialConfiguracoesList = spedSocialConfiguracoesList;
    }

    @XmlTransient
    public List<ProdutosConfiguracoes> getProdutosConfiguracoesList() {
        return produtosConfiguracoesList;
    }

    public void setProdutosConfiguracoesList(List<ProdutosConfiguracoes> produtosConfiguracoesList) {
        this.produtosConfiguracoesList = produtosConfiguracoesList;
    }

    @XmlTransient
    public List<SpedContribuicoes> getSpedContribuicoesList() {
        return spedContribuicoesList;
    }

    public void setSpedContribuicoesList(List<SpedContribuicoes> spedContribuicoesList) {
        this.spedContribuicoesList = spedContribuicoesList;
    }

    @XmlTransient
    public List<NFeConfiguracoes> getNFeConfiguracoesList() {
        return nFeConfiguracoesList;
    }

    public void setNFeConfiguracoesList(List<NFeConfiguracoes> nFeConfiguracoesList) {
        this.nFeConfiguracoesList = nFeConfiguracoesList;
    }

    @XmlTransient
    public List<SpedSocial> getSpedSocialList() {
        return spedSocialList;
    }

    public void setSpedSocialList(List<SpedSocial> spedSocialList) {
        this.spedSocialList = spedSocialList;
    }

    @XmlTransient
    public List<SpedFiscal> getSpedFiscalList() {
        return spedFiscalList;
    }

    public void setSpedFiscalList(List<SpedFiscal> spedFiscalList) {
        this.spedFiscalList = spedFiscalList;
    }

    public CTeConfiguracoes getCTeConfiguracoes() {
        return cTeConfiguracoes;
    }

    public void setCTeConfiguracoes(CTeConfiguracoes cTeConfiguracoes) {
        this.cTeConfiguracoes = cTeConfiguracoes;
    }

    @XmlTransient
    public List<NFe> getNFeList() {
        return nFeList;
    }

    public void setNFeList(List<NFe> nFeList) {
        this.nFeList = nFeList;
    }

    public SpedFiscalConfiguracoes getSpedFiscalConfiguracoes() {
        return spedFiscalConfiguracoes;
    }

    public void setSpedFiscalConfiguracoes(SpedFiscalConfiguracoes spedFiscalConfiguracoes) {
        this.spedFiscalConfiguracoes = spedFiscalConfiguracoes;
    }

    @XmlTransient
    public List<CertificadoA1> getCertificadoA1List() {
        return certificadoA1List;
    }

    public void setCertificadoA1List(List<CertificadoA1> certificadoA1List) {
        this.certificadoA1List = certificadoA1List;
    }

    @XmlTransient
    public List<FaturasConfiguracoes> getFaturasConfiguracoesList() {
        return faturasConfiguracoesList;
    }

    public void setFaturasConfiguracoesList(List<FaturasConfiguracoes> faturasConfiguracoesList) {
        this.faturasConfiguracoesList = faturasConfiguracoesList;
    }

    @XmlTransient
    public List<CTe> getCTeList() {
        return cTeList;
    }

    public void setCTeList(List<CTe> cTeList) {
        this.cTeList = cTeList;
    }

    public Contabilidade getContabilidade() {
        return tbContabilidadeId;
    }

    public void setContabilidade(Contabilidade tbContabilidadeId) {
        this.tbContabilidadeId = tbContabilidadeId;
    }

    public Plano getPlano() {
        return tbPlanosId;
    }

    public void setPlano(Plano tbPlanosId) {
        this.tbPlanosId = tbPlanosId;
    }

    @XmlTransient
    public List<SpedContribuicoesConfiguracoes> getSpedContribuicoesConfiguracoesList() {
        return spedContribuicoesConfiguracoesList;
    }

    public void setSpedContribuicoesConfiguracoesList(List<SpedContribuicoesConfiguracoes> spedContribuicoesConfiguracoesList) {
        this.spedContribuicoesConfiguracoesList = spedContribuicoesConfiguracoesList;
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
        return "Assinante[ id=" + id + " ]";
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
   
}
