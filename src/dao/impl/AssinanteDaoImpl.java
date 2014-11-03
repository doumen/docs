package dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import model.AssinanteReport;
import model.Modulo;
import dao.AssinanteDao;
import entity.Assinante;
import entity.Contabilidade;
import entity.Usuario;

@Stateless
public class AssinanteDaoImpl extends GenericDAOImpl<Assinante> implements AssinanteDao{
	
	private String assinantesComTodosOsDoctos = "select distinct a from Assinante a "
				+ "join fetch a.plano Plano "
				+ "join fetch a.contabilidade Contabilidade "
				+ "left join fetch a.spedsContribuicoes sc "
				+ "left join fetch a.spedsSociais ss "
				+ "left join fetch a.spedsFiscais sf "
				+ "left join fetch a.nFes nf "
				+ "left join fetch a.cTes ct ";
	
	private String assinantesAtivosComTodosOsDoctos = "select distinct a from Assinante a "
			+ "join fetch a.plano Plano "
			+ "join fetch a.contabilidade Contabilidade "
			+ "left join fetch a.spedsContribuicoes sc "
			+ "left join fetch a.spedsSociais ss "
			+ "left join fetch a.spedsFiscais sf "
			+ "left join fetch a.nFes nf "
			+ "left join fetch a.cTes ct "
			+ "where a.ativo=true";
	
	public List<Assinante> getAssinantes(){
		 return em.createQuery("from Assinante a join fetch a.plano Plano join fetch a.contabilidade Contabilidade where a.ativo=true",Assinante.class).getResultList();		 
	}

	@Override
	public Assinante findByCnpj(Assinante selected) {		
		return em.createQuery("select distinct a from Assinante a join fetch a.plano Plano join fetch a.contabilidade Contabilidade join fetch a.usuarios where a.cnpj = :cnpj",Assinante.class).setParameter("cnpj", selected.getCnpj()).getSingleResult();
	}

	@Override
	public List<Assinante> getAssinantesDoUsuario(Usuario u,Modulo m) {
		
		StringBuilder s = new StringBuilder("from Assinante a join fetch a.plano Plano join fetch "
					+ "a.contabilidade Contabilidade join fetch a.usuarios u where a.ativo=true and u.login=:login");
		
		if(Modulo.ADMINISTRATIVO.equals(m)){
			s = new StringBuilder("from Usuario u where u.permissaoAreaAdministrador = true and u.login=:login");
			List<Usuario> user = em.createQuery(s.toString(),Usuario.class).setParameter("login", u.getLogin()).getResultList();
			List<Assinante> ass = new ArrayList<>();
			if(user.size()>0)
				ass.add(new Assinante());
			return ass;
		}
		else if(Modulo.ASSINANTE.equals(m)){
			Usuario user;
			try{
				user = em.createQuery("from Usuario u join fetch u.tbContabilidadeId c where u.permissaoAreaUsuario = true and u.login=:login and c.ativo=true",Usuario.class)
					.setParameter("login", u.getLogin()).getSingleResult();
			}catch (Exception e) {
				try{
				user = em.createQuery("from Usuario u join fetch u.assinantesList a where u.permissaoAreaUsuario = true and u.login=:login and a.ativo=true",Usuario.class)
						.setParameter("login", u.getLogin()).getSingleResult();
				}catch(Exception ex){
					user = null;
				}
			}
			List<Assinante> ass = new ArrayList<>();
			if(user != null && user.getContabilidade() != null){
				ass = em.createQuery("from Assinante a join fetch a.contabilidade c where c = :cont",Assinante.class).setParameter("cont", user.getContabilidade()).getResultList();
			}
			if(user != null && !user.getAssinantesList().isEmpty()){
				return user.getAssinantesList();
			}				
			if(user!=null && ass.isEmpty())
				ass.add(new Assinante());				
			return ass;			
		}
		else if(Modulo.CONTABILIDADE.equals(m)){
			Usuario user = em.createQuery("from Usuario u join fetch u.tbContabilidadeId c where u.permissaoAreaContador = true and u.login=:login and c.ativo=true",Usuario.class)
					.setParameter("login", u.getLogin()).getSingleResult();
			s.append(" and u.permissaoAreaContador = true");

			//Contabildade com Assinantes
			List<Assinante> ass = em.createQuery("from Assinante a join fetch a.contabilidade c where c = :cont",Assinante.class).setParameter("cont", user.getContabilidade()).getResultList();
			
				if(user!=null && ass.isEmpty())
					ass.add(new Assinante());				
			return ass;			
		}
		return null;
	}

	@Override
	public List<Assinante> getAssinantesComTodosOsDoctos() {		
		return em.createQuery(assinantesComTodosOsDoctos,Assinante.class).getResultList();
	}
	
	@Override
	public List<Assinante> getAssinantesComTodosOsDoctos(Date d) {		
		return em.createQuery(assinantesComTodosOsDoctos + " and a.dataInclusao < :d",Assinante.class).setParameter("d", d).getResultList();
	}
	
	@Override
	public List<AssinanteReport> getAssinanteReportAteAData(Date d,String doctoListField) {
		String q = "select new model.AssinanteReport(day(nf.dataInclusao),month(nf.dataInclusao),year(nf.dataInclusao),count(nf.id),a) from Assinante a "
				+ "inner join a.plano Plano "
				+ "inner join a.contabilidade Contabilidade "
				+ "left join a."+ doctoListField + " nf "
				+ "where a.ativo=true and nf.dataInclusao < :data "
				+ "group by day(nf.dataInclusao) || month(nf.dataInclusao) || year(nf.dataInclusao)|| a";
		return em.createQuery(q,AssinanteReport.class).setParameter("data", d).getResultList();
	}

	@Override
	public List<AssinanteReport> getAssinantesSemNota(Date d) {
		String q = "select new model.AssinanteReport(day(nf.dataInclusao),month(nf.dataInclusao),year(nf.dataInclusao),count(nf.id)) from Assinante a "
				+ "inner join a.plano Plano "
				+ "inner join a.contabilidade Contabilidade "
				+ "left join a.nFes nf "
				+ "where a.ativo=true and nf.dataInclusao < :data "
				+ "group by day(nf.dataInclusao) || month(nf.dataInclusao) || year(nf.dataInclusao)";
		return em.createQuery(q,AssinanteReport.class).setParameter("data", d).getResultList();
	}

	@Override
	public List<Assinante> getAssinantesAtivosComTodosOsDoctos() {
		return em.createQuery(assinantesAtivosComTodosOsDoctos,Assinante.class).getResultList();
	}

	@Override
	public List<Assinante> getAssinantesComTodosOsDoctos(
			Contabilidade contabilidade) {
		return em.createQuery(assinantesAtivosComTodosOsDoctos + " and a.contabilidade = :cont",Assinante.class).setParameter("cont", contabilidade).getResultList();
	}

	@Override
	public Assinante getAssinanteComTodosDoctos(Assinante assinanteId) {
		return em.createQuery(assinantesAtivosComTodosOsDoctos + " and a.id = :id",Assinante.class).setParameter("id", assinanteId.getId()).getSingleResult();
	}
}
