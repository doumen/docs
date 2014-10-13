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
@Table(name = "tbSpedContribuicoesArquivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpedContribuicoesArquivos.findAll", query = "SELECT s FROM SpedContribuicoesArquivos s"),
    @NamedQuery(name = "SpedContribuicoesArquivos.findById", query = "SELECT s FROM SpedContribuicoesArquivos s WHERE s.id = :id"),
    @NamedQuery(name = "SpedContribuicoesArquivos.findByDataInclusao", query = "SELECT s FROM SpedContribuicoesArquivos s WHERE s.dataInclusao = :dataInclusao")})
public class SpedContribuicoesArquivos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "ArquivoSpedFiscalTXT")
    private byte[] arquivoSpedFiscalTXT;
    @Lob
    @Column(name = "ArquivoResultadoValidacaoPDF")
    private byte[] arquivoResultadoValidacaoPDF;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbSpedContribuicoes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SpedContribuicoes tbSpedContribuicoesId;

    public SpedContribuicoesArquivos() {
    }

    public SpedContribuicoesArquivos(Integer id) {
        this.id = id;
    }

    public SpedContribuicoesArquivos(Integer id, byte[] arquivoSpedFiscalTXT, Date dataInclusao) {
        this.id = id;
        this.arquivoSpedFiscalTXT = arquivoSpedFiscalTXT;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getArquivoSpedFiscalTXT() {
        return arquivoSpedFiscalTXT;
    }

    public void setArquivoSpedFiscalTXT(byte[] arquivoSpedFiscalTXT) {
        this.arquivoSpedFiscalTXT = arquivoSpedFiscalTXT;
    }

    public byte[] getArquivoResultadoValidacaoPDF() {
        return arquivoResultadoValidacaoPDF;
    }

    public void setArquivoResultadoValidacaoPDF(byte[] arquivoResultadoValidacaoPDF) {
        this.arquivoResultadoValidacaoPDF = arquivoResultadoValidacaoPDF;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public SpedContribuicoes getTbSpedContribuicoesId() {
        return tbSpedContribuicoesId;
    }

    public void setTbSpedContribuicoesId(SpedContribuicoes tbSpedContribuicoesId) {
        this.tbSpedContribuicoesId = tbSpedContribuicoesId;
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
        if (!(object instanceof SpedContribuicoesArquivos)) {
            return false;
        }
        SpedContribuicoesArquivos other = (SpedContribuicoesArquivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.SpedContribuicoesArquivos[ id=" + id + " ]";
    }
    
}
