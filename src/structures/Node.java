package src.structures;

import src.common.BaseEntity;

public class Node<T extends BaseEntity> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
    this.next = null;
  }
}
