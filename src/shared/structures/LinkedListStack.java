package src.shared.structures;

import src.shared.utils.BaseEntity;

public class LinkedListStack<T extends BaseEntity> {
  private Node<T> top;
  private int size;

  public LinkedListStack() {
    top = null;
    size = 0;
  }

  public boolean isEmpty() {
    return top == null;
  }

  @SuppressWarnings("unchecked")
  public void push(T data) {
    T copy = (T) data.copy();
    Node<T> newNode = new Node<T>(copy);
    newNode.next = top;

    this.top = newNode;
    this.size++;
  }

  public T pop() {
    if (this.isEmpty()) {
      return null;
    }

    T data = top.data;
    size--;
    return data;
  }

  public T peek() {
    return top.data;
  }

  public int size() {
    return this.size;
  }
}
