package component;

import java.util.Calendar;

import javax.ejb.Stateless;

import model.Assinante;
import model.Contabilidade;
import model.Modulo;
import model.Usuario;

@Stateless
public class UsuarioComponent {

	public boolean validar(Usuario usuario,Modulo modulo){
		if(usuario==null)			
			return false;
		if(usuario.getLogin()==null)
			return false;
		if(usuario.getLogin().equals("contador") && Modulo.CONTABILIDADE.equals(modulo))
			return true;
		if(usuario.getLogin().equals("assinante") && Modulo.ASSINANTE.equals(modulo))
			return true;
		if(usuario.getLogin().equals("administrador") && Modulo.ADMINISTRATIVO.equals(modulo))			
			return true;
		return false;
	}

	public boolean existeUsuario(Usuario u,Modulo modulo) {
		return validar(u, modulo);
	}

	public Usuario getUsuario(Usuario usuario) {
		//select * from usuario where login = usuario.login and senha = usuario.senha and id_assinante = usuario.assinante.id
		Usuario u = new Usuario();
		Assinante a = usuario.getAssinante();
		Contabilidade c = new Contabilidade();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,2012);
		c.setDataInclusao(cal);
		a.setContabilidade(c);
		u.setAssinante(a);
		u.setLogin(usuario.getLogin());
		
		return u;
	}
}
