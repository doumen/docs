package component;

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
}
