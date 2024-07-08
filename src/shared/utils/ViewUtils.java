package src.shared.utils;

import java.util.Scanner;

public class ViewUtils {
  private static final int CONSOLE_WIDTH = 80;
  private static final Scanner scanner = new Scanner(System.in);

  public static void printHeader(String title) {
    int paddingSize = (CONSOLE_WIDTH - title.length()) / 2;
    String padding = " ".repeat(paddingSize);

    System.out.println("*".repeat(CONSOLE_WIDTH));
    System.out.println(padding + title + padding + (title.length() % 2 == 0 ? "" : " "));
    System.out.println("*".repeat(CONSOLE_WIDTH));
  }

  public static void printOption(Integer num, String option) {
    System.out.println(num + " - " + option);
  }

  public static void clear() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  public static void printLine() {
    System.out.println("*".repeat(CONSOLE_WIDTH));
  }

  public static String getUserInput(String prompt) {
    System.out.print(prompt + ": ");
    return scanner.nextLine().trim();
  }

  public static String promptForInput(String prompt) {
    while (true) {
      try {
        return ViewUtils.getUserInput(prompt);
      } catch (Exception e) {
        System.out.println("Invalid input. Please try again.");
      }
    }
  }

  public static int promptForIntInput(String prompt) {
    while (true) {
      try {
        return Integer.parseInt(ViewUtils.getUserInput(prompt));
      } catch (NumberFormatException e) {
        System.out.println("Invalid number. Please enter a valid integer.");
      }
    }
  }

  public static float promptForFloatInput(String prompt) {
    while (true) {
      try {
        return Float.parseFloat(ViewUtils.getUserInput(prompt));
      } catch (NumberFormatException e) {
        System.out.println("Invalid number. Please enter a valid float.");
      }
    }
  }

  public static boolean promptForBooleanInput(String prompt) {
    while (true) {
      String input = ViewUtils.getUserInput(prompt);
      if (input.equalsIgnoreCase("Y")) {
        return true;
      } else if (input.equalsIgnoreCase("N")) {
        return false;
      } else {
        System.out.println("Invalid input. Please enter 'Y' or 'N'.");
      }
    }
  }
}
