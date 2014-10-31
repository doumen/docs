package model;

public class ChaveDocto {
	
	private AjaxStatus ajaxStatus;
	private String chave;
	private String mensagem;
	private int progresso;
	
	public ChaveDocto(String chave){
		this.chave = chave;
		this.ajaxStatus = AjaxStatus.Aguardando;
		this.mensagem = "";
	}
	
	public ChaveDocto(){
		this.chave = "";
	}
	
	public AjaxStatus getAjaxStatus() {
		return ajaxStatus;
	}
	public void setAjaxStatus(AjaxStatus ajaxStatus) {
		this.ajaxStatus = ajaxStatus;
	}
	public String getChave() {
		return chave==null?"":chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getProgresso() {
		return progresso;
	}

	public void setProgresso(int progresso) {
		this.progresso = progresso;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj==this)
			return true;
		if(!(obj instanceof ChaveDocto))
			return false;
		ChaveDocto other = (ChaveDocto) obj;
		return other.getChave().equals(this.chave);
	}
	@Override
	public int hashCode() {		
		return getChave().hashCode();
	}
}
