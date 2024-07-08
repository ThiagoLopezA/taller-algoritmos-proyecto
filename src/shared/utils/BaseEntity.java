package src.shared.utils;

public class BaseEntity {
  private Integer id;

  public BaseEntity() {
    this.id = IdGenerator.generateRandomId();
  }

  public BaseEntity(int id) {
    this.setId(id);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public boolean isEqual(BaseEntity entity) {
    return this.id.equals(entity.getId());
  }

  public BaseEntity copy() {
    return new BaseEntity(this.getId());
  }
}
