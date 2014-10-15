package dao.impl;

import javax.ejb.Stateless;

import dao.CertificadoA1Dao;
import entity.Assinante;
import entity.CertificadoA1;

@Stateless
public class CertificadoA1DaoImpl extends GenericDAOImpl<CertificadoA1> implements CertificadoA1Dao{

	@Override
	public CertificadoA1 findByAssinanteId(Assinante a) {
		CertificadoA1 certificadoA1 = null;
		 try {
			 certificadoA1 = (CertificadoA1) em.createNamedQuery("CertificadoA1.findByAssinanteId")
		   .setParameter("assinanteId", a.getId())
		   .getSingleResult();
		 } catch (Exception e) {
		  e.printStackTrace();
		 }
		 return certificadoA1;		 
	}
}
