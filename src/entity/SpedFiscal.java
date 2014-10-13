/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbSpedFiscal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpedFiscal.findAll", query = "SELECT s FROM SpedFiscal s"),
    @NamedQuery(name = "SpedFiscal.findById", query = "SELECT s FROM SpedFiscal s WHERE s.id = :id"),
    @NamedQuery(name = "SpedFiscal.findByCompetencia", query = "SELECT s FROM SpedFiscal s WHERE s.competencia = :competencia"),
    @NamedQuery(name = "SpedFiscal.findByLayout", query = "SELECT s FROM SpedFiscal s WHERE s.layout = :layout"),
    @NamedQuery(name = "SpedFiscal.findByPeriodoInicio", query = "SELECT s FROM SpedFiscal s WHERE s.periodoInicio = :periodoInicio"),
    @NamedQuery(name = "SpedFiscal.findByPeriodoFim", query = "SELECT s FROM SpedFiscal s WHERE s.periodoFim = :periodoFim"),
    @NamedQuery(name = "SpedFiscal.findByCnpj", query = "SELECT s FROM SpedFiscal s WHERE s.cnpj = :cnpj"),
    @NamedQuery(name = "SpedFiscal.findByRazaoSocial", query = "SELECT s FROM SpedFiscal s WHERE s.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "SpedFiscal.findBySistemaStatus", query = "SELECT s FROM SpedFiscal s WHERE s.sistemaStatus = :sistemaStatus"),
    @NamedQuery(name = "SpedFiscal.findBySistemaTipoRecepcaoSpedFiscal", query = "SELECT s FROM SpedFiscal s WHERE s.sistemaTipoRecepcaoSpedFiscal = :sistemaTipoRecepcaoSpedFiscal"),
    @NamedQuery(name = "SpedFiscal.findBySistemaArquivo", query = "SELECT s FROM SpedFiscal s WHERE s.sistemaArquivo = :sistemaArquivo"),
    @NamedQuery(name = "SpedFiscal.findBySistemaArquivoTamanho", query = "SELECT s FROM SpedFiscal s WHERE s.sistemaArquivoTamanho = :sistemaArquivoTamanho"),
    @NamedQuery(name = "SpedFiscal.findBySistemaUploadDataHora", query = "SELECT s FROM SpedFiscal s WHERE s.sistemaUploadDataHora = :sistemaUploadDataHora"),
    @NamedQuery(name = "SpedFiscal.findBySistemaUploadLocalOrigem", query = "SELECT s FROM SpedFiscal s WHERE s.sistemaUploadLocalOrigem = :sistemaUploadLocalOrigem"),
    @NamedQuery(name = "SpedFiscal.findBySistemaUploadLocalDestino", query = "SELECT s FROM SpedFiscal s WHERE s.sistemaUploadLocalDestino = :sistemaUploadLocalDestino"),
    @NamedQuery(name = "SpedFiscal.findBySistemaValidacao", query = "SELECT s FROM SpedFiscal s WHERE s.sistemaValidacao = :sistemaValidacao"),
    @NamedQuery(name = "SpedFiscal.findByDataInclusao", query = "SELECT s FROM SpedFiscal s WHERE s.dataInclusao = :dataInclusao")})
public class SpedFiscal implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Competencia")
    @Temporal(TemporalType.DATE)
    private Date competencia;
    @Basic(optional = false)
    @Column(name = "Layout")
    private int layout;
    @Basic(optional = false)
    @Column(name = "PeriodoInicio")
    @Temporal(TemporalType.DATE)
    private Date periodoInicio;
    @Basic(optional = false)
    @Column(name = "PeriodoFim")
    @Temporal(TemporalType.DATE)
    private Date periodoFim;
    @Basic(optional = false)
    @Column(name = "Cnpj")
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "RazaoSocial")
    private String razaoSocial;
    @Basic(optional = false)
    @Column(name = "SistemaStatus")
    private String sistemaStatus;
    @Basic(optional = false)
    @Column(name = "SistemaTipoRecepcaoSpedFiscal")
    private String sistemaTipoRecepcaoSpedFiscal;
    @Basic(optional = false)
    @Column(name = "SistemaArquivo")
    private String sistemaArquivo;
    @Basic(optional = false)
    @Column(name = "SistemaArquivoTamanho")
    private String sistemaArquivoTamanho;
    @Basic(optional = false)
    @Column(name = "SistemaUploadDataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sistemaUploadDataHora;
    @Basic(optional = false)
    @Column(name = "SistemaUploadLocalOrigem")
    private String sistemaUploadLocalOrigem;
    @Basic(optional = false)
    @Column(name = "SistemaUploadLocalDestino")
    private String sistemaUploadLocalDestino;
    @Column(name = "SistemaValidacao")
    private String sistemaValidacao;
    @Lob
    @Column(name = "SistemaValidacaoObservacao")
    private String sistemaValidacaoObservacao;
    @Lob
    @Column(name = "SistemaObservacao")
    private String sistemaObservacao;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbSpedFiscalId", fetch = FetchType.LAZY)
    private List<SpedFiscalArquivos> spedFiscalArquivosList;
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;
    @OneToMany(mappedBy = "tbSpedFiscalId", fetch = FetchType.LAZY)
    private List<NFe> nFeList;

    public SpedFiscal() {
    }

    public SpedFiscal(Integer id) {
        this.id = id;
    }

    public SpedFiscal(Integer id, Date competencia, int layout, Date periodoInicio, Date periodoFim, String cnpj, String razaoSocial, String sistemaStatus, String sistemaTipoRecepcaoSpedFiscal, String sistemaArquivo, String sistemaArquivoTamanho, Date sistemaUploadDataHora, String sistemaUploadLocalOrigem, String sistemaUploadLocalDestino, Date dataInclusao) {
        this.id = id;
        this.competencia = competencia;
        this.layout = layout;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.sistemaStatus = sistemaStatus;
        this.sistemaTipoRecepcaoSpedFiscal = sistemaTipoRecepcaoSpedFiscal;
        this.sistemaArquivo = sistemaArquivo;
        this.sistemaArquivoTamanho = sistemaArquivoTamanho;
        this.sistemaUploadDataHora = sistemaUploadDataHora;
        this.sistemaUploadLocalOrigem = sistemaUploadLocalOrigem;
        this.sistemaUploadLocalDestino = sistemaUploadLocalDestino;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Date competencia) {
        this.competencia = competencia;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public Date getPeriodoInicio() {
        return periodoInicio;
    }

    public void setPeriodoInicio(Date periodoInicio) {
        this.periodoInicio = periodoInicio;
    }

    public Date getPeriodoFim() {
        return periodoFim;
    }

    public void setPeriodoFim(Date periodoFim) {
        this.periodoFim = periodoFim;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSistemaStatus() {
        return sistemaStatus;
    }

    public void setSistemaStatus(String sistemaStatus) {
        this.sistemaStatus = sistemaStatus;
    }

    public String getSistemaTipoRecepcaoSpedFiscal() {
        return sistemaTipoRecepcaoSpedFiscal;
    }

    public void setSistemaTipoRecepcaoSpedFiscal(String sistemaTipoRecepcaoSpedFiscal) {
        this.sistemaTipoRecepcaoSpedFiscal = sistemaTipoRecepcaoSpedFiscal;
    }

    public String getSistemaArquivo() {
        return sistemaArquivo;
    }

    public void setSistemaArquivo(String sistemaArquivo) {
        this.sistemaArquivo = sistemaArquivo;
    }

    public String getSistemaArquivoTamanho() {
        return sistemaArquivoTamanho;
    }

    public void setSistemaArquivoTamanho(String sistemaArquivoTamanho) {
        this.sistemaArquivoTamanho = sistemaArquivoTamanho;
    }

    public Date getSistemaUploadDataHora() {
        return sistemaUploadDataHora;
    }

    public void setSistemaUploadDataHora(Date sistemaUploadDataHora) {
        this.sistemaUploadDataHora = sistemaUploadDataHora;
    }

    public String getSistemaUploadLocalOrigem() {
        return sistemaUploadLocalOrigem;
    }

    public void setSistemaUploadLocalOrigem(String sistemaUploadLocalOrigem) {
        this.sistemaUploadLocalOrigem = sistemaUploadLocalOrigem;
    }

    public String getSistemaUploadLocalDestino() {
        return sistemaUploadLocalDestino;
    }

    public void setSistemaUploadLocalDestino(String sistemaUploadLocalDestino) {
        this.sistemaUploadLocalDestino = sistemaUploadLocalDestino;
    }

    public String getSistemaValidacao() {
        return sistemaValidacao;
    }

    public void setSistemaValidacao(String sistemaValidacao) {
        this.sistemaValidacao = sistemaValidacao;
    }

    public String getSistemaValidacaoObservacao() {
        return sistemaValidacaoObservacao;
    }

    public void setSistemaValidacaoObservacao(String sistemaValidacaoObservacao) {
        this.sistemaValidacaoObservacao = sistemaValidacaoObservacao;
    }

    public String getSistemaObservacao() {
        return sistemaObservacao;
    }

    public void setSistemaObservacao(String sistemaObservacao) {
        this.sistemaObservacao = sistemaObservacao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    @XmlTransient
    public List<SpedFiscalArquivos> getSpedFiscalArquivosList() {
        return spedFiscalArquivosList;
    }

    public void setSpedFiscalArquivosList(List<SpedFiscalArquivos> spedFiscalArquivosList) {
        this.spedFiscalArquivosList = spedFiscalArquivosList;
    }

    public Assinante getTbAssinantesId() {
        return tbAssinantesId;
    }

    public void setTbAssinantesId(Assinante tbAssinantesId) {
        this.tbAssinantesId = tbAssinantesId;
    }

    @XmlTransient
    public List<NFe> getNFeList() {
        return nFeList;
    }

    public void setNFeList(List<NFe> nFeList) {
        this.nFeList = nFeList;
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
        if (!(object instanceof SpedFiscal)) {
            return false;
        }
        SpedFiscal other = (SpedFiscal) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.SpedFiscal[ id=" + id + " ]";
    }
    
}
