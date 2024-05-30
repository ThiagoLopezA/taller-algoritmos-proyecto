package src.common;

public class Validations {
  public static void validateString(String str) throws Exception {
    if (str == "" || str == null)
      throw new Exception("Model can't be empty");
  }

  public static void validateNumber(Number n) throws Exception {
    if (n.doubleValue() < 0) {
      throw new Exception("Number must be >= 0");
    }
  }
}
