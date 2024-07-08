package src.views;

import src.database.Repository;
import src.database.interfaces.IStorage;
import src.models.Vehicle;
import src.shared.structures.Array;
import src.shared.utils.ViewUtils;
import src.shared.sorting.BubbleSort;
import src.shared.sorting.InsertionSort;
import src.shared.sorting.MergeSort;
import src.shared.sorting.QuickSort;
import src.shared.sorting.ShellSort;

public class SortVisualizer<T extends Vehicle, K extends IStorage<T>> {
  private final Repository<T, K> repository;

  public SortVisualizer(Repository<T, K> repository) {
    this.repository = repository;
  }

  public void show() {
    ViewUtils.clear();
    ViewUtils.printHeader("Select Sorting Algorithm");
    ViewUtils.printOption(1, "Bubble Sort");
    ViewUtils.printOption(2, "Insertion Sort");
    ViewUtils.printOption(3, "Merge Sort");
    ViewUtils.printOption(4, "Quick Sort");
    ViewUtils.printOption(5, "Shell Sort");
    ViewUtils.printOption(6, "Go back to menu");
    ViewUtils.printLine();

    int userChoice = ViewUtils.promptForIntInput("Enter your choice");

    Array<T> vehicles = repository.getAll();
    if (userChoice != 6) {
      vehicles.print();
      sort(vehicles, userChoice);
      System.out.println("Sorted Array:");
      vehicles.print();
    }
  }

  private void sort(Array<T> vehicles, int choice) {
    switch (choice) {
      case 1:
        BubbleSort.sort(vehicles);
        break;
      case 2:
        InsertionSort.sort(vehicles);
        break;
      case 3:
        MergeSort.sort(vehicles);
        break;
      case 4:
        QuickSort.sort(vehicles);
        break;
      case 5:
        ShellSort.sort(vehicles);
        break;
    }
    ViewUtils.promptForInput("Press enter to continue");
  }
}