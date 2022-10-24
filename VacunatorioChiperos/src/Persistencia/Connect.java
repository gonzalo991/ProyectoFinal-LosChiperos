
package Persistencia;

import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  

//Conexión a la base de datos
public class Connect {
  
    
    public static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:vacunatorio.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
