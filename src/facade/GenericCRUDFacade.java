package facade;

public interface GenericCRUDFacade<T> {

	public boolean acaoAntesRemover(T entity);
	public void acaoNaoRemocao(T entity);
	public void acaoComponenteNaoRemoveuComSucesso();
}
