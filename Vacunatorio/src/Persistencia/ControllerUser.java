
package Persistencia;

import GUI.Principal;
import GUI.login;
import static Persistencia.Connect.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import model.User;


public class ControllerUser {
    public static void UsuarioBypass(String user, String pass, login lo){
        User usuario = new User();
        
         String sql = "SELECT user, email FROM user"
                        +" where pass = ?";
         try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, pass);
            ResultSet rs;
            rs = prepared.executeQuery();
            
            while(rs.next()){             
               
                usuario.setUser(rs.getString("user"));
                usuario.setEmail(rs.getString("email"));                
            }
            conn.close();
            
             if (user.equals(usuario.getUser())) {
                 lo.dispose();
                 Principal p = new Principal();
                 p.setSize(1280, 720);
                 p.setLocationRelativeTo(null);
                 p.setVisible(true);
             }else{
                 System.out.println("error login");
             }
             
            
          
            }   catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
    }
}
