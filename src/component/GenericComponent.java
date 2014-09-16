package component;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.GenericDAO;

@Stateless
public abstract class GenericComponent<T> {

	public abstract boolean removeuComSucesso(T entity);

	@Inject
	private GenericDAO<T> dao;
	
	public List<T> findAll() {
		return dao.findAll();
	}
	
}
