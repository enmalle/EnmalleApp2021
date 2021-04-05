package com.example.enmalleapp.modelos;

public class CreyentePosDetalle {
    private String idCreyentePosDetalle;
    private String nombresLiderPosDetalle;
    private String nombresPosDetalle;
    private String apellidosPosDetalle;
    private String edadPosDetalle;
    private boolean isSelected;

    public CreyentePosDetalle() {
    }

    public CreyentePosDetalle(String idCreyentePosDetalle, String nombresLiderPosDetalle, String nombresPosDetalle, String apellidosPosDetalle, String edadPosDetalle, boolean isSelected) {
        this.idCreyentePosDetalle = idCreyentePosDetalle;
        this.nombresLiderPosDetalle = nombresLiderPosDetalle;
        this.nombresPosDetalle = nombresPosDetalle;
        this.apellidosPosDetalle = apellidosPosDetalle;
        this.edadPosDetalle = edadPosDetalle;
        this.isSelected = isSelected;
    }

    public String getIdCreyentePosDetalle() {
        return idCreyentePosDetalle;
    }

    public void setIdCreyentePosDetalle(String idCreyentePosDetalle) {
        this.idCreyentePosDetalle = idCreyentePosDetalle;
    }

    public String getNombresLiderPosDetalle() {
        return nombresLiderPosDetalle;
    }

    public void setNombresLiderPosDetalle(String nombresLiderPosDetalle) {
        this.nombresLiderPosDetalle = nombresLiderPosDetalle;
    }

    public String getNombresPosDetalle() {
        return nombresPosDetalle;
    }

    public void setNombresPosDetalle(String nombresPosDetalle) {
        this.nombresPosDetalle = nombresPosDetalle;
    }

    public String getApellidosPosDetalle() {
        return apellidosPosDetalle;
    }

    public void setApellidosPosDetalle(String apellidosPosDetalle) {
        this.apellidosPosDetalle = apellidosPosDetalle;
    }

    public String getEdadPosDetalle() {
        return edadPosDetalle;
    }

    public void setEdadPosDetalle(String edadPosDetalle) {
        this.edadPosDetalle = edadPosDetalle;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
