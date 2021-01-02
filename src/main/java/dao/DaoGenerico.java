package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import utilitarios.JpaUtil;

public class DaoGenerico<E> {

	public DaoGenerico() {

	}

	public void doAdicionar(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(entidade);
		entityTransaction.commit();
		entityManager.close();
	}

	public E doSalvar(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		E retorno = entityManager.merge(entidade);

		entityTransaction.commit();
		entityManager.close();

		return retorno;
	}

	public void doApagar(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(entidade);
		entityTransaction.commit();
		entityManager.close();
	}

	public void doApagarPorId(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Object Id = JpaUtil.getPrimaryKey(entidade);
		String tab = JpaUtil.getEntityName(entidade);
		entityManager.createQuery("delete from " + tab + " where id = " + Id).executeUpdate();

		entityTransaction.commit();
		entityManager.close();
	}

	@SuppressWarnings({ "unchecked" })
	public List<E> doListar(E entidade) {
		EntityManager entityManager = JpaUtil.getEntityManagerFactory().createEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<E> createQuery = (CriteriaQuery<E>) criteriaBuilder.createQuery();

		Root<E> from = (Root<E>) createQuery.from(entidade.getClass());
		createQuery.select(from);

		TypedQuery<E> typedQuery = entityManager.createQuery(createQuery);
		List<E> lstRetorno = typedQuery.getResultList();

		entityManager.close();
		return lstRetorno;
	}

}
