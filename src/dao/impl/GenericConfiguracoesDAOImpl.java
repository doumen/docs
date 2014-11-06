package dao.impl;

import javax.ejb.Stateless;

import dao.GenericConfiguracoesDao;
import entity.Assinante;
@Stateless
public class GenericConfiguracoesDAOImpl<T> extends GenericDAOImpl<T> implements GenericConfiguracoesDao<T>{

	@Override
	public T findConfiguracoesDoAssinante(Assinante a) {
		try{
		return em.createQuery("from " + super.persistentClass.getSimpleName()
								+ " where tbAssinantesId = :assinante",persistentClass)
				.setParameter("assinante", a).getSingleResult();
		}catch(Exception e){
			return null;
		}
	}
}
