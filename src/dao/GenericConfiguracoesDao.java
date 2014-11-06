package dao;
import entity.Assinante;

public interface GenericConfiguracoesDao<T> extends GenericDao<T> {
	public T findConfiguracoesDoAssinante(Assinante a);
}
