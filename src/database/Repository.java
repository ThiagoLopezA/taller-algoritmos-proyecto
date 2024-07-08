package src.database;

import src.database.interfaces.IRepositoryOperations;
import src.database.interfaces.IStorage;
import src.shared.structures.Array;
import src.shared.structures.LinkedListStack;
import src.shared.utils.BaseEntity;
import src.shared.utils.ViewUtils;

public class Repository<T extends BaseEntity, K extends IStorage<T>> implements IRepositoryOperations<T> {
  LinkedListStack<ChangeLog<T>> changesHistory = new LinkedListStack<ChangeLog<T>>();
  K storage;

  public Repository(K storage) {
    this.storage = storage;
  }

  public T save(T entity) {
    ChangeLog<T> evt = this.storage.insert(entity);
    changesHistory.push(evt);
    return evt.getNewValues();
  }

  public T delete(T entity) {
    ChangeLog<T> evt = this.storage.delete(entity);
    changesHistory.push(evt);
    return evt.getOldValues();
  }

  public T update(Integer id, T entity) {
    ChangeLog<T> evt = this.storage.update(id, entity);
    changesHistory.push(evt);
    return evt.getNewValues();
  }

  public Array<T> getAll() {
    return this.storage.getAll();
  }

  public T getById(Integer id) {
    return this.storage.getById(id);
  }

  public void revertLastChange() {
    ChangeLog<T> lastChange = this.changesHistory.pop();

    System.out.println(lastChange.toString());

    switch (lastChange.getType()) {
      case ChangeLogType.DELETE:
        this.save(lastChange.getOldValues());
        break;

      case ChangeLogType.INSERT:
        this.delete(lastChange.getNewValues());
        break;

      case ChangeLogType.UPDATE:
        T oldRecord = lastChange.getOldValues();
        System.out.println(oldRecord.toString());
        ViewUtils.promptForInput("test");
        this.update(oldRecord.getId(), oldRecord);
        break;
    }

    this.changesHistory.pop();
  }

  public LinkedListStack<ChangeLog<T>> getHistory() {
    return this.changesHistory;
  }

}
