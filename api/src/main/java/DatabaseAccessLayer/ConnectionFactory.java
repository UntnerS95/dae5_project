package DatabaseAccessLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;

/**
 * documentation to the jdbc drivers can be found here:
 * https://jdbc.postgresql.org/documentation/head/index.html
 * 
 * @author Stefan Untner (S2010306033)
 */
public class ConnectionFactory {

  // URL for connecting :
  // https://jdbc.postgresql.org/documentation/head/connect.html

  @Value("${spring.datasource.url}")
  private static final String localPostgresDbUrl = "jdbc:postgresql://localhost:5432";
  private static final String USER = "user_admin";
  private static final String PASS = "admin";
  private static final String SCHEMA = "tms";
  private static final String LOGLEVEL = "DEBUG"; // OFF, DEBUG, TRACE, FATAL, ERROR, WARNING

  /**
   * Get a connection to database.
   *
   * @return Connection object
   */
  public static Connection getConnection() {
    try {
      return getRemoteDatabaseConnection();
    } catch (Throwable t) {
      t.printStackTrace();
    }
    return null;
  }

  private static Connection getRemoteDatabaseConnection() {
    try {
      DriverManager.registerDriver(new Driver());
      Properties connectionProperties = new Properties();
      connectionProperties.setProperty("user", USER);
      connectionProperties.setProperty("password", PASS);
      connectionProperties.setProperty("currentSchema", SCHEMA);
      connectionProperties.setProperty("loggerLevel", LOGLEVEL);
      return DriverManager.getConnection(localPostgresDbUrl, connectionProperties);
    } catch (SQLException ex) {
      throw new RuntimeException("Error connecting to the database", ex);
    }
  }
}