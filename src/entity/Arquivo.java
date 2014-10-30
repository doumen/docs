package entity;

import java.util.Date;

public interface Arquivo {
	public Integer getId();
	public byte[] getArquivoXML();
	public void setArquivoXML(byte[] arquivoXML);
	public Date getDataInclusao();
	public void setDataInclusao(Date d);
	public void setDocto(Docto d);
	public Docto getDocto();
}
