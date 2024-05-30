package src.models;

public class FuelType {
  public static final String ELECTRIC = "electric";
  public static final String GASOIL = "gasoil";
  public static final String GASOLINE = "gasoline";

  public static boolean isValidFuelType(String fuelType) {
    return ELECTRIC.equals(fuelType) || GASOIL.equals(fuelType) || GASOLINE.equals(fuelType);
  }
}
