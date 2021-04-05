package com.example.enmalleapp.modelos;

public class CreyenteEncuentroCelula {
    private String lider;
    private String candidatos;
    private String nominados;
    private String asistentes;
    private String idLider;

    public CreyenteEncuentroCelula() {
    }

    public CreyenteEncuentroCelula(String lider, String candidatos, String nominados, String asistentes, String idLider) {
        this.lider = lider;
        this.candidatos = candidatos;
        this.nominados = nominados;
        this.asistentes = asistentes;
        this.idLider = idLider;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String lider) {
        this.lider = lider;
    }

    public String getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(String candidatos) {
        this.candidatos = candidatos;
    }

    public String getNominados() {
        return nominados;
    }

    public void setNominados(String nominados) {
        this.nominados = nominados;
    }

    public String getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(String asistentes) {
        this.asistentes = asistentes;
    }

    public String getIdLider() {
        return idLider;
    }

    public void setIdLider(String idLider) {
        this.idLider = idLider;
    }
}
