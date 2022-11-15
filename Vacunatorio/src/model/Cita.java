
package model;

import java.util.Date;

public class Cita {
    private int id;
    private Date fecha_cita;
    private int dosis;// dosis a aplicar
    private String vacunatorio;
    private boolean estado;
    private String nombre;
    private int id_paciente;
    private int id_vacunatorio;

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
    private String apellido;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getId_vacunatorio() {
        return id_vacunatorio;
    }

    public void setId_vacunatorio(int id_vacunatorio) {
        this.id_vacunatorio = id_vacunatorio;
    }
  

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(Date fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public int getDosis() {
        return dosis;
    }

    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public String getVacunatorio() {
        return vacunatorio;
    }

    public void setVacunatorio(String vacunatorio) {
        this.vacunatorio = vacunatorio;
    }
    
}
