package dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import dao.PlanoDao;
import entity.Plano;
@Stateless
public class PlanoDaoImpl extends GenericDAOImpl<Plano> implements PlanoDao{

	@Override
	public List<Plano> getPlanos() throws Exception {
		return super.list();
	}

	@Override
	public Plano getPlanoById(Long valueOf) throws Exception {
		return super.find(valueOf);
	}

	@Override
	public Plano getPlanoByDescricao(String descricao) {		
		Plano plano = null;
		 try {
			 plano = (Plano) em.createNamedQuery("Plano.findByDescricao")
		   .setParameter("descricao", descricao)
		   .getSingleResult();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return plano;	}
}
