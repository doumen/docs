package dao;

import java.util.Date;
import java.util.List;

import model.AssinanteReport;
import model.Modulo;
import entity.Assinante;
import entity.Contabilidade;
import entity.Usuario;

public interface AssinanteDao extends GenericDao<Assinante>{

	public List<Assinante> getAssinantes();

	public Assinante findByCnpj(Assinante selected);

	public List<Assinante> getAssinantesDoUsuario(Usuario usuario,
			Modulo valueOf);

	public List<Assinante> getAssinantesComTodosOsDoctos();
	public List<Assinante> getAssinantesAtivosComTodosOsDoctos();
	public List<Assinante> getAssinantesComTodosOsDoctos(Date d);
	public List<AssinanteReport> getAssinanteReportAteAData(Date d,String doctoListField);
	public List<AssinanteReport> getAssinantesSemNota(Date d);

	public List<Assinante> getAssinantesComTodosOsDoctos(
			Contabilidade contabilidade);
}
