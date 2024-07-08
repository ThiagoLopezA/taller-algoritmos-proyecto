package src.views;

import src.database.Repository;
import src.database.interfaces.IStorage;
import src.models.Car;
import src.models.Motorcycle;
import src.shared.utils.BaseEntity;
import src.shared.utils.ViewUtils;

import java.util.Random;

public class TestDataGenerator<T extends BaseEntity, K extends IStorage<T>> {
  private final Repository<T, K> repository;
  private final Random random = new Random();

  public TestDataGenerator(Repository<T, K> repository) {
    this.repository = repository;
  }

  public void show() {
    ViewUtils.clear();
    ViewUtils.printHeader("Generate Test Data");
    int numberOfEntries = ViewUtils.promptForIntInput("Enter number of test data entries to generate");

    for (int i = 0; i < numberOfEntries; i++) {
      if (random.nextBoolean()) {
        generateRandomCar();
      } else {
        generateRandomMotorcycle();
      }
    }

    System.out.println(numberOfEntries + " test data entries generated successfully!");
  }

  @SuppressWarnings("unchecked")
  private void generateRandomCar() {
    try {
      Car car = new Car.Builder()
          .setModel(generateRandomString("CarModel"))
          .setColor(generateRandomColor())
          .setPrice(generateRandomPrice())
          .setKilometers(generateRandomKilometers())
          .setUsed(random.nextBoolean())
          .setDoorsQuantity(random.nextInt(5) + 2) // Random between 2 and 6
          .setFuelType(generateRandomFuelType())
          .setBrand(generateRandomString("Brand"))
          .setLicensePlate(generateRandomString("LicensePlate"))
          .build();

      repository.save((T) car);
    } catch (Exception e) {
      System.out.println("Error generating random Car: " + e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  private void generateRandomMotorcycle() {
    try {
      Motorcycle motorcycle = new Motorcycle.Builder()
          .setModel(generateRandomString("MotorcycleModel"))
          .setColor(generateRandomColor())
          .setPrice(generateRandomPrice())
          .setKilometers(generateRandomKilometers())
          .setUsed(random.nextBoolean())
          .setEngineCapacity(random.nextInt(1000) + 50) // Random between 50 and 1050
          .setFuelCapacity(random.nextInt(20) + 5) // Random between 5 and 25
          .build();

      repository.save((T) motorcycle);
    } catch (Exception e) {
      System.out.println("Error generating random Motorcycle: " + e.getMessage());
    }
  }

  private String generateRandomString(String base) {
    return base + random.nextInt(1000);
  }

  private String generateRandomColor() {
    String[] colors = { "Red", "Blue", "Green", "Black", "White" };
    return colors[random.nextInt(colors.length)];
  }

  private double generateRandomPrice() {
    return 5000 + (100000 - 5000) * random.nextDouble(); // Random between 5000 and 100000
  }

  private float generateRandomKilometers() {
    return random.nextInt(200000); // Random between 0 and 200000
  }

  private String generateRandomFuelType() {
    String[] fuelTypes = { "gasoline", "electric", "gasoil" };
    return fuelTypes[random.nextInt(fuelTypes.length)];
  }
}