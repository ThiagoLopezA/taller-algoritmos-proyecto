package src.views;

import src.database.Repository;
import src.models.Car;
import src.models.Motorcycle;
import src.shared.utils.ViewUtils;
import src.database.interfaces.IStorage;
import src.shared.utils.BaseEntity;

public class VehicleCreator<T extends BaseEntity, K extends IStorage<T>> {
  Repository<T, K> repository;

  public VehicleCreator(Repository<T, K> repository) {
    this.repository = repository;
  }

  public void show() {
    ViewUtils.clear();
    ViewUtils.printHeader("Select vehicle type");
    ViewUtils.printOption(1, "Car");
    ViewUtils.printOption(2, "Motorcycle");
    ViewUtils.printOption(3, "Go back to menu");
    ViewUtils.printLine();

    String userChoice = ViewUtils.getUserInput("Enter your choice");

    switch (Integer.valueOf(userChoice)) {
      case 1:
        this.createCar();
        break;
      case 2:
        this.createMotorcycle();
        break;
      case 3:
        break;
    }
  }

  @SuppressWarnings("unchecked")
  public void createMotorcycle() {
    ViewUtils.clear();
    ViewUtils.printHeader("Create Motorcycle menu");

    String model = ViewUtils.promptForInput("Model");
    String color = ViewUtils.promptForInput("Color");
    int price = ViewUtils.promptForIntInput("Price");
    float kilometers = ViewUtils.promptForFloatInput("Kilometers");
    boolean isUsed = ViewUtils.promptForBooleanInput("Is used? (Y/N)");
    int engineCapacity = ViewUtils.promptForIntInput("Engine capacity");
    int fuelCapacity = ViewUtils.promptForIntInput("Fuel capacity");

    try {
      this.repository.save((T) new Motorcycle.Builder()
          .setModel(model)
          .setColor(color)
          .setPrice(price)
          .setKilometers(kilometers)
          .setUsed(isUsed)
          .setEngineCapacity(engineCapacity)
          .setFuelCapacity(fuelCapacity)
          .build());
      System.out.println("Motorcycle created successfully!");
    } catch (Exception e) {
      System.out.println("Error creating Motorcycle: " + e.getMessage());
      this.createMotorcycle();
    }
  }

  @SuppressWarnings("unchecked")
  public void createCar() {
    ViewUtils.clear();
    ViewUtils.printHeader("Create Car menu");

    String model = ViewUtils.promptForInput("Model");
    String color = ViewUtils.promptForInput("Color");
    int price = ViewUtils.promptForIntInput("Price");
    float kilometers = ViewUtils.promptForFloatInput("Kilometers");
    boolean isUsed = ViewUtils.promptForBooleanInput("Is used? (Y/N)");
    int doorsQuantity = ViewUtils.promptForIntInput("Doors quantity");
    String fuelType = ViewUtils.promptForInput("Fuel type (gasoline/electric/gasoil)");
    String brand = ViewUtils.promptForInput("Brand");
    String licensePlate = ViewUtils.promptForInput("License plate");

    try {
      Car c = new Car.Builder()
          .setModel(model)
          .setColor(color)
          .setPrice(price)
          .setKilometers(kilometers)
          .setUsed(isUsed)
          .setDoorsQuantity(doorsQuantity)
          .setFuelType(fuelType)
          .setBrand(brand)
          .setLicensePlate(licensePlate)
          .build();

      this.repository.save((T) c);
    } catch (Exception e) {
      System.out.println("Error creating Car: " + e.getMessage());
      this.createCar();
    }
  }
}
