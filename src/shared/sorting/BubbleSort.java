package src.shared.sorting;

import src.shared.structures.Array;
import src.shared.utils.ViewUtils;
import src.models.Vehicle;

public class BubbleSort {
  public static <T extends Vehicle> void sort(Array<T> array) {
    int n = array.getSize();
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (array.get(j).getId().compareTo(array.get(j + 1).getId()) > 0) {
          T temp = array.get(j);
          array.set(j, array.get(j + 1));
          array.set(j + 1, temp);
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
}