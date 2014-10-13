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
@Table(name = "tbProdutosConfiguracoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProdutosConfiguracoes.findAll", query = "SELECT p FROM ProdutosConfiguracoes p"),
    @NamedQuery(name = "ProdutosConfiguracoes.findById", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.id = :id"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByExportarXLS", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.exportarXLS = :exportarXLS"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByExportarPDF", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.exportarPDF = :exportarPDF"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByCompactarArquivoFormatoZIP", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.compactarArquivoFormatoZIP = :compactarArquivoFormatoZIP"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailEnderecoServidorPop", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailEnderecoServidorPop = :enviarEmailEnderecoServidorPop"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailSemEncriptacao", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailSemEncriptacao = :enviarEmailSemEncriptacao"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailComEncriptacaoSSL", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailComEncriptacaoSSL = :enviarEmailComEncriptacaoSSL"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailPorta", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailPorta = :enviarEmailPorta"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailRequerAutenticacao", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailRequerAutenticacao = :enviarEmailRequerAutenticacao"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailRemetenteEmail", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailRemetenteEmail = :enviarEmailRemetenteEmail"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailRemetenteSenha", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailRemetenteSenha = :enviarEmailRemetenteSenha"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailDestino", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailDestino = :enviarEmailDestino"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailEnviarArquivoXML", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailEnviarArquivoXML = :enviarEmailEnviarArquivoXML"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailEnviarArquivoPDF", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailEnviarArquivoPDF = :enviarEmailEnviarArquivoPDF"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByEnviarEmailCompactarArquivoFormatoZIP", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.enviarEmailCompactarArquivoFormatoZIP = :enviarEmailCompactarArquivoFormatoZIP"),
    @NamedQuery(name = "ProdutosConfiguracoes.findByDataInclusao", query = "SELECT p FROM ProdutosConfiguracoes p WHERE p.dataInclusao = :dataInclusao")})
public class ProdutosConfiguracoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ExportarXLS")
    private boolean exportarXLS;
    @Basic(optional = false)
    @Column(name = "ExportarPDF")
    private boolean exportarPDF;
    @Basic(optional = false)
    @Column(name = "CompactarArquivoFormatoZIP")
    private boolean compactarArquivoFormatoZIP;
    @Column(name = "EnviarEmailEnderecoServidorPop")
    private String enviarEmailEnderecoServidorPop;
    @Basic(optional = false)
    @Column(name = "EnviarEmailSemEncriptacao")
    private boolean enviarEmailSemEncriptacao;
    @Basic(optional = false)
    @Column(name = "EnviarEmailComEncriptacaoSSL")
    private boolean enviarEmailComEncriptacaoSSL;
    @Column(name = "EnviarEmailPorta")
    private String enviarEmailPorta;
    @Basic(optional = false)
    @Column(name = "EnviarEmailRequerAutenticacao")
    private boolean enviarEmailRequerAutenticacao;
    @Column(name = "EnviarEmailRemetenteEmail")
    private String enviarEmailRemetenteEmail;
    @Column(name = "EnviarEmailRemetenteSenha")
    private String enviarEmailRemetenteSenha;
    @Column(name = "EnviarEmailDestino")
    private String enviarEmailDestino;
    @Basic(optional = false)
    @Column(name = "EnviarEmailEnviarArquivoXML")
    private boolean enviarEmailEnviarArquivoXML;
    @Basic(optional = false)
    @Column(name = "EnviarEmailEnviarArquivoPDF")
    private boolean enviarEmailEnviarArquivoPDF;
    @Basic(optional = false)
    @Column(name = "EnviarEmailCompactarArquivoFormatoZIP")
    private boolean enviarEmailCompactarArquivoFormatoZIP;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;

    public ProdutosConfiguracoes() {
    }

    public ProdutosConfiguracoes(Integer id) {
        this.id = id;
    }

    public ProdutosConfiguracoes(Integer id, boolean exportarXLS, boolean exportarPDF, boolean compactarArquivoFormatoZIP, boolean enviarEmailSemEncriptacao, boolean enviarEmailComEncriptacaoSSL, boolean enviarEmailRequerAutenticacao, boolean enviarEmailEnviarArquivoXML, boolean enviarEmailEnviarArquivoPDF, boolean enviarEmailCompactarArquivoFormatoZIP, Date dataInclusao) {
        this.id = id;
        this.exportarXLS = exportarXLS;
        this.exportarPDF = exportarPDF;
        this.compactarArquivoFormatoZIP = compactarArquivoFormatoZIP;
        this.enviarEmailSemEncriptacao = enviarEmailSemEncriptacao;
        this.enviarEmailComEncriptacaoSSL = enviarEmailComEncriptacaoSSL;
        this.enviarEmailRequerAutenticacao = enviarEmailRequerAutenticacao;
        this.enviarEmailEnviarArquivoXML = enviarEmailEnviarArquivoXML;
        this.enviarEmailEnviarArquivoPDF = enviarEmailEnviarArquivoPDF;
        this.enviarEmailCompactarArquivoFormatoZIP = enviarEmailCompactarArquivoFormatoZIP;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getExportarXLS() {
        return exportarXLS;
    }

    public void setExportarXLS(boolean exportarXLS) {
        this.exportarXLS = exportarXLS;
    }

    public boolean getExportarPDF() {
        return exportarPDF;
    }

    public void setExportarPDF(boolean exportarPDF) {
        this.exportarPDF = exportarPDF;
    }

    public boolean getCompactarArquivoFormatoZIP() {
        return compactarArquivoFormatoZIP;
    }

    public void setCompactarArquivoFormatoZIP(boolean compactarArquivoFormatoZIP) {
        this.compactarArquivoFormatoZIP = compactarArquivoFormatoZIP;
    }

    public String getEnviarEmailEnderecoServidorPop() {
        return enviarEmailEnderecoServidorPop;
    }

    public void setEnviarEmailEnderecoServidorPop(String enviarEmailEnderecoServidorPop) {
        this.enviarEmailEnderecoServidorPop = enviarEmailEnderecoServidorPop;
    }

    public boolean getEnviarEmailSemEncriptacao() {
        return enviarEmailSemEncriptacao;
    }

    public void setEnviarEmailSemEncriptacao(boolean enviarEmailSemEncriptacao) {
        this.enviarEmailSemEncriptacao = enviarEmailSemEncriptacao;
    }

    public boolean getEnviarEmailComEncriptacaoSSL() {
        return enviarEmailComEncriptacaoSSL;
    }

    public void setEnviarEmailComEncriptacaoSSL(boolean enviarEmailComEncriptacaoSSL) {
        this.enviarEmailComEncriptacaoSSL = enviarEmailComEncriptacaoSSL;
    }

    public String getEnviarEmailPorta() {
        return enviarEmailPorta;
    }

    public void setEnviarEmailPorta(String enviarEmailPorta) {
        this.enviarEmailPorta = enviarEmailPorta;
    }

    public boolean getEnviarEmailRequerAutenticacao() {
        return enviarEmailRequerAutenticacao;
    }

    public void setEnviarEmailRequerAutenticacao(boolean enviarEmailRequerAutenticacao) {
        this.enviarEmailRequerAutenticacao = enviarEmailRequerAutenticacao;
    }

    public String getEnviarEmailRemetenteEmail() {
        return enviarEmailRemetenteEmail;
    }

    public void setEnviarEmailRemetenteEmail(String enviarEmailRemetenteEmail) {
        this.enviarEmailRemetenteEmail = enviarEmailRemetenteEmail;
    }

    public String getEnviarEmailRemetenteSenha() {
        return enviarEmailRemetenteSenha;
    }

    public void setEnviarEmailRemetenteSenha(String enviarEmailRemetenteSenha) {
        this.enviarEmailRemetenteSenha = enviarEmailRemetenteSenha;
    }

    public String getEnviarEmailDestino() {
        return enviarEmailDestino;
    }

    public void setEnviarEmailDestino(String enviarEmailDestino) {
        this.enviarEmailDestino = enviarEmailDestino;
    }

    public boolean getEnviarEmailEnviarArquivoXML() {
        return enviarEmailEnviarArquivoXML;
    }

    public void setEnviarEmailEnviarArquivoXML(boolean enviarEmailEnviarArquivoXML) {
        this.enviarEmailEnviarArquivoXML = enviarEmailEnviarArquivoXML;
    }

    public boolean getEnviarEmailEnviarArquivoPDF() {
        return enviarEmailEnviarArquivoPDF;
    }

    public void setEnviarEmailEnviarArquivoPDF(boolean enviarEmailEnviarArquivoPDF) {
        this.enviarEmailEnviarArquivoPDF = enviarEmailEnviarArquivoPDF;
    }

    public boolean getEnviarEmailCompactarArquivoFormatoZIP() {
        return enviarEmailCompactarArquivoFormatoZIP;
    }

    public void setEnviarEmailCompactarArquivoFormatoZIP(boolean enviarEmailCompactarArquivoFormatoZIP) {
        this.enviarEmailCompactarArquivoFormatoZIP = enviarEmailCompactarArquivoFormatoZIP;
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
        if (!(object instanceof ProdutosConfiguracoes)) {
            return false;
        }
        ProdutosConfiguracoes other = (ProdutosConfiguracoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.ProdutosConfiguracoes[ id=" + id + " ]";
    }
    
}
