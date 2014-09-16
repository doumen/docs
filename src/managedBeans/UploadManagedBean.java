package managedBeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UploadManagedBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer progressEnviarArquivo;
	private Integer progressProcessarNfe;

	public Integer getProgressEnviarArquivo() {
		if (progressEnviarArquivo == null) {
			progressEnviarArquivo = 0;
		} else {
			progressEnviarArquivo = progressEnviarArquivo
					+ (int) (Math.random() * 35);

			if (progressEnviarArquivo > 100)
				progressEnviarArquivo = 100;
		}

		return progressEnviarArquivo;
	}

	public void setProgress(Integer progressEnviarArquivo) {
		this.progressEnviarArquivo = progressEnviarArquivo;
	}

	public Integer getProgressProcessarNfe() {
		if (progressProcessarNfe == null) {
			progressProcessarNfe = 0;
		} else {
			progressProcessarNfe = progressProcessarNfe
					+ (int) (Math.random() * 35);

			if (progressProcessarNfe > 100)
				progressProcessarNfe = 100;
		}

		return progressProcessarNfe;
	}

	public void setProgressProcessarNfe(Integer progressProcessarNfe) {
		this.progressProcessarNfe = progressProcessarNfe;
	}
}
