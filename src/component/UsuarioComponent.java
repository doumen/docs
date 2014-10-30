package component;

import java.util.Calendar;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Modulo;
import dao.UsuarioDao;
import entity.Assinante;
import entity.Contabilidade;
import entity.Usuario;

@Stateless
public class UsuarioComponent {

	@EJB
	private UsuarioDao usuarioDao;
	
	public boolean validar(Usuario usuario,Modulo modulo){
		if(usuario==null)			
			return false;
		if(usuario.getLogin()==null)
			return false;		
		try {
			usuarioDao.getUsuarioComSenhaValida(usuario,modulo);
			return true;
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
	}

	public Usuario getUsuarioComSenhaValida(Usuario usuario,Modulo modulo) throws Exception{
		return usuarioDao.getUsuarioComSenhaValida(usuario,modulo);
	}
	
	public Usuario getUsuario(Usuario usuario) {
		//select * from usuario where login = usuario.login and senha = usuario.senha and id_assinante = usuario.assinante.id
		Usuario u = new Usuario();
		Assinante a = usuario.getAssinante();
		Contabilidade c = new Contabilidade();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR,2012);
		c.setDataInclusao(cal.getTime());
		a.setContabilidade(c);
		u.setAssinante(a);
		u.setLogin(usuario.getLogin());
		
		return u;
	}

	public void incluirUsuario(Usuario u) {
		try {
			usuarioDao.persist(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> getUsuarios(Assinante selected) {
		return usuarioDao.findUsuariosFromAssinante(selected);
	}

	public void save(Contabilidade c) throws Exception {
		for(Usuario u:c.getUsuarios()){
			usuarioDao.persist(u);
		}
	}
	
	public boolean remove(Usuario u) throws Exception{
		return usuarioDao.remove(u);
	}

	public void remove(List<Usuario> usuariosRemovidos) throws Exception {
		for(Usuario u:usuariosRemovidos){
			remove(u);
		}		
	}
}
