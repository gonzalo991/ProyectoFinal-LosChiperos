
package model;

import java.util.Date;


public class Aplicacion {
    private int id;
    private Date fecha_ult_dosis;
    private String vacunatorio;
    private String lote_vacuna;
    private String marca_vacuna;
    private int numeroDosis; // número de dosis aplicada
    private int id_paciente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha_ult_dosis() {
        return fecha_ult_dosis;
    }

    public void setFecha_ult_dosis(Date fecha_ult_dosis) {
        this.fecha_ult_dosis = fecha_ult_dosis;
    }

    public String getVacunatorio() {
        return vacunatorio;
    }

    public void setVacunatorio(String vacunatorio) {
        this.vacunatorio = vacunatorio;
    }

    public String getLote_vacuna() {
        return lote_vacuna;
    }

    public void setLote_vacuna(String lote_vacuna) {
        this.lote_vacuna = lote_vacuna;
    }

    public String getMarca_vacuna() {
        return marca_vacuna;
    }

    public void setMarca_vacuna(String marca_vacuna) {
        this.marca_vacuna = marca_vacuna;
    }

    public int getNumeroDosis() {
        return numeroDosis;
    }

    public void setNumeroDosis(int numeroDosis) {
        this.numeroDosis = numeroDosis;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
    
    
    
    
}
