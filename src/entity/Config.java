package entity;

import java.util.Date;

public interface Config {

	public Assinante getAssinante();
	public void setAssinante(Assinante a);
	public void setDataInclusao(Date d);
	public Date getDataInclusao();
}
