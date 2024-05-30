package src.main;

import src.models.Car;
import src.models.FuelType;
import src.models.Motorcycle;
import src.models.Vehicle;
import src.repositories.Repository;

public class Main {
  public static void main(String[] args) {
    try {
      Repository<Vehicle> vehicleStore = new Repository<Vehicle>();

      Motorcycle motorcycle = new Motorcycle.Builder()
          .setId(1)
          .setModel("Ninja 300")
          .setColor("Green")
          .setPrice(5000)
          .setKilometers(2500.5f)
          .setUsed(true)
          .setEngineCapacity(300)
          .setFuelCapacity(100)
          .build();

      Car car = new Car.Builder()
          .setId(2)
          .setModel("Civic")
          .setColor("Red")
          .setPrice(20000)
          .setKilometers(0)
          .setUsed(false)
          .setDoorsQuantity(4)
          .setFuelType(FuelType.GASOLINE)
          .setBrand("Honda")
          .setLicensePlate("ABC-1234")
          .build();

      vehicleStore.save(motorcycle);
      vehicleStore.save(car);

      car.setBrand("Civil modified");

      vehicleStore.update(car.getId(), car);

      System.out.println("\nFirst printAll");
      vehicleStore.printAll();

      vehicleStore.delete(car);

      System.out.println("\nSecond printAll");
      vehicleStore.printAll();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
