package dao;

import entity.UserEntity;
import executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Guskov Artem
 *         on 10.01.2016.
 */
public class UserDao {

  private Executor executor;

  public UserDao(Connection connection) {
    this.executor = new Executor(connection);
  }

  public UserEntity get(long id) throws SQLException {
    return executor.execQuery("select id, user_name, password from user where id=" + id, result -> {
      result.next();
      return new UserEntity(result.getLong("id"), result.getString("user_name"), result.getString("password"));
    });
  }

  public long getUserId(String name) throws SQLException {
    return executor.execQuery("select id from user where user_name='" + name + "'", result -> {
      result.next();
      return result.getLong(1);
    });
  }

  public void insertUser(String name, String password) throws SQLException {
    executor.execUpdate("insert into user (user_name, password) values ('" + name + "', '" + password + "')");
  }

  public void createTable() throws SQLException {
    executor.execUpdate("create table if not exists user (id bigint auto_increment, user_name varchar(256), password varchar(256), primary key (id))");
  }

  public void dropTable() throws SQLException {
    executor.execUpdate("drop table user");
  }
}
