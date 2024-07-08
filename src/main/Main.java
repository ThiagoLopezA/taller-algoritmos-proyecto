package src.main;

import src.database.Repository;
import src.database.storages.LinkedListStorage;
import src.models.Vehicle;
import src.views.Menu;
import src.views.VehicleCreator;
import src.views.VehicleDeleter;
import src.views.VehicleList;
import src.views.VehicleUpdater;
import src.views.Revert;
import src.views.SortVisualizer;
import src.views.TestDataGenerator;

public class Main {
  public static void main(String[] args) {
    try {

      LinkedListStorage<Vehicle> storage = new LinkedListStorage<Vehicle>();
      Repository<Vehicle, LinkedListStorage<Vehicle>> repository = new Repository<Vehicle, LinkedListStorage<Vehicle>>(
          storage);

      VehicleCreator<Vehicle, LinkedListStorage<Vehicle>> vehicleCreatorView = new VehicleCreator<>(repository);
      VehicleList<Vehicle, LinkedListStorage<Vehicle>> vehicleListView = new VehicleList<>(repository);
      VehicleUpdater<Vehicle, LinkedListStorage<Vehicle>> vehicleUpdaterView = new VehicleUpdater<>(repository);
      Revert<Vehicle, LinkedListStorage<Vehicle>> vehicleRevertView = new Revert<>(repository);
      VehicleDeleter<Vehicle, LinkedListStorage<Vehicle>> vehicleDeleterView = new VehicleDeleter<>(repository);
      TestDataGenerator<Vehicle, LinkedListStorage<Vehicle>> testDataGeneratorView = new TestDataGenerator<>(
          repository);
      SortVisualizer<Vehicle, LinkedListStorage<Vehicle>> sortVisualizerView = new SortVisualizer<>(repository);

      while (true) {
        Integer userChoice = Menu.show();

        switch (userChoice) {
          case 1:
            vehicleCreatorView.show();
            break;
          case 2:
            vehicleListView.show();
            break;
          case 3:
            vehicleUpdaterView.show();
            break;
          case 4:
            vehicleDeleterView.show();
            break;
          case 5:
            sortVisualizerView.show();
            break;
          case 6:
            vehicleRevertView.show();
            break;
          case 7:
            testDataGeneratorView.show();
            break;
          case 8:
            return;
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
