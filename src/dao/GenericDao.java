package dao;

import java.util.List;

public interface GenericDao<T> {
	public boolean persist(T t) throws Exception;
	public boolean merge(T t) throws Exception;
	public boolean remove(T t) throws Exception;
	public T find(Long pk) throws Exception;
	public T find(String id) throws Exception;
	public List<T> list() throws Exception ;
	public T findByToAnnotadedField(String toString);
}
