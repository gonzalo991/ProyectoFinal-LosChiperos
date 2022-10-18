/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;



import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
/**
 *
 * @author Cristian
 */
public class Connect {
    /**
     * Connect to a sample database
     */
    
    /*
    public static Connection connect() throws SQLException {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:vacunatorio.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
        /*
        finally {
            if (conn != null) {
                conn.close();
            }
        }

        return conn;
    }
*/
    
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
