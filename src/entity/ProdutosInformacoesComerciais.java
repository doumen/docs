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
@Table(name = "tbProdutosInformacoesComerciais")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutosInformacoesComerciais.findAll", query = "SELECT p FROM ProdutosInformacoesComerciais p"),
    @NamedQuery(name = "ProdutosInformacoesComerciais.findById", query = "SELECT p FROM ProdutosInformacoesComerciais p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutosInformacoesComerciais.findByQuantidade", query = "SELECT p FROM ProdutosInformacoesComerciais p WHERE p.quantidade = :quantidade"),
    @NamedQuery(name = "ProdutosInformacoesComerciais.findByUnidadeMedidaComercial", query = "SELECT p FROM ProdutosInformacoesComerciais p WHERE p.unidadeMedidaComercial = :unidadeMedidaComercial"),
    @NamedQuery(name = "ProdutosInformacoesComerciais.findByValorUnitario", query = "SELECT p FROM ProdutosInformacoesComerciais p WHERE p.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "ProdutosInformacoesComerciais.findByValorTotal", query = "SELECT p FROM ProdutosInformacoesComerciais p WHERE p.valorTotal = :valorTotal"),
    @NamedQuery(name = "ProdutosInformacoesComerciais.findByDataInclusao", query = "SELECT p FROM ProdutosInformacoesComerciais p WHERE p.dataInclusao = :dataInclusao")})
public class ProdutosInformacoesComerciais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Quantidade")
    private BigDecimal quantidade;
    @Basic(optional = false)
    @Column(name = "UnidadeMedidaComercial")
    private String unidadeMedidaComercial;
    @Basic(optional = false)
    @Column(name = "ValorUnitario")
    private BigDecimal valorUnitario;
    @Basic(optional = false)
    @Column(name = "ValorTotal")
    private BigDecimal valorTotal;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProdutosInformacoesComerciaisId", fetch = FetchType.LAZY)
    private List<NFeItens> nFeItensList;

    public ProdutosInformacoesComerciais() {
    }

    public ProdutosInformacoesComerciais(Integer id) {
        this.id = id;
    }

    public ProdutosInformacoesComerciais(Integer id, BigDecimal quantidade, String unidadeMedidaComercial, BigDecimal valorUnitario, BigDecimal valorTotal, Date dataInclusao) {
        this.id = id;
        this.quantidade = quantidade;
        this.unidadeMedidaComercial = unidadeMedidaComercial;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidadeMedidaComercial() {
        return unidadeMedidaComercial;
    }

    public void setUnidadeMedidaComercial(String unidadeMedidaComercial) {
        this.unidadeMedidaComercial = unidadeMedidaComercial;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
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
    public List<NFeItens> getNFeItensList() {
        return nFeItensList;
    }

    public void setNFeItensList(List<NFeItens> nFeItensList) {
        this.nFeItensList = nFeItensList;
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
        if (!(object instanceof ProdutosInformacoesComerciais)) {
            return false;
        }
        ProdutosInformacoesComerciais other = (ProdutosInformacoesComerciais) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ProdutosInformacoesComerciais[ id=" + id + " ]";
    }
    
}
