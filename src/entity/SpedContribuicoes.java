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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author desenv
 */
@Entity
@Table(name = "tbSpedContribuicoes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpedContribuicoes.findAll", query = "SELECT s FROM SpedContribuicoes s"),
    @NamedQuery(name = "SpedContribuicoes.findById", query = "SELECT s FROM SpedContribuicoes s WHERE s.id = :id"),
    @NamedQuery(name = "SpedContribuicoes.findByCompetencia", query = "SELECT s FROM SpedContribuicoes s WHERE s.competencia = :competencia"),
    @NamedQuery(name = "SpedContribuicoes.findByLayout", query = "SELECT s FROM SpedContribuicoes s WHERE s.layout = :layout"),
    @NamedQuery(name = "SpedContribuicoes.findByPeriodoInicio", query = "SELECT s FROM SpedContribuicoes s WHERE s.periodoInicio = :periodoInicio"),
    @NamedQuery(name = "SpedContribuicoes.findByPeriodoFim", query = "SELECT s FROM SpedContribuicoes s WHERE s.periodoFim = :periodoFim"),
    @NamedQuery(name = "SpedContribuicoes.findByCnpj", query = "SELECT s FROM SpedContribuicoes s WHERE s.cnpj = :cnpj"),
    @NamedQuery(name = "SpedContribuicoes.findByRazaoSocial", query = "SELECT s FROM SpedContribuicoes s WHERE s.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "SpedContribuicoes.findBySistemaStatus", query = "SELECT s FROM SpedContribuicoes s WHERE s.sistemaStatus = :sistemaStatus"),
    @NamedQuery(name = "SpedContribuicoes.findBySistemaTipoRecepcaoSpedContribuicoes", query = "SELECT s FROM SpedContribuicoes s WHERE s.sistemaTipoRecepcaoSpedContribuicoes = :sistemaTipoRecepcaoSpedContribuicoes"),
    @NamedQuery(name = "SpedContribuicoes.findBySistemaArquivo", query = "SELECT s FROM SpedContribuicoes s WHERE s.sistemaArquivo = :sistemaArquivo"),
    @NamedQuery(name = "SpedContribuicoes.findBySistemaArquivoTamanho", query = "SELECT s FROM SpedContribuicoes s WHERE s.sistemaArquivoTamanho = :sistemaArquivoTamanho"),
    @NamedQuery(name = "SpedContribuicoes.findBySistemaUploadDataHora", query = "SELECT s FROM SpedContribuicoes s WHERE s.sistemaUploadDataHora = :sistemaUploadDataHora"),
    @NamedQuery(name = "SpedContribuicoes.findBySistemaUploadLocalOrigem", query = "SELECT s FROM SpedContribuicoes s WHERE s.sistemaUploadLocalOrigem = :sistemaUploadLocalOrigem"),
    @NamedQuery(name = "SpedContribuicoes.findBySistemaUploadLocalDestino", query = "SELECT s FROM SpedContribuicoes s WHERE s.sistemaUploadLocalDestino = :sistemaUploadLocalDestino"),
    @NamedQuery(name = "SpedContribuicoes.findBySistemaValidacao", query = "SELECT s FROM SpedContribuicoes s WHERE s.sistemaValidacao = :sistemaValidacao"),
    @NamedQuery(name = "SpedContribuicoes.findByDataInclusao", query = "SELECT s FROM SpedContribuicoes s WHERE s.dataInclusao = :dataInclusao")})
public class SpedContribuicoes implements Serializable,Docto {
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
    private int cnpj;
    @Basic(optional = false)
    @Column(name = "RazaoSocial")
    private String razaoSocial;
    @Basic(optional = false)
    @Column(name = "SistemaStatus")
    private String sistemaStatus;
    @Basic(optional = false)
    @Column(name = "SistemaTipoRecepcaoSpedContribuicoes")
    private String sistemaTipoRecepcaoSpedContribuicoes;
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

    @Transient
    private SpedContribuicoesArquivos spedContribuicoesArquivos;
    
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;
    @OneToMany(mappedBy = "tbSpedContribuicoesId", fetch = FetchType.LAZY)
    private List<NFe> nFeList;

    @JoinColumn(name = "tbUsuarios_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuario;
    
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
    public SpedContribuicoes() {
    }

    public SpedContribuicoes(Integer id) {
        this.id = id;
    }

    public SpedContribuicoes(Integer id, Date competencia, int layout, Date periodoInicio, Date periodoFim, int cnpj, String razaoSocial, String sistemaStatus, String sistemaTipoRecepcaoSpedContribuicoes, String sistemaArquivo, String sistemaArquivoTamanho, Date sistemaUploadDataHora, String sistemaUploadLocalOrigem, String sistemaUploadLocalDestino, Date dataInclusao) {
        this.id = id;
        this.competencia = competencia;
        this.layout = layout;
        this.periodoInicio = periodoInicio;
        this.periodoFim = periodoFim;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.sistemaStatus = sistemaStatus;
        this.sistemaTipoRecepcaoSpedContribuicoes = sistemaTipoRecepcaoSpedContribuicoes;
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

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
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

    public String getSistemaTipoRecepcaoSpedContribuicoes() {
        return sistemaTipoRecepcaoSpedContribuicoes;
    }

    public void setSistemaTipoRecepcaoSpedContribuicoes(String sistemaTipoRecepcaoSpedContribuicoes) {
        this.sistemaTipoRecepcaoSpedContribuicoes = sistemaTipoRecepcaoSpedContribuicoes;
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
    public SpedContribuicoesArquivos getSpedContribuicoesArquivos() {
        return spedContribuicoesArquivos;
    }

    public void setSpedContribuicoesArquivos(SpedContribuicoesArquivos spedContribuicoesArquivosList) {
        this.spedContribuicoesArquivos = spedContribuicoesArquivosList;
    }

    public Assinante getAssinante() {
        return tbAssinantesId;
    }

    public void setAssinante(Assinante tbAssinantesId) {
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
        if (!(object instanceof SpedContribuicoes)) {
            return false;
        }
        SpedContribuicoes other = (SpedContribuicoes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.SpedContribuicoes[ id=" + id + " ]";
    }

	@Override
	public void setArquivoXml(Arquivo a) {
		setSpedContribuicoesArquivos((SpedContribuicoesArquivos) a);
		
	}

	@Override
	public Arquivo getArquivoXml() {
		return (Arquivo) getSpedContribuicoesArquivos();
	}
    
}
