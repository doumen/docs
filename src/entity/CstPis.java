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
@Table(name = "tbCstPis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CstPis.findAll", query = "SELECT c FROM CstPis c"),
    @NamedQuery(name = "CstPis.findById", query = "SELECT c FROM CstPis c WHERE c.id = :id"),
    @NamedQuery(name = "CstPis.findByCst", query = "SELECT c FROM CstPis c WHERE c.cst = :cst"),
    @NamedQuery(name = "CstPis.findByDescricao", query = "SELECT c FROM CstPis c WHERE c.descricao = :descricao"),
    @NamedQuery(name = "CstPis.findByDataInclusao", query = "SELECT c FROM CstPis c WHERE c.dataInclusao = :dataInclusao")})
public class CstPis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Cst")
    private int cst;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbCstPisId", fetch = FetchType.LAZY)
    private List<Pis> pisList;

    public CstPis() {
    }

    public CstPis(Integer id) {
        this.id = id;
    }

    public CstPis(Integer id, int cst, String descricao, Date dataInclusao) {
        this.id = id;
        this.cst = cst;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCst() {
        return cst;
    }

    public void setCst(int cst) {
        this.cst = cst;
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
    public List<Pis> getPisList() {
        return pisList;
    }

    public void setPisList(List<Pis> pisList) {
        this.pisList = pisList;
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
        if (!(object instanceof CstPis)) {
            return false;
        }
        CstPis other = (CstPis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.CstPis[ id=" + id + " ]";
    }
    
}
