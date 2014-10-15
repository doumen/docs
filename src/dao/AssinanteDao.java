package dao;

import java.util.List;

import entity.Assinante;

public interface AssinanteDao extends GenericDao<Assinante>{

	public List<Assinante> getAssinantes();
}
