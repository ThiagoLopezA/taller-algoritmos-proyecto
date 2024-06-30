package src.structures;

import src.common.BaseEntity;

public class LinkedList<T extends BaseEntity> {
  Node<T> head;

  @SuppressWarnings("unchecked")
  public void insert(T data) {
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

  @SuppressWarnings("unchecked")
  public T searchById(Integer id) {
    Node<T> temp = this.head;

    while (temp != null) {
      if (temp.data.getId() == id) {
        return (T) temp.data.copy();
      }
      temp = temp.next;
    }

    return null;
  }

  public boolean update(T data) {
    Node<T> temp = this.head;

    while (temp != null) {
      if (temp.data.isEqual(data)) {
        temp.data = data;
        return true;
      }

      temp = temp.next;
    }

    return false;
  }

  public void printAll() {
    Node<T> temp = this.head;

    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }

    System.out.println();
  }

}
