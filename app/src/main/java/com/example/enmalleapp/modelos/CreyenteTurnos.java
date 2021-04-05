package com.example.enmalleapp.modelos;

public class CreyenteTurnos {
    private String fechaTurno;
    private String accionTurno;

    public CreyenteTurnos() {
    }

    public CreyenteTurnos(String fechaTurno, String accionTurno) {
        this.fechaTurno = fechaTurno;
        this.accionTurno = accionTurno;
    }

    public String getFechaTurno() {
        return fechaTurno;
    }

    public void setFechaTurno(String fechaTurno) {
        this.fechaTurno = fechaTurno;
    }

    public String getAccionTurno() {
        return accionTurno;
    }

    public void setAccionTurno(String accionTurno) {
        this.accionTurno = accionTurno;
    }
}
