package managedBeans;

import managedBeans.components.RelatorioJasperMB;

public abstract class AbstractConsultaMB<T> extends AbstractListMB<T> {

	public AbstractConsultaMB(Class<T> clazz) {
		super(clazz);
	}

	private String tipo;
	private String headerInclude;
	private boolean botaoAlterar;
	private boolean botaoIncluir;
	private boolean showUploadNome;
	private boolean showUpload;

	public abstract String getAvisoExcluir();

	public abstract String getAvisoPreExcluir();

	public abstract String getPdfFileName();

	public void removeSelectedList() {
		listTable.removeAll(selectedList);
	}

	public abstract void incluir();
	
	public abstract void alterar();

	public boolean isUpdateEmptySelection() {
		return "alterar".equals(tipo) && selectedList.isEmpty();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		if ("incluir".equals(tipo)) {
			super.limpar();
			setHeaderInclude("Incluir");
			setBotaoIncluir(true);
			setBotaoAlterar(false);
			setShowUpload(true);
			setShowUploadNome(false);
		} else if ("alterar".equals(tipo)) {
			setHeaderInclude("Alterar");
			selected = listTable.get(0);
			setBotaoIncluir(false);
			setBotaoAlterar(true);
			setShowUpload(false);
			setShowUploadNome(true);
		}
		this.tipo = tipo;
	}

	public String getHeaderInclude() {
		return headerInclude;
	}

	public void setHeaderInclude(String headerInclude) {
		this.headerInclude = headerInclude;
	}

	public boolean isBotaoAlterar() {
		return botaoAlterar;
	}

	public void setBotaoAlterar(boolean botaoAlterar) {
		this.botaoAlterar = botaoAlterar;
	}

	public boolean isBotaoIncluir() {
		return botaoIncluir;
	}

	public void setBotaoIncluir(boolean botaoIncluir) {
		this.botaoIncluir = botaoIncluir;
	}
	
	public void print(){
		try{
			createRelatorioJasperMB().browserReport();
		}catch(Exception e){
			System.out.println("errou");
			e.printStackTrace();
		}
	}
	
	private RelatorioJasperMB<T> createRelatorioJasperMB(){
		RelatorioJasperMB<T> r = new RelatorioJasperMB<>();
		r.setBeans(listTable);
		r.setReport(getPdfFileName());
		return r;
	}
	
	public void exportPdf(){
		try{
			createRelatorioJasperMB().downloadReport();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public boolean isShowUploadNome() {
		return showUploadNome;
	}

	public void setShowUploadNome(boolean showUploadNome) {
		this.showUploadNome = showUploadNome;
	}

	public boolean isShowUpload() {
		return showUpload;
	}

	public void setShowUpload(boolean showUpload) {
		this.showUpload = showUpload;
	}


}