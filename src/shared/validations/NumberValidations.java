package src.shared.validations;

public class NumberValidations {
  public static void greatherOrEqualThan(Number n, Number ref) throws Exception {
    if (n.doubleValue() < ref.doubleValue()) {
      throw new Exception("Number " + n + " must be greather than " + ref);
    }
  }
}
