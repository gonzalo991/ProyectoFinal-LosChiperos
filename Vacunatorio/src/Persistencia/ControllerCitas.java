
package Persistencia;

import static Persistencia.Connect.connect;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import model.Cita;



public class ControllerCitas {
    
    public static List<Cita> AllCitas() throws SQLException, ParseException{
        List<Cita> ListC = new ArrayList<Cita>();
        Statement stmt = null;
        String sql = "SELECT * FROM pacientes";
        
         try {
            Connection conn;
            conn = connect();
            stmt  = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Cita c = new Cita();
                c.setId(rs.getInt("id"));
                c.setFecha_cita(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_cita")));// debo convertir dado que parece que en sqlite la celda date son text
                c.setDosis(rs.getInt("dosis"));
                c.setVacunatorio(rs.getString("vacunatorio"));
                c.setId_paciente(rs.getInt("id_paciente"));
                
              ListC.add(c);
              
            }
            conn.close();
            return ListC;
            }   catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
        
        return ListC;
        }        
    public static Cita CitaByDNI(String dni) throws SQLException, ParseException{
    
        
        
        
        String sql = "select c.id, c.dosis, c.fecha_cita, c.vacunatorio, c.id_paciente from " +
                        "pacientes as p" +
                    "inner join cita as c on p.id = c.id_paciente" +
                    "where p.dni = ?";
       Cita c = new Cita();
        
         try {
            Connection conn;
            conn = connect();
        PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, dni);
            ResultSet rs;
            rs = prepared.executeQuery();
            
            while(rs.next()){
                
                c.setId(rs.getInt("id"));
                c.setDosis(rs.getInt("dosis"));
                c.setFecha_cita(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_cita")));// debo convertir dado que parece que en sqlite la celda date son text
                c.setVacunatorio(rs.getString("vacunatorio"));
                c.setId_paciente(rs.getInt("id_paciente"));
            }
            conn.close();
            return c;
            }   catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
    return c;
    }    
    public static void CitaDeleteById(int id){
         String sql = "DELETE FROM cita where id = ?";
         try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setInt(1, id);            
            prepared.executeUpdate();
             System.out.println("Cita eliminada ok");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
    }    
    public static void CitaDeleteByPaciente(int id_paciente){
         String sql = "DELETE FROM cita where id_paciente = ?";
         try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setInt(1, id_paciente);            
            prepared.executeUpdate();
             System.out.println("Cita eliminada ok");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
    }    
    public static void CitaUpdate(Cita c){
    
         String sql = "UPDATE cita SET fecha_cita = ? , "
                + "dosis = ? ,"
                 + "vacunatorio = ? "                 
                + "WHERE id = ?";
         try {
            Connection conn;
            conn = connect();
           PreparedStatement pstmt = conn.prepareStatement(sql);
           DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(1, df.format(c.getFecha_cita()) );
            pstmt.setInt(2, c.getDosis());
            pstmt.setString(3, c.getVacunatorio());
            pstmt.setInt(4, c.getId());
            
            
           pstmt.executeUpdate();
             System.out.println("Paciente actualizado Ok");
           conn.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }    
    public static void CitaInsert(Cita c){
    
        String sql = "INSERT INTO cita (fecha_cita,dosis,vacunatorio,id_paciente) VALUES(?,?,?,?)";
        try {
            Connection conn;
            conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(1, df.format(c.getFecha_cita()));
            pstmt.setInt(2, c.getDosis());
            pstmt.setString(3, c.getVacunatorio());
            pstmt.setInt(4, c.getId_paciente());
            
           pstmt.executeUpdate();
            System.out.println("Cita ingresada Ok");
           conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
