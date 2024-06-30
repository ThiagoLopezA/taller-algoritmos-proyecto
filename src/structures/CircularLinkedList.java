package src.structures;

import src.common.BaseEntity;

public class CircularLinkedList<T extends BaseEntity> {
  Node<T> head = null;
  Node<T> tail = null;

  @SuppressWarnings("unchecked")
  public void insert(T data) {
    T copy = (T) data.copy();
    Node<T> newNode = new Node<T>(copy);

    if (head == null) {
      this.head = newNode;
      this.tail = newNode;
      newNode.next = this.head;
    } else {
      this.tail.next = newNode;
      this.tail = newNode;
      this.tail.next = this.head;
    }
  }

  @SuppressWarnings("unchecked")
  public T searchById(Integer id) {
    Node<T> current = this.head;

    if (head == null)
      return null;

    do {
      if (current.data.getId() == id)
        return (T) current.data.copy();
    } while (current != this.head);

    return null;
  }

  public void delete(T data) {
    if (this.head == null)
      return;

    Node<T> current = this.head;
    Node<T> previous = null;

    if (this.head.data == data) {
      if (head == tail) {
        head = null;
        tail = null;
      } else {
        this.head = this.head.next;
        this.tail.next = this.head;
      }
    }

    do {
      previous = current;
      current = current.next;

      if (current.data == data) {
        previous.next = current.next;
        if (current == this.tail) {
          this.tail = previous;
        }

        return;
      }
    } while (current != head);
  }

  public boolean udpate(T data) {
    Node<T> current = this.head;

    if (this.head == null)
      return false;

    do {
      if (current.data.isEqual(data)) {
        current.data = data;
        return true;
      }

    } while (current != this.head);

    return false;
  }

  public void printAll() {
    Node<T> current = this.head;

    if (head == null)
      return;

    do {
      System.out.print(current.data + " ");
      current = current.next;
    } while (current != this.head);

    System.out.println();

  }

}
