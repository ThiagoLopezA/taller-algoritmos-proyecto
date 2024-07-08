package src.views;

import src.database.Repository;
import src.database.interfaces.IStorage;
import src.models.Car;
import src.models.Motorcycle;
import src.shared.utils.BaseEntity;
import src.shared.utils.ViewUtils;
import src.shared.structures.Array;

public class VehicleUpdater<T extends BaseEntity, K extends IStorage<T>> {
  Repository<T, K> repository;

  public VehicleUpdater(Repository<T, K> repository) {
    this.repository = repository;
  }

  public void show() {
    ViewUtils.clear();
    ViewUtils.printHeader("Update Vehicle");
    Array<T> vehicles = this.repository.getAll();
    for (Integer i = 0; i < vehicles.getSize(); i++) {
      ViewUtils.printOption(i, vehicles.get(i).toString());
    }
    int vehicleIndex = ViewUtils.promptForIntInput("Enter the number of the vehicle to update");

    if (vehicleIndex < 0 || vehicleIndex >= vehicles.getSize()) {
      System.out.println("Invalid vehicle number. Please try again.");
      show();
      return;
    }

    T vehicle = vehicles.get(vehicleIndex);
    if (vehicle instanceof Car) {
      updateCar((Car) vehicle);
    } else if (vehicle instanceof Motorcycle) {
      updateMotorcycle((Motorcycle) vehicle);
    }
  }

  @SuppressWarnings("unchecked")
  private void updateCar(Car car) {
    ViewUtils.clear();
    ViewUtils.printHeader("Update Car menu");

    String model = ViewUtils.promptForInput("Model [" + car.getModel() + "]");
    String color = ViewUtils.promptForInput("Color [" + car.getColor() + "]");
    int price = ViewUtils.promptForIntInput("Price [" + car.getPrice() + "]");
    float kilometers = ViewUtils.promptForFloatInput("Kilometers [" + car.getKilometers() + "]");
    boolean isUsed = ViewUtils.promptForBooleanInput("Is used? (Y/N) [" + (car.getUsed() ? "Y" : "N") + "]");
    int doorsQuantity = ViewUtils.promptForIntInput("Doors quantity [" + car.getDoorsQuantity() + "]");
    String fuelType = ViewUtils.promptForInput("Fuel type [" + car.getFuelType() + "]");
    String brand = ViewUtils.promptForInput("Brand [" + car.getBrand() + "]");
    String licensePlate = ViewUtils.promptForInput("License plate [" + car.getLicensePlate() + "]");

    try {
      Car updatedCar = new Car.Builder()
          .setId(car.getId())
          .setModel(model.isEmpty() ? car.getModel() : model)
          .setColor(color.isEmpty() ? car.getColor() : color)
          .setPrice(price)
          .setKilometers(kilometers)
          .setUsed(isUsed)
          .setDoorsQuantity(doorsQuantity)
          .setFuelType(fuelType.isEmpty() ? car.getFuelType() : fuelType)
          .setBrand(brand.isEmpty() ? car.getBrand() : brand)
          .setLicensePlate(licensePlate.isEmpty() ? car.getLicensePlate() : licensePlate)
          .build();

      this.repository.update(car.getId(), (T) updatedCar);
      System.out.println("Car updated successfully!");
    } catch (Exception e) {
      System.out.println("Error updating Car: " + e.getMessage());
      updateCar(car);
    }
  }

  @SuppressWarnings("unchecked")
  private void updateMotorcycle(Motorcycle motorcycle) {
    ViewUtils.clear();
    ViewUtils.printHeader("Update Motorcycle menu");

    String model = ViewUtils.promptForInput("Model [" + motorcycle.getModel() + "]");
    String color = ViewUtils.promptForInput("Color [" + motorcycle.getColor() + "]");
    int price = ViewUtils.promptForIntInput("Price [" + motorcycle.getPrice() + "]");
    float kilometers = ViewUtils.promptForFloatInput("Kilometers [" + motorcycle.getKilometers() + "]");
    boolean isUsed = ViewUtils.promptForBooleanInput("Is used? (Y/N) [" + (motorcycle.getUsed() ? "Y" : "N") + "]");
    int engineCapacity = ViewUtils.promptForIntInput("Engine capacity [" + motorcycle.getEngineCapacity() + "]");
    int fuelCapacity = ViewUtils.promptForIntInput("Fuel capacity [" + motorcycle.getFuelCapacity() + "]");

    try {
      Motorcycle updatedMotorcycle = new Motorcycle.Builder()
          .setId(motorcycle.getId())
          .setModel(model.isEmpty() ? motorcycle.getModel() : model)
          .setColor(color.isEmpty() ? motorcycle.getColor() : color)
          .setPrice(price)
          .setKilometers(kilometers)
          .setUsed(isUsed)
          .setEngineCapacity(engineCapacity)
          .setFuelCapacity(fuelCapacity)
          .build();

      this.repository.update(motorcycle.getId(), (T) updatedMotorcycle);
      System.out.println("Motorcycle updated successfully!");
    } catch (Exception e) {
      System.out.println("Error updating Motorcycle: " + e.getMessage());
      updateMotorcycle(motorcycle);
    }
  }
}
