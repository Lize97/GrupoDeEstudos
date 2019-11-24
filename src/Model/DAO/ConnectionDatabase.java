package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionDatabase {
private static final String URL = "jdbc:mysql://localhost:3306/grupoestudo?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
      private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
      private static final String USER = "root";
      private static final String PASS = "Kurama1990";
      
      public  static Connection getConnection(){
          try {
              Class.forName(DRIVER);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              return DriverManager.getConnection(URL, USER, PASS);
          } catch (SQLException ex) {
              Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
              }
          return null;
  }
}
