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
@Table(name = "tbCertificadoA1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CertificadoA1.findAll", query = "SELECT c FROM CertificadoA1 c"),
    @NamedQuery(name = "CertificadoA1.findById", query = "SELECT c FROM CertificadoA1 c WHERE c.id = :id"),
    @NamedQuery(name = "CertificadoA1.findByNotificarExpiracaoCertificado", query = "SELECT c FROM CertificadoA1 c WHERE c.notificarExpiracaoCertificado = :notificarExpiracaoCertificado"),
    @NamedQuery(name = "CertificadoA1.findByDataInclusao", query = "SELECT c FROM CertificadoA1 c WHERE c.dataInclusao = :dataInclusao")})
public class CertificadoA1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "ArquivoPFX_CertificadoA1")
    private byte[] arquivoPFXCertificadoA1;
    @Basic(optional = false)
    @Column(name = "NotificarExpiracaoCertificado")
    private boolean notificarExpiracaoCertificado;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;

    public CertificadoA1() {
    }

    public CertificadoA1(Integer id) {
        this.id = id;
    }

    public CertificadoA1(Integer id, byte[] arquivoPFXCertificadoA1, boolean notificarExpiracaoCertificado, Date dataInclusao) {
        this.id = id;
        this.arquivoPFXCertificadoA1 = arquivoPFXCertificadoA1;
        this.notificarExpiracaoCertificado = notificarExpiracaoCertificado;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getArquivoPFXCertificadoA1() {
        return arquivoPFXCertificadoA1;
    }

    public void setArquivoPFXCertificadoA1(byte[] arquivoPFXCertificadoA1) {
        this.arquivoPFXCertificadoA1 = arquivoPFXCertificadoA1;
    }

    public boolean getNotificarExpiracaoCertificado() {
        return notificarExpiracaoCertificado;
    }

    public void setNotificarExpiracaoCertificado(boolean notificarExpiracaoCertificado) {
        this.notificarExpiracaoCertificado = notificarExpiracaoCertificado;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Assinante getTbAssinantesId() {
        return tbAssinantesId;
    }

    public void setTbAssinantesId(Assinante tbAssinantesId) {
        this.tbAssinantesId = tbAssinantesId;
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
        if (!(object instanceof CertificadoA1)) {
            return false;
        }
        CertificadoA1 other = (CertificadoA1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.CertificadoA1[ id=" + id + " ]";
    }
    
}
