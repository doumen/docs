package dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import model.Modulo;
import dao.UsuarioDao;
import entity.Assinante;
import entity.Usuario;
@Stateless
public class UsuarioDaoImpl extends GenericDAOImpl<Usuario> implements UsuarioDao {

	@Override
	public List<Usuario> findUsuariosFromAssinante(Assinante selected) {
		return em.createQuery("select distinct u from Usuario u join fetch u.assinantesList a where a.id = :id",Usuario.class).setParameter("id", selected.getId()).getResultList();
//		List<Usuario> resultList = createNamedQuery.getResultList();
//		 return resultList;		 
	}

	@Override
	public boolean validar(Usuario u, Modulo modulo) {
		
		return false;
	}

	@Override
	public Usuario getUsuarioComSenhaValida(Usuario usuario, Modulo modulo) throws Exception{
		if(Modulo.ADMINISTRATIVO.equals(modulo)){
			try{
			return em.createQuery("from Usuario u where u.login=:login and u.senha=:senha "
					+ "and permissaoAreaAdministrador=true",Usuario.class).setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getSingleResult();			
			}catch(Exception e){
				throw new Exception("Tentativa de logar no módulo administrativo");
			}
		}else if(Modulo.ASSINANTE.equals(modulo)){
			try{
				return em.createQuery("from Usuario u where u.login=:login and u.senha=:senha and u.permissaoAreaUsuario=true",Usuario.class).setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getSingleResult();				
			}catch(Exception e){
				throw new Exception("Tentativa de logar no módulo assinante");
			}
		}else if(Modulo.CONTABILIDADE.equals(modulo)){
			try{
			return em.createQuery("from Usuario u join fetch u.tbContabilidadeId c where u.login=:login and u.senha=:senha and u.permissaoAreaContador=true",Usuario.class).setParameter("login", usuario.getLogin()).setParameter("senha", usuario.getSenha()).getSingleResult();				
			}catch(Exception e){
				throw new Exception("Tentativa de logar no módulo contabilidade");
			}
		}
		return null;
	}

}
