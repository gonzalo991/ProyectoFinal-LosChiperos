package vacunatorio.entidades;

import java.util.Date;

/*
Aquí definimos la clase paciente con los atributos del mismo
 */
public class Paciente {

    private String nombre;
    private String apellido;
    private String dni;

    //Recibe un objeto en éste caso la clase cita que contiene nro de dosis fecha de aplicación y fecha de la proxima cita
    private Cita cita;

    private Date fechaDeNac;
    private String ctroSaludo;
    private String lote;
    private String nombreVacuna;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String dni, Cita cita, Date fechaDeNac, String ctroSaludo, String lote, String nombreVacuna) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cita = cita;
        this.fechaDeNac = fechaDeNac;
        this.ctroSaludo = ctroSaludo;
        this.lote = lote;
        this.nombreVacuna = nombreVacuna;
    }

}
