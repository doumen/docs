package model;

import java.util.Calendar;

public class Usuario {

	private int id;
	private String login;
	private String senha;
	private transient Assinante assinante;
	private Boolean permissaoAreaAssinante;
	private Boolean permissaoAreaContador;
	private Calendar dataInclusao;
	private transient Contabilidade contabilidade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login == null ? "" : login;
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

	public Assinante getAssinante() {
		return assinante;
	}

	public void setAssinante(Assinante assinante) {
		this.assinante = assinante;
	}

	public Boolean getPermissaoAreaAssinante() {
		return permissaoAreaAssinante;
	}

	public void setPermissaoAreaAssinante(Boolean permissaoAreaAssinante) {
		this.permissaoAreaAssinante = permissaoAreaAssinante;
	}

	public Boolean getPermissaoAreaContador() {
		return permissaoAreaContador;
	}

	public void setPermissaoAreaContador(Boolean permissaoAreaContador) {
		this.permissaoAreaContador = permissaoAreaContador;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Usuario))
			return false;
		Usuario u = (Usuario) obj;
		if (u.login == null)
			return false;
		return u.login.equals(login);
	}

	@Override
	public int hashCode() {
		int r = 17;
		r = 31 * r + getLogin().hashCode();
		return r;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Contabilidade getContabilidade() {
		return contabilidade;
	}

	public void setContabilidade(Contabilidade contabilidade) {
		this.contabilidade = contabilidade;
	}

}
