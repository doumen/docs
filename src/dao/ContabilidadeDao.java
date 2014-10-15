package dao;

import entity.Contabilidade;

public interface ContabilidadeDao extends GenericDao<Contabilidade>{

	Contabilidade getContabilidadeByNomeFantasia(String nomeFantasia);

}
