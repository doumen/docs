package dao.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.ContabilidadeDao;
import dao.UsuarioDao;
import entity.Contabilidade;
@Stateless
public class ContabilidadeDaoImpl extends GenericDAOImpl<Contabilidade> implements ContabilidadeDao{

	@EJB
	private UsuarioDao usuarioDao;
	
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

	@Override
	public List<Contabilidade> getContabilidadesFetch() {		
		return em.createQuery("select distinct c from Contabilidade c left join fetch c.usuariosList where c.ativo=true",Contabilidade.class).getResultList();
	}

	@Override
	public Contabilidade findByIdFetch(Contabilidade contabilidade) {
//		Contabilidade result;
		return em.createQuery("from Contabilidade c left join fetch c.usuariosList where c.id=:id",Contabilidade.class).setParameter("id", contabilidade.getId()).getSingleResult();
//		em.detach(result);
//		return result;
	}

	@Override
	public List<Contabilidade> getContabilidadesNaoFetch() {
		return em.createQuery("from Contabilidade c where c.ativo=true",Contabilidade.class).getResultList();
	}

	@Override
	public Contabilidade findByCnpjFetch(Contabilidade contabilidade) {
		return em.createQuery("from Contabilidade c left join fetch c.usuariosList where c.cnpj=:id",Contabilidade.class).setParameter("id", contabilidade.getCnpj()).getSingleResult();
	}
	
	/*
	@Override
	public boolean merge(Contabilidade t) throws Exception {
		for(Usuario u:t.getUsuarios())
			usuarioDao.merge(u);
		return super.merge(t);
	}	
	*/
}
