package src.shared.structures;

public class Array<T> {
  private T[] data;
  private int size;

  @SuppressWarnings("unchecked")
  public Array(Integer initialCapacity) {
    this.data = (T[]) new Object[initialCapacity];
    this.size = 0;
  }

  public void add(T item) {
    if (size == data.length) {
      this.resize(size * 2);
    }
    this.data[size++] = item;
  }

  @SuppressWarnings("unchecked")
  private void resize(int newSize) {
    T[] newData = (T[]) new Object[newSize];
    System.arraycopy(this.data, 0, newData, 0, this.size);
    this.data = newData;
  }

  public T get(int index) {
    if (index >= 0 && index < this.size) {
      return this.data[index];
    }
    throw new IndexOutOfBoundsException();
  }

  public void set(int index, T value) {
    if (index >= 0 && index < this.size) {
      this.data[index] = value;
      return;
    }
    throw new IndexOutOfBoundsException();
  }

  public int getSize() {
    return this.size;
  }

  public void print() {
    for (int i = 0; i < this.size; i++) {
      System.out.print(data[i] + "\n");
    }
    System.out.println();
  }
}
