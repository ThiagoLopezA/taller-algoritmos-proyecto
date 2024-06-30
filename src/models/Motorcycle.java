package src.models;

import src.common.Validations;

public class Motorcycle extends Vehicle {
  private int engineCapacity;
  private float fuelCapacity;

  public Motorcycle() {
  }

  public Motorcycle(
      int id,
      String model,
      String color,
      double price,
      float kilometers,
      boolean used,
      int engineCapacity,
      float fuelCapacity) {
    super(id, model, color, price, kilometers, used);

    try {
      this.validateVehicle();
      this.setFuelCapacity(engineCapacity);
      this.setEngineCapacity(engineCapacity);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setEngineCapacity(int engineCapacity) throws Exception {
    Validations.validateNumber(engineCapacity);
    this.engineCapacity = engineCapacity;
  }

  public int getEngineCapacity() {
    return this.engineCapacity;
  }

  public void setFuelCapacity(float fuelCapacity) throws Exception {
    Validations.validateNumber(fuelCapacity);
    this.fuelCapacity = fuelCapacity;
  }

  @Override
  public String toString() {
    return "Motorcycle{" +
        "id = " + this.getId() +
        ", model='" + this.getModel() + '\'' +
        ", color='" + this.getColor() + '\'' +
        ", price=" + this.getPrice() +
        ", kilometers=" + this.getKilometers() +
        ", used=" + this.getUsed() +
        ", engineCapacity=" + this.engineCapacity +
        ", fuelCapacity=" + this.fuelCapacity +
        '}';
  }

  @Override
  public Motorcycle copy() {
    return new Motorcycle.Builder()
        .setId(this.getId())
        .setModel(this.getModel())
        .setColor(this.getColor())
        .setPrice(this.getPrice())
        .setKilometers(this.getKilometers())
        .setUsed(this.getUsed())
        .setEngineCapacity(this.engineCapacity)
        .setFuelCapacity(this.fuelCapacity)
        .build();
  }

  public static class Builder {
    private int id;
    private String model;
    private String color;
    private double price;
    private float kilometers;
    private boolean used;
    private int engineCapacity;
    private float fuelCapacity;

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

    public Builder setEngineCapacity(int engineCapacity) {
      this.engineCapacity = engineCapacity;
      return this;
    }

    public Builder setFuelCapacity(float fuelCapacity) {
      this.fuelCapacity = fuelCapacity;
      return this;
    }

    public Motorcycle build() {
      return new Motorcycle(
          this.id,
          this.model,
          this.color,
          this.price,
          this.kilometers,
          this.used,
          this.engineCapacity,
          this.fuelCapacity);
    }
  }
}
