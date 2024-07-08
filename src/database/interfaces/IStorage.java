package src.database.interfaces;

import src.database.ChangeLog;
import src.shared.structures.Array;

public interface IStorage<T> {
  public ChangeLog<T> insert(T entity);

  public ChangeLog<T> delete(T entity);

  public ChangeLog<T> update(Integer id, T entity);

  public Array<T> getAll();

  public T getById(Integer id);
}
