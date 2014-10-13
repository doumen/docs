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
@Table(name = "tbPis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pis.findAll", query = "SELECT p FROM Pis p"),
    @NamedQuery(name = "Pis.findById", query = "SELECT p FROM Pis p WHERE p.id = :id"),
    @NamedQuery(name = "Pis.findByQuantidadeVendida", query = "SELECT p FROM Pis p WHERE p.quantidadeVendida = :quantidadeVendida"),
    @NamedQuery(name = "Pis.findByAliquota", query = "SELECT p FROM Pis p WHERE p.aliquota = :aliquota"),
    @NamedQuery(name = "Pis.findByBaseDeCalculo", query = "SELECT p FROM Pis p WHERE p.baseDeCalculo = :baseDeCalculo"),
    @NamedQuery(name = "Pis.findByValorTributacaoPorUnidade", query = "SELECT p FROM Pis p WHERE p.valorTributacaoPorUnidade = :valorTributacaoPorUnidade"),
    @NamedQuery(name = "Pis.findByValorTotal", query = "SELECT p FROM Pis p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "Pis.findByDataInclusao", query = "SELECT p FROM Pis p WHERE p.dataInclusao = :dataInclusao")})
public class Pis implements Serializable {
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
    @JoinColumn(name = "tbCstPis_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CstPis tbCstPisId;
    @JoinColumn(name = "tbNFeItens_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NFeItens tbNFeItensId;

    public Pis() {
    }

    public Pis(Integer id) {
        this.id = id;
    }

    public Pis(Integer id, BigDecimal quantidadeVendida, BigDecimal valorTotal, Date dataInclusao) {
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

    public CstPis getTbCstPisId() {
        return tbCstPisId;
    }

    public void setTbCstPisId(CstPis tbCstPisId) {
        this.tbCstPisId = tbCstPisId;
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
        if (!(object instanceof Pis)) {
            return false;
        }
        Pis other = (Pis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Pis[ id=" + id + " ]";
    }
    
}
