package com.example.enmalleapp;

import android.app.Application;

public class claseGlobal extends Application {

    private String idLider;
    private String idCelula;
    private String variableControl;
    private String variablePrePantalla;
    private String id_nivel_acceso;
    private String id_nivel_acceso_estado;
    private String variableClasePos;
    private String id_sexo;

    public String getVariableClasePos() {return variableClasePos;}
    public void setVariableClasePos(String variableClasePos) {this.variableClasePos = variableClasePos;}

    public String getId_sexo() {return id_sexo;}
    public void setId_sexo(String id_sexo) {this.id_sexo = id_sexo;}

    public String getId_nivel_acceso() {return id_nivel_acceso;}
    public void setId_nivel_acceso(String id_nivel_acceso) {this.id_nivel_acceso = id_nivel_acceso;}

    public String getId_nivel_acceso_estado() {return id_nivel_acceso_estado;}
    public void setId_nivel_acceso_estado(String id_nivel_acceso_estado) {this.id_nivel_acceso_estado = id_nivel_acceso_estado;}

    public String getIdLider() {
        return idLider;
    }
    public void setIdLider(String idLider) {
        this.idLider = idLider;
    }

    public String getIdCelula() {return idCelula;}
    public void setIdCelula(String idCelula){this.idCelula = idCelula;}

    public String getVariableControl() {return variableControl;}
    public void setVariableControl(String variableControl) {this.variableControl = variableControl;}

    public String getVariablePrePantalla() {return variablePrePantalla;}
    public void setVariablePrePantalla(String variablePrePantalla) {this.variablePrePantalla = variablePrePantalla;
    }
}
