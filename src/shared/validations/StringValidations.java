package src.shared.validations;

public class StringValidations {
  public static void notNullish(String str) throws Exception {
    if (str == "" || str == null) {
      throw new Exception("String can't be nullish");
    }
  }
}
