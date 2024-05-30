package src.repositories;

import src.common.BaseEntity;

public class Repository<T extends BaseEntity> implements RepositoryOperations<T> {
  private T[] inMemoryStore;

  private int size = 0;
  private int capacity = 20;

  @SuppressWarnings("unchecked")
  public Repository() {
    this.inMemoryStore = (T[]) new BaseEntity[this.capacity];
  }

  @Override
  public boolean save(T entity) {
    if (this.size >= this.capacity) {
      this.resize();
    }
    this.inMemoryStore[this.size++] = entity;
    return true;
  }

  @Override
  public boolean update(Integer id, T updatedEntity) {
    if (this.size == 0)
      return false;
    boolean elementUpdated = false;

    for (int i = 0; i < this.size; i++) {
      if (this.inMemoryStore[i].getId() == id) {
        this.inMemoryStore[i] = updatedEntity;
        elementUpdated = true;
        break;
      }
    }

    return elementUpdated;
  }

  @Override
  public void delete(T entity) {
    for (int i = 0; i < this.size; i++) {
      if (this.inMemoryStore[i].isEqual(entity)) {
        for (int j = i; j < size - 1; j++) {
          this.inMemoryStore[j] = this.inMemoryStore[j + 1];
        }

        inMemoryStore[--size] = null;
        break;
      }
    }
  }

  @Override
  public T[] getAll() {
    // TODO Needs to be tested
    return this.inMemoryStore;
  }

  public void printAll() {
    for (int i = 0; i < this.size; i++) {
      System.out.println(this.inMemoryStore[i].toString());
    }
  }

  @Override
  public T getOne(Integer id) {
    for (int i = 0; i < this.size; i++) {
      if (this.inMemoryStore[i].getId() == id) {
        return this.inMemoryStore[i];
      }
    }

    return null;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    capacity *= 2;
    T[] expandedStore = (T[]) new BaseEntity[capacity];
    System.arraycopy(this.inMemoryStore, 0, expandedStore, 0, size);
    this.inMemoryStore = expandedStore;
  }
}
