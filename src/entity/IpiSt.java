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
import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbIpiSt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IpiSt.findAll", query = "SELECT i FROM IpiSt i"),
    @NamedQuery(name = "IpiSt.findById", query = "SELECT i FROM IpiSt i WHERE i.id = :id"),
    @NamedQuery(name = "IpiSt.findByQuantidadeVendida", query = "SELECT i FROM IpiSt i WHERE i.quantidadeVendida = :quantidadeVendida"),
    @NamedQuery(name = "IpiSt.findByMva", query = "SELECT i FROM IpiSt i WHERE i.mva = :mva"),
    @NamedQuery(name = "IpiSt.findByBaseDeCalculo", query = "SELECT i FROM IpiSt i WHERE i.baseDeCalculo = :baseDeCalculo"),
    @NamedQuery(name = "IpiSt.findByReducaoBaseCalculo", query = "SELECT i FROM IpiSt i WHERE i.reducaoBaseCalculo = :reducaoBaseCalculo"),
    @NamedQuery(name = "IpiSt.findByValorTributacaoPorUnidade", query = "SELECT i FROM IpiSt i WHERE i.valorTributacaoPorUnidade = :valorTributacaoPorUnidade"),
    @NamedQuery(name = "IpiSt.findByAliquota", query = "SELECT i FROM IpiSt i WHERE i.aliquota = :aliquota"),
    @NamedQuery(name = "IpiSt.findByValorTotal", query = "SELECT i FROM IpiSt i WHERE i.valorTotal = :valorTotal"),
    @NamedQuery(name = "IpiSt.findByDataInclusao", query = "SELECT i FROM IpiSt i WHERE i.dataInclusao = :dataInclusao")})
public class IpiSt implements Serializable {
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
    @Column(name = "ValorTributacaoPorUnidade")
    private BigDecimal valorTributacaoPorUnidade;
    @Column(name = "Aliquota")
    private BigDecimal aliquota;
    @Basic(optional = false)
    @Column(name = "ValorTotal")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(mappedBy = "tbIpiStId", fetch = FetchType.LAZY)
    private List<Ipi> ipiList;

    public IpiSt() {
    }

    public IpiSt(Integer id) {
        this.id = id;
    }

    public IpiSt(Integer id, BigDecimal quantidadeVendida, BigDecimal valorTotal, Date dataInclusao) {
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

    public BigDecimal getValorTributacaoPorUnidade() {
        return valorTributacaoPorUnidade;
    }

    public void setValorTributacaoPorUnidade(BigDecimal valorTributacaoPorUnidade) {
        this.valorTributacaoPorUnidade = valorTributacaoPorUnidade;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
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

    @XmlTransient
    public List<Ipi> getIpiList() {
        return ipiList;
    }

    public void setIpiList(List<Ipi> ipiList) {
        this.ipiList = ipiList;
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
        if (!(object instanceof IpiSt)) {
            return false;
        }
        IpiSt other = (IpiSt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.IpiSt[ id=" + id + " ]";
    }
    
}
