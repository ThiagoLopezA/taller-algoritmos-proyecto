package src.models;

import src.shared.utils.BaseEntity;
import src.shared.validations.NumberValidations;
import src.shared.validations.StringValidations;

public abstract class Vehicle extends BaseEntity {
  private String model;
  private String color;
  private double price;
  private float kilometers;
  private boolean used;

  public Vehicle() {
    super();
  }

  public Vehicle(String model, String color, double price, float kilometers, boolean used) {
    super();

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
    StringValidations.notNullish(model);
    this.model = model;
  }

  public String getModel() {
    return this.model;
  }

  public void setColor(String color) throws Exception {
    StringValidations.notNullish(color);
    this.color = color;
  }

  public String getColor() {
    return this.color;
  }

  public void setPrice(double price) throws Exception {
    NumberValidations.greatherOrEqualThan(price, 0);
    this.price = price;
  }

  public double getPrice() {
    return this.price;
  }

  public void setKilometers(float kilometers) throws Exception {
    NumberValidations.greatherOrEqualThan(price, 0);
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
    StringValidations.notNullish(this.color);
    StringValidations.notNullish(this.model);
    NumberValidations.greatherOrEqualThan(this.price, 0);
    NumberValidations.greatherOrEqualThan(this.kilometers, 0);
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
