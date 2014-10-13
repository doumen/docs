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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbIcmsSt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IcmsSt.findAll", query = "SELECT i FROM IcmsSt i"),
    @NamedQuery(name = "IcmsSt.findById", query = "SELECT i FROM IcmsSt i WHERE i.id = :id"),
    @NamedQuery(name = "IcmsSt.findByQuantidadeVendida", query = "SELECT i FROM IcmsSt i WHERE i.quantidadeVendida = :quantidadeVendida"),
    @NamedQuery(name = "IcmsSt.findByMva", query = "SELECT i FROM IcmsSt i WHERE i.mva = :mva"),
    @NamedQuery(name = "IcmsSt.findByBaseDeCalculo", query = "SELECT i FROM IcmsSt i WHERE i.baseDeCalculo = :baseDeCalculo"),
    @NamedQuery(name = "IcmsSt.findByReducaoBaseCalculo", query = "SELECT i FROM IcmsSt i WHERE i.reducaoBaseCalculo = :reducaoBaseCalculo"),
    @NamedQuery(name = "IcmsSt.findByAliquota", query = "SELECT i FROM IcmsSt i WHERE i.aliquota = :aliquota"),
    @NamedQuery(name = "IcmsSt.findByValorTributacaoPorUnidade", query = "SELECT i FROM IcmsSt i WHERE i.valorTributacaoPorUnidade = :valorTributacaoPorUnidade"),
    @NamedQuery(name = "IcmsSt.findByValorTotal", query = "SELECT i FROM IcmsSt i WHERE i.valorTotal = :valorTotal"),
    @NamedQuery(name = "IcmsSt.findByDataInclusao", query = "SELECT i FROM IcmsSt i WHERE i.dataInclusao = :dataInclusao")})
public class IcmsSt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "QuantidadeVendida")
    private BigDecimal quantidadeVendida;
    @Column(name = "Mva")
    private BigDecimal mva;
    @Column(name = "BaseDeCalculo")
    private BigDecimal baseDeCalculo;
    @Column(name = "ReducaoBaseCalculo")
    private BigDecimal reducaoBaseCalculo;
    @Column(name = "Aliquota")
    private BigDecimal aliquota;
    @Column(name = "ValorTributacaoPorUnidade")
    private BigDecimal valorTributacaoPorUnidade;
    @Basic(optional = false)
    @Column(name = "ValorTotal")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbModalidadeDeterminacaoBaseCalculoIcmsSt_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ModalidadeDeterminacaoBaseCalculoIcmsSt tbModalidadeDeterminacaoBaseCalculoIcmsStId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbIcmsStId", fetch = FetchType.LAZY)
    private List<Icms> icmsList;

    public IcmsSt() {
    }

    public IcmsSt(Integer id) {
        this.id = id;
    }

    public IcmsSt(Integer id, BigDecimal quantidadeVendida, BigDecimal valorTotal, Date dataInclusao) {
        this.id = id;
        this.quantidadeVendida = quantidadeVendida;
        this.valorTotal = valorTotal;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void setQuantidadeVendida(BigDecimal quantidadeVendida) {
        this.quantidadeVendida = quantidadeVendida;
    }

    public BigDecimal getMva() {
        return mva;
    }

    public void setMva(BigDecimal mva) {
        this.mva = mva;
    }

    public BigDecimal getBaseDeCalculo() {
        return baseDeCalculo;
    }

    public void setBaseDeCalculo(BigDecimal baseDeCalculo) {
        this.baseDeCalculo = baseDeCalculo;
    }

    public BigDecimal getReducaoBaseCalculo() {
        return reducaoBaseCalculo;
    }

    public void setReducaoBaseCalculo(BigDecimal reducaoBaseCalculo) {
        this.reducaoBaseCalculo = reducaoBaseCalculo;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getValorTributacaoPorUnidade() {
        return valorTributacaoPorUnidade;
    }

    public void setValorTributacaoPorUnidade(BigDecimal valorTributacaoPorUnidade) {
        this.valorTributacaoPorUnidade = valorTributacaoPorUnidade;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public ModalidadeDeterminacaoBaseCalculoIcmsSt getTbModalidadeDeterminacaoBaseCalculoIcmsStId() {
        return tbModalidadeDeterminacaoBaseCalculoIcmsStId;
    }

    public void setTbModalidadeDeterminacaoBaseCalculoIcmsStId(ModalidadeDeterminacaoBaseCalculoIcmsSt tbModalidadeDeterminacaoBaseCalculoIcmsStId) {
        this.tbModalidadeDeterminacaoBaseCalculoIcmsStId = tbModalidadeDeterminacaoBaseCalculoIcmsStId;
    }

    @XmlTransient
    public List<Icms> getIcmsList() {
        return icmsList;
    }

    public void setIcmsList(List<Icms> icmsList) {
        this.icmsList = icmsList;
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
        if (!(object instanceof IcmsSt)) {
            return false;
        }
        IcmsSt other = (IcmsSt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.IcmsSt[ id=" + id + " ]";
    }
    
}
