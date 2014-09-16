package managedBeans;


public abstract class AbstractConsultaMB<T> extends AbstractListMB<T>{
	
	public AbstractConsultaMB(Class<T> clazz){
		super(clazz);
	}
	
	private String tipo;
	private String headerInclude;
	private boolean botaoAlterar;
	private boolean botaoIncluir;

	public String getAvisoExcluir(){
		return "Os itens abaixo serão excluídos";
	}

	public String getAvisoPreExcluir(){
		return selectedList.isEmpty()?"":"Tem certeza que deseja excluir os itens abaixo ?";
	}

	public abstract String getPdfFileName();
	
	public abstract void removeSelectedList();
	
	public abstract void incluir();
	
	public abstract void alterar();

	public boolean isUpdateEmptySelection(){
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
		} else if ("alterar".equals(tipo)) {
			setHeaderInclude("Alterar");
			selected = listTable.get(0);
			setBotaoIncluir(false);
			setBotaoAlterar(true);
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
}
