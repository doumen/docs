package component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.ejb.Stateless;

import model.NFe;

@Stateless
public class NFeComponent {

	public List<NFe> getNFes() {
		List<NFe> nfes = new ArrayList<NFe>();
		for(int i=0;i<10;i++){
			nfes.add(createNfe(i));
		}
		return nfes;
	}

	private NFe createNfe(int i) {
		NFe nfe = new NFe();
			nfe.setEmissaoNFe(Calendar.getInstance());
			nfe.setAutorizacaoDataHoraNFe(Calendar.getInstance());
		return nfe;
	}

}
