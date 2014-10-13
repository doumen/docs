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
@Table(name = "tbNFeConfiguracoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NFeConfiguracoes.findAll", query = "SELECT n FROM NFeConfiguracoes n"),
    @NamedQuery(name = "NFeConfiguracoes.findById", query = "SELECT n FROM NFeConfiguracoes n WHERE n.id = :id"),
    @NamedQuery(name = "NFeConfiguracoes.findByDownloadBaixarArquivoXML", query = "SELECT n FROM NFeConfiguracoes n WHERE n.downloadBaixarArquivoXML = :downloadBaixarArquivoXML"),
    @NamedQuery(name = "NFeConfiguracoes.findByDownloadBaixarArquivoPDF", query = "SELECT n FROM NFeConfiguracoes n WHERE n.downloadBaixarArquivoPDF = :downloadBaixarArquivoPDF"),
    @NamedQuery(name = "NFeConfiguracoes.findByDownloadCompactarArquivoFormatoZIP", query = "SELECT n FROM NFeConfiguracoes n WHERE n.downloadCompactarArquivoFormatoZIP = :downloadCompactarArquivoFormatoZIP"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailEnderecoServidorPop", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailEnderecoServidorPop = :enviarEmailEnderecoServidorPop"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailSemEncriptacao", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailSemEncriptacao = :enviarEmailSemEncriptacao"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailComEncriptacaoSSL", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailComEncriptacaoSSL = :enviarEmailComEncriptacaoSSL"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailPorta", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailPorta = :enviarEmailPorta"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailRequerAutenticacao", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailRequerAutenticacao = :enviarEmailRequerAutenticacao"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailRemetenteEmail", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailRemetenteEmail = :enviarEmailRemetenteEmail"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailRemetenteSenha", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailRemetenteSenha = :enviarEmailRemetenteSenha"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailDestino", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailDestino = :enviarEmailDestino"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailEnviarArquivoXML", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailEnviarArquivoXML = :enviarEmailEnviarArquivoXML"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailEnviarArquivoPDF", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailEnviarArquivoPDF = :enviarEmailEnviarArquivoPDF"),
    @NamedQuery(name = "NFeConfiguracoes.findByEnviarEmailCompactarArquivoFormatoZIP", query = "SELECT n FROM NFeConfiguracoes n WHERE n.enviarEmailCompactarArquivoFormatoZIP = :enviarEmailCompactarArquivoFormatoZIP"),
    @NamedQuery(name = "NFeConfiguracoes.findByReceberEmailEnderecoServidorSMTP", query = "SELECT n FROM NFeConfiguracoes n WHERE n.receberEmailEnderecoServidorSMTP = :receberEmailEnderecoServidorSMTP"),
    @NamedQuery(name = "NFeConfiguracoes.findByReceberEmailSemEncriptacao", query = "SELECT n FROM NFeConfiguracoes n WHERE n.receberEmailSemEncriptacao = :receberEmailSemEncriptacao"),
    @NamedQuery(name = "NFeConfiguracoes.findByReceberEmailComEncriptacaoSSL", query = "SELECT n FROM NFeConfiguracoes n WHERE n.receberEmailComEncriptacaoSSL = :receberEmailComEncriptacaoSSL"),
    @NamedQuery(name = "NFeConfiguracoes.findByReceberEmailComEncriptacaoTLS", query = "SELECT n FROM NFeConfiguracoes n WHERE n.receberEmailComEncriptacaoTLS = :receberEmailComEncriptacaoTLS"),
    @NamedQuery(name = "NFeConfiguracoes.findByReceberEmailPorta", query = "SELECT n FROM NFeConfiguracoes n WHERE n.receberEmailPorta = :receberEmailPorta"),
    @NamedQuery(name = "NFeConfiguracoes.findByReceberEmailRequerAutenticacao", query = "SELECT n FROM NFeConfiguracoes n WHERE n.receberEmailRequerAutenticacao = :receberEmailRequerAutenticacao"),
    @NamedQuery(name = "NFeConfiguracoes.findByReceberEmailRemetenteEmail", query = "SELECT n FROM NFeConfiguracoes n WHERE n.receberEmailRemetenteEmail = :receberEmailRemetenteEmail"),
    @NamedQuery(name = "NFeConfiguracoes.findByReceberEmailRemetenteSenha", query = "SELECT n FROM NFeConfiguracoes n WHERE n.receberEmailRemetenteSenha = :receberEmailRemetenteSenha"),
    @NamedQuery(name = "NFeConfiguracoes.findByDataInclusao", query = "SELECT n FROM NFeConfiguracoes n WHERE n.dataInclusao = :dataInclusao")})
public class NFeConfiguracoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DownloadBaixarArquivoXML")
    private boolean downloadBaixarArquivoXML;
    @Basic(optional = false)
    @Column(name = "DownloadBaixarArquivoPDF")
    private boolean downloadBaixarArquivoPDF;
    @Basic(optional = false)
    @Column(name = "DownloadCompactarArquivoFormatoZIP")
    private boolean downloadCompactarArquivoFormatoZIP;
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
    @Column(name = "ReceberEmailEnderecoServidorSMTP")
    private String receberEmailEnderecoServidorSMTP;
    @Basic(optional = false)
    @Column(name = "ReceberEmailSemEncriptacao")
    private boolean receberEmailSemEncriptacao;
    @Basic(optional = false)
    @Column(name = "ReceberEmailComEncriptacaoSSL")
    private boolean receberEmailComEncriptacaoSSL;
    @Basic(optional = false)
    @Column(name = "ReceberEmailComEncriptacaoTLS")
    private boolean receberEmailComEncriptacaoTLS;
    @Column(name = "ReceberEmailPorta")
    private String receberEmailPorta;
    @Basic(optional = false)
    @Column(name = "ReceberEmailRequerAutenticacao")
    private boolean receberEmailRequerAutenticacao;
    @Basic(optional = false)
    @Column(name = "ReceberEmailRemetenteEmail")
    private String receberEmailRemetenteEmail;
    @Basic(optional = false)
    @Column(name = "ReceberEmailRemetenteSenha")
    private String receberEmailRemetenteSenha;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;

    public NFeConfiguracoes() {
    }

    public NFeConfiguracoes(Integer id) {
        this.id = id;
    }

    public NFeConfiguracoes(Integer id, boolean downloadBaixarArquivoXML, boolean downloadBaixarArquivoPDF, boolean downloadCompactarArquivoFormatoZIP, boolean enviarEmailSemEncriptacao, boolean enviarEmailComEncriptacaoSSL, boolean enviarEmailRequerAutenticacao, boolean enviarEmailEnviarArquivoXML, boolean enviarEmailEnviarArquivoPDF, boolean enviarEmailCompactarArquivoFormatoZIP, boolean receberEmailSemEncriptacao, boolean receberEmailComEncriptacaoSSL, boolean receberEmailComEncriptacaoTLS, boolean receberEmailRequerAutenticacao, String receberEmailRemetenteEmail, String receberEmailRemetenteSenha, Date dataInclusao) {
        this.id = id;
        this.downloadBaixarArquivoXML = downloadBaixarArquivoXML;
        this.downloadBaixarArquivoPDF = downloadBaixarArquivoPDF;
        this.downloadCompactarArquivoFormatoZIP = downloadCompactarArquivoFormatoZIP;
        this.enviarEmailSemEncriptacao = enviarEmailSemEncriptacao;
        this.enviarEmailComEncriptacaoSSL = enviarEmailComEncriptacaoSSL;
        this.enviarEmailRequerAutenticacao = enviarEmailRequerAutenticacao;
        this.enviarEmailEnviarArquivoXML = enviarEmailEnviarArquivoXML;
        this.enviarEmailEnviarArquivoPDF = enviarEmailEnviarArquivoPDF;
        this.enviarEmailCompactarArquivoFormatoZIP = enviarEmailCompactarArquivoFormatoZIP;
        this.receberEmailSemEncriptacao = receberEmailSemEncriptacao;
        this.receberEmailComEncriptacaoSSL = receberEmailComEncriptacaoSSL;
        this.receberEmailComEncriptacaoTLS = receberEmailComEncriptacaoTLS;
        this.receberEmailRequerAutenticacao = receberEmailRequerAutenticacao;
        this.receberEmailRemetenteEmail = receberEmailRemetenteEmail;
        this.receberEmailRemetenteSenha = receberEmailRemetenteSenha;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getDownloadBaixarArquivoXML() {
        return downloadBaixarArquivoXML;
    }

    public void setDownloadBaixarArquivoXML(boolean downloadBaixarArquivoXML) {
        this.downloadBaixarArquivoXML = downloadBaixarArquivoXML;
    }

    public boolean getDownloadBaixarArquivoPDF() {
        return downloadBaixarArquivoPDF;
    }

    public void setDownloadBaixarArquivoPDF(boolean downloadBaixarArquivoPDF) {
        this.downloadBaixarArquivoPDF = downloadBaixarArquivoPDF;
    }

    public boolean getDownloadCompactarArquivoFormatoZIP() {
        return downloadCompactarArquivoFormatoZIP;
    }

    public void setDownloadCompactarArquivoFormatoZIP(boolean downloadCompactarArquivoFormatoZIP) {
        this.downloadCompactarArquivoFormatoZIP = downloadCompactarArquivoFormatoZIP;
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

    public String getReceberEmailEnderecoServidorSMTP() {
        return receberEmailEnderecoServidorSMTP;
    }

    public void setReceberEmailEnderecoServidorSMTP(String receberEmailEnderecoServidorSMTP) {
        this.receberEmailEnderecoServidorSMTP = receberEmailEnderecoServidorSMTP;
    }

    public boolean getReceberEmailSemEncriptacao() {
        return receberEmailSemEncriptacao;
    }

    public void setReceberEmailSemEncriptacao(boolean receberEmailSemEncriptacao) {
        this.receberEmailSemEncriptacao = receberEmailSemEncriptacao;
    }

    public boolean getReceberEmailComEncriptacaoSSL() {
        return receberEmailComEncriptacaoSSL;
    }

    public void setReceberEmailComEncriptacaoSSL(boolean receberEmailComEncriptacaoSSL) {
        this.receberEmailComEncriptacaoSSL = receberEmailComEncriptacaoSSL;
    }

    public boolean getReceberEmailComEncriptacaoTLS() {
        return receberEmailComEncriptacaoTLS;
    }

    public void setReceberEmailComEncriptacaoTLS(boolean receberEmailComEncriptacaoTLS) {
        this.receberEmailComEncriptacaoTLS = receberEmailComEncriptacaoTLS;
    }

    public String getReceberEmailPorta() {
        return receberEmailPorta;
    }

    public void setReceberEmailPorta(String receberEmailPorta) {
        this.receberEmailPorta = receberEmailPorta;
    }

    public boolean getReceberEmailRequerAutenticacao() {
        return receberEmailRequerAutenticacao;
    }

    public void setReceberEmailRequerAutenticacao(boolean receberEmailRequerAutenticacao) {
        this.receberEmailRequerAutenticacao = receberEmailRequerAutenticacao;
    }

    public String getReceberEmailRemetenteEmail() {
        return receberEmailRemetenteEmail;
    }

    public void setReceberEmailRemetenteEmail(String receberEmailRemetenteEmail) {
        this.receberEmailRemetenteEmail = receberEmailRemetenteEmail;
    }

    public String getReceberEmailRemetenteSenha() {
        return receberEmailRemetenteSenha;
    }

    public void setReceberEmailRemetenteSenha(String receberEmailRemetenteSenha) {
        this.receberEmailRemetenteSenha = receberEmailRemetenteSenha;
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
        if (!(object instanceof NFeConfiguracoes)) {
            return false;
        }
        NFeConfiguracoes other = (NFeConfiguracoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.NFeConfiguracoes[ id=" + id + " ]";
    }
    
}
