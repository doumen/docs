/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import converter.ConvertByField;
import model.SiglaEstado;
import model.TipoInclusao;
import model.Util;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbContabilidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contabilidade.findAll", query = "SELECT c FROM Contabilidade c"),
    @NamedQuery(name = "Contabilidade.findById", query = "SELECT c FROM Contabilidade c WHERE c.id = :id"),
    @NamedQuery(name = "Contabilidade.findByCnpj", query = "SELECT c FROM Contabilidade c WHERE c.cnpj = :cnpj"),
    @NamedQuery(name = "Contabilidade.findByInscricaoEstadual", query = "SELECT c FROM Contabilidade c WHERE c.inscricaoEstadual = :inscricaoEstadual"),
    @NamedQuery(name = "Contabilidade.findByNomeFantasia", query = "SELECT c FROM Contabilidade c WHERE c.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Contabilidade.findByRazaoSocial", query = "SELECT c FROM Contabilidade c WHERE c.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Contabilidade.findByEndereco", query = "SELECT c FROM Contabilidade c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Contabilidade.findByEnderecoNumero", query = "SELECT c FROM Contabilidade c WHERE c.enderecoNumero = :enderecoNumero"),
    @NamedQuery(name = "Contabilidade.findByEnderecoComplemento", query = "SELECT c FROM Contabilidade c WHERE c.enderecoComplemento = :enderecoComplemento"),
    @NamedQuery(name = "Contabilidade.findByBairro", query = "SELECT c FROM Contabilidade c WHERE c.bairro = :bairro"),
    @NamedQuery(name = "Contabilidade.findByMunicipio", query = "SELECT c FROM Contabilidade c WHERE c.municipio = :municipio"),
    @NamedQuery(name = "Contabilidade.findByUf", query = "SELECT c FROM Contabilidade c WHERE c.uf = :uf"),
    @NamedQuery(name = "Contabilidade.findByCep", query = "SELECT c FROM Contabilidade c WHERE c.cep = :cep"),
    @NamedQuery(name = "Contabilidade.findByComissao", query = "SELECT c FROM Contabilidade c WHERE c.comissao = :comissao"),
    @NamedQuery(name = "Contabilidade.findByDataInclusao", query = "SELECT c FROM Contabilidade c WHERE c.dataInclusao = :dataInclusao")})
public class Contabilidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Cnpj")
    private String cnpj;
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
    private int cep;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Comissao")
    private BigDecimal comissao;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(mappedBy = "tbContabilidadeId", fetch = FetchType.LAZY)
    private List<Usuario> usuariosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contabilidade", fetch = FetchType.LAZY)
    private List<Assinante> assinantesList;
    @Column(name = "TipoInclusao")
    @Enumerated(EnumType.STRING)
    private TipoInclusao tipoInclusao;

    public TipoInclusao getTipoInclusao() {
		return tipoInclusao;
	}

	public void setTipoInclusao(TipoInclusao tipoInclusao) {
		this.tipoInclusao = tipoInclusao;
	}

	public Contabilidade() {
    }

    public Contabilidade(Long id) {
        this.id = id;
    }

    public Contabilidade(Long id, String cnpj, String nomeFantasia, String razaoSocial, String endereco, String enderecoNumero, String bairro, String municipio, SiglaEstado uf, int cep, BigDecimal comissao, Date dataInclusao) {
        this.id = id;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.enderecoNumero = enderecoNumero;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
        this.cep = cep;
        this.comissao = comissao;
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

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public BigDecimal getComissao() {
        return comissao;
    }

    public void setComissao(BigDecimal comissao) {
        this.comissao = comissao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    @XmlTransient
    public List<Usuario> getUsuarios() {
        return usuariosList;
    }

    public void setUsuarios(List<Usuario> usuariosList) {
        this.usuariosList = usuariosList;
    }

    @XmlTransient
    public List<Assinante> getAssinantesList() {
        return assinantesList;
    }

    public void setAssinantesList(List<Assinante> assinantesList) {
        this.assinantesList = assinantesList;
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
        if (!(object instanceof Contabilidade)) {
            return false;
        }
        Contabilidade other = (Contabilidade) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nomeFantasia;
    }

	public void setComissao(double d) {
		// TODO Auto-generated method stub
		
	}

	public void addUsuario(Usuario u) {
		this.usuariosList.add(u);
	}

	public void removeUsuario(Usuario usuario) {
		this.usuariosList.remove(usuario);
	}

	public double getComissaoDouble() {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getCnpjFormatado() {
		return Util.formatCnpj(cnpj);
	}
	public String getCodigo() {
		return id == null ? null : id.toString();
	}
   
}
