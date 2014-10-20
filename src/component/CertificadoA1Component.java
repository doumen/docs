package component;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.CertificadoA1Dao;
import entity.Assinante;
import entity.CertificadoA1;

@Stateless
public class CertificadoA1Component {
	
	@EJB
	private CertificadoA1Dao certificadoA1Dao;
	
	public CertificadoA1 getCertificadoA1(Assinante a){
		return certificadoA1Dao.findByAssinanteId(a);
	}

	public void salvar(CertificadoA1 certificadoA1) {
		try {
			certificadoA1Dao.persist(certificadoA1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void merge(CertificadoA1 certificadoA1) {
		try {
			certificadoA1Dao.merge(certificadoA1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<CertificadoA1> getCertificadosA1(Assinante t) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(CertificadoA1 c) {
		try {
			certificadoA1Dao.remove(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean remove(Assinante a){
		try{
			List<CertificadoA1> certificadosA1 = getCertificadosA1(a);
			for(CertificadoA1 c:certificadosA1){
				remove(c);
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
