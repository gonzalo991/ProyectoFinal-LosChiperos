/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunatorio;

import GUI.login;
import static Persistencia.Connect.connect;
import static Persistencia.ControllerPacientes.AllPacientes;
import static Persistencia.ControllerPacientes.PacienteDelete;
import static Persistencia.ControllerPacientes.PacienteInsert;
import static Persistencia.ControllerPacientes.PacienteUpdate;
import static Persistencia.ControllerPacientes.PacientesByDNI;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static java.time.Instant.now;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import model.Paciente;

/**
 *
 * @author Cristian
 */
public class Vacunatorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        login lg = new login();
        lg.setLocationRelativeTo(null);
        lg.show();
        
        //List<Pacientes> LP = AllPacientes();
        //LP.forEach((n) -> System.out.println(n.getNombre()));
         /* 
         Pacientes LPe = PacientesByDNI("29111111");
         System.out.println(LPe.getApellido()+" " 
                 +LPe.getNombre()+" " +LPe.getDni()
               );
       LPe.setNombre("Cristian");
       LPe.setFecha_nacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1989-02-26"));
       // LPe.setFecha_nacimiento(new GregorianCalendar(2014, Calendar.FEBRUARY, 11).getTime());
       // System.out.println(LPe.getApellido()+" " +LPe.getNombre()+" " +LPe.getDni());
      
        PacienteUpdate(LPe);
        Pacientes LPe2 = PacientesByDNI("29111111");
        System.out.println(LPe2.getApellido()+" " 
                 +LPe2.getNombre()+" " +LPe2.getDni()
                 + " "+ LPe2.getFecha_nacimiento().toString());
        
     
     Paciente p = new Paciente();
     p.setNombre("Jose");
     p.setApellido("perez");
     p.setDni("25666688");
     p.setFecha_nacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("1999-02-26"));
     
     PacienteInsert(p);
     PacienteDelete("25666688");
*/
    }
    
}
