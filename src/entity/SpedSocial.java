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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbSpedSocial")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpedSocial.findAll", query = "SELECT s FROM SpedSocial s"),
    @NamedQuery(name = "SpedSocial.findById", query = "SELECT s FROM SpedSocial s WHERE s.id = :id"),
    @NamedQuery(name = "SpedSocial.findByCompetencia", query = "SELECT s FROM SpedSocial s WHERE s.competencia = :competencia"),
    @NamedQuery(name = "SpedSocial.findByLayout", query = "SELECT s FROM SpedSocial s WHERE s.layout = :layout"),
    @NamedQuery(name = "SpedSocial.findByPeriodoInicio", query = "SELECT s FROM SpedSocial s WHERE s.periodoInicio = :periodoInicio"),
    @NamedQuery(name = "SpedSocial.findByPeriodoFim", query = "SELECT s FROM SpedSocial s WHERE s.periodoFim = :periodoFim"),
    @NamedQuery(name = "SpedSocial.findByCnpj", query = "SELECT s FROM SpedSocial s WHERE s.cnpj = :cnpj"),
    @NamedQuery(name = "SpedSocial.findByRazaoSocial", query = "SELECT s FROM SpedSocial s WHERE s.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "SpedSocial.findBySistemaStatus", query = "SELECT s FROM SpedSocial s WHERE s.sistemaStatus = :sistemaStatus"),
    @NamedQuery(name = "SpedSocial.findBySistemaTipoRecepcaoSpedSocial", query = "SELECT s FROM SpedSocial s WHERE s.sistemaTipoRecepcaoSpedSocial = :sistemaTipoRecepcaoSpedSocial"),
    @NamedQuery(name = "SpedSocial.findBySistemaArquivo", query = "SELECT s FROM SpedSocial s WHERE s.sistemaArquivo = :sistemaArquivo"),
    @NamedQuery(name = "SpedSocial.findBySistemaArquivoTamanho", query = "SELECT s FROM SpedSocial s WHERE s.sistemaArquivoTamanho = :sistemaArquivoTamanho"),
    @NamedQuery(name = "SpedSocial.findBySistemaUploadDataHora", query = "SELECT s FROM SpedSocial s WHERE s.sistemaUploadDataHora = :sistemaUploadDataHora"),
    @NamedQuery(name = "SpedSocial.findBySistemaUploadLocalOrigem", query = "SELECT s FROM SpedSocial s WHERE s.sistemaUploadLocalOrigem = :sistemaUploadLocalOrigem"),
    @NamedQuery(name = "SpedSocial.findBySistemaUploadLocalDestino", query = "SELECT s FROM SpedSocial s WHERE s.sistemaUploadLocalDestino = :sistemaUploadLocalDestino"),
    @NamedQuery(name = "SpedSocial.findBySistemaValidacao", query = "SELECT s FROM SpedSocial s WHERE s.sistemaValidacao = :sistemaValidacao"),
    @NamedQuery(name = "SpedSocial.findByDataInclusao", query = "SELECT s FROM SpedSocial s WHERE s.dataInclusao = :dataInclusao")})
public class SpedSocial implements Serializable,Docto {
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
    @Column(name = "SistemaTipoRecepcaoSpedSocial")
    private String sistemaTipoRecepcaoSpedSocial;
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
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbSpedSocialId", fetch = FetchType.LAZY)
    @Transient
    private SpedSocialArquivos spedSocialArquivos;
    
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;

    public SpedSocial() {
    }

    public SpedSocial(Integer id) {
        this.id = id;
    }

    public SpedSocial(Integer id, Date competencia, int layout, Date periodoInicio, Date periodoFim, String cnpj, String razaoSocial, String sistemaStatus, String sistemaTipoRecepcaoSpedSocial, String sistemaArquivo, String sistemaArquivoTamanho, Date sistemaUploadDataHora, String sistemaUploadLocalOrigem, String sistemaUploadLocalDestino, Date dataInclusao) {
        this.id = id;
        this.competencia = competencia;
        this.layout = layout;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.sistemaStatus = sistemaStatus;
        this.sistemaTipoRecepcaoSpedSocial = sistemaTipoRecepcaoSpedSocial;
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

    public String getSistemaTipoRecepcaoSpedSocial() {
        return sistemaTipoRecepcaoSpedSocial;
    }

    public void setSistemaTipoRecepcaoSpedSocial(String sistemaTipoRecepcaoSpedSocial) {
        this.sistemaTipoRecepcaoSpedSocial = sistemaTipoRecepcaoSpedSocial;
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
    public SpedSocialArquivos getSpedSocialArquivos() {
        return spedSocialArquivos;
    }

    public void setSpedSocialArquivos(SpedSocialArquivos spedSocialArquivosList) {
        this.spedSocialArquivos = spedSocialArquivosList;
    }

    public Assinante getAssinante() {
        return tbAssinantesId;
    }

    public void setAssinante(Assinante tbAssinantesId) {
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
        if (!(object instanceof SpedSocial)) {
            return false;
        }
        SpedSocial other = (SpedSocial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.SpedSocial[ id=" + id + " ]";
    }

	@Override
	public void setArquivoXml(Arquivo a) {
		setSpedSocialArquivos((SpedSocialArquivos) a);		
	}

	@Override
	public Arquivo getArquivoXml() {
		return (Arquivo) getSpedSocialArquivos();
	}
    
}
