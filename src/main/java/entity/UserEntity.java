package entity;

/**
 * @author Guskov Artem
 *         on 10.01.2016.
 */
public class UserEntity {
  private long id;
  private String name;
  private String password;

  public UserEntity(long id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserEntity that = (UserEntity) o;

    if (id != that.id) return false;
    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return password != null ? password.equals(that.password) : that.password == null;

  }

  @Override
  public int hashCode() {
    int result = (int) (id ^ (id >>> 32));
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserEntity{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", password='" + password + '\'' +
      '}';
  }
}
