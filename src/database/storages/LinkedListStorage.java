package src.database.storages;

import src.database.ChangeLog;
import src.database.ChangeLogType;
import src.database.interfaces.IStorage;
import src.shared.structures.Array;
import src.shared.structures.LinkedList;
import src.shared.utils.BaseEntity;

public class LinkedListStorage<T extends BaseEntity> implements IStorage<T> {
  LinkedList<T> storage = new LinkedList<T>();

  public ChangeLog<T> insert(T entity) {
    storage.insert(entity);
    return new ChangeLog<T>(null, entity, ChangeLogType.INSERT);
  }

  public ChangeLog<T> delete(T entity) {
    storage.delete(entity);
    return new ChangeLog<T>(entity, null, ChangeLogType.DELETE);
  }

  @SuppressWarnings("unchecked")
  public ChangeLog<T> update(Integer id, T entity) {
    T record = storage.getById(id);
    T previousValue = null;

    if (record != null) {
      previousValue = (T) record.copy();
    }

    T newValues = storage.update(id, entity);
    return new ChangeLog<T>(previousValue, newValues, ChangeLogType.UPDATE);
  }

  public Array<T> getAll() {
    return this.storage.getAll();
  }

  public T getById(Integer id) {
    return this.storage.getById(id);
  }

}
