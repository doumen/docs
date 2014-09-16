package model;

import java.io.Serializable;
import java.util.Calendar;

public class Account implements Serializable {

	private static final long serialVersionUID = -7892756439010696824L;

	private Long id;

	private String email;

	private String password;

	private Calendar registryDate;

	private Boolean premmium;

	private Boolean active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Calendar getRegistryDate() {
		return registryDate;
	}

	public void setRegistryDate(Calendar registryDate) {
		this.registryDate = registryDate;
	}

	public Boolean getPremmium() {
		return premmium;
	}

	public void setPremmium(Boolean premmium) {
		this.premmium = premmium;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
