/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
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
@Table(name = "tbPlanos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plano.findAll", query = "SELECT p FROM Plano p"),
    @NamedQuery(name = "Plano.findById", query = "SELECT p FROM Plano p WHERE p.id = :id"),
    @NamedQuery(name = "Plano.findByDescricao", query = "SELECT p FROM Plano p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Plano.findByFaixaInicial", query = "SELECT p FROM Plano p WHERE p.faixaInicial = :faixaInicial"),
    @NamedQuery(name = "Plano.findByFaixaFinal", query = "SELECT p FROM Plano p WHERE p.faixaFinal = :faixaFinal"),
    @NamedQuery(name = "Plano.findByValorMensal", query = "SELECT p FROM Plano p WHERE p.valorMensal = :valorMensal"),
    @NamedQuery(name = "Plano.findByValorDoctoAdicional", query = "SELECT p FROM Plano p WHERE p.valorDoctoAdicional = :valorDoctoAdicional"),
    @NamedQuery(name = "Plano.findByTipoInclusao", query = "SELECT p FROM Plano p WHERE p.tipoInclusao = :tipoInclusao"),
    @NamedQuery(name = "Plano.findByDataInclusao", query = "SELECT p FROM Plano p WHERE p.dataInclusao = :dataInclusao")})
public class Plano implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Descricao")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "FaixaInicial")
    private int faixaInicial;
    @Basic(optional = false)
    @Column(name = "FaixaFinal")
    private int faixaFinal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ValorMensal")
    private BigDecimal valorMensal;
    @Basic(optional = false)
    @Column(name = "ValorDoctoAdicional")
    private BigDecimal valorDoctoAdicional;
    @Basic(optional = false)
    @Column(name = "TipoInclusao")
    private String tipoInclusao;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbPlanosId", fetch = FetchType.LAZY)
    private List<Assinante> assinantesList;

    public Plano() {
    }

    public Plano(Long id) {
        this.id = id;
    }

    public Plano(Long id, String descricao, int faixaInicial, int faixaFinal, BigDecimal valorMensal, BigDecimal valorDoctoAdicional, String tipoInclusao, Date dataInclusao) {
        this.id = id;
        this.descricao = descricao;
        this.faixaInicial = faixaInicial;
        this.faixaFinal = faixaFinal;
        this.valorMensal = valorMensal;
        this.valorDoctoAdicional = valorDoctoAdicional;
        this.tipoInclusao = tipoInclusao;
        this.dataInclusao = dataInclusao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFaixaInicial() {
        return faixaInicial;
    }

    public void setFaixaInicial(int faixaInicial) {
        this.faixaInicial = faixaInicial;
    }

    public int getFaixaFinal() {
        return faixaFinal;
    }

    public void setFaixaFinal(int faixaFinal) {
        this.faixaFinal = faixaFinal;
    }

    public BigDecimal getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(BigDecimal valorMensal) {
        this.valorMensal = valorMensal;
    }

    public BigDecimal getValorDoctoAdicional() {
        return valorDoctoAdicional;
    }

    public void setValorDoctoAdicional(BigDecimal valorDoctoAdicional) {
        this.valorDoctoAdicional = valorDoctoAdicional;
    }

    public String getTipoInclusao() {
        return tipoInclusao;
    }

    public void setTipoInclusao(String tipoInclusao) {
        this.tipoInclusao = tipoInclusao;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    @XmlTransient
    public List<Assinante> getAssinantesList() {
        return assinantesList;
    }

    public void setAssinantesList(List<Assinante> assinantesList) {
        this.assinantesList = assinantesList;
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
        if (!(object instanceof Plano)) {
            return false;
        }
        Plano other = (Plano) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Planos[ id=" + id + " ]";
    }

	public void setValorMensal(double d) {
		// TODO Auto-generated method stub
		
	}

	public void setValorNfeAdicional(double d) {
		// TODO Auto-generated method stub
		
	}

	public void setDataInclusao(Calendar instance) {
		// TODO Auto-generated method stub
		
	}
    
}
