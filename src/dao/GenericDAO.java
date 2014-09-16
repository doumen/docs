package dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public abstract class GenericDAO<T> {

	public abstract EntityManager getEntityManager();

	public List<T> findAll() {
		ArrayList<T> a = new ArrayList<>();
		
		return a;
	}
	
	
}
