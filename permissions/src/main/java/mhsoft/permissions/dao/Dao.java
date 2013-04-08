package mhsoft.permissions.dao;

import java.util.List;

public interface Dao<E> {

  public void persist(E entity);

  public void remove(E entity);

  public List<E> getAll();

  public E getById(Long id);

}