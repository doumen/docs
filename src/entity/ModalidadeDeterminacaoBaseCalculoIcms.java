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
@Table(name = "tbModalidadeDeterminacaoBaseCalculoIcms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModalidadeDeterminacaoBaseCalculoIcms.findAll", query = "SELECT m FROM ModalidadeDeterminacaoBaseCalculoIcms m"),
    @NamedQuery(name = "ModalidadeDeterminacaoBaseCalculoIcms.findById", query = "SELECT m FROM ModalidadeDeterminacaoBaseCalculoIcms m WHERE m.id = :id"),
    @NamedQuery(name = "ModalidadeDeterminacaoBaseCalculoIcms.findByModelo", query = "SELECT m FROM ModalidadeDeterminacaoBaseCalculoIcms m WHERE m.modelo = :modelo"),
    @NamedQuery(name = "ModalidadeDeterminacaoBaseCalculoIcms.findByDescricao", query = "SELECT m FROM ModalidadeDeterminacaoBaseCalculoIcms m WHERE m.descricao = :descricao"),
    @NamedQuery(name = "ModalidadeDeterminacaoBaseCalculoIcms.findByDataInclusao", query = "SELECT m FROM ModalidadeDeterminacaoBaseCalculoIcms m WHERE m.dataInclusao = :dataInclusao")})
public class ModalidadeDeterminacaoBaseCalculoIcms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Modelo")
    private int modelo;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbModelalidadeDeterminacaoBaseCalculoIcmsId", fetch = FetchType.LAZY)
    private List<Icms> icmsList;

    public ModalidadeDeterminacaoBaseCalculoIcms() {
    }

    public ModalidadeDeterminacaoBaseCalculoIcms(Integer id) {
        this.id = id;
    }

    public ModalidadeDeterminacaoBaseCalculoIcms(Integer id, int modelo, String descricao, Date dataInclusao) {
        this.id = id;
        this.modelo = modelo;
        this.descricao = descricao;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
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
    public List<Icms> getIcmsList() {
        return icmsList;
    }

    public void setIcmsList(List<Icms> icmsList) {
        this.icmsList = icmsList;
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
        if (!(object instanceof ModalidadeDeterminacaoBaseCalculoIcms)) {
            return false;
        }
        ModalidadeDeterminacaoBaseCalculoIcms other = (ModalidadeDeterminacaoBaseCalculoIcms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ModalidadeDeterminacaoBaseCalculoIcms[ id=" + id + " ]";
    }
    
}
