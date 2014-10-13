/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tbFaturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fatura.findAll", query = "SELECT f FROM Fatura f"),
    @NamedQuery(name = "Fatura.findById", query = "SELECT f FROM Fatura f WHERE f.id = :id"),
    @NamedQuery(name = "Fatura.findByVencimento", query = "SELECT f FROM Fatura f WHERE f.vencimento = :vencimento"),
    @NamedQuery(name = "Fatura.findByNumero", query = "SELECT f FROM Fatura f WHERE f.numero = :numero"),
    @NamedQuery(name = "Fatura.findByValor", query = "SELECT f FROM Fatura f WHERE f.valor = :valor"),
    @NamedQuery(name = "Fatura.findByEmissaoDocumento", query = "SELECT f FROM Fatura f WHERE f.emissaoDocumento = :emissaoDocumento"),
    @NamedQuery(name = "Fatura.findByNumeroNFe", query = "SELECT f FROM Fatura f WHERE f.numeroNFe = :numeroNFe"),
    @NamedQuery(name = "Fatura.findBySerie", query = "SELECT f FROM Fatura f WHERE f.serie = :serie"),
    @NamedQuery(name = "Fatura.findByEmitenteCnpj", query = "SELECT f FROM Fatura f WHERE f.emitenteCnpj = :emitenteCnpj"),
    @NamedQuery(name = "Fatura.findByEmitenteRazaoSocial", query = "SELECT f FROM Fatura f WHERE f.emitenteRazaoSocial = :emitenteRazaoSocial"),
    @NamedQuery(name = "Fatura.findByValorTotalNFe", query = "SELECT f FROM Fatura f WHERE f.valorTotalNFe = :valorTotalNFe"),
    @NamedQuery(name = "Fatura.findByDataInclusao", query = "SELECT f FROM Fatura f WHERE f.dataInclusao = :dataInclusao")})
public class Fatura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "Vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Basic(optional = false)
    @Column(name = "Numero")
    private String numero;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Valor")
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(name = "EmissaoDocumento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissaoDocumento;
    @Basic(optional = false)
    @Column(name = "NumeroNFe")
    private int numeroNFe;
    @Basic(optional = false)
    @Column(name = "Serie")
    private int serie;
    @Basic(optional = false)
    @Column(name = "EmitenteCnpj")
    private int emitenteCnpj;
    @Basic(optional = false)
    @Column(name = "EmitenteRazaoSocial")
    private String emitenteRazaoSocial;
    @Basic(optional = false)
    @Column(name = "ValorTotalNFe")
    private BigDecimal valorTotalNFe;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @JoinColumn(name = "tbNFe_Id", referencedColumnName = "Id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NFe tbNFeId;

    public Fatura() {
    }

    public Fatura(Integer id) {
        this.id = id;
    }

    public Fatura(Integer id, Date vencimento, String numero, BigDecimal valor, Date emissaoDocumento, int numeroNFe, int serie, int emitenteCnpj, String emitenteRazaoSocial, BigDecimal valorTotalNFe, Date dataInclusao) {
        this.id = id;
        this.vencimento = vencimento;
        this.numero = numero;
        this.valor = valor;
        this.emissaoDocumento = emissaoDocumento;
        this.numeroNFe = numeroNFe;
        this.serie = serie;
        this.emitenteCnpj = emitenteCnpj;
        this.emitenteRazaoSocial = emitenteRazaoSocial;
        this.valorTotalNFe = valorTotalNFe;
        this.dataInclusao = dataInclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getEmissaoDocumento() {
        return emissaoDocumento;
    }

    public void setEmissaoDocumento(Date emissaoDocumento) {
        this.emissaoDocumento = emissaoDocumento;
    }

    public int getNumeroNFe() {
        return numeroNFe;
    }

    public void setNumeroNFe(int numeroNFe) {
        this.numeroNFe = numeroNFe;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
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

    public BigDecimal getValorTotalNFe() {
        return valorTotalNFe;
    }

    public void setValorTotalNFe(BigDecimal valorTotalNFe) {
        this.valorTotalNFe = valorTotalNFe;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public NFe getTbNFeId() {
        return tbNFeId;
    }

    public void setTbNFeId(NFe tbNFeId) {
        this.tbNFeId = tbNFeId;
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
        if (!(object instanceof Fatura)) {
            return false;
        }
        Fatura other = (Fatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Faturas[ id=" + id + " ]";
    }
    
}
