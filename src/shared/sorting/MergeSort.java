package src.shared.sorting;

import src.shared.structures.Array;
import src.shared.utils.ViewUtils;
import src.models.Vehicle;

public class MergeSort {
  public static <T extends Vehicle> void sort(Array<T> array) {
    if (array.getSize() < 2) {
      return;
    }
    int mid = array.getSize() / 2;
    Array<T> leftArray = new Array<>(mid);
    Array<T> rightArray = new Array<>(array.getSize() - mid);

    for (int i = 0; i < mid; i++) {
      leftArray.add(array.get(i));
    }
    for (int i = mid; i < array.getSize(); i++) {
      rightArray.add(array.get(i));
    }
    sort(leftArray);
    sort(rightArray);

    merge(array, leftArray, rightArray);
  }

  private static <T extends Vehicle> void merge(Array<T> array, Array<T> leftArray, Array<T> rightArray) {
    int i = 0, j = 0, k = 0;
    while (i < leftArray.getSize() && j < rightArray.getSize()) {
      if (leftArray.get(i).getId().compareTo(rightArray.get(j).getId()) <= 0) {
        array.set(k++, leftArray.get(i++));
      } else {
        array.set(k++, rightArray.get(j++));
      }
      ViewUtils.clear();
      array.print();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    while (i < leftArray.getSize()) {
      array.set(k++, leftArray.get(i++));
      ViewUtils.clear();
      array.print();
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    while (j < rightArray.getSize()) {
      array.set(k++, rightArray.get(j++));
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
