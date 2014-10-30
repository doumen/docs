package entity;

import java.util.Date;

public interface Docto {
	public Integer getId();
	public Date getDataInclusao();
	public void setDataInclusao(Date d);
	public void setArquivoXml(Arquivo a);
	public Arquivo getArquivoXml();
	public void setAssinante(Assinante a);
	public Assinante getAssinante();
}
