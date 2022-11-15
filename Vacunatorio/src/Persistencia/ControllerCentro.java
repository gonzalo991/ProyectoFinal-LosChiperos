
package Persistencia;

import GUI.Principal;
import GUI.login;
import static Persistencia.Connect.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Centro;



public class ControllerCentro {
    public static List<Centro> AllCentros(){
        List<Centro> listaCentros = new ArrayList<Centro>();
        
         String sql = "SELECT * FROM vacunatorio";
                        
         try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            
            ResultSet rs;
            rs = prepared.executeQuery();
            
            while(rs.next()){             
               Centro c = new Centro();
                c.setId(rs.getInt("id"));
                c.setVacunatorio(rs.getString("vacunatorio"));
                c.setDomicilio(rs.getString("domicilio"));
                c.setLocalidad(rs.getString("localidad"));
                c.setProvincia(rs.getString("provincia"));
                c.setHorarios(rs.getString("horarios"));
                c.setTelefono(rs.getString("telefono"));
                listaCentros.add(c);
                
            }
            conn.close(); 
            return listaCentros;
                      

            }   catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
         return listaCentros;
    }
}
