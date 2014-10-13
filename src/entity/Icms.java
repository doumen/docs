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
@Table(name = "tbIcms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Icms.findAll", query = "SELECT i FROM Icms i"),
    @NamedQuery(name = "Icms.findById", query = "SELECT i FROM Icms i WHERE i.id = :id"),
    @NamedQuery(name = "Icms.findByQuantidadeVendida", query = "SELECT i FROM Icms i WHERE i.quantidadeVendida = :quantidadeVendida"),
    @NamedQuery(name = "Icms.findByAliquota", query = "SELECT i FROM Icms i WHERE i.aliquota = :aliquota"),
    @NamedQuery(name = "Icms.findByBaseDeCalculo", query = "SELECT i FROM Icms i WHERE i.baseDeCalculo = :baseDeCalculo"),
    @NamedQuery(name = "Icms.findByReducaoBaseCalculo", query = "SELECT i FROM Icms i WHERE i.reducaoBaseCalculo = :reducaoBaseCalculo"),
    @NamedQuery(name = "Icms.findByValorTotal", query = "SELECT i FROM Icms i WHERE i.valorTotal = :valorTotal"),
    @NamedQuery(name = "Icms.findByDataInclusao", query = "SELECT i FROM Icms i WHERE i.dataInclusao = :dataInclusao")})
public class Icms implements Serializable {
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
    @Basic(optional = false)
    @Column(name = "ValorTotal")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbCstIcms_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CstIcms tbCstIcmsId;
    @JoinColumn(name = "tbCstIcmsOrigem_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CstIcmsOrigem tbCstIcmsOrigemId;
    @JoinColumn(name = "tbIcmsSt_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private IcmsSt tbIcmsStId;
    @JoinColumn(name = "tbModelalidadeDeterminacaoBaseCalculoIcms_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ModalidadeDeterminacaoBaseCalculoIcms tbModelalidadeDeterminacaoBaseCalculoIcmsId;
    @JoinColumn(name = "tbNFeItens_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NFeItens tbNFeItensId;

    public Icms() {
    }

    public Icms(Integer id) {
        this.id = id;
    }

    public Icms(Integer id, BigDecimal quantidadeVendida, BigDecimal valorTotal, Date dataInclusao) {
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

    public CstIcms getTbCstIcmsId() {
        return tbCstIcmsId;
    }

    public void setTbCstIcmsId(CstIcms tbCstIcmsId) {
        this.tbCstIcmsId = tbCstIcmsId;
    }

    public CstIcmsOrigem getTbCstIcmsOrigemId() {
        return tbCstIcmsOrigemId;
    }

    public void setTbCstIcmsOrigemId(CstIcmsOrigem tbCstIcmsOrigemId) {
        this.tbCstIcmsOrigemId = tbCstIcmsOrigemId;
    }

    public IcmsSt getTbIcmsStId() {
        return tbIcmsStId;
    }

    public void setTbIcmsStId(IcmsSt tbIcmsStId) {
        this.tbIcmsStId = tbIcmsStId;
    }

    public ModalidadeDeterminacaoBaseCalculoIcms getTbModelalidadeDeterminacaoBaseCalculoIcmsId() {
        return tbModelalidadeDeterminacaoBaseCalculoIcmsId;
    }

    public void setTbModelalidadeDeterminacaoBaseCalculoIcmsId(ModalidadeDeterminacaoBaseCalculoIcms tbModelalidadeDeterminacaoBaseCalculoIcmsId) {
        this.tbModelalidadeDeterminacaoBaseCalculoIcmsId = tbModelalidadeDeterminacaoBaseCalculoIcmsId;
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
        if (!(object instanceof Icms)) {
            return false;
        }
        Icms other = (Icms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Icms[ id=" + id + " ]";
    }
    
}
