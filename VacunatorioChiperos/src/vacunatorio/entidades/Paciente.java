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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Date getFechaDeNac() {
        return fechaDeNac;
    }

    public void setFechaDeNac(Date fechaDeNac) {
        this.fechaDeNac = fechaDeNac;
    }

    public String getCtroSaludo() {
        return ctroSaludo;
    }

    public void setCtroSaludo(String ctroSaludo) {
        this.ctroSaludo = ctroSaludo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }

    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }

}
