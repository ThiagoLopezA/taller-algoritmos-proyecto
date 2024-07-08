package src.shared.utils;

import java.util.Random;

public class IdGenerator {
  private static final int BOUND = 1000000;

  public static int generateRandomId() {
    Random random = new Random();
    return random.nextInt(BOUND);
  }
}
