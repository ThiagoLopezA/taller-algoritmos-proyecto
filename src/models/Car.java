package src.models;

import src.shared.validations.NumberValidations;
import src.shared.validations.StringValidations;

public class Car extends Vehicle {
  private int doorsQuantity;
  private String fuelType;
  private String brand;
  private String licensePlate;

  public Car() {
  }

  public Car(
      String model,
      String color,
      double price,
      float kilometers,
      boolean used,
      int doorsQuantity,
      String fuelType,
      String brand,
      String licensePlate) {
    super(model, color, price, kilometers, used);

    try {
      this.validateVehicle();
      this.setDoorsQuantity(doorsQuantity);
      this.setFuelType(fuelType);
      this.setBrand(brand);
      this.licensePlate = licensePlate;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public Car(
      int id,
      String model,
      String color,
      double price,
      float kilometers,
      boolean used,
      int doorsQuantity,
      String fuelType,
      String brand,
      String licensePlate) {
    super(id, model, color, price, kilometers, used);

    try {
      this.validateVehicle();
      this.setDoorsQuantity(doorsQuantity);
      this.setFuelType(fuelType);
      this.setBrand(brand);
      this.licensePlate = licensePlate;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setDoorsQuantity(int quantity) throws Exception {
    NumberValidations.greatherOrEqualThan(quantity, 0);
    this.doorsQuantity = quantity;
  }

  public int getDoorsQuantity() {
    return this.doorsQuantity;
  }

  public void setFuelType(String fuelType) throws Exception {
    if (!FuelType.isValidFuelType(fuelType))
      throw new Exception("Invalid fuel type");

    this.fuelType = fuelType;
  }

  public String getFuelType() {
    return this.fuelType;
  }

  public void setBrand(String brand) throws Exception {
    StringValidations.notNullish(brand);
    this.brand = brand;
  }

  public String getBrand() {
    return this.brand;
  }

  public void setLicensePlate(String licensePlate) throws Exception {
    StringValidations.notNullish(licensePlate);
    this.licensePlate = licensePlate;
  }

  public String getLicensePlate() {
    return this.licensePlate;
  }

  @Override
  public String toString() {
    return "Car{" +
        "id = " + this.getId() +
        ", model='" + this.getModel() + '\'' +
        ", color='" + this.getColor() + '\'' +
        ", price=" + this.getPrice() +
        ", kilometers=" + this.getKilometers() +
        ", used=" + this.getUsed() +
        ", doorsQuantity=" + doorsQuantity +
        ", fuelType='" + fuelType + '\'' +
        ", brand='" + brand + '\'' +
        ", licensePlate='" + licensePlate + '\'' +
        '}';
  }

  @Override
  public Car copy() {
    return new Car.Builder()
        .setId(this.getId())
        .setModel(this.getModel())
        .setColor(this.getColor())
        .setPrice(this.getPrice())
        .setKilometers(this.getKilometers())
        .setUsed(this.getUsed())
        .setDoorsQuantity(this.getDoorsQuantity())
        .setFuelType(this.getFuelType())
        .setBrand(this.getBrand())
        .setLicensePlate(this.getLicensePlate())
        .build();
  }

  public static class Builder {
    private Integer id;
    private String model;
    private String color;
    private double price;
    private float kilometers;
    private boolean used;
    private int doorsQuantity;
    private String fuelType;
    private String brand;
    private String licensePlate;

    public Builder setId(int id) {
      this.id = id;
      return this;
    }

    public Builder setModel(String model) {
      this.model = model;
      return this;
    }

    public Builder setColor(String color) {
      this.color = color;
      return this;
    }

    public Builder setPrice(double price) {
      this.price = price;
      return this;
    }

    public Builder setKilometers(float kilometers) {
      this.kilometers = kilometers;
      return this;
    }

    public Builder setUsed(boolean used) {
      this.used = used;
      return this;
    }

    public Builder setDoorsQuantity(int quantity) {
      this.doorsQuantity = quantity;
      return this;
    }

    public Builder setFuelType(String type) {
      this.fuelType = type;
      return this;
    }

    public Builder setBrand(String brand) {
      this.brand = brand;
      return this;
    }

    public Builder setLicensePlate(String licensePlate) {
      this.licensePlate = licensePlate;
      return this;
    }

    public Car build() {
      if (this.id == null) {
        return new Car(
            this.model,
            this.color,
            this.price,
            this.kilometers,
            this.used,
            this.doorsQuantity,
            this.fuelType,
            this.brand,
            this.licensePlate);
      }

      return new Car(
          this.id,
          this.model,
          this.color,
          this.price,
          this.kilometers,
          this.used,
          this.doorsQuantity,
          this.fuelType,
          this.brand,
          this.licensePlate);
    }

  }
}
