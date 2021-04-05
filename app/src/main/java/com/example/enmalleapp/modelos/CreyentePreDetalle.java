package com.example.enmalleapp.modelos;

public class CreyentePreDetalle {
    private String idCreyentePreDetalle;
    private String nombresLiderPreDetalle;
    private String nombresPreDetalle;
    private String apellidosPreDetalle;
    private String edadPreDetalle;
    private boolean isSelected;

    public CreyentePreDetalle() {
    }

    public CreyentePreDetalle(String idCreyentePreDetalle, String nombresLiderPreDetalle, String nombresPreDetalle, String apellidosPreDetalle, String edadPreDetalle, boolean isSelected) {
        this.idCreyentePreDetalle = idCreyentePreDetalle;
        this.nombresLiderPreDetalle = nombresLiderPreDetalle;
        this.nombresPreDetalle = nombresPreDetalle;
        this.apellidosPreDetalle = apellidosPreDetalle;
        this.edadPreDetalle = edadPreDetalle;


        this.isSelected = isSelected;
    }

    public String getIdCreyentePreDetalle() {
        return idCreyentePreDetalle;
    }

    public void setIdCreyentePreDetalle(String idCreyentePreDetalle) {
        this.idCreyentePreDetalle = idCreyentePreDetalle;
    }

    public String getNombresLiderPreDetalle() {
        return nombresLiderPreDetalle;
    }

    public void setNombresLiderPreDetalle(String nombresLiderPreDetalle) {
        this.nombresLiderPreDetalle = nombresLiderPreDetalle;
    }

    public String getNombresPreDetalle() {
        return nombresPreDetalle;
    }

    public void setNombresPreDetalle(String nombresPreDetalle) {
        this.nombresPreDetalle = nombresPreDetalle;
    }

    public String getApellidosPreDetalle() {
        return apellidosPreDetalle;
    }

    public void setApellidosPreDetalle(String apellidosPreDetalle) {
        this.apellidosPreDetalle = apellidosPreDetalle;
    }

    public String getEdadPreDetalle() {
        return edadPreDetalle;
    }

    public void setEdadPreDetalle(String edadPreDetalle) {
        this.edadPreDetalle = edadPreDetalle;
    }


    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
