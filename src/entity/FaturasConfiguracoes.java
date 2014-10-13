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
@Table(name = "tbFaturasConfiguracoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FaturasConfiguracoes.findAll", query = "SELECT f FROM FaturasConfiguracoes f"),
    @NamedQuery(name = "FaturasConfiguracoes.findById", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.id = :id"),
    @NamedQuery(name = "FaturasConfiguracoes.findByExportarXLS", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.exportarXLS = :exportarXLS"),
    @NamedQuery(name = "FaturasConfiguracoes.findByExportarPDF", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.exportarPDF = :exportarPDF"),
    @NamedQuery(name = "FaturasConfiguracoes.findByCompactarArquivoFormatoZIP", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.compactarArquivoFormatoZIP = :compactarArquivoFormatoZIP"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailEnderecoServidorPop", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailEnderecoServidorPop = :enviarEmailEnderecoServidorPop"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailSemEncriptacao", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailSemEncriptacao = :enviarEmailSemEncriptacao"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailComEncriptacaoSSL", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailComEncriptacaoSSL = :enviarEmailComEncriptacaoSSL"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailPorta", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailPorta = :enviarEmailPorta"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailRequerAutenticacao", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailRequerAutenticacao = :enviarEmailRequerAutenticacao"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailRemetenteEmail", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailRemetenteEmail = :enviarEmailRemetenteEmail"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailRemetenteSenha", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailRemetenteSenha = :enviarEmailRemetenteSenha"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailDestino", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailDestino = :enviarEmailDestino"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailEnviarArquivoXML", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailEnviarArquivoXML = :enviarEmailEnviarArquivoXML"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailEnviarArquivoPDF", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailEnviarArquivoPDF = :enviarEmailEnviarArquivoPDF"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailCompactarArquivoFormatoZIP", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailCompactarArquivoFormatoZIP = :enviarEmailCompactarArquivoFormatoZIP"),
    @NamedQuery(name = "FaturasConfiguracoes.findByEnviarEmailAutomaticoAlertantoVencimentoFaturas", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.enviarEmailAutomaticoAlertantoVencimentoFaturas = :enviarEmailAutomaticoAlertantoVencimentoFaturas"),
    @NamedQuery(name = "FaturasConfiguracoes.findByDataInclusao", query = "SELECT f FROM FaturasConfiguracoes f WHERE f.dataInclusao = :dataInclusao")})
public class FaturasConfiguracoes implements Serializable {
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
    @Column(name = "EnviarEmailAutomaticoAlertantoVencimentoFaturas")
    private boolean enviarEmailAutomaticoAlertantoVencimentoFaturas;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;

    public FaturasConfiguracoes() {
    }

    public FaturasConfiguracoes(Integer id) {
        this.id = id;
    }

    public FaturasConfiguracoes(Integer id, boolean exportarXLS, boolean exportarPDF, boolean compactarArquivoFormatoZIP, boolean enviarEmailSemEncriptacao, boolean enviarEmailComEncriptacaoSSL, boolean enviarEmailRequerAutenticacao, boolean enviarEmailEnviarArquivoXML, boolean enviarEmailEnviarArquivoPDF, boolean enviarEmailCompactarArquivoFormatoZIP, boolean enviarEmailAutomaticoAlertantoVencimentoFaturas, Date dataInclusao) {
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
        this.enviarEmailAutomaticoAlertantoVencimentoFaturas = enviarEmailAutomaticoAlertantoVencimentoFaturas;
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

    public boolean getEnviarEmailAutomaticoAlertantoVencimentoFaturas() {
        return enviarEmailAutomaticoAlertantoVencimentoFaturas;
    }

    public void setEnviarEmailAutomaticoAlertantoVencimentoFaturas(boolean enviarEmailAutomaticoAlertantoVencimentoFaturas) {
        this.enviarEmailAutomaticoAlertantoVencimentoFaturas = enviarEmailAutomaticoAlertantoVencimentoFaturas;
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
        if (!(object instanceof FaturasConfiguracoes)) {
            return false;
        }
        FaturasConfiguracoes other = (FaturasConfiguracoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.FaturasConfiguracoes[ id=" + id + " ]";
    }
    
}
