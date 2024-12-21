package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.sistemajpa.HibernateUltil;

public class DaoGeneric<E> {

	private EntityManager entityManager = HibernateUltil.getEntityManager();

	public void salvar(E entidade) {

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();

	}

	/*
	 * public E pesquisar( E entidade) { Object id =
	 * HibernateUltil.getprimarykey(entidade);
	 * 
	 * E e = (E) entityManager.find(entidade.getClass(), id); return e; }
	 */

	public E pesquisar(long id, Class<E> entidade) {

		E e = (E) entityManager.find(entidade, id);
		return e;
	}

	public E updateMerge(E entidade) { // salva e atualiza

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		E entidadeSalvar = entityManager.merge(entidade);
		transaction.commit();

		return entidadeSalvar;

	}

	/*
	 * public void deletarPorId(E entidade) { Object id =
	 * HibernateUltil.getprimarykey(entidade); EntityTransaction transaction =
	 * entityManager.getTransaction(); transaction.begin();
	 * 
	 * entityManager.createNativeQuery("delete from" +
	 * entidade.getClass().getSimpleName().toLowerCase() + "where id =" +
	 * id).executeUpdate(); transaction.commit();
	 * 
	 * }
	 */

	public void deletarPorId(E entidade) {
		Object id = HibernateUltil.getprimarykey(entidade);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String entityName = entidade.getClass().getSimpleName().toLowerCase();
		entityManager.createNativeQuery("delete from " + entityName + " where id = " + id).executeUpdate();
		transaction.commit();

	}
	
	
	public List<E> listar(Class<E> entidade) {
		EntityTransaction transaction = entityManager.getTransaction(); transaction.begin(); 
	List<E> lista = entityManager.createQuery("from " + entidade.getName(), entidade).getResultList(); transaction.commit(); return lista; 
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
	
