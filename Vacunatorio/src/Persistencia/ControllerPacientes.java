
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
import model.Paciente;
//import java.util.Date;

public class ControllerPacientes {
    
    public static List<Paciente> AllPacientes() throws SQLException, ParseException{
        List<Paciente> ListP = new ArrayList<Paciente>();
        Statement stmt = null;
        String sql = "SELECT * FROM pacientes";
        
         try {
            Connection conn;
            conn = connect();
            stmt  = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Paciente p = new Paciente();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDni(rs.getString("dni"));
                p.setFecha_nacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_nacimiento")));// debo convertir dado que parece que en sqlite la celda date son text
                
              ListP.add(p);
              
            }
            conn.close();
            return ListP;
            }   catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
        
        return ListP;
        }        
    public static Paciente PacientesByDNI(String dni) throws SQLException, ParseException{
    
        
        
        
        String sql = "SELECT * FROM pacientes"
                        +" where dni = ?";
       Paciente p = new Paciente();
        
         try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, dni);
            ResultSet rs;
            rs = prepared.executeQuery();
            
            while(rs.next()){                
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));                
                p.setDni(rs.getString("dni"));  
                System.out.println(rs.getString("fecha_nacimiento"));
                p.setFecha_nacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_nacimiento")));// debo convertir dado que parece que en sqlite la celda date son text
             
            }
            conn.close();
            return p;
            }   catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
    return p;
    }    
    public static void PacienteDelete(String dni){
         String sql = "DELETE FROM pacientes where dni = ?";
         try {
            Connection conn;
            conn = connect();
            PreparedStatement prepared = conn.prepareStatement(sql);
            prepared.setString(1, dni);            
            prepared.executeUpdate();
             System.out.println("Paciente eliminado ok");
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
         
    } 
    public static void PacienteUpdate(Paciente p){
    
         String sql = "UPDATE pacientes SET nombre = ? , "
                + "apellido = ? ,"
                 + "dni = ? ,"
                 + "fecha_nacimiento = ? "
                + "WHERE id = ?";
         try {
            Connection conn;
            conn = connect();
           PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getApellido());
            pstmt.setString(3, p.getDni());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(4, df.format(p.getFecha_nacimiento()) );
            pstmt.setInt(5,p.getId());
            
           pstmt.executeUpdate();
             System.out.println("Paciente actualizado Ok");
           conn.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }    
    public static void PacienteInsert(Paciente p){
    
        String sql = "INSERT INTO pacientes(nombre,apellido,dni,fecha_nacimiento) VALUES(?,?,?,?)";
        try {
            Connection conn;
            conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getApellido());
            pstmt.setString(3, p.getDni());
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            pstmt.setString(4, df.format(p.getFecha_nacimiento()));
           pstmt.executeUpdate();
            System.out.println("Paciente ingresado Ok");
           conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    }
    
    

