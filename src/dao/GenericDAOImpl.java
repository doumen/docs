package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

public class GenericDAOImpl<T> {
	@PersistenceContext
    protected EntityManager em;

    private final Class<T> persistentClass;

    /**
     * Método responsável pela instanciação e extração da classe persistente.
     */
    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {

        this.persistentClass = (Class<T>) ((ParameterizedType)
                this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Método responsável pela persistência de uma instância da classe
     * persistente.
     * 
     * @param t
     *            T
     * @return Boolean
     * @throws EntityExistsException
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     * @throws PersistenceException
     */
    public boolean persist(T t) throws Exception {

        try {
            em.persist(t);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método responsável pela atualização de uma instância da classe
     * persistente.
     * 
     * @param t
     *            T
     * @return Boolean
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     */
    public boolean merge(T t) throws Exception {

        try {
            em.merge(t);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método responsável pela remoção de uma instância da classe persistente.
     * 
     * @param t
     *            T
     * @return Boolean
     * @throws IllegalArgumentException
     * @throws TransactionRequiredException
     */
    public boolean remove(T t) throws Exception {

        try {
            em.remove(t);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Método responsável pela busca de uma instância da classe persistente pela
     * chave-primária.
     * 
     * @param pk
     *            Long
     * @return T
     * @throws IllegalArgumentException
     */
    public T find(Long pk) throws Exception {

        try {
            return em.find(this.persistentClass, pk);
        } catch (Exception e) {
            throw e;
        }
    }

    public T find(String id) throws NumberFormatException, Exception{
    	return find(Long.valueOf(id));
    }
    
    /**
     * Método responsável pela listagem de instâncias da classe persistente.
     * 
     * @return List<T>
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("unchecked")
    public List<T> list() throws Exception {

        try {
            return em.createQuery("from " +
                    this.persistentClass.getSimpleName()).getResultList();
        } catch (Exception e) {
            throw e;
        }
    }

}
