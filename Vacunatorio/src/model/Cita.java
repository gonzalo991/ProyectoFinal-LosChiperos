
package model;

import java.util.Date;

public class Cita {
    private int id;
    private Date fecha_cita;
    private int dosis;// dosis a aplicar
    private String vacunatorio;
    private int id_paciente;

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
