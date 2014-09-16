package managedBeans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import component.GenericComponent;

import facade.GenericCRUDFacade;

@ManagedBean
public abstract class AbstractCRUDManagedBean<T> {
	
	protected List<T> itensSelecionados;

	protected List<T> listaItens;
	
	protected GenericCRUDFacade<T> genericCRUDFacade;
		
	private T entity;
	
	@Inject
	protected GenericComponent<T> component;
			
	public List<T> getItensSelecionados() {
		return itensSelecionados;
	}

	@PostConstruct
	public void init(){
		genericCRUDFacade = createGenericCRUDFacade();
		dataTableColumnLabel = createDataTableColumnLabel();
	}
	
	protected abstract GenericCRUDFacade<T> createGenericCRUDFacade();
	
	protected abstract Map<String,Object> createDataTableColumnLabel();
	
	protected Map<String,Object> dataTableColumnLabel;
	
	public Map<String,Object> getDataTableColumnLabel(){
		return dataTableColumnLabel==null?new HashMap<String,Object>():dataTableColumnLabel;
	}
	
	public void setItensSelecionados(List<T> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}

	public List<T> getListaItens() {
		return listaItens==null?new ArrayList<T>():component.findAll();
	}

	public void removeItens(){
		if(genericCRUDFacade.acaoAntesRemover(getEntity())){
			if(!component.removeuComSucesso(getEntity()));
				genericCRUDFacade.acaoComponenteNaoRemoveuComSucesso();
		}else{
			genericCRUDFacade.acaoNaoRemocao(getEntity());
		}
	}

	public T getEntity() {		
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	
	
}
