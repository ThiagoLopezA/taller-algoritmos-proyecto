package src.shared.sorting;

import src.shared.structures.Array;
import src.shared.utils.ViewUtils;
import src.models.Vehicle;

public class ShellSort {
  public static <T extends Vehicle> void sort(Array<T> array) {
    int n = array.getSize();
    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i++) {
        T key = array.get(i);
        int j = i;
        while (j >= gap && array.get(j - gap).getId().compareTo(key.getId()) > 0) {
          array.set(j, array.get(j - gap));
          j -= gap;
          ViewUtils.clear();
          array.print();
          try {
            Thread.sleep(500);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
        array.set(j, key);
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
}
