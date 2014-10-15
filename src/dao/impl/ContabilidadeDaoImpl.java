package dao.impl;

import javax.ejb.Stateless;

import dao.ContabilidadeDao;
import entity.Contabilidade;
import entity.Plano;

@Stateless
public class ContabilidadeDaoImpl extends GenericDAOImpl<Contabilidade> implements ContabilidadeDao{

	@Override
	public Contabilidade getContabilidadeByNomeFantasia(String nomeFantasia) {
		Contabilidade plano = null;
		 try {
			 plano = (Contabilidade) em.createNamedQuery("Plano.findByDescricao")
		   .setParameter("descricao", nomeFantasia)
		   .getSingleResult();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return plano;
	}
		
}
