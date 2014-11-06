package managedBeans;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import dao.GenericConfiguracoesDao;
import dao.GenericDoctosDao;
import dao.NFeConfiguracoesDao;
import dao.NFeDao;
import entity.NFe;
import entity.NFeConfiguracoes;

@ManagedBean
@ViewScoped
public class ConsultaNFeAssMB extends AbstractProcessosMB<NFeConfiguracoes, NFe>{

	@Inject 
	private NFeDao nfeDao;
	
	@Inject
	private NFeConfiguracoesDao nFeConfiguracoesDao;
	
	@Override
	public GenericConfiguracoesDao<NFeConfiguracoes> getDaoConfig() {
		return nFeConfiguracoesDao;
	}

	@Override
	public GenericDoctosDao<NFe> getDaoDoctos() {
		return nfeDao;
	}

	@Override
	public void setCamposDoConfiguracoesManagedBeansParaOConfig(
			ConfiguracoesManagedBeans configuracoesManagedBeans,
			NFeConfiguracoes config) {
		// TODO Auto-generated method stub
		config.setDownloadBaixarArquivoPDF(configuracoesManagedBeans.isDownExportArqPdf());
		config.setDownloadBaixarArquivoXML(configuracoesManagedBeans.isDownBaixarArqXml());
		config.setDownloadCompactarArquivoFormatoZIP(configuracoesManagedBeans.isDownCompactarArqZip());
		config.setEnviarEmailComEncriptacaoSSL(configuracoesManagedBeans.isEnviarAutenticacao());
		config.setEnviarEmailCompactarArquivoFormatoZIP(configuracoesManagedBeans.isEnviarArqCompactado());
		config.setEnviarEmailDestino(configuracoesManagedBeans.getEnviarEmailDestino());
	}

	@Override
	public void setCamposDoConfigParaOConfiguracoesManagedBeans(
			NFeConfiguracoes config,
			ConfiguracoesManagedBeans configuracoesManagedBeans) {
		// TODO Auto-generated method stub
		
	}

	
}
