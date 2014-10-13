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
@Table(name = "tbCodigoEnquadramentoLegalIpi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodigoEnquadramentoLegalIpi.findAll", query = "SELECT c FROM CodigoEnquadramentoLegalIpi c"),
    @NamedQuery(name = "CodigoEnquadramentoLegalIpi.findById", query = "SELECT c FROM CodigoEnquadramentoLegalIpi c WHERE c.id = :id"),
    @NamedQuery(name = "CodigoEnquadramentoLegalIpi.findByCodigo", query = "SELECT c FROM CodigoEnquadramentoLegalIpi c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "CodigoEnquadramentoLegalIpi.findByDescricao", query = "SELECT c FROM CodigoEnquadramentoLegalIpi c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "CodigoEnquadramentoLegalIpi.findByDataInclusao", query = "SELECT c FROM CodigoEnquadramentoLegalIpi c WHERE c.dataInclusao = :dataInclusao")})
public class CodigoEnquadramentoLegalIpi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Codigo")
    private int codigo;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCodigoEnquadramentoLegalIpiId", fetch = FetchType.LAZY)
    private List<Ipi> ipiList;

    public CodigoEnquadramentoLegalIpi() {
    }

    public CodigoEnquadramentoLegalIpi(Integer id) {
        this.id = id;
    }

    public CodigoEnquadramentoLegalIpi(Integer id, int codigo, String descricao, Date dataInclusao) {
        this.id = id;
        this.codigo = codigo;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(object instanceof CodigoEnquadramentoLegalIpi)) {
            return false;
        }
        CodigoEnquadramentoLegalIpi other = (CodigoEnquadramentoLegalIpi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.CodigoEnquadramentoLegalIpi[ id=" + id + " ]";
    }
    
}
