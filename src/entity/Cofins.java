/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbCofins")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cofins.findAll", query = "SELECT c FROM Cofins c"),
    @NamedQuery(name = "Cofins.findById", query = "SELECT c FROM Cofins c WHERE c.id = :id"),
    @NamedQuery(name = "Cofins.findByQuantidadeVendida", query = "SELECT c FROM Cofins c WHERE c.quantidadeVendida = :quantidadeVendida"),
    @NamedQuery(name = "Cofins.findByAliquota", query = "SELECT c FROM Cofins c WHERE c.aliquota = :aliquota"),
    @NamedQuery(name = "Cofins.findByBaseDeCalculo", query = "SELECT c FROM Cofins c WHERE c.baseDeCalculo = :baseDeCalculo"),
    @NamedQuery(name = "Cofins.findByValorTributacaoPorUnidade", query = "SELECT c FROM Cofins c WHERE c.valorTributacaoPorUnidade = :valorTributacaoPorUnidade"),
    @NamedQuery(name = "Cofins.findByValorTotal", query = "SELECT c FROM Cofins c WHERE c.valorTotal = :valorTotal"),
    @NamedQuery(name = "Cofins.findByDataInclusao", query = "SELECT c FROM Cofins c WHERE c.dataInclusao = :dataInclusao")})
public class Cofins implements Serializable {
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
    @Column(name = "Aliquota")
    private BigDecimal aliquota;
    @Column(name = "BaseDeCalculo")
    private BigDecimal baseDeCalculo;
    @Column(name = "ValorTributacaoPorUnidade")
    private BigDecimal valorTributacaoPorUnidade;
    @Basic(optional = false)
    @Column(name = "ValorTotal")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbCstCofins_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CstCofins tbCstCofinsId;
    @JoinColumn(name = "tbNFeItens_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NFeItens tbNFeItensId;

    public Cofins() {
    }

    public Cofins(Integer id) {
        this.id = id;
    }

    public Cofins(Integer id, BigDecimal quantidadeVendida, BigDecimal valorTotal, Date dataInclusao) {
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

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getBaseDeCalculo() {
        return baseDeCalculo;
    }

    public void setBaseDeCalculo(BigDecimal baseDeCalculo) {
        this.baseDeCalculo = baseDeCalculo;
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

    public CstCofins getTbCstCofinsId() {
        return tbCstCofinsId;
    }

    public void setTbCstCofinsId(CstCofins tbCstCofinsId) {
        this.tbCstCofinsId = tbCstCofinsId;
    }

    public NFeItens getTbNFeItensId() {
        return tbNFeItensId;
    }

    public void setTbNFeItensId(NFeItens tbNFeItensId) {
        this.tbNFeItensId = tbNFeItensId;
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
        if (!(object instanceof Cofins)) {
            return false;
        }
        Cofins other = (Cofins) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Cofins[ id=" + id + " ]";
    }
    
}
