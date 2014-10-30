package managedBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

public abstract class AbstractListMB<T> {

	public AbstractListMB(Class<T> clazz) {
		try {
			this.selected = clazz.newInstance();
			this.selectedClass = clazz;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	private Class<T> selectedClass;

	@PostConstruct
	public void iniciar() {
		this.init();		
	}

	protected List<T> selectedList = new ArrayList<>();

	protected List<T> listTable = new ArrayList<>();

	protected T selected;

	public List<T> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(List<T> selectedList) {
		this.selectedList = selectedList;
	}

	public List<T> getListTable() {
		return listTable;
	}

	public abstract void init();

	public T getSelected() {
		return selected;
	}

	public void setSelected(T selected) {
		if(selected!=null)
			this.selected = selected;		
		else if(selectedList != null && !selectedList.isEmpty())
			this.selected = selectedList.get(0);		
	}

	public void limpar() {
		try {
			this.selected = selectedClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}