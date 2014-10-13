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
@Table(name = "tbTipi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipi.findAll", query = "SELECT t FROM Tipi t"),
    @NamedQuery(name = "Tipi.findById", query = "SELECT t FROM Tipi t WHERE t.id = :id"),
    @NamedQuery(name = "Tipi.findByNcm", query = "SELECT t FROM Tipi t WHERE t.ncm = :ncm"),
    @NamedQuery(name = "Tipi.findByNcmEx", query = "SELECT t FROM Tipi t WHERE t.ncmEx = :ncmEx"),
    @NamedQuery(name = "Tipi.findByDescricao", query = "SELECT t FROM Tipi t WHERE t.descricao = :descricao"),
    @NamedQuery(name = "Tipi.findByAliquota", query = "SELECT t FROM Tipi t WHERE t.aliquota = :aliquota"),
    @NamedQuery(name = "Tipi.findByDataInclusao", query = "SELECT t FROM Tipi t WHERE t.dataInclusao = :dataInclusao")})
public class Tipi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Ncm")
    private int ncm;
    @Column(name = "NcmEx")
    private Integer ncmEx;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Aliquota")
    private BigDecimal aliquota;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbTipiId", fetch = FetchType.LAZY)
    private List<Ipi> ipiList;

    public Tipi() {
    }

    public Tipi(Integer id) {
        this.id = id;
    }

    public Tipi(Integer id, int ncm, String descricao, BigDecimal aliquota, Date dataInclusao) {
        this.id = id;
        this.ncm = ncm;
        this.descricao = descricao;
        this.aliquota = aliquota;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
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
        if (!(object instanceof Tipi)) {
            return false;
        }
        Tipi other = (Tipi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Tipi[ id=" + id + " ]";
    }
    
}
