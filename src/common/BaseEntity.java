package src.common;

public class BaseEntity {
  private Integer id;

  public BaseEntity() {
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
    return this.id == entity.getId();
  }

  public BaseEntity copy() {
    return new BaseEntity(this.getId());
  }
}
