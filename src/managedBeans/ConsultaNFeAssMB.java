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

	public ConsultaNFeAssMB() {
		super(NFeConfiguracoes.class, NFe.class);
	}

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
	public void setCamposDoConfiguracoesManagedBeansParaOConfig(NFeConfiguracoes config) {
		
		config.setDownloadBaixarArquivoPDF(isDownExportArqPdf());
		config.setDownloadBaixarArquivoXML(isDownBaixarArqXml());
		config.setDownloadCompactarArquivoFormatoZIP(isDownCompactarArqZip());

		config.setEnviarEmailEnderecoServidorPop(getEnviarProvedor());
		config.setEnviarEmailComEncriptacaoSSL(isEnviarEmailComEncriptacaoSSL());
		config.setEnviarEmailSemEncriptacao(isEnviarEmailSemEncriptacao());
		config.setEnviarEmailPorta(getEnviarPorta());
		config.setEnviarEmailRequerAutenticacao(isEnviarAutenticacao());
		config.setEnviarEmailRemetenteEmail(getEnviarEmailOrigem());
		config.setEnviarEmailRemetenteSenha(getEnviarSenha());
		config.setEnviarEmailDestino(getEnviarEmailDestino());
		config.setEnviarEmailEnviarArquivoXML(isEnviarArqXml());
		config.setEnviarEmailEnviarArquivoPDF(isEnviarArqPdf());
		config.setEnviarEmailCompactarArquivoFormatoZIP(isEnviarArqCompactado());
		
		config.setReceberEmailEnderecoServidorSMTP(getReceberProvedor());
		config.setReceberEmailPorta(getReceberPorta());
		config.setReceberEmailSemEncriptacao(isReceberEmailSemEncriptacao());
		config.setReceberEmailComEncriptacaoSSL(isReceberEmailComEncriptacaoSSL());
		config.setReceberEmailComEncriptacaoTLS(isReceberEmailComEncriptacaoTSL());
		config.setReceberEmailRequerAutenticacao(isReceberAutenticacao());
		config.setReceberEmailRemetenteEmail(getReceberEmail());
		config.setReceberEmailRemetenteSenha(getReceberSenha());
	}

	@Override
	public void setCamposDoConfigParaOConfiguracoesManagedBeans(
			NFeConfiguracoes config) {
		
		setDownExportArqPdf(config.getDownloadBaixarArquivoPDF());
		setDownBaixarArqXml(config.getDownloadBaixarArquivoXML()) ;
		setDownCompactarArqZip(config.getDownloadCompactarArquivoFormatoZIP()) ;

		setEnviarProvedor(config.getEnviarEmailEnderecoServidorPop()) ;
		setEnviarEmailComEncriptacaoSSL(config.getEnviarEmailComEncriptacaoSSL()) ;
		setEnviarEmailSemEncriptacao(config.getEnviarEmailSemEncriptacao()) ;
		setEnviarPorta(config.getEnviarEmailPorta()) ;
		setEnviarAutenticacao(config.getEnviarEmailRequerAutenticacao()) ;
		setEnviarEmailOrigem(config.getEnviarEmailRemetenteEmail()) ;
		setEnviarSenha(config.getEnviarEmailRemetenteSenha());
		setEnviarEmailDestino(config.getEnviarEmailDestino());
		setEnviarArqXml(config.getEnviarEmailEnviarArquivoXML());
		setEnviarArqPdf(config.getEnviarEmailEnviarArquivoPDF());
		setEnviarArqCompactado(config.getEnviarEmailCompactarArquivoFormatoZIP());
		
		setReceberProvedor(config.getReceberEmailEnderecoServidorSMTP());
		setReceberPorta(config.getReceberEmailPorta());
		setReceberEmailSemEncriptacao(config.getReceberEmailSemEncriptacao());
		setReceberEmailComEncriptacaoSSL(config.getReceberEmailComEncriptacaoSSL());
		setReceberEmailComEncriptacaoTSL(config.getReceberEmailComEncriptacaoTLS());
		setReceberAutenticacao(config.getReceberEmailRequerAutenticacao());
		setReceberEmail(config.getReceberEmailRemetenteEmail());
		setReceberSenha(config.getReceberEmailRemetenteSenha());
	}

	
}
