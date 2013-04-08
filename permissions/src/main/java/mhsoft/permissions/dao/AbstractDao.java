package mhsoft.permissions.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class AbstractDao<E> implements Dao<E> {

  protected Class<E> entityClass;

  @PersistenceContext(unitName = "permissions")
  protected EntityManager entityManager;

  public AbstractDao(final Class<E> entityClass) {
    this.entityClass = entityClass;
  }

  @Override
  public void persist(final E entity) {
    this.entityManager.persist(entity);
  }

  @Override
  public void remove(final E entity) {
    this.entityManager.remove(entity);
  }

  @Override
  public List<E> getAll() {
    final CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
    final CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
    final Root<E> from = criteriaQuery.from(this.entityClass);
    final CriteriaQuery<Object> select = criteriaQuery.select(from);
    final TypedQuery<Object> typedQuery = this.entityManager.createQuery(select);
    @SuppressWarnings("unchecked")
    final List<E> result = (List<E>) typedQuery.getResultList();
    return result;
  }

  @Override
  public E getById(final Long id) {
    return this.entityManager.find(this.entityClass, id);
  }

}