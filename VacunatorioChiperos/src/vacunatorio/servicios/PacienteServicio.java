package vacunatorio.servicios;

import java.util.Date;
import javax.swing.JOptionPane;
import vacunatorio.entidades.Paciente;


public class PacienteServicio {
        
    public Paciente ingresarPaciente(){
        String dni = JOptionPane.showInputDialog("Ingrese el dni del paciente:");
        Paciente paciente = new Paciente(); //buscamos en la base de datos;
        
        if(paciente.getDni().isEmpty()){
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del paciente");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del paciente");
            dni = JOptionPane.showInputDialog("Ingrese el dni del paciente");
            
            //Para agregar la cita usamos el servicio de cita de registrar_dosis() o cita()
            
            Date fechaNac = new Date();
            
            
        }else{
            JOptionPane.showMessageDialog(null, "El paciente ya existe en la base de datos");
        }
        return paciente;
    }
}
