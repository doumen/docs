package dao.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TransactionRequiredException;

import model.Util;
import converter.ConvertByField;
import dao.GenericDao;
import entity.Assinante;
@Stateless
public class GenericDAOImpl<T> implements GenericDao<T> {
	@PersistenceContext
	protected EntityManager em;

	private final Class<T> persistentClass;

	/**
	 * Método responsável pela instanciação e extração da classe persistente.
	 */
	@SuppressWarnings("unchecked")	
	public GenericDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * Método responsável pela persistência de uma instância da classe
	 * persistente.
	 * 
	 * @param t
	 *            T
	 * @return Boolean
	 * @throws EntityExistsException
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 * @throws PersistenceException
	 */

	public boolean persist(T t) throws Exception {
		try {
			Util.removeMask(t);
			em.persist(t);
			em.flush();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método responsável pela atualização de uma instância da classe
	 * persistente.
	 * 
	 * @param t
	 *            T
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean merge(T t) throws Exception {

		try {
			Util.removeMask(t);
			em.merge(t);
			em.flush();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método responsável pela remoção de uma instância da classe persistente.
	 * 
	 * @param t
	 *            T
	 * @return Boolean
	 * @throws IllegalArgumentException
	 * @throws TransactionRequiredException
	 */
	public boolean remove(T entity) throws Exception {
		try {
			em.remove(em.contains(entity) ? entity : em.merge(entity));
			em.flush();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * Método responsável pela busca de uma instância da classe persistente pela
	 * chave-primária.
	 * 
	 * @param pk
	 *            Long
	 * @return T
	 * @throws IllegalArgumentException
	 */
	public T find(Long pk) throws Exception {

		try {
			return em.find(this.persistentClass, pk);
		} catch (Exception e) {
			throw e;
		}
	}

	public T find(String id) throws Exception {
		return find(Long.valueOf(id));
	}

	/**
	 * Método responsável pela listagem de instâncias da classe persistente.
	 * 
	 * @return List<T>
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public List<T> list() throws Exception {

		try {
			return em.createQuery(
					"from " + this.persistentClass.getSimpleName())
					.getResultList();
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 * Método que reconstrói o objeto pelo resultado do seu método toString
	 */
	@SuppressWarnings("unchecked")
	public T findByToAnnotadedField(String toString) {
		for (Field f : this.persistentClass.getDeclaredFields()) {
			if (f.isAnnotationPresent(ConvertByField.class)) {
				return (T) em
						.createQuery(
								"from " + this.persistentClass.getSimpleName()
										+ " where " + f.getName()
										+ "=:toString")
						.setParameter("toString", toString).getSingleResult();
			}
		}
		return null;
	}

	@Override
	public Integer countDoctos(Assinante a,Date d) {
		// Assuming that the Query is strQ
		try {
			String strQ = "select count(id) from "
					+ this.persistentClass.getSimpleName()
					+ " where assinante = :ass and dataInclusao < :data";
			return (Integer) em.createQuery(strQ).setParameter("ass", a).setParameter("data", d).getSingleResult();
		} catch (Exception e) {			
			return 0;
		}
	}
}
