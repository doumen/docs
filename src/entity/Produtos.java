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
@Table(name = "tbProdutos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findById", query = "SELECT p FROM Produtos p WHERE p.id = :id"),
    @NamedQuery(name = "Produtos.findByCodigo", query = "SELECT p FROM Produtos p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Produtos.findByCodigoBarras", query = "SELECT p FROM Produtos p WHERE p.codigoBarras = :codigoBarras"),
    @NamedQuery(name = "Produtos.findByCodigoBarrasTributavel", query = "SELECT p FROM Produtos p WHERE p.codigoBarrasTributavel = :codigoBarrasTributavel"),
    @NamedQuery(name = "Produtos.findByTipoProduto", query = "SELECT p FROM Produtos p WHERE p.tipoProduto = :tipoProduto"),
    @NamedQuery(name = "Produtos.findByDescricaoAssinante", query = "SELECT p FROM Produtos p WHERE p.descricaoAssinante = :descricaoAssinante"),
    @NamedQuery(name = "Produtos.findByDescricaoFornecedor", query = "SELECT p FROM Produtos p WHERE p.descricaoFornecedor = :descricaoFornecedor"),
    @NamedQuery(name = "Produtos.findByNcm", query = "SELECT p FROM Produtos p WHERE p.ncm = :ncm"),
    @NamedQuery(name = "Produtos.findByNcmEx", query = "SELECT p FROM Produtos p WHERE p.ncmEx = :ncmEx"),
    @NamedQuery(name = "Produtos.findByUnidadeMedidaTributavel", query = "SELECT p FROM Produtos p WHERE p.unidadeMedidaTributavel = :unidadeMedidaTributavel"),
    @NamedQuery(name = "Produtos.findByDataInclusao", query = "SELECT p FROM Produtos p WHERE p.dataInclusao = :dataInclusao")})
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Codigo")
    private String codigo;
    @Column(name = "CodigoBarras")
    private Integer codigoBarras;
    @Column(name = "CodigoBarrasTributavel")
    private Integer codigoBarrasTributavel;
    @Basic(optional = false)
    @Column(name = "TipoProduto")
    private Character tipoProduto;
    @Column(name = "DescricaoAssinante")
    private String descricaoAssinante;
    @Column(name = "DescricaoFornecedor")
    private String descricaoFornecedor;
    @Basic(optional = false)
    @Column(name = "Ncm")
    private int ncm;
    @Column(name = "NcmEx")
    private Integer ncmEx;
    @Basic(optional = false)
    @Column(name = "UnidadeMedidaTributavel")
    private String unidadeMedidaTributavel;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbCfop_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cfop tbCfopId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProdutosId", fetch = FetchType.LAZY)
    private List<NFeItens> nFeItensList;

    public Produtos() {
    }

    public Produtos(Integer id) {
        this.id = id;
    }

    public Produtos(Integer id, String codigo, Character tipoProduto, int ncm, String unidadeMedidaTributavel, Date dataInclusao) {
        this.id = id;
        this.codigo = codigo;
        this.tipoProduto = tipoProduto;
        this.ncm = ncm;
        this.unidadeMedidaTributavel = unidadeMedidaTributavel;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Character getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(Character tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public String getDescricaoAssinante() {
        return descricaoAssinante;
    }

    public void setDescricaoAssinante(String descricaoAssinante) {
        this.descricaoAssinante = descricaoAssinante;
    }

    public String getDescricaoFornecedor() {
        return descricaoFornecedor;
    }

    public void setDescricaoFornecedor(String descricaoFornecedor) {
        this.descricaoFornecedor = descricaoFornecedor;
    }

    public int getNcm() {
        return ncm;
    }

    public void setNcm(int ncm) {
        this.ncm = ncm;
    }

    public Integer getNcmEx() {
        return ncmEx;
    }

    public void setNcmEx(Integer ncmEx) {
        this.ncmEx = ncmEx;
    }

    public String getUnidadeMedidaTributavel() {
        return unidadeMedidaTributavel;
    }

    public void setUnidadeMedidaTributavel(String unidadeMedidaTributavel) {
        this.unidadeMedidaTributavel = unidadeMedidaTributavel;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Cfop getTbCfopId() {
        return tbCfopId;
    }

    public void setTbCfopId(Cfop tbCfopId) {
        this.tbCfopId = tbCfopId;
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
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Produtos[ id=" + id + " ]";
    }
    
}
