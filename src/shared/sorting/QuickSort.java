package src.shared.sorting;

import src.shared.structures.Array;
import src.shared.utils.ViewUtils;
import src.models.Vehicle;

public class QuickSort {
  public static <T extends Vehicle> void sort(Array<T> array) {
    quickSort(array, 0, array.getSize() - 1);
  }

  private static <T extends Vehicle> void quickSort(Array<T> array, int low, int high) {
    if (low < high) {
      int pi = partition(array, low, high);
      quickSort(array, low, pi - 1);
      quickSort(array, pi + 1, high);
    }
  }

  private static <T extends Vehicle> int partition(Array<T> array, int low, int high) {
    T pivot = array.get(high);
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (array.get(j).getId().compareTo(pivot.getId()) <= 0) {
        i++;
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
        ViewUtils.clear();
        array.print();
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
    T temp = array.get(i + 1);
    array.set(i + 1, array.get(high));
    array.set(high, temp);
    ViewUtils.clear();
    array.print();
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    return i + 1;
  }
}
