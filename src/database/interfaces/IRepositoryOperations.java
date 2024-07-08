package src.database.interfaces;

import src.shared.structures.Array;

public interface IRepositoryOperations<T> {
  public T save(T entity);

  public T delete(T entity);

  public T update(Integer id, T entity);

  public Array<T> getAll();

  public T getById(Integer id);

  public void revertLastChange();
}
