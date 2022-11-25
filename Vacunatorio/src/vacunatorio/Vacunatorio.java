
package vacunatorio;

import GUI.login;
import java.sql.SQLException;
import java.text.ParseException;



public class Vacunatorio {

   
    public static void main(String[] args) throws SQLException, ParseException {
        login lg = new login();
        lg.setLocationRelativeTo(null);
        lg.show();
    }
            
    
}
