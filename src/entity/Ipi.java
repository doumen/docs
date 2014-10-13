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
@Table(name = "tbIpi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ipi.findAll", query = "SELECT i FROM Ipi i"),
    @NamedQuery(name = "Ipi.findById", query = "SELECT i FROM Ipi i WHERE i.id = :id"),
    @NamedQuery(name = "Ipi.findByQuantidadeVendida", query = "SELECT i FROM Ipi i WHERE i.quantidadeVendida = :quantidadeVendida"),
    @NamedQuery(name = "Ipi.findByAliquota", query = "SELECT i FROM Ipi i WHERE i.aliquota = :aliquota"),
    @NamedQuery(name = "Ipi.findByBaseDeCalculo", query = "SELECT i FROM Ipi i WHERE i.baseDeCalculo = :baseDeCalculo"),
    @NamedQuery(name = "Ipi.findByReducaoBaseCalculo", query = "SELECT i FROM Ipi i WHERE i.reducaoBaseCalculo = :reducaoBaseCalculo"),
    @NamedQuery(name = "Ipi.findByValorTributacaoPorUnidade", query = "SELECT i FROM Ipi i WHERE i.valorTributacaoPorUnidade = :valorTributacaoPorUnidade"),
    @NamedQuery(name = "Ipi.findByValorTotal", query = "SELECT i FROM Ipi i WHERE i.valorTotal = :valorTotal"),
    @NamedQuery(name = "Ipi.findByDataInclusao", query = "SELECT i FROM Ipi i WHERE i.dataInclusao = :dataInclusao")})
public class Ipi implements Serializable {
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
    @Column(name = "ReducaoBaseCalculo")
    private BigDecimal reducaoBaseCalculo;
    @Column(name = "ValorTributacaoPorUnidade")
    private BigDecimal valorTributacaoPorUnidade;
    @Basic(optional = false)
    @Column(name = "ValorTotal")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbCodigoEnquadramentoLegalIpi_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CodigoEnquadramentoLegalIpi tbCodigoEnquadramentoLegalIpiId;
    @JoinColumn(name = "tbCstIpi_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CstIpi tbCstIpiId;
    @JoinColumn(name = "tbIpiSt_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private IpiSt tbIpiStId;
    @JoinColumn(name = "tbNFeItens_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NFeItens tbNFeItensId;
    @JoinColumn(name = "tbTipi_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipi tbTipiId;

    public Ipi() {
    }

    public Ipi(Integer id) {
        this.id = id;
    }

    public Ipi(Integer id, BigDecimal quantidadeVendida, BigDecimal valorTotal, Date dataInclusao) {
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

    public CodigoEnquadramentoLegalIpi getTbCodigoEnquadramentoLegalIpiId() {
        return tbCodigoEnquadramentoLegalIpiId;
    }

    public void setTbCodigoEnquadramentoLegalIpiId(CodigoEnquadramentoLegalIpi tbCodigoEnquadramentoLegalIpiId) {
        this.tbCodigoEnquadramentoLegalIpiId = tbCodigoEnquadramentoLegalIpiId;
    }

    public CstIpi getTbCstIpiId() {
        return tbCstIpiId;
    }

    public void setTbCstIpiId(CstIpi tbCstIpiId) {
        this.tbCstIpiId = tbCstIpiId;
    }

    public IpiSt getTbIpiStId() {
        return tbIpiStId;
    }

    public void setTbIpiStId(IpiSt tbIpiStId) {
        this.tbIpiStId = tbIpiStId;
    }

    public NFeItens getTbNFeItensId() {
        return tbNFeItensId;
    }

    public void setTbNFeItensId(NFeItens tbNFeItensId) {
        this.tbNFeItensId = tbNFeItensId;
    }

    public Tipi getTbTipiId() {
        return tbTipiId;
    }

    public void setTbTipiId(Tipi tbTipiId) {
        this.tbTipiId = tbTipiId;
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
        if (!(object instanceof Ipi)) {
            return false;
        }
        Ipi other = (Ipi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Ipi[ id=" + id + " ]";
    }
    
}
