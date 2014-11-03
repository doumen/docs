package dao;

import java.util.List;

import entity.Contabilidade;
import entity.Usuario;

public interface ContabilidadeDao extends GenericDao<Contabilidade>{

	Contabilidade getContabilidadeByNomeFantasia(String nomeFantasia);

	List<Contabilidade> getContabilidadesFetch();

	Contabilidade findByIdFetch(Contabilidade contabilidade);

	List<Contabilidade> getContabilidadesNaoFetch();

	Contabilidade findByCnpjFetch(Contabilidade contabilidade);

	void merge(Contabilidade c, List<Usuario> usuariosParaRemover,List<Usuario> usuariosParaAdicionar);

}
