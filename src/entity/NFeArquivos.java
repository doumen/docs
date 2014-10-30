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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbNFeArquivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NFeArquivos.findAll", query = "SELECT n FROM NFeArquivos n"),
    @NamedQuery(name = "NFeArquivos.findById", query = "SELECT n FROM NFeArquivos n WHERE n.id = :id"),
    @NamedQuery(name = "NFeArquivos.findByDataInclusao", query = "SELECT n FROM NFeArquivos n WHERE n.dataInclusao = :dataInclusao")})
public class NFeArquivos implements Serializable,Arquivo {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "ArquivoNFeXML")
    private byte[] arquivoNFeXML;
    @Basic(optional = false)
    @Lob
    @Column(name = "ArquivoDanfePDF")
    private byte[] arquivoDanfePDF;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    /*
    @JoinColumn(name = "tbNFe_Id", referencedColumnName = "Id")
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    */
    @Column(name = "tbNFe_Id")
    private NFe tbNFeId;

    public NFeArquivos() {
    }

    public NFeArquivos(Integer id) {
        this.id = id;
    }

    public NFeArquivos(Integer id, byte[] arquivoNFeXML, byte[] arquivoDanfePDF, Date dataInclusao) {
        this.id = id;
        this.arquivoNFeXML = arquivoNFeXML;
        this.arquivoDanfePDF = arquivoDanfePDF;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getArquivoNFeXML() {
        return arquivoNFeXML;
    }

    public void setArquivoNFeXML(byte[] arquivoNFeXML) {
        this.arquivoNFeXML = arquivoNFeXML;
    }

    public byte[] getArquivoDanfePDF() {
        return arquivoDanfePDF;
    }

    public void setArquivoDanfePDF(byte[] arquivoDanfePDF) {
        this.arquivoDanfePDF = arquivoDanfePDF;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public NFe getTbNFeId() {
        return tbNFeId;
    }

    public void setTbNFeId(NFe tbNFeId) {
        this.tbNFeId = tbNFeId;
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
        if (!(object instanceof NFeArquivos)) {
            return false;
        }
        NFeArquivos other = (NFeArquivos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.NFeArquivos[ id=" + id + " ]";
    }

	@Override
	public byte[] getArquivoXML() {
		return getArquivoNFeXML();
	}

	@Override
	public void setArquivoXML(byte[] arquivoXML) {
		setArquivoNFeXML(arquivoXML);
	}

	@Override
	public void setDocto(Docto d) {
		setTbNFeId(new NFe(d.getId()));		
	}

	@Override
	public Docto getDocto() {
		return getTbNFeId();
	}
    
}
