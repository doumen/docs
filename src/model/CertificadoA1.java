package model;

import java.util.Calendar;

public class CertificadoA1 {
	private Long id;
	private byte[] arquivo_PFX_certificadoA1;
	private boolean notificarExpiracaoCertificado;
	private Calendar dataInclusao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getArquivo_PFX_certificadoA1() {
		return arquivo_PFX_certificadoA1;
	}

	public void setArquivo_PFX_certificadoA1(byte[] arquivo_PFX_certificadoA1) {
		this.arquivo_PFX_certificadoA1 = arquivo_PFX_certificadoA1;
	}

	public boolean isNotificarExpiracaoCertificado() {
		return notificarExpiracaoCertificado;
	}

	public void setNotificarExpiracaoCertificado(
			boolean notificarExpiracaoCertificado) {
		this.notificarExpiracaoCertificado = notificarExpiracaoCertificado;
	}

	public Calendar getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Calendar dataInclusao) {
		this.dataInclusao = dataInclusao;
	}
}
