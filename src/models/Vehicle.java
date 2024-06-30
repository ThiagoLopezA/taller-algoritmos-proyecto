package src.models;

import src.common.BaseEntity;
import src.common.Validations;

public abstract class Vehicle extends BaseEntity {
  private String model;
  private String color;
  private double price;
  private float kilometers;
  private boolean used;

  public Vehicle() {
    super();
  }

  public Vehicle(int id, String model, String color, double price, float kilometers, boolean used) {
    super(id);

    try {
      this.setModel(model);
      this.setColor(color);
      this.setPrice(price);
      this.setKilometers(kilometers);
      this.used = used;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void setModel(String model) throws Exception {
    Validations.validateString(model);
    this.model = model;
  }

  public String getModel() {
    return this.model;
  }

  public void setColor(String color) throws Exception {
    Validations.validateString(color);
    this.color = color;
  }

  public String getColor() {
    return this.color;
  }

  public void setPrice(double price) throws Exception {
    Validations.validateNumber(price);
    this.price = price;
  }

  public double getPrice() {
    return this.price;
  }

  public void setKilometers(float kilometers) throws Exception {
    Validations.validateNumber(price);
    this.kilometers = kilometers;
  }

  public float getKilometers() {
    return this.kilometers;
  }

  public void setUsed(boolean used) {
    this.used = used;
  }

  public boolean getUsed() {
    return this.used;
  }

  public void validateVehicle() throws Exception {
    Validations.validateString(this.color);
    Validations.validateString(this.model);
    Validations.validateNumber(this.price);
    Validations.validateNumber(this.kilometers);
  }

  @Override
  public String toString() {
    return "Vehicle{" +
        "id = " + this.getId() +
        ", model='" + this.model + '\'' +
        ", color='" + this.color + '\'' +
        ", price=" + this.price +
        ", kilometers=" + this.kilometers +
        ", used=" + this.used +
        '}';
  }

  @Override
  public abstract Vehicle copy();
}
