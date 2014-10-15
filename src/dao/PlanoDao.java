package dao;

import java.util.List;

import entity.Plano;

public interface PlanoDao extends GenericDao<Plano>{

	List<Plano> getPlanos() throws Exception;

	Plano getPlanoById(Long valueOf) throws Exception;

	Plano getPlanoByDescricao(String descricao);
}
