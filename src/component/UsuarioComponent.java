package component;

import javax.ejb.Stateless;

import model.Modulo;
import model.Usuario;

@Stateless
public class UsuarioComponent {

	public boolean validar(Usuario usuario,Modulo modulo){
		if(usuario==null)			
			return false;
		if(usuario.getLogin()==null)
			return false;
		if(usuario.getLogin().equals("contador") && "contabilidade".equals(modulo))
			return true;
		if(usuario.getLogin().equals("assinante") && "assinante".equals(modulo))
			return true;
		if(usuario.getLogin().equals("administrador") && "administrativo".equals(modulo))			
			return true;
		return false;
	}

	public boolean existeUsuario(Usuario u,Modulo modulo) {
		return validar(u, modulo);
	}
}
