package dao;

import entity.Assinante;
import entity.CertificadoA1;

public interface CertificadoA1Dao extends GenericDao<CertificadoA1>{

	CertificadoA1 findByAssinanteId(Assinante a);

}
