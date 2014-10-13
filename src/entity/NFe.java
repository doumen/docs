/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.OneToOne;
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
@Table(name = "tbNFe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NFe.findAll", query = "SELECT n FROM NFe n"),
    @NamedQuery(name = "NFe.findById", query = "SELECT n FROM NFe n WHERE n.id = :id"),
    @NamedQuery(name = "NFe.findByEmissaoNFe", query = "SELECT n FROM NFe n WHERE n.emissaoNFe = :emissaoNFe"),
    @NamedQuery(name = "NFe.findByChaveNFe", query = "SELECT n FROM NFe n WHERE n.chaveNFe = :chaveNFe"),
    @NamedQuery(name = "NFe.findByAutorizacaoDataHoraNFe", query = "SELECT n FROM NFe n WHERE n.autorizacaoDataHoraNFe = :autorizacaoDataHoraNFe"),
    @NamedQuery(name = "NFe.findByAutorizacaoProtocoloNFe", query = "SELECT n FROM NFe n WHERE n.autorizacaoProtocoloNFe = :autorizacaoProtocoloNFe"),
    @NamedQuery(name = "NFe.findByEntradaSaidaNFe", query = "SELECT n FROM NFe n WHERE n.entradaSaidaNFe = :entradaSaidaNFe"),
    @NamedQuery(name = "NFe.findByStatusNFe", query = "SELECT n FROM NFe n WHERE n.statusNFe = :statusNFe"),
    @NamedQuery(name = "NFe.findByManifestoRealizado", query = "SELECT n FROM NFe n WHERE n.manifestoRealizado = :manifestoRealizado"),
    @NamedQuery(name = "NFe.findByManifestoDataHora", query = "SELECT n FROM NFe n WHERE n.manifestoDataHora = :manifestoDataHora"),
    @NamedQuery(name = "NFe.findByManifestoTipoEvento", query = "SELECT n FROM NFe n WHERE n.manifestoTipoEvento = :manifestoTipoEvento"),
    @NamedQuery(name = "NFe.findByManifestoJustificativa", query = "SELECT n FROM NFe n WHERE n.manifestoJustificativa = :manifestoJustificativa"),
    @NamedQuery(name = "NFe.findByNumeroNFe", query = "SELECT n FROM NFe n WHERE n.numeroNFe = :numeroNFe"),
    @NamedQuery(name = "NFe.findBySerieNFe", query = "SELECT n FROM NFe n WHERE n.serieNFe = :serieNFe"),
    @NamedQuery(name = "NFe.findByCnpjEmitente", query = "SELECT n FROM NFe n WHERE n.cnpjEmitente = :cnpjEmitente"),
    @NamedQuery(name = "NFe.findByEmitenteRazaoSocial", query = "SELECT n FROM NFe n WHERE n.emitenteRazaoSocial = :emitenteRazaoSocial"),
    @NamedQuery(name = "NFe.findByCnpjDestinatario", query = "SELECT n FROM NFe n WHERE n.cnpjDestinatario = :cnpjDestinatario"),
    @NamedQuery(name = "NFe.findByDestinatarioRazaoSocial", query = "SELECT n FROM NFe n WHERE n.destinatarioRazaoSocial = :destinatarioRazaoSocial"),
    @NamedQuery(name = "NFe.findByValorTotalNFe", query = "SELECT n FROM NFe n WHERE n.valorTotalNFe = :valorTotalNFe"),
    @NamedQuery(name = "NFe.findBySistemaUploadStatusXml", query = "SELECT n FROM NFe n WHERE n.sistemaUploadStatusXml = :sistemaUploadStatusXml"),
    @NamedQuery(name = "NFe.findBySistemaTipoRecepcaoNFe", query = "SELECT n FROM NFe n WHERE n.sistemaTipoRecepcaoNFe = :sistemaTipoRecepcaoNFe"),
    @NamedQuery(name = "NFe.findBySistemaNomeArquivoNFe", query = "SELECT n FROM NFe n WHERE n.sistemaNomeArquivoNFe = :sistemaNomeArquivoNFe"),
    @NamedQuery(name = "NFe.findBySistemaUploadXmlDataHora", query = "SELECT n FROM NFe n WHERE n.sistemaUploadXmlDataHora = :sistemaUploadXmlDataHora"),
    @NamedQuery(name = "NFe.findBySistemaUploadLocalOrigemXml", query = "SELECT n FROM NFe n WHERE n.sistemaUploadLocalOrigemXml = :sistemaUploadLocalOrigemXml"),
    @NamedQuery(name = "NFe.findBySistemaUploadLocalDestinoXml", query = "SELECT n FROM NFe n WHERE n.sistemaUploadLocalDestinoXml = :sistemaUploadLocalDestinoXml"),
    @NamedQuery(name = "NFe.findByDataInclusao", query = "SELECT n FROM NFe n WHERE n.dataInclusao = :dataInclusao")})
public class NFe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "EmissaoNFe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissaoNFe;
    @Basic(optional = false)
    @Column(name = "ChaveNFe")
    private int chaveNFe;
    @Column(name = "AutorizacaoDataHoraNFe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date autorizacaoDataHoraNFe;
    @Basic(optional = false)
    @Column(name = "AutorizacaoProtocoloNFe")
    private int autorizacaoProtocoloNFe;
    @Basic(optional = false)
    @Column(name = "EntradaSaidaNFe")
    private Character entradaSaidaNFe;
    @Basic(optional = false)
    @Column(name = "StatusNFe")
    private String statusNFe;
    @Basic(optional = false)
    @Column(name = "ManifestoRealizado")
    private boolean manifestoRealizado;
    @Basic(optional = false)
    @Column(name = "ManifestoDataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date manifestoDataHora;
    @Column(name = "ManifestoTipoEvento")
    private String manifestoTipoEvento;
    @Column(name = "ManifestoJustificativa")
    private String manifestoJustificativa;
    @Basic(optional = false)
    @Column(name = "NumeroNFe")
    private int numeroNFe;
    @Basic(optional = false)
    @Column(name = "SerieNFe")
    private int serieNFe;
    @Basic(optional = false)
    @Column(name = "CnpjEmitente")
    private String cnpjEmitente;
    @Basic(optional = false)
    @Column(name = "EmitenteRazaoSocial")
    private String emitenteRazaoSocial;
    @Basic(optional = false)
    @Column(name = "CnpjDestinatario")
    private String cnpjDestinatario;
    @Basic(optional = false)
    @Column(name = "DestinatarioRazaoSocial")
    private String destinatarioRazaoSocial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ValorTotalNFe")
    private BigDecimal valorTotalNFe;
    @Basic(optional = false)
    @Column(name = "SistemaUploadStatusXml")
    private String sistemaUploadStatusXml;
    @Basic(optional = false)
    @Column(name = "SistemaTipoRecepcaoNFe")
    private String sistemaTipoRecepcaoNFe;
    @Basic(optional = false)
    @Column(name = "SistemaNomeArquivoNFe")
    private String sistemaNomeArquivoNFe;
    @Basic(optional = false)
    @Column(name = "SistemaUploadXmlDataHora")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sistemaUploadXmlDataHora;
    @Basic(optional = false)
    @Column(name = "SistemaUploadLocalOrigemXml")
    private String sistemaUploadLocalOrigemXml;
    @Column(name = "SistemaUploadLocalDestinoXml")
    private String sistemaUploadLocalDestinoXml;
    @Basic(optional = false)
    @Lob
    @Column(name = "SistemaUploadObservacaoXml")
    private String sistemaUploadObservacaoXml;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbNFeId", fetch = FetchType.LAZY)
    private NFeArquivos nFeArquivos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbNFeId", fetch = FetchType.LAZY)
    private List<Fatura> faturasList;
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;
    @JoinColumn(name = "tbCTe_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CTe tbCTeId;
    @JoinColumn(name = "tbSpedContribuicoes_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SpedContribuicoes tbSpedContribuicoesId;
    @JoinColumn(name = "tbSpedFiscal_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private SpedFiscal tbSpedFiscalId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbNFeId", fetch = FetchType.LAZY)
    private List<NFeItens> nFeItensList;

    public NFe() {
    }

    public NFe(Integer id) {
        this.id = id;
    }

    public NFe(Integer id, Date emissaoNFe, int chaveNFe, int autorizacaoProtocoloNFe, Character entradaSaidaNFe, String statusNFe, boolean manifestoRealizado, Date manifestoDataHora, int numeroNFe, int serieNFe, String cnpjEmitente, String emitenteRazaoSocial, String cnpjDestinatario, String destinatarioRazaoSocial, BigDecimal valorTotalNFe, String sistemaUploadStatusXml, String sistemaTipoRecepcaoNFe, String sistemaNomeArquivoNFe, Date sistemaUploadXmlDataHora, String sistemaUploadLocalOrigemXml, String sistemaUploadObservacaoXml, Date dataInclusao) {
        this.id = id;
        this.emissaoNFe = emissaoNFe;
        this.chaveNFe = chaveNFe;
        this.autorizacaoProtocoloNFe = autorizacaoProtocoloNFe;
        this.entradaSaidaNFe = entradaSaidaNFe;
        this.statusNFe = statusNFe;
        this.manifestoRealizado = manifestoRealizado;
        this.manifestoDataHora = manifestoDataHora;
        this.numeroNFe = numeroNFe;
        this.serieNFe = serieNFe;
        this.cnpjEmitente = cnpjEmitente;
        this.emitenteRazaoSocial = emitenteRazaoSocial;
        this.cnpjDestinatario = cnpjDestinatario;
        this.destinatarioRazaoSocial = destinatarioRazaoSocial;
        this.valorTotalNFe = valorTotalNFe;
        this.sistemaUploadStatusXml = sistemaUploadStatusXml;
        this.sistemaTipoRecepcaoNFe = sistemaTipoRecepcaoNFe;
        this.sistemaNomeArquivoNFe = sistemaNomeArquivoNFe;
        this.sistemaUploadXmlDataHora = sistemaUploadXmlDataHora;
        this.sistemaUploadLocalOrigemXml = sistemaUploadLocalOrigemXml;
        this.sistemaUploadObservacaoXml = sistemaUploadObservacaoXml;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEmissaoNFe() {
        return emissaoNFe;
    }

    public void setEmissaoNFe(Date emissaoNFe) {
        this.emissaoNFe = emissaoNFe;
    }

    public int getChaveNFe() {
        return chaveNFe;
    }

    public void setChaveNFe(int chaveNFe) {
        this.chaveNFe = chaveNFe;
    }

    public Date getAutorizacaoDataHoraNFe() {
        return autorizacaoDataHoraNFe;
    }

    public void setAutorizacaoDataHoraNFe(Date autorizacaoDataHoraNFe) {
        this.autorizacaoDataHoraNFe = autorizacaoDataHoraNFe;
    }

    public int getAutorizacaoProtocoloNFe() {
        return autorizacaoProtocoloNFe;
    }

    public void setAutorizacaoProtocoloNFe(int autorizacaoProtocoloNFe) {
        this.autorizacaoProtocoloNFe = autorizacaoProtocoloNFe;
    }

    public Character getEntradaSaidaNFe() {
        return entradaSaidaNFe;
    }

    public void setEntradaSaidaNFe(Character entradaSaidaNFe) {
        this.entradaSaidaNFe = entradaSaidaNFe;
    }

    public String getStatusNFe() {
        return statusNFe;
    }

    public void setStatusNFe(String statusNFe) {
        this.statusNFe = statusNFe;
    }

    public boolean getManifestoRealizado() {
        return manifestoRealizado;
    }

    public void setManifestoRealizado(boolean manifestoRealizado) {
        this.manifestoRealizado = manifestoRealizado;
    }

    public Date getManifestoDataHora() {
        return manifestoDataHora;
    }

    public void setManifestoDataHora(Date manifestoDataHora) {
        this.manifestoDataHora = manifestoDataHora;
    }

    public String getManifestoTipoEvento() {
        return manifestoTipoEvento;
    }

    public void setManifestoTipoEvento(String manifestoTipoEvento) {
        this.manifestoTipoEvento = manifestoTipoEvento;
    }

    public String getManifestoJustificativa() {
        return manifestoJustificativa;
    }

    public void setManifestoJustificativa(String manifestoJustificativa) {
        this.manifestoJustificativa = manifestoJustificativa;
    }

    public int getNumeroNFe() {
        return numeroNFe;
    }

    public void setNumeroNFe(int numeroNFe) {
        this.numeroNFe = numeroNFe;
    }

    public int getSerieNFe() {
        return serieNFe;
    }

    public void setSerieNFe(int serieNFe) {
        this.serieNFe = serieNFe;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    public void setCnpjEmitente(String cnpjEmitente) {
        this.cnpjEmitente = cnpjEmitente;
    }

    public String getEmitenteRazaoSocial() {
        return emitenteRazaoSocial;
    }

    public void setEmitenteRazaoSocial(String emitenteRazaoSocial) {
        this.emitenteRazaoSocial = emitenteRazaoSocial;
    }

    public String getCnpjDestinatario() {
        return cnpjDestinatario;
    }

    public void setCnpjDestinatario(String cnpjDestinatario) {
        this.cnpjDestinatario = cnpjDestinatario;
    }

    public String getDestinatarioRazaoSocial() {
        return destinatarioRazaoSocial;
    }

    public void setDestinatarioRazaoSocial(String destinatarioRazaoSocial) {
        this.destinatarioRazaoSocial = destinatarioRazaoSocial;
    }

    public BigDecimal getValorTotalNFe() {
        return valorTotalNFe;
    }

    public void setValorTotalNFe(BigDecimal valorTotalNFe) {
        this.valorTotalNFe = valorTotalNFe;
    }

    public String getSistemaUploadStatusXml() {
        return sistemaUploadStatusXml;
    }

    public void setSistemaUploadStatusXml(String sistemaUploadStatusXml) {
        this.sistemaUploadStatusXml = sistemaUploadStatusXml;
    }

    public String getSistemaTipoRecepcaoNFe() {
        return sistemaTipoRecepcaoNFe;
    }

    public void setSistemaTipoRecepcaoNFe(String sistemaTipoRecepcaoNFe) {
        this.sistemaTipoRecepcaoNFe = sistemaTipoRecepcaoNFe;
    }

    public String getSistemaNomeArquivoNFe() {
        return sistemaNomeArquivoNFe;
    }

    public void setSistemaNomeArquivoNFe(String sistemaNomeArquivoNFe) {
        this.sistemaNomeArquivoNFe = sistemaNomeArquivoNFe;
    }

    public Date getSistemaUploadXmlDataHora() {
        return sistemaUploadXmlDataHora;
    }

    public void setSistemaUploadXmlDataHora(Date sistemaUploadXmlDataHora) {
        this.sistemaUploadXmlDataHora = sistemaUploadXmlDataHora;
    }

    public String getSistemaUploadLocalOrigemXml() {
        return sistemaUploadLocalOrigemXml;
    }

    public void setSistemaUploadLocalOrigemXml(String sistemaUploadLocalOrigemXml) {
        this.sistemaUploadLocalOrigemXml = sistemaUploadLocalOrigemXml;
    }

    public String getSistemaUploadLocalDestinoXml() {
        return sistemaUploadLocalDestinoXml;
    }

    public void setSistemaUploadLocalDestinoXml(String sistemaUploadLocalDestinoXml) {
        this.sistemaUploadLocalDestinoXml = sistemaUploadLocalDestinoXml;
    }

    public String getSistemaUploadObservacaoXml() {
        return sistemaUploadObservacaoXml;
    }

    public void setSistemaUploadObservacaoXml(String sistemaUploadObservacaoXml) {
        this.sistemaUploadObservacaoXml = sistemaUploadObservacaoXml;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public NFeArquivos getNFeArquivos() {
        return nFeArquivos;
    }

    public void setNFeArquivos(NFeArquivos nFeArquivos) {
        this.nFeArquivos = nFeArquivos;
    }

    @XmlTransient
    public List<Fatura> getFaturasList() {
        return faturasList;
    }

    public void setFaturasList(List<Fatura> faturasList) {
        this.faturasList = faturasList;
    }

    public Assinante getTbAssinantesId() {
        return tbAssinantesId;
    }

    public void setTbAssinantesId(Assinante tbAssinantesId) {
        this.tbAssinantesId = tbAssinantesId;
    }

    public CTe getTbCTeId() {
        return tbCTeId;
    }

    public void setTbCTeId(CTe tbCTeId) {
        this.tbCTeId = tbCTeId;
    }

    public SpedContribuicoes getTbSpedContribuicoesId() {
        return tbSpedContribuicoesId;
    }

    public void setTbSpedContribuicoesId(SpedContribuicoes tbSpedContribuicoesId) {
        this.tbSpedContribuicoesId = tbSpedContribuicoesId;
    }

    public SpedFiscal getTbSpedFiscalId() {
        return tbSpedFiscalId;
    }

    public void setTbSpedFiscalId(SpedFiscal tbSpedFiscalId) {
        this.tbSpedFiscalId = tbSpedFiscalId;
    }

    @XmlTransient
    public List<NFeItens> getNFeItensList() {
        return nFeItensList;
    }

    public void setNFeItensList(List<NFeItens> nFeItensList) {
        this.nFeItensList = nFeItensList;
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
        if (!(object instanceof NFe)) {
            return false;
        }
        NFe other = (NFe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.NFe[ id=" + id + " ]";
    }
    
}
