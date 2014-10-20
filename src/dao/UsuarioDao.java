package dao;

import java.util.List;

import entity.Assinante;
import entity.Usuario;

public interface UsuarioDao extends GenericDao<Usuario>{

	List<Usuario> findUsuariosFromAssinante(Assinante selected);

}
