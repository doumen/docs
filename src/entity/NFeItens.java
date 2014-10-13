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
@Table(name = "tbNFeItens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NFeItens.findAll", query = "SELECT n FROM NFeItens n"),
    @NamedQuery(name = "NFeItens.findById", query = "SELECT n FROM NFeItens n WHERE n.id = :id"),
    @NamedQuery(name = "NFeItens.findByItem", query = "SELECT n FROM NFeItens n WHERE n.item = :item"),
    @NamedQuery(name = "NFeItens.findByCodigo", query = "SELECT n FROM NFeItens n WHERE n.codigo = :codigo"),
    @NamedQuery(name = "NFeItens.findByCodigoBarras", query = "SELECT n FROM NFeItens n WHERE n.codigoBarras = :codigoBarras"),
    @NamedQuery(name = "NFeItens.findByCodigoBarrasTributavel", query = "SELECT n FROM NFeItens n WHERE n.codigoBarrasTributavel = :codigoBarrasTributavel"),
    @NamedQuery(name = "NFeItens.findByDataInclusao", query = "SELECT n FROM NFeItens n WHERE n.dataInclusao = :dataInclusao")})
public class NFeItens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Item")
    private int item;
    @Basic(optional = false)
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "CodigoBarras")
    private Integer codigoBarras;
    @Column(name = "CodigoBarrasTributavel")
    private Integer codigoBarrasTributavel;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbNFeItensId", fetch = FetchType.LAZY)
    private List<Ipi> ipiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbNFeItensId", fetch = FetchType.LAZY)
    private List<Cofins> cofinsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbNFeItensId", fetch = FetchType.LAZY)
    private List<Pis> pisList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbNFeItensId", fetch = FetchType.LAZY)
    private List<Icms> icmsList;
    @JoinColumn(name = "tbNFe_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NFe tbNFeId;
    @JoinColumn(name = "tbProdutos_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produtos tbProdutosId;
    @JoinColumn(name = "tbProdutosInformacoesComerciais_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ProdutosInformacoesComerciais tbProdutosInformacoesComerciaisId;

    public NFeItens() {
    }

    public NFeItens(Integer id) {
        this.id = id;
    }

    public NFeItens(Integer id, int item, String codigo, Date dataInclusao) {
        this.id = id;
        this.item = item;
        this.codigo = codigo;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Integer codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getCodigoBarrasTributavel() {
        return codigoBarrasTributavel;
    }

    public void setCodigoBarrasTributavel(Integer codigoBarrasTributavel) {
        this.codigoBarrasTributavel = codigoBarrasTributavel;
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

    @XmlTransient
    public List<Cofins> getCofinsList() {
        return cofinsList;
    }

    public void setCofinsList(List<Cofins> cofinsList) {
        this.cofinsList = cofinsList;
    }

    @XmlTransient
    public List<Pis> getPisList() {
        return pisList;
    }

    public void setPisList(List<Pis> pisList) {
        this.pisList = pisList;
    }

    @XmlTransient
    public List<Icms> getIcmsList() {
        return icmsList;
    }

    public void setIcmsList(List<Icms> icmsList) {
        this.icmsList = icmsList;
    }

    public NFe getTbNFeId() {
        return tbNFeId;
    }

    public void setTbNFeId(NFe tbNFeId) {
        this.tbNFeId = tbNFeId;
    }

    public Produtos getTbProdutosId() {
        return tbProdutosId;
    }

    public void setTbProdutosId(Produtos tbProdutosId) {
        this.tbProdutosId = tbProdutosId;
    }

    public ProdutosInformacoesComerciais getTbProdutosInformacoesComerciaisId() {
        return tbProdutosInformacoesComerciaisId;
    }

    public void setTbProdutosInformacoesComerciaisId(ProdutosInformacoesComerciais tbProdutosInformacoesComerciaisId) {
        this.tbProdutosInformacoesComerciaisId = tbProdutosInformacoesComerciaisId;
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
        if (!(object instanceof NFeItens)) {
            return false;
        }
        NFeItens other = (NFeItens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.NFeItens[ id=" + id + " ]";
    }
    
}
