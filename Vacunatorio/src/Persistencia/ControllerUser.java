
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
        
         String sql = "SELECT u.user, u.email, u.permisos, v.vacunatorio FROM user as u"
                        +" inner join vacunatorio as v on u.id_vacunatorio = v.id"
                        +" where u.pass = ? and u.user = ?";
         try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, pass);
            prepared.setString(2, user);
            ResultSet rs;
            rs = prepared.executeQuery();
            
            while(rs.next()){             
               
                usuario.setUser(rs.getString("user"));
                usuario.setEmail(rs.getString("email"));
                usuario.setPermisos(rs.getString("permisos"));
                usuario.setVacunatorio(rs.getString("vacunatorio"));
            }
            conn.close();
            
             if (user.equals(usuario.getUser())) {
                 lo.dispose();
                 Principal p = new Principal(usuario);
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
