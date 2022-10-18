
package Persistencia;

import static Persistencia.Connect.connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.Pacientes;


public class ControllerPacientes {
    
    public static List<Pacientes> AllPacientes() throws SQLException{
        List<Pacientes> ListP = new ArrayList<Pacientes>();
        Statement stmt = null;
        String sql = "SELECT * FROM pacientes";
        
         try {
            Connection conn;
            conn = connect();
            stmt  = conn.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Pacientes p = new Pacientes();
                p.setId(rs.getInt("id"));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setDni(rs.getString("dni"));
                //p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                
              ListP.add(p);
              
            }
            conn.close();
            return ListP;
            }   catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
        
        return ListP;
        }
        
    public static List<Pacientes> PacientesByDNI(String dni) throws SQLException, ParseException{
    
        List<Pacientes> ListP = new ArrayList<Pacientes>();
        Pacientes p = new Pacientes();
        
        String sql = "SELECT * FROM pacientes"
                        +" where dni = ?";
       
        
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
                p.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
              ListP.add(p);
            }
            conn.close();
            return ListP;
            }   catch (SQLException e) {
            System.out.println(e.getMessage());
        }     
    return ListP;
    }
    
    
    
    }
    
    

