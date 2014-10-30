package dao;

import java.util.List;

import model.Modulo;
import entity.Assinante;
import entity.Usuario;

public interface UsuarioDao extends GenericDao<Usuario>{

	List<Usuario> findUsuariosFromAssinante(Assinante selected);

	boolean validar(Usuario u, Modulo modulo);

	Usuario getUsuarioComSenhaValida(Usuario usuario, Modulo modulo) throws Exception;

}
