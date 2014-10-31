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
@Table(name = "tbCTe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CTe.findAll", query = "SELECT c FROM CTe c"),
    @NamedQuery(name = "CTe.findById", query = "SELECT c FROM CTe c WHERE c.id = :id"),
    @NamedQuery(name = "CTe.findByStatusCTe", query = "SELECT c FROM CTe c WHERE c.statusCTe = :statusCTe"),
    @NamedQuery(name = "CTe.findByModeloCTe", query = "SELECT c FROM CTe c WHERE c.modeloCTe = :modeloCTe"),
    @NamedQuery(name = "CTe.findBySerieCTe", query = "SELECT c FROM CTe c WHERE c.serieCTe = :serieCTe"),
    @NamedQuery(name = "CTe.findByNumeroCTe", query = "SELECT c FROM CTe c WHERE c.numeroCTe = :numeroCTe"),
    @NamedQuery(name = "CTe.findByEmissaoDataHoraCTe", query = "SELECT c FROM CTe c WHERE c.emissaoDataHoraCTe = :emissaoDataHoraCTe"),
    @NamedQuery(name = "CTe.findByModalCTe", query = "SELECT c FROM CTe c WHERE c.modalCTe = :modalCTe"),
    @NamedQuery(name = "CTe.findByChaveCTe", query = "SELECT c FROM CTe c WHERE c.chaveCTe = :chaveCTe"),
    @NamedQuery(name = "CTe.findByTipoDoCTe", query = "SELECT c FROM CTe c WHERE c.tipoDoCTe = :tipoDoCTe"),
    @NamedQuery(name = "CTe.findByTomadorServicoCTe", query = "SELECT c FROM CTe c WHERE c.tomadorServicoCTe = :tomadorServicoCTe"),
    @NamedQuery(name = "CTe.findByTipoServicoCTe", query = "SELECT c FROM CTe c WHERE c.tipoServicoCTe = :tipoServicoCTe"),
    @NamedQuery(name = "CTe.findByFormaPagtoCTe", query = "SELECT c FROM CTe c WHERE c.formaPagtoCTe = :formaPagtoCTe"),
    @NamedQuery(name = "CTe.findByAutorizacaoDataHoraCTe", query = "SELECT c FROM CTe c WHERE c.autorizacaoDataHoraCTe = :autorizacaoDataHoraCTe"),
    @NamedQuery(name = "CTe.findByAutorizacaoProtocoloCTe", query = "SELECT c FROM CTe c WHERE c.autorizacaoProtocoloCTe = :autorizacaoProtocoloCTe"),
    @NamedQuery(name = "CTe.findByEmitenteCnpj", query = "SELECT c FROM CTe c WHERE c.emitenteCnpj = :emitenteCnpj"),
    @NamedQuery(name = "CTe.findByEmitenteRazaoSocial", query = "SELECT c FROM CTe c WHERE c.emitenteRazaoSocial = :emitenteRazaoSocial"),
    @NamedQuery(name = "CTe.findByRemetenteCnpj", query = "SELECT c FROM CTe c WHERE c.remetenteCnpj = :remetenteCnpj"),
    @NamedQuery(name = "CTe.findByRemetenteRazaoSocial", query = "SELECT c FROM CTe c WHERE c.remetenteRazaoSocial = :remetenteRazaoSocial"),
    @NamedQuery(name = "CTe.findByDestinatarioCnpj", query = "SELECT c FROM CTe c WHERE c.destinatarioCnpj = :destinatarioCnpj"),
    @NamedQuery(name = "CTe.findByDestinatarioRazaoSocial", query = "SELECT c FROM CTe c WHERE c.destinatarioRazaoSocial = :destinatarioRazaoSocial"),
    @NamedQuery(name = "CTe.findByExpedidorCnpj", query = "SELECT c FROM CTe c WHERE c.expedidorCnpj = :expedidorCnpj"),
    @NamedQuery(name = "CTe.findByExpedidorRazaoSocial", query = "SELECT c FROM CTe c WHERE c.expedidorRazaoSocial = :expedidorRazaoSocial"),
    @NamedQuery(name = "CTe.findByRecebedorCnpj", query = "SELECT c FROM CTe c WHERE c.recebedorCnpj = :recebedorCnpj"),
    @NamedQuery(name = "CTe.findByRecebedorRazaoSocial", query = "SELECT c FROM CTe c WHERE c.recebedorRazaoSocial = :recebedorRazaoSocial"),
    @NamedQuery(name = "CTe.findByTomadorServicoCnpj", query = "SELECT c FROM CTe c WHERE c.tomadorServicoCnpj = :tomadorServicoCnpj"),
    @NamedQuery(name = "CTe.findByTomadorRazaoSocial", query = "SELECT c FROM CTe c WHERE c.tomadorRazaoSocial = :tomadorRazaoSocial"),
    @NamedQuery(name = "CTe.findByValorTotalServicoCTe", query = "SELECT c FROM CTe c WHERE c.valorTotalServicoCTe = :valorTotalServicoCTe"),
    @NamedQuery(name = "CTe.findByValotTotalReceberCTe", query = "SELECT c FROM CTe c WHERE c.valotTotalReceberCTe = :valotTotalReceberCTe"),
    @NamedQuery(name = "CTe.findBySistemaUploadStatusXml", query = "SELECT c FROM CTe c WHERE c.sistemaUploadStatusXml = :sistemaUploadStatusXml"),
    @NamedQuery(name = "CTe.findBySistemaTipoRecepcaoCTe", query = "SELECT c FROM CTe c WHERE c.sistemaTipoRecepcaoCTe = :sistemaTipoRecepcaoCTe"),
    @NamedQuery(name = "CTe.findBySistemaNomeArquivoCTe", query = "SELECT c FROM CTe c WHERE c.sistemaNomeArquivoCTe = :sistemaNomeArquivoCTe"),
    @NamedQuery(name = "CTe.findBySistemaUploadXmlDataHora", query = "SELECT c FROM CTe c WHERE c.sistemaUploadXmlDataHora = :sistemaUploadXmlDataHora"),
    @NamedQuery(name = "CTe.findBySistemaUploadLocalOrigemXml", query = "SELECT c FROM CTe c WHERE c.sistemaUploadLocalOrigemXml = :sistemaUploadLocalOrigemXml"),
    @NamedQuery(name = "CTe.findBySistemaUploadLocalDestinoXml", query = "SELECT c FROM CTe c WHERE c.sistemaUploadLocalDestinoXml = :sistemaUploadLocalDestinoXml"),
    @NamedQuery(name = "CTe.findBySistemaUploadObservacaoXml", query = "SELECT c FROM CTe c WHERE c.sistemaUploadObservacaoXml = :sistemaUploadObservacaoXml"),
    @NamedQuery(name = "CTe.findByDataInclusao", query = "SELECT c FROM CTe c WHERE c.dataInclusao = :dataInclusao")})
public class CTe implements Serializable,Docto {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "StatusCTe")
    private String statusCTe;
    @Basic(optional = false)
    @Column(name = "ModeloCTe")
    private int modeloCTe;
    @Basic(optional = false)
    @Column(name = "SerieCTe")
    private int serieCTe;
    @Basic(optional = false)
    @Column(name = "NumeroCTe")
    private int numeroCTe;
    @Basic(optional = false)
    @Column(name = "EmissaoDataHoraCTe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissaoDataHoraCTe;
    @Basic(optional = false)
    @Column(name = "ModalCTe")
    private String modalCTe;
    @Basic(optional = false)
    @Column(name = "ChaveCTe")
    private int chaveCTe;
    @Basic(optional = false)
    @Column(name = "TipoDoCTe")
    private String tipoDoCTe;
    @Basic(optional = false)
    @Column(name = "TomadorServicoCTe")
    private String tomadorServicoCTe;
    @Basic(optional = false)
    @Column(name = "TipoServicoCTe")
    private String tipoServicoCTe;
    @Basic(optional = false)
    @Column(name = "FormaPagtoCTe")
    private String formaPagtoCTe;
    @Column(name = "AutorizacaoDataHoraCTe")
    @Temporal(TemporalType.TIMESTAMP)
    private Date autorizacaoDataHoraCTe;
    @Basic(optional = false)
    @Column(name = "AutorizacaoProtocoloCTe")
    private int autorizacaoProtocoloCTe;
    @Basic(optional = false)
    @Column(name = "EmitenteCnpj")
    private int emitenteCnpj;
    @Basic(optional = false)
    @Column(name = "EmitenteRazaoSocial")
    private String emitenteRazaoSocial;
    @Basic(optional = false)
    @Column(name = "RemetenteCnpj")
    private int remetenteCnpj;
    @Basic(optional = false)
    @Column(name = "RemetenteRazaoSocial")
    private String remetenteRazaoSocial;
    @Basic(optional = false)
    @Column(name = "DestinatarioCnpj")
    private int destinatarioCnpj;
    @Basic(optional = false)
    @Column(name = "DestinatarioRazaoSocial")
    private String destinatarioRazaoSocial;
    @Basic(optional = false)
    @Column(name = "ExpedidorCnpj")
    private int expedidorCnpj;
    @Basic(optional = false)
    @Column(name = "ExpedidorRazaoSocial")
    private String expedidorRazaoSocial;
    @Basic(optional = false)
    @Column(name = "RecebedorCnpj")
    private int recebedorCnpj;
    @Basic(optional = false)
    @Column(name = "RecebedorRazaoSocial")
    private String recebedorRazaoSocial;
    @Basic(optional = false)
    @Column(name = "TomadorServicoCnpj")
    private int tomadorServicoCnpj;
    @Basic(optional = false)
    @Column(name = "TomadorRazaoSocial")
    private String tomadorRazaoSocial;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ValorTotalServicoCTe")
    private BigDecimal valorTotalServicoCTe;
    @Basic(optional = false)
    @Column(name = "ValotTotalReceberCTe")
    private BigDecimal valotTotalReceberCTe;
    @Basic(optional = false)
    @Column(name = "SistemaUploadStatusXml")
    private String sistemaUploadStatusXml;
    @Basic(optional = false)
    @Column(name = "SistemaTipoRecepcaoCTe")
    private String sistemaTipoRecepcaoCTe;
    @Basic(optional = false)
    @Column(name = "SistemaNomeArquivoCTe")
    private String sistemaNomeArquivoCTe;
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
    @Column(name = "SistemaUploadObservacaoXml")
    private BigDecimal sistemaUploadObservacaoXml;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tbCTeId", fetch = FetchType.LAZY)
    private CTeArquivos cTeArquivos;
    @OneToMany(mappedBy = "tbCTeId", fetch = FetchType.LAZY)
    private List<NFe> nFeList;
    @JoinColumn(name = "tbAssinantes_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Assinante tbAssinantesId;

    public CTe() {
    }

    public CTe(Integer id) {
        this.id = id;
    }

    public CTe(Integer id, String statusCTe, int modeloCTe, int serieCTe, int numeroCTe, Date emissaoDataHoraCTe, String modalCTe, int chaveCTe, String tipoDoCTe, String tomadorServicoCTe, String tipoServicoCTe, String formaPagtoCTe, int autorizacaoProtocoloCTe, int emitenteCnpj, String emitenteRazaoSocial, int remetenteCnpj, String remetenteRazaoSocial, int destinatarioCnpj, String destinatarioRazaoSocial, int expedidorCnpj, String expedidorRazaoSocial, int recebedorCnpj, String recebedorRazaoSocial, int tomadorServicoCnpj, String tomadorRazaoSocial, BigDecimal valorTotalServicoCTe, BigDecimal valotTotalReceberCTe, String sistemaUploadStatusXml, String sistemaTipoRecepcaoCTe, String sistemaNomeArquivoCTe, Date sistemaUploadXmlDataHora, String sistemaUploadLocalOrigemXml, BigDecimal sistemaUploadObservacaoXml, Date dataInclusao) {
        this.id = id;
        this.statusCTe = statusCTe;
        this.modeloCTe = modeloCTe;
        this.serieCTe = serieCTe;
        this.numeroCTe = numeroCTe;
        this.emissaoDataHoraCTe = emissaoDataHoraCTe;
        this.modalCTe = modalCTe;
        this.chaveCTe = chaveCTe;
        this.tipoDoCTe = tipoDoCTe;
        this.tomadorServicoCTe = tomadorServicoCTe;
        this.tipoServicoCTe = tipoServicoCTe;
        this.formaPagtoCTe = formaPagtoCTe;
        this.autorizacaoProtocoloCTe = autorizacaoProtocoloCTe;
        this.emitenteCnpj = emitenteCnpj;
        this.emitenteRazaoSocial = emitenteRazaoSocial;
        this.remetenteCnpj = remetenteCnpj;
        this.remetenteRazaoSocial = remetenteRazaoSocial;
        this.destinatarioCnpj = destinatarioCnpj;
        this.destinatarioRazaoSocial = destinatarioRazaoSocial;
        this.expedidorCnpj = expedidorCnpj;
        this.expedidorRazaoSocial = expedidorRazaoSocial;
        this.recebedorCnpj = recebedorCnpj;
        this.recebedorRazaoSocial = recebedorRazaoSocial;
        this.tomadorServicoCnpj = tomadorServicoCnpj;
        this.tomadorRazaoSocial = tomadorRazaoSocial;
        this.valorTotalServicoCTe = valorTotalServicoCTe;
        this.valotTotalReceberCTe = valotTotalReceberCTe;
        this.sistemaUploadStatusXml = sistemaUploadStatusXml;
        this.sistemaTipoRecepcaoCTe = sistemaTipoRecepcaoCTe;
        this.sistemaNomeArquivoCTe = sistemaNomeArquivoCTe;
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

    public String getStatusCTe() {
        return statusCTe;
    }

    public void setStatusCTe(String statusCTe) {
        this.statusCTe = statusCTe;
    }

    public int getModeloCTe() {
        return modeloCTe;
    }

    public void setModeloCTe(int modeloCTe) {
        this.modeloCTe = modeloCTe;
    }

    public int getSerieCTe() {
        return serieCTe;
    }

    public void setSerieCTe(int serieCTe) {
        this.serieCTe = serieCTe;
    }

    public int getNumeroCTe() {
        return numeroCTe;
    }

    public void setNumeroCTe(int numeroCTe) {
        this.numeroCTe = numeroCTe;
    }

    public Date getEmissaoDataHoraCTe() {
        return emissaoDataHoraCTe;
    }

    public void setEmissaoDataHoraCTe(Date emissaoDataHoraCTe) {
        this.emissaoDataHoraCTe = emissaoDataHoraCTe;
    }

    public String getModalCTe() {
        return modalCTe;
    }

    public void setModalCTe(String modalCTe) {
        this.modalCTe = modalCTe;
    }

    public int getChaveCTe() {
        return chaveCTe;
    }

    public void setChaveCTe(int chaveCTe) {
        this.chaveCTe = chaveCTe;
    }

    public String getTipoDoCTe() {
        return tipoDoCTe;
    }

    public void setTipoDoCTe(String tipoDoCTe) {
        this.tipoDoCTe = tipoDoCTe;
    }

    public String getTomadorServicoCTe() {
        return tomadorServicoCTe;
    }

    public void setTomadorServicoCTe(String tomadorServicoCTe) {
        this.tomadorServicoCTe = tomadorServicoCTe;
    }

    public String getTipoServicoCTe() {
        return tipoServicoCTe;
    }

    public void setTipoServicoCTe(String tipoServicoCTe) {
        this.tipoServicoCTe = tipoServicoCTe;
    }

    public String getFormaPagtoCTe() {
        return formaPagtoCTe;
    }

    public void setFormaPagtoCTe(String formaPagtoCTe) {
        this.formaPagtoCTe = formaPagtoCTe;
    }

    public Date getAutorizacaoDataHoraCTe() {
        return autorizacaoDataHoraCTe;
    }

    public void setAutorizacaoDataHoraCTe(Date autorizacaoDataHoraCTe) {
        this.autorizacaoDataHoraCTe = autorizacaoDataHoraCTe;
    }

    public int getAutorizacaoProtocoloCTe() {
        return autorizacaoProtocoloCTe;
    }

    public void setAutorizacaoProtocoloCTe(int autorizacaoProtocoloCTe) {
        this.autorizacaoProtocoloCTe = autorizacaoProtocoloCTe;
    }

    public int getEmitenteCnpj() {
        return emitenteCnpj;
    }

    public void setEmitenteCnpj(int emitenteCnpj) {
        this.emitenteCnpj = emitenteCnpj;
    }

    public String getEmitenteRazaoSocial() {
        return emitenteRazaoSocial;
    }

    public void setEmitenteRazaoSocial(String emitenteRazaoSocial) {
        this.emitenteRazaoSocial = emitenteRazaoSocial;
    }

    public int getRemetenteCnpj() {
        return remetenteCnpj;
    }

    public void setRemetenteCnpj(int remetenteCnpj) {
        this.remetenteCnpj = remetenteCnpj;
    }

    public String getRemetenteRazaoSocial() {
        return remetenteRazaoSocial;
    }

    public void setRemetenteRazaoSocial(String remetenteRazaoSocial) {
        this.remetenteRazaoSocial = remetenteRazaoSocial;
    }

    public int getDestinatarioCnpj() {
        return destinatarioCnpj;
    }

    public void setDestinatarioCnpj(int destinatarioCnpj) {
        this.destinatarioCnpj = destinatarioCnpj;
    }

    public String getDestinatarioRazaoSocial() {
        return destinatarioRazaoSocial;
    }

    public void setDestinatarioRazaoSocial(String destinatarioRazaoSocial) {
        this.destinatarioRazaoSocial = destinatarioRazaoSocial;
    }

    public int getExpedidorCnpj() {
        return expedidorCnpj;
    }

    public void setExpedidorCnpj(int expedidorCnpj) {
        this.expedidorCnpj = expedidorCnpj;
    }

    public String getExpedidorRazaoSocial() {
        return expedidorRazaoSocial;
    }

    public void setExpedidorRazaoSocial(String expedidorRazaoSocial) {
        this.expedidorRazaoSocial = expedidorRazaoSocial;
    }

    public int getRecebedorCnpj() {
        return recebedorCnpj;
    }

    public void setRecebedorCnpj(int recebedorCnpj) {
        this.recebedorCnpj = recebedorCnpj;
    }

    public String getRecebedorRazaoSocial() {
        return recebedorRazaoSocial;
    }

    public void setRecebedorRazaoSocial(String recebedorRazaoSocial) {
        this.recebedorRazaoSocial = recebedorRazaoSocial;
    }

    public int getTomadorServicoCnpj() {
        return tomadorServicoCnpj;
    }

    public void setTomadorServicoCnpj(int tomadorServicoCnpj) {
        this.tomadorServicoCnpj = tomadorServicoCnpj;
    }

    public String getTomadorRazaoSocial() {
        return tomadorRazaoSocial;
    }

    public void setTomadorRazaoSocial(String tomadorRazaoSocial) {
        this.tomadorRazaoSocial = tomadorRazaoSocial;
    }

    public BigDecimal getValorTotalServicoCTe() {
        return valorTotalServicoCTe;
    }

    public void setValorTotalServicoCTe(BigDecimal valorTotalServicoCTe) {
        this.valorTotalServicoCTe = valorTotalServicoCTe;
    }

    public BigDecimal getValotTotalReceberCTe() {
        return valotTotalReceberCTe;
    }

    public void setValotTotalReceberCTe(BigDecimal valotTotalReceberCTe) {
        this.valotTotalReceberCTe = valotTotalReceberCTe;
    }

    public String getSistemaUploadStatusXml() {
        return sistemaUploadStatusXml;
    }

    public void setSistemaUploadStatusXml(String sistemaUploadStatusXml) {
        this.sistemaUploadStatusXml = sistemaUploadStatusXml;
    }

    public String getSistemaTipoRecepcaoCTe() {
        return sistemaTipoRecepcaoCTe;
    }

    public void setSistemaTipoRecepcaoCTe(String sistemaTipoRecepcaoCTe) {
        this.sistemaTipoRecepcaoCTe = sistemaTipoRecepcaoCTe;
    }

    public String getSistemaNomeArquivoCTe() {
        return sistemaNomeArquivoCTe;
    }

    public void setSistemaNomeArquivoCTe(String sistemaNomeArquivoCTe) {
        this.sistemaNomeArquivoCTe = sistemaNomeArquivoCTe;
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

    public BigDecimal getSistemaUploadObservacaoXml() {
        return sistemaUploadObservacaoXml;
    }

    public void setSistemaUploadObservacaoXml(BigDecimal sistemaUploadObservacaoXml) {
        this.sistemaUploadObservacaoXml = sistemaUploadObservacaoXml;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public CTeArquivos getCTeArquivos() {
        return cTeArquivos;
    }

    public void setCTeArquivos(CTeArquivos cTeArquivos) {
        this.cTeArquivos = cTeArquivos;
    }

    @XmlTransient
    public List<NFe> getNFeList() {
        return nFeList;
    }

    public void setNFeList(List<NFe> nFeList) {
        this.nFeList = nFeList;
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
        if (!(object instanceof CTe)) {
            return false;
        }
        CTe other = (CTe) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.CTe[ id=" + id + " ]";
    }

	@Override
	public void setArquivoXml(Arquivo a) {
		setCTeArquivos((CTeArquivos) a);		
	}

	@Override
	public Arquivo getArquivoXml() {
		return (Arquivo) getCTeArquivos();
	}
    
}
