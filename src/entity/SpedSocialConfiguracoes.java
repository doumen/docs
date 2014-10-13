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
@Table(name = "tbSpedSocialConfiguracoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpedSocialConfiguracoes.findAll", query = "SELECT s FROM SpedSocialConfiguracoes s"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findById", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.id = :id"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByDownloadBaixarArquivoTXT", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.downloadBaixarArquivoTXT = :downloadBaixarArquivoTXT"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByDownloadCompactarArquivoFormatoZIP", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.downloadCompactarArquivoFormatoZIP = :downloadCompactarArquivoFormatoZIP"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailEnderecoServidorPop", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailEnderecoServidorPop = :enviarEmailEnderecoServidorPop"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailSemEncriptacao", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailSemEncriptacao = :enviarEmailSemEncriptacao"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailComEncriptacaoSSL", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailComEncriptacaoSSL = :enviarEmailComEncriptacaoSSL"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailPorta", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailPorta = :enviarEmailPorta"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailRequerAutenticacao", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailRequerAutenticacao = :enviarEmailRequerAutenticacao"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailRemetenteEmail", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailRemetenteEmail = :enviarEmailRemetenteEmail"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailRemetenteSenha", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailRemetenteSenha = :enviarEmailRemetenteSenha"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailDestino", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailDestino = :enviarEmailDestino"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailEnviarArquivoTXT", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailEnviarArquivoTXT = :enviarEmailEnviarArquivoTXT"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByEnviarEmailCompactarArquivoFormatoZIP", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.enviarEmailCompactarArquivoFormatoZIP = :enviarEmailCompactarArquivoFormatoZIP"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByReceberEmailEnderecoServidorSMTP", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.receberEmailEnderecoServidorSMTP = :receberEmailEnderecoServidorSMTP"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByReceberEmailSemEncriptacao", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.receberEmailSemEncriptacao = :receberEmailSemEncriptacao"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByReceberEmailComEncriptacaoSSL", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.receberEmailComEncriptacaoSSL = :receberEmailComEncriptacaoSSL"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByReceberEmailComEncriptacaoTLS", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.receberEmailComEncriptacaoTLS = :receberEmailComEncriptacaoTLS"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByReceberEmailPorta", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.receberEmailPorta = :receberEmailPorta"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByReceberEmailRequerAutenticacao", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.receberEmailRequerAutenticacao = :receberEmailRequerAutenticacao"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByReceberEmailRemetenteEmail", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.receberEmailRemetenteEmail = :receberEmailRemetenteEmail"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByReceberEmailRemetenteSenha", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.receberEmailRemetenteSenha = :receberEmailRemetenteSenha"),
    @NamedQuery(name = "SpedSocialConfiguracoes.findByDataInclusao", query = "SELECT s FROM SpedSocialConfiguracoes s WHERE s.dataInclusao = :dataInclusao")})
public class SpedSocialConfiguracoes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DownloadBaixarArquivoTXT")
    private boolean downloadBaixarArquivoTXT;
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
    @Column(name = "EnviarEmailEnviarArquivoTXT")
    private boolean enviarEmailEnviarArquivoTXT;
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

    public SpedSocialConfiguracoes() {
    }

    public SpedSocialConfiguracoes(Integer id) {
        this.id = id;
    }

    public SpedSocialConfiguracoes(Integer id, boolean downloadBaixarArquivoTXT, boolean downloadCompactarArquivoFormatoZIP, boolean enviarEmailSemEncriptacao, boolean enviarEmailComEncriptacaoSSL, boolean enviarEmailRequerAutenticacao, boolean enviarEmailEnviarArquivoTXT, boolean enviarEmailCompactarArquivoFormatoZIP, boolean receberEmailSemEncriptacao, boolean receberEmailComEncriptacaoSSL, boolean receberEmailComEncriptacaoTLS, boolean receberEmailRequerAutenticacao, String receberEmailRemetenteEmail, String receberEmailRemetenteSenha, Date dataInclusao) {
        this.id = id;
        this.downloadBaixarArquivoTXT = downloadBaixarArquivoTXT;
        this.downloadCompactarArquivoFormatoZIP = downloadCompactarArquivoFormatoZIP;
        this.enviarEmailSemEncriptacao = enviarEmailSemEncriptacao;
        this.enviarEmailComEncriptacaoSSL = enviarEmailComEncriptacaoSSL;
        this.enviarEmailRequerAutenticacao = enviarEmailRequerAutenticacao;
        this.enviarEmailEnviarArquivoTXT = enviarEmailEnviarArquivoTXT;
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

    public boolean getDownloadBaixarArquivoTXT() {
        return downloadBaixarArquivoTXT;
    }

    public void setDownloadBaixarArquivoTXT(boolean downloadBaixarArquivoTXT) {
        this.downloadBaixarArquivoTXT = downloadBaixarArquivoTXT;
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

    public boolean getEnviarEmailEnviarArquivoTXT() {
        return enviarEmailEnviarArquivoTXT;
    }

    public void setEnviarEmailEnviarArquivoTXT(boolean enviarEmailEnviarArquivoTXT) {
        this.enviarEmailEnviarArquivoTXT = enviarEmailEnviarArquivoTXT;
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
        if (!(object instanceof SpedSocialConfiguracoes)) {
            return false;
        }
        SpedSocialConfiguracoes other = (SpedSocialConfiguracoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.SpedSocialConfiguracoes[ id=" + id + " ]";
    }
    
}
