package component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;

import model.Plano;

@Stateless
public class PlanoComponent {
	public List<Plano> getPlanos() {
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
	}

	public Plano getPlanoById(String descricao) {
		for(Plano p : getPlanos()){
			if(p.getDescricao().equals(descricao)){
				return p;
			}
		}
		return null;
	}
}
