package com.example.enmalleapp.modelos;

public class CreyenteEncuentroDetalle {
    private String idCreyenteEncuentroDetalle;
    private String nombresLiderEncuentroDetalle;
    private String nombresEncuentroDetalle;
    private String apellidosEncuentroDetalle;
    private String edadEncuentroDetalle;
    private boolean isSelected;

    public CreyenteEncuentroDetalle() {
    }

    public CreyenteEncuentroDetalle(String idCreyenteEncuentroDetalle, String nombresLiderEncuentroDetalle, String nombresEncuentroDetalle, String apellidosEncuentroDetalle, String edadEncuentroDetalle, boolean isSelected) {
        this.idCreyenteEncuentroDetalle = idCreyenteEncuentroDetalle;
        this.nombresLiderEncuentroDetalle = nombresLiderEncuentroDetalle;
        this.nombresEncuentroDetalle = nombresEncuentroDetalle;
        this.apellidosEncuentroDetalle = apellidosEncuentroDetalle;
        this.edadEncuentroDetalle = edadEncuentroDetalle;
        this.isSelected = isSelected;
    }

    public String getIdCreyenteEncuentroDetalle() {
        return idCreyenteEncuentroDetalle;
    }

    public void setIdCreyenteEncuentroDetalle(String idCreyenteEncuentroDetalle) {
        this.idCreyenteEncuentroDetalle = idCreyenteEncuentroDetalle;
    }

    public String getNombresLiderEncuentroDetalle() {
        return nombresLiderEncuentroDetalle;
    }

    public void setNombresLiderEncuentroDetalle(String nombresLiderEncuentroDetalle) {
        this.nombresLiderEncuentroDetalle = nombresLiderEncuentroDetalle;
    }

    public String getNombresEncuentroDetalle() {
        return nombresEncuentroDetalle;
    }

    public void setNombresEncuentroDetalle(String nombresEncuentroDetalle) {
        this.nombresEncuentroDetalle = nombresEncuentroDetalle;
    }

    public String getApellidosEncuentroDetalle() {
        return apellidosEncuentroDetalle;
    }

    public void setApellidosEncuentroDetalle(String apellidosEncuentroDetalle) {
        this.apellidosEncuentroDetalle = apellidosEncuentroDetalle;
    }

    public String getEdadEncuentroDetalle() {
        return edadEncuentroDetalle;
    }

    public void setEdadEncuentroDetalle(String edadEncuentroDetalle) {
        this.edadEncuentroDetalle = edadEncuentroDetalle;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
