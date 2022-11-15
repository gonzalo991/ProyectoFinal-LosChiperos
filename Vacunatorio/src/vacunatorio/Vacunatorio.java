
package vacunatorio;

import GUI.login;
import Mail.Mail;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import model.Cita;


public class Vacunatorio {

   
    public static void main(String[] args) throws SQLException, ParseException {
//        login lg = new login();
//        lg.setLocationRelativeTo(null);
//        lg.show();
        String asunto ="Turno agendado";
        String cuerpo ="el dia tiene un turno en para darse la dosis";
        String email ="catastones@gmail.com";
        
        Mail.enviarMail(asunto, cuerpo, email);
        
       
    }
            
    
}
