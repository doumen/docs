package dao.impl;

import java.util.List;

import javax.ejb.Stateless;

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

}
