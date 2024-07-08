package src.views;

import src.database.Repository;
import src.database.interfaces.IStorage;
import src.shared.utils.BaseEntity;
import src.shared.utils.ViewUtils;

public class Revert<T extends BaseEntity, K extends IStorage<T>> {
  Repository<T, K> repository;

  public Revert(Repository<T, K> repository) {
    this.repository = repository;
  }

  public void show() {
    ViewUtils.clear();
    ViewUtils.printHeader("Reverted successfully");
    this.repository.revertLastChange();
    ViewUtils.promptForInput("Press enter to continue...");
  }
}
