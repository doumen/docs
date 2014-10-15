package dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.AssinanteDao;
import entity.Assinante;

@Stateless
public class AssinanteDaoImpl extends GenericDAOImpl<Assinante> implements AssinanteDao{
	
	public List<Assinante> getAssinantes(){
		Query createNamedQuery = em.createNamedQuery("Assinante.findAll");
		List<Assinante> resultList = createNamedQuery.getResultList();
		 return resultList;		 
	}
}
