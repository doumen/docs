package managedBeans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


public abstract class AbstractProcessosMB<T> extends AbstractListMB<T>{
	private StreamedContent file;
	private boolean download;
	private boolean flagShow;
	private String processo;
	
	public AbstractProcessosMB(Class<T> clazz) throws FileNotFoundException {
		super(clazz);
		try {
			InputStream stream = new FileInputStream(
					"/home/desenv/Downloads/teste.txt");
			file = new DefaultStreamedContent(stream, "application/txt",
					"teste.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void loadDataTables();
	
	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public void onChange(TabChangeEvent event) {
		int tab;

		tab = getIndexFromCurrentTab();

		if (tab != 0)
			setFlagShow(true);
		else
			setFlagShow(false);
	}

	public boolean isDownload() {
		return download;
	}

	public void setDownload(boolean download) {
		this.download = download;
	}

	@PostConstruct
	public void init() {		
		setFlagShow(false);
		loadDataTables();
	}

	public boolean isFlagShow() {
		return flagShow;
	}

	public void setFlagShow(boolean flagShow) {
		this.flagShow = flagShow;
	}

	public int getIndexFromCurrentTab() {
		ExternalContext external = FacesContext.getCurrentInstance()
				.getExternalContext();
		Map<String, String> requestMap = external.getRequestParameterMap();

		// procura entre todos os parâmetros o tabIndex da tab corrente
		for (String code : requestMap.keySet()) {
			if (code.contains("tabindex"))
				return Integer.parseInt(requestMap.get(code));
		}

		return -1;
	}

	public String getTituloPrimeiraAba() {
		return processo + " - Todas (" + listTable.size() + ")";
	}


	public String getTituloSegundaAba() {
		return "Recebidos e Processados (" + listTable.size() + ")";
	}

	public String getTituloTerceiraAba() {
		return "Rejeitadas (";
	}

	public String getSubTitulo(){
		return "Consulta de " + processo;
	}
	
	public String getAvisoExcluir() {
		return avisoExcluir;
	}

	public void setAvisoExcluir(String avisoExcluir) {
		this.avisoExcluir = avisoExcluir;
	}

	public String getPdfFileName() {
		return pdfFileName;
	}

	public void setPdfFileName(String pdfFileName) {
		this.pdfFileName = pdfFileName;
	}

	public String getAvisoPreExcluir() {
		return avisoPreExcluir;
	}

	public void setAvisoPreExcluir(String avisoPreExcluir) {
		this.avisoPreExcluir = avisoPreExcluir;
	}

	private String avisoExcluir;
	private String avisoPreExcluir;
	private String pdfFileName;

}
