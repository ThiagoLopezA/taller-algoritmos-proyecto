package src.views;

import src.database.Repository;
import src.database.interfaces.IStorage;
import src.shared.structures.Array;
import src.shared.utils.BaseEntity;
import src.shared.utils.ViewUtils;

public class VehicleDeleter<T extends BaseEntity, K extends IStorage<T>> {
  Repository<T, K> repository;

  public VehicleDeleter(Repository<T, K> repository) {
    this.repository = repository;
  }

  public void show() {
    ViewUtils.clear();
    Array<T> vehicles = this.repository.getAll();
    ViewUtils.printHeader("Delete Vehicle");
    for (Integer i = 0; i < vehicles.getSize(); i++) {
      ViewUtils.printOption(i, vehicles.get(i).toString());
    }
    int vehicleIndex = ViewUtils.promptForIntInput("Enter the number of the vehicle to delete");

    if (vehicleIndex < 0 || vehicleIndex >= vehicles.getSize()) {
      System.out.println("Invalid vehicle number. Please try again.");
      show();
      return;
    }

    T vehicle = vehicles.get(vehicleIndex);
    try {
      this.repository.delete(vehicle);
      System.out.println("Vehicle deleted successfully!");
    } catch (Exception e) {
      System.out.println("Error deleting vehicle: " + e.getMessage());
      show();
    }
  }
}
