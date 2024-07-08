package src.shared.sorting;

import src.shared.structures.Array;
import src.shared.utils.ViewUtils;
import src.models.Vehicle;

public class InsertionSort {
  public static <T extends Vehicle> void sort(Array<T> array) {
    int n = array.getSize();
    for (int i = 1; i < n; ++i) {
      T key = array.get(i);
      int j = i - 1;

      while (j >= 0 && array.get(j).getId().compareTo(key.getId()) > 0) {
        array.set(j + 1, array.get(j));
        j = j - 1;
        ViewUtils.clear();
        array.print();
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      array.set(j + 1, key);
      ViewUtils.clear();
      array.print();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
