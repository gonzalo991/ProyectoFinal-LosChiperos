package vacunatorio.entidades;

import java.util.Date;

public class Cita {

    private Date fechaUltimaDosis;
    private int dosisAplicada;
    private Date proximaCita;

    public Cita() {
    }

    public Cita(Date fechaUltimaDosis, int dosisAplicada, Date proximaCita) {
        this.fechaUltimaDosis = fechaUltimaDosis;
        this.dosisAplicada = dosisAplicada;
        this.proximaCita = proximaCita;
    }

}
