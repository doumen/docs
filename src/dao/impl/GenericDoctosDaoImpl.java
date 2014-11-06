package dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import dao.GenericDoctosDao;
import entity.Assinante;
@Stateless
public class GenericDoctosDaoImpl<T> extends GenericDAOImpl<T> implements GenericDoctosDao<T>{

	@Override
	public List<T> findDoctosDoAssinante(Assinante a) {
		try{
		return em.createQuery("from " + super.persistentClass.getSimpleName()
				+ " where tbAssinantesId = :assinante",persistentClass)
				.setParameter("assinante", a).getResultList();
		}catch(Exception e){
			return null;
		}
	}
}
