package vacunatorio.entidades;

import java.util.Date;

public class Cita {

    private Date fechaUltimaDosis;
    private int dosisAplicada;
    private Date proximaCita;


    public Cita(Date fechaUltimaDosis, int dosisAplicada, Date proximaCita) {
        this.fechaUltimaDosis = fechaUltimaDosis;
        this.dosisAplicada = dosisAplicada;
        this.proximaCita = proximaCita;
    }

    public Date getFechaUltimaDosis() {
        return fechaUltimaDosis;
    }

    public void setFechaUltimaDosis(Date fechaUltimaDosis) {
        this.fechaUltimaDosis = fechaUltimaDosis;
    }

    public int getDosisAplicada() {
        return dosisAplicada;
    }

    public void setDosisAplicada(int dosisAplicada) {
        this.dosisAplicada = dosisAplicada;
    }

    public Date getProximaCita() {
        return proximaCita;
    }

    public void setProximaCita(Date proximaCita) {
        this.proximaCita = proximaCita;
    }

    
    
}
