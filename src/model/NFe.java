package model;

import java.util.Calendar;

public class NFe {
	
	private Long id;
	private Calendar emissaoNFe;
	private int chaveNFe;
	private Calendar  autorizacaoDataHoraNFe;
	private int autorizacaoProtocoloNFe;
	private char entradaSaidaNFe;
	private StatusNFe statusNFe;
	private boolean manifestoRealizado;
	private Calendar mainifestoDataHora;
	private ManifestoTipoEvento manifestoTipoEvento;
	private String manifestoJustificativa;
	private int numeroNFe;
	private short serieNfe;
	private int emitenteCnpj;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getEmissaoNFe() {
		return emissaoNFe;
	}
	public void setEmissaoNFe(Calendar emissaoNFe) {
		this.emissaoNFe = emissaoNFe;
	}
	public int getChaveNFe() {
		return chaveNFe;
	}
	public void setChaveNFe(int chaveNFe) {
		this.chaveNFe = chaveNFe;
	}
	public Calendar getAutorizacaoDataHoraNFe() {
		return autorizacaoDataHoraNFe;
	}
	public void setAutorizacaoDataHoraNFe(Calendar autorizacaoDataHoraNFe) {
		this.autorizacaoDataHoraNFe = autorizacaoDataHoraNFe;
	}
	public int getAutorizacaoProtocoloNFe() {
		return autorizacaoProtocoloNFe;
	}
	public void setAutorizacaoProtocoloNFe(int autorizacaoProtocoloNFe) {
		this.autorizacaoProtocoloNFe = autorizacaoProtocoloNFe;
	}
	public char getEntradaSaidaNFe() {
		return entradaSaidaNFe;
	}
	public void setEntradaSaidaNFe(char entradaSaidaNFe) {
		this.entradaSaidaNFe = entradaSaidaNFe;
	}
	public StatusNFe getStatusNFe() {
		return statusNFe;
	}
	public void setStatusNFe(StatusNFe statusNFe) {
		this.statusNFe = statusNFe;
	}
	
}
