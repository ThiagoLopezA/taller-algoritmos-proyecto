package src.views;

import src.shared.utils.ViewUtils;

public class Menu {
  public static Integer show() {
    ViewUtils.clear();
    ViewUtils.printHeader("Vehicles");
    ViewUtils.printOption(1, "Create vehicle");
    ViewUtils.printOption(2, "See all vehicles");
    ViewUtils.printOption(3, "Update vehicle");
    ViewUtils.printOption(4, "Delete vehicle");
    ViewUtils.printOption(5, "Visualize sorting");
    ViewUtils.printOption(6, "Revert last action");
    ViewUtils.printOption(7, "Load test data");
    ViewUtils.printOption(8, "Exit");
    ViewUtils.printLine();

    return ViewUtils.promptForIntInput("Enter your choice");
  }
}
