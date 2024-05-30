package src.repositories;

public interface RepositoryOperations<T> {
  public boolean save(T entity);

  public boolean update(Integer id, T entity);

  public void delete(T entity);

  public T[] getAll();

  public T getOne(Integer id);

  public void printAll();
}
