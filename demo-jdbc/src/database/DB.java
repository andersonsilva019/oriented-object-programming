package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {

  private static Connection connection = null;

  public static Connection getConnection() {
    if (connection == null) {
      try {
        Properties props = loadProperties();
        String url = props.getProperty("jdbc.url");
        connection = DriverManager.getConnection(url, props);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return connection;
  }

  public static void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  private static Properties loadProperties() {
    try (FileInputStream fs = new FileInputStream("db.properties")) {
      Properties properties = new Properties();
      properties.load(fs);
      return properties;
    } catch (IOException e) {
      throw new DbException(e.getMessage());
    }
  }
}