package component;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.PlanoDao;
import entity.Plano;

@Stateless
public class PlanoComponent {
	
	@EJB
	private PlanoDao planoDao;
	
	public List<Plano> getPlanos() {
		/*
		ArrayList<Plano> planos = new ArrayList<>();
		for (Long i = 0l; i < 100; i++) {
			Plano c = new Plano();
			c.setId(i);
			c.setDescricao("Plano " + i + 10);
			c.setFaixaInicial(Integer.valueOf(i.intValue()));
			c.setFaixaFinal((int) (i * 10));
			c.setValorMensal(i * 1.2);
			c.setValorNfeAdicional(i * 1.5);
			c.setDataInclusao(Calendar.getInstance());

			planos.add(c);
		}
		return planos;
		*/
		try {
			return planoDao.getPlanos();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Plano getPlanoById(String id) throws NumberFormatException, Exception {
		return planoDao.getPlanoById(Long.valueOf(id));
	}
	
	public Plano getPlanoByDescricao(String descricao){
		return planoDao.getPlanoByDescricao(descricao);
	}
	
	
}
