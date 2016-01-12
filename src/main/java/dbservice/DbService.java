package dbservice;

import dao.UserDao;
import entity.UserEntity;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author Guskov Artem
 *         on 10.01.2016.
 */
public class DbService {

  private static final Logger logger = Logger.getGlobal();

  private UserDao userDao;

  private Connection connection;

  public DbService() {
    connection = getH2Connection();
    userDao = new UserDao(connection);
    printConnectInfo();
  }

  public UserEntity getUser(long id) {
    try {
      return userDao.get(id);
    } catch (SQLException e) {
      logger.warning("Exception: " + e);
    }
    return null;
  }

  public UserEntity getUser(String name) {
    try {
      return userDao.get(userDao.getUserId(name));
    } catch (SQLException e) {
      logger.warning("Exception: " + e);
    }
    return null;
  }

  public long addUser(String name, String password) {
    try {
      userDao.createTable();
      userDao.insertUser(name, password);
      return userDao.getUserId(name);
    } catch (SQLException e) {

      logger.warning("Exception: " + e);

    }
    return 0;
  }

  public void cleanUp() {
    try {
      userDao.dropTable();
    } catch (SQLException e) {
      logger.warning("Exception: " + e);
    }
  }

  public void printConnectInfo() {
    try {
      System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
      System.out.println("DB version: " + connection.getMetaData().getDatabaseProductVersion());
      System.out.println("Driver: " + connection.getMetaData().getDriverName());
      System.out.println("Autocommit: " + connection.getAutoCommit());
    } catch (SQLException e) {
      logger.warning("Exception: " + e);
    }
  }

  public static Connection getH2Connection() {
    try {
      String url = "jdbc:h2:./h2db";
      String name = "guskov";
      String pass = "password";

      JdbcDataSource ds = new JdbcDataSource();
      ds.setURL(url);
      ds.setUser(name);
      ds.setPassword(pass);

      Connection connection = DriverManager.getConnection(url, name, pass);
      return connection;
    } catch (SQLException e) {
      logger.warning("Exception: " + e);
    }
    return null;
  }
}
