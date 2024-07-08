package src.views;

import src.database.Repository;
import src.database.interfaces.IStorage;
import src.shared.structures.Array;
import src.shared.utils.BaseEntity;
import src.shared.utils.ViewUtils;

public class VehicleList<T extends BaseEntity, K extends IStorage<T>> {
  Repository<T, K> repository;

  public VehicleList(Repository<T, K> repository) {
    this.repository = repository;
  }

  public void show() {
    ViewUtils.clear();
    Array<T> vehicles = this.repository.getAll();
    ViewUtils.printHeader("Vehicle list");
    for (Integer i = 0; i < vehicles.getSize(); i++) {
      ViewUtils.printOption(i, vehicles.get(i).toString());
    }
    ViewUtils.promptForInput("Press enter to go back to menu...");
  }

}
