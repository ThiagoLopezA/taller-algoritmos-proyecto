package src.database;

import src.shared.utils.BaseEntity;

public class ChangeLog<T> extends BaseEntity {
  private T oldValues;
  private T newValues;
  private ChangeLogType type;

  public ChangeLog(T oldValues, T newValues, ChangeLogType type) {
    this.oldValues = oldValues;
    this.newValues = newValues;
    this.type = type;
  }

  public T getOldValues() {
    return oldValues;
  }

  public void setOldValues(T oldValues) {
    this.oldValues = oldValues;
  }

  public T getNewValues() {
    return newValues;
  }

  public void setNewValues(T newValues) {
    this.newValues = newValues;
  }

  public ChangeLogType getType() {
    return this.type;
  }

  public void setType(ChangeLogType type) {
    this.type = type;
  }

  @Override
  public ChangeLog<T> copy() {
    return new ChangeLog<T>(this.oldValues, this.newValues, this.type);
  }

  @Override
  public String toString() {
    return "ChangeRecord{" +
        "oldValues=" + this.oldValues +
        ", newValues=" + this.newValues +
        ", type= " + this.type +
        "}";
  }
}
