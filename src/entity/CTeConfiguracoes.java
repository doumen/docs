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
@Table(name = "tbCTeConfiguracoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTeConfiguracoes.findAll", query = "SELECT c FROM CTeConfiguracoes c"),
    @NamedQuery(name = "CTeConfiguracoes.findById", query = "SELECT c FROM CTeConfiguracoes c WHERE c.id = :id"),
    @NamedQuery(name = "CTeConfiguracoes.findByDownloadBaixarArquivoXML", query = "SELECT c FROM CTeConfiguracoes c WHERE c.downloadBaixarArquivoXML = :downloadBaixarArquivoXML"),
    @NamedQuery(name = "CTeConfiguracoes.findByDownloadBaixarArquivoPDF", query = "SELECT c FROM CTeConfiguracoes c WHERE c.downloadBaixarArquivoPDF = :downloadBaixarArquivoPDF"),
    @NamedQuery(name = "CTeConfiguracoes.findByDownloadCompactarArquivoFormatoZIP", query = "SELECT c FROM CTeConfiguracoes c WHERE c.downloadCompactarArquivoFormatoZIP = :downloadCompactarArquivoFormatoZIP"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailEnderecoServidorPop", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailEnderecoServidorPop = :enviarEmailEnderecoServidorPop"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailSemEncriptacao", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailSemEncriptacao = :enviarEmailSemEncriptacao"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailComEncriptacaoSSL", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailComEncriptacaoSSL = :enviarEmailComEncriptacaoSSL"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailPorta", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailPorta = :enviarEmailPorta"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailRequerAutenticacao", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailRequerAutenticacao = :enviarEmailRequerAutenticacao"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailRemetenteEmail", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailRemetenteEmail = :enviarEmailRemetenteEmail"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailRemetenteSenha", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailRemetenteSenha = :enviarEmailRemetenteSenha"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailDestino", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailDestino = :enviarEmailDestino"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailEnviarArquivoXML", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailEnviarArquivoXML = :enviarEmailEnviarArquivoXML"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailEnviarArquivoPDF", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailEnviarArquivoPDF = :enviarEmailEnviarArquivoPDF"),
    @NamedQuery(name = "CTeConfiguracoes.findByEnviarEmailCompactarArquivoFormatoZIP", query = "SELECT c FROM CTeConfiguracoes c WHERE c.enviarEmailCompactarArquivoFormatoZIP = :enviarEmailCompactarArquivoFormatoZIP"),
    @NamedQuery(name = "CTeConfiguracoes.findByReceberEmailEnderecoServidorSMTP", query = "SELECT c FROM CTeConfiguracoes c WHERE c.receberEmailEnderecoServidorSMTP = :receberEmailEnderecoServidorSMTP"),
    @NamedQuery(name = "CTeConfiguracoes.findByReceberEmailSemEncriptacao", query = "SELECT c FROM CTeConfiguracoes c WHERE c.receberEmailSemEncriptacao = :receberEmailSemEncriptacao"),
    @NamedQuery(name = "CTeConfiguracoes.findByReceberEmailComEncriptacaoSSL", query = "SELECT c FROM CTeConfiguracoes c WHERE c.receberEmailComEncriptacaoSSL = :receberEmailComEncriptacaoSSL"),
    @NamedQuery(name = "CTeConfiguracoes.findByReceberEmailComEncriptacaoTLS", query = "SELECT c FROM CTeConfiguracoes c WHERE c.receberEmailComEncriptacaoTLS = :receberEmailComEncriptacaoTLS"),
    @NamedQuery(name = "CTeConfiguracoes.findByReceberEmailPorta", query = "SELECT c FROM CTeConfiguracoes c WHERE c.receberEmailPorta = :receberEmailPorta"),
    @NamedQuery(name = "CTeConfiguracoes.findByReceberEmailRequerAutenticacao", query = "SELECT c FROM CTeConfiguracoes c WHERE c.receberEmailRequerAutenticacao = :receberEmailRequerAutenticacao"),
    @NamedQuery(name = "CTeConfiguracoes.findByReceberEmailRemetenteEmail", query = "SELECT c FROM CTeConfiguracoes c WHERE c.receberEmailRemetenteEmail = :receberEmailRemetenteEmail"),
    @NamedQuery(name = "CTeConfiguracoes.findByReceberEmailRemetenteSenha", query = "SELECT c FROM CTeConfiguracoes c WHERE c.receberEmailRemetenteSenha = :receberEmailRemetenteSenha"),
    @NamedQuery(name = "CTeConfiguracoes.findByDataInclusao", query = "SELECT c FROM CTeConfiguracoes c WHERE c.dataInclusao = :dataInclusao")})
public class CTeConfiguracoes implements Serializable {
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
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;

    public CTeConfiguracoes() {
    }

    public CTeConfiguracoes(Integer id) {
        this.id = id;
    }

    public CTeConfiguracoes(Integer id, boolean downloadBaixarArquivoXML, boolean downloadBaixarArquivoPDF, boolean downloadCompactarArquivoFormatoZIP, boolean enviarEmailSemEncriptacao, boolean enviarEmailComEncriptacaoSSL, boolean enviarEmailRequerAutenticacao, boolean enviarEmailEnviarArquivoXML, boolean enviarEmailEnviarArquivoPDF, boolean enviarEmailCompactarArquivoFormatoZIP, boolean receberEmailSemEncriptacao, boolean receberEmailComEncriptacaoSSL, boolean receberEmailComEncriptacaoTLS, boolean receberEmailRequerAutenticacao, String receberEmailRemetenteEmail, String receberEmailRemetenteSenha, Date dataInclusao) {
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
        if (!(object instanceof CTeConfiguracoes)) {
            return false;
        }
        CTeConfiguracoes other = (CTeConfiguracoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.CTeConfiguracoes[ id=" + id + " ]";
    }
    
}
