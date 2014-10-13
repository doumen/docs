/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbCTeArquivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTeArquivos.findAll", query = "SELECT c FROM CTeArquivos c"),
    @NamedQuery(name = "CTeArquivos.findById", query = "SELECT c FROM CTeArquivos c WHERE c.id = :id"),
    @NamedQuery(name = "CTeArquivos.findByDataInclusao", query = "SELECT c FROM CTeArquivos c WHERE c.dataInclusao = :dataInclusao")})
public class CTeArquivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "ArquivoCTeXML")
    private byte[] arquivoCTeXML;
    @Basic(optional = false)
    @Lob
    @Column(name = "ArquivoDactePDF")
    private byte[] arquivoDactePDF;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbCTe_Id", referencedColumnName = "Id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private CTe tbCTeId;

    public CTeArquivos() {
    }

    public CTeArquivos(Integer id) {
        this.id = id;
    }

    public CTeArquivos(Integer id, byte[] arquivoCTeXML, byte[] arquivoDactePDF, Date dataInclusao) {
        this.id = id;
        this.arquivoCTeXML = arquivoCTeXML;
        this.arquivoDactePDF = arquivoDactePDF;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getArquivoCTeXML() {
        return arquivoCTeXML;
    }

    public void setArquivoCTeXML(byte[] arquivoCTeXML) {
        this.arquivoCTeXML = arquivoCTeXML;
    }

    public byte[] getArquivoDactePDF() {
        return arquivoDactePDF;
    }

    public void setArquivoDactePDF(byte[] arquivoDactePDF) {
        this.arquivoDactePDF = arquivoDactePDF;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public CTe getTbCTeId() {
        return tbCTeId;
    }

    public void setTbCTeId(CTe tbCTeId) {
        this.tbCTeId = tbCTeId;
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
        if (!(object instanceof CTeArquivos)) {
            return false;
        }
        CTeArquivos other = (CTeArquivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.CTeArquivos[ id=" + id + " ]";
    }
    
}
