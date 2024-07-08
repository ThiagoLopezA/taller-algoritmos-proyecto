package src.shared.structures;

import src.shared.utils.BaseEntity;

public class LinkedList<T extends BaseEntity> {
  Node<T> head;

  @SuppressWarnings("unchecked")
  public T insert(T data) {
    T copy = (T) data.copy();
    Node<T> newNode = new Node<T>(copy);

    if (this.head == null) {
      this.head = newNode;
    } else {
      Node<T> temp = this.head;

      while (temp.next != null) {
        temp = temp.next;
      }

      temp.next = newNode;
    }

    return data;
  }

  public void delete(T data) {
    Node<T> temp = this.head;
    Node<T> prev = null;

    if (temp != null && temp.data.isEqual(data)) {
      this.head = temp.next;
      return;
    }

    while (temp != null && !temp.data.isEqual(data)) {
      prev = temp;
      temp = temp.next;
    }

    if (temp == null)
      return;

    prev.next = temp.next;
  }

  public T update(Integer id, T data) {
    Node<T> temp = this.head;

    while (temp != null) {

      if (id.equals(temp.data.getId())) {
        temp.data = data;
        return temp.data;
      }

      temp = temp.next;
    }

    return null;
  }

  public T getById(Integer id) {
    Node<T> temp = this.head;

    while (temp != null) {
      if (id.equals(temp.data.getId())) {
        return temp.data;
      }
      temp = temp.next;
    }

    return null;
  }

  public Array<T> getAll() {
    Node<T> temp = this.head;
    Array<T> results = new Array<>(10);

    while (temp != null) {
      results.add(temp.data);
      temp = temp.next;
    }

    return results;
  }

}
