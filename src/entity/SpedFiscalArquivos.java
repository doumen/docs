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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbSpedFiscalArquivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpedFiscalArquivos.findAll", query = "SELECT s FROM SpedFiscalArquivos s"),
    @NamedQuery(name = "SpedFiscalArquivos.findById", query = "SELECT s FROM SpedFiscalArquivos s WHERE s.id = :id"),
    @NamedQuery(name = "SpedFiscalArquivos.findByDataInclusao", query = "SELECT s FROM SpedFiscalArquivos s WHERE s.dataInclusao = :dataInclusao")})
public class SpedFiscalArquivos implements Serializable,Arquivo {
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
    /*
    @JoinColumn(name = "tbSpedFiscal_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    */
    @Transient
    private SpedFiscal tbSpedFiscalId;

    public SpedFiscalArquivos() {
    }

    public SpedFiscalArquivos(Integer id) {
        this.id = id;
    }

    public SpedFiscalArquivos(Integer id, byte[] arquivoSpedFiscalTXT, Date dataInclusao) {
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

    public SpedFiscal getTbSpedFiscalId() {
        return tbSpedFiscalId;
    }

    public void setTbSpedFiscalId(SpedFiscal tbSpedFiscalId) {
        this.tbSpedFiscalId = tbSpedFiscalId;
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
        if (!(object instanceof SpedFiscalArquivos)) {
            return false;
        }
        SpedFiscalArquivos other = (SpedFiscalArquivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.SpedFiscalArquivos[ id=" + id + " ]";
    }

	@Override
	public byte[] getArquivoXML() {
		return getArquivoSpedFiscalTXT();
	}

	@Override
	public void setArquivoXML(byte[] arquivoXML) {
		setArquivoSpedFiscalTXT(arquivoXML);
	}

	@Override
	public void setDocto(Docto d) {
		setTbSpedFiscalId((SpedFiscal) d);
	}

	@Override
	public Docto getDocto() {
		return (Docto) getTbSpedFiscalId();
	}
    
}
