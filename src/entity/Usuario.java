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
import javax.persistence.ManyToMany;
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
@Table(name = "tbUsuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findById", query = "SELECT u FROM Usuario u WHERE u.id = :id"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByPermissaoAreaUsuario", query = "SELECT u FROM Usuario u WHERE u.permissaoAreaUsuario = :permissaoAreaUsuario"),
    @NamedQuery(name = "Usuario.findByPermissaoAreaContador", query = "SELECT u FROM Usuario u WHERE u.permissaoAreaContador = :permissaoAreaContador"),
    @NamedQuery(name = "Usuario.findByPermissaoAreaAdministrador", query = "SELECT u FROM Usuario u WHERE u.permissaoAreaAdministrador = :permissaoAreaAdministrador"),
    @NamedQuery(name = "Usuario.findByDataInclusao", query = "SELECT u FROM Usuario u WHERE u.dataInclusao = :dataInclusao")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "Usuario")
    private String login;
    @Basic(optional = false)
    @Column(name = "Senha")
    private String senha;
    @Basic(optional = false)
    @Column(name = "PermissaoAreaUsuario")
    private boolean permissaoAreaUsuario;
    @Basic(optional = false)
    @Column(name = "PermissaoAreaContador")
    private boolean permissaoAreaContador;
    @Basic(optional = false)
    @Column(name = "PermissaoAreaAdministrador")
    private boolean permissaoAreaAdministrador;
    @Basic(optional = false)
    @Column(name = "DataInclusao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInclusao;
    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    private List<Assinante> assinantesList;
    @JoinColumn(name = "tbContabilidade_Id", referencedColumnName = "Id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Contabilidade tbContabilidadeId;

    @Transient
    private Assinante assinante;
    
    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

    public Usuario(Long id, String login, String senha, boolean permissaoAreaUsuario, boolean permissaoAreaContador, boolean permissaoAreaAdministrador, Date dataInclusao) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.permissaoAreaUsuario = permissaoAreaUsuario;
        this.permissaoAreaContador = permissaoAreaContador;
        this.permissaoAreaAdministrador = permissaoAreaAdministrador;
        this.dataInclusao = dataInclusao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getPermissaoAreaUsuario() {
        return permissaoAreaUsuario;
    }

    public void setPermissaoAreaUsuario(boolean permissaoAreaUsuario) {
        this.permissaoAreaUsuario = permissaoAreaUsuario;
    }

    public boolean getPermissaoAreaContador() {
        return permissaoAreaContador;
    }

    public void setPermissaoAreaContador(boolean permissaoAreaContador) {
        this.permissaoAreaContador = permissaoAreaContador;
    }

    public boolean getPermissaoAreaAdministrador() {
        return permissaoAreaAdministrador;
    }

    public void setPermissaoAreaAdministrador(boolean permissaoAreaAdministrador) {
        this.permissaoAreaAdministrador = permissaoAreaAdministrador;
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

    public Contabilidade getContabilidade() {
        return tbContabilidadeId;
    }

    public void setContabilidade(Contabilidade tbContabilidadeId) {
        this.tbContabilidadeId = tbContabilidadeId;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Usuarios[ id=" + id + " ]";
    }

	public Assinante getAssinante() {
		return assinante;
	}

	public void setAssinante(Assinante assinante) {
		this.assinante = assinante;
	}
    
}
