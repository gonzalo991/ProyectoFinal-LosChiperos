/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vacunatorio;

import GUI.login;
import static Persistencia.Connect.connect;
import static Persistencia.ControllerPacientes.AllPacientes;
import static Persistencia.ControllerPacientes.PacientesByDNI;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import model.Pacientes;

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
        lg.show();
        
        //List<Pacientes> LP = AllPacientes();
        //LP.forEach((n) -> System.out.println(n.getNombre()));
        
         List<Pacientes> LPe = PacientesByDNI("29111111");
        LPe.forEach((n) -> System.out.println(n.getNombre()));
    }
    
}
