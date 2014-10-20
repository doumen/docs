package dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import dao.AssinanteDao;
import entity.Assinante;

@Stateless
public class AssinanteDaoImpl extends GenericDAOImpl<Assinante> implements AssinanteDao{
	
	public List<Assinante> getAssinantes(){
		 return em.createQuery("from Assinante a join fetch a.plano Plano join fetch a.contabilidade Contabilidade",Assinante.class).getResultList();		 
	}
}
