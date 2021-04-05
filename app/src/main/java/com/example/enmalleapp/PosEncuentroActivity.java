package com.example.enmalleapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.example.enmalleapp.adaptadores.AdaptadorRecyclerPos;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.CreyentePos;

public class PosEncuentroActivity extends AppCompatActivity {
    private Toolbar toolbar;

    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    Date fecha = new Date();
    RecyclerView recyclerViewPos;
    ArrayList <CreyentePos> listaDatosPos;
    AdaptadorRecyclerPos adapter;
    private Toast mToast;
    String trama = "";
    String VariableControl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_encuentro);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        recyclerViewPos = findViewById(R.id.recyclerPos);
        recyclerViewPos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menue,menu); //Se cambia aqui "menue"
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.MenuBuscare:
                //validarRegistroAsistenciaCelula();
                VariableControl="NO EXISTE"; //borrar si se habilita la linea anterior
                if (VariableControl == "NO EXISTE"){
                    menuItem.setEnabled(false);
                    llenarListaCandidatos();
                    adapter = new AdaptadorRecyclerPos(listaDatosPos);
                    recyclerViewPos.setAdapter(adapter);
                    adapter.setOnItemClickListener(new AdaptadorRecyclerPos.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                        }
                        @Override
                        public void onDeleteClick(int position) {
                            removeItem(position);
                        }
                    });
                }
                break;
            case R.id.MenuGuardare:
                if (VariableControl == "NO EXISTE")
                {
                    guardarCandidatos();
                    registrarCandidatosPosEncuentro();
                    borrarData();
                    menuItem.setEnabled(false);
                }else
                {
                    Toast.makeText(getApplicationContext(), "NO EXISTEN DATOS A GUARDAR", Toast.LENGTH_SHORT).show();
                    menuItem.setEnabled(false);
                }
                break;
            case R.id.MenuSalire:
                finish();
                break;
        }
        return true;
    }

    public void removeItem(int position) {
        listaDatosPos.remove(position);
        adapter.notifyItemRemoved(position);
    }

    public String guardarCandidatos(){
        trama = "";
        claseGlobal objLectura = (claseGlobal)getApplicationContext();
        trama = trama + objLectura.getIdLider() + ";";
        trama = trama + objLectura.getIdCelula() + ":";
        for(int i = 0; i < listaDatosPos.size() ; i++){
            CreyentePos s = listaDatosPos.get(i);
            if(i==listaDatosPos.size()-1){
                trama = trama + s.getIdCreyentePos()+",";
            }else{
                trama = trama + s.getIdCreyentePos()+",";
            }
        }
        return trama;
    }

    public void llenarListaCandidatos(){
        try {
            boolean existe = false;
            String parametro1;
            String parametro2;
            claseGlobal objLectura = (claseGlobal)getApplicationContext();
            parametro1 = objLectura.getIdLider();
            parametro2 = objLectura.getId_sexo();
            PreparedStatement pst = cc.stConsulta("exec sp_consulta_candidatos_pos_encuentro ?, ?");
            //variable Global del id lider
            pst.setString(1, parametro1);
            pst.setString(2, parametro2);
            ResultSet rs = pst.executeQuery();
            listaDatosPos = new ArrayList<CreyentePos>();
            while (rs.next()) {
                existe = true;
                CreyentePos CreyentePos = new CreyentePos();
                CreyentePos.setIdCreyentePos(rs.getString(1));
                CreyentePos.setNombresPos(rs.getString(2));
                CreyentePos.setApellidosPos(rs.getString(3));
                CreyentePos.setEdadPos(rs.getString(4));

                listaDatosPos.add(CreyentePos);
            }
            if(existe == false) {
                Toast.makeText(PosEncuentroActivity.this, "No hay candidatos o aun no hay Pre-Encuentro", Toast.LENGTH_LONG).show();
            }
            if (listaDatosPos.size()==0){
                VariableControl="EXISTE"; //borrar si se habilita la linea anterior
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void registrarCandidatosPosEncuentro() {
        try {
            String parametro2;
            claseGlobal objLectura = (claseGlobal)getApplicationContext();
            parametro2 = objLectura.getId_sexo();
            PreparedStatement pst = cc.stConsulta("exec sp_registro_candidatos_pos_encuentro ?, ?");
            pst.setString(1, trama);
            pst.setString(2, parametro2);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Toast.makeText(getApplicationContext(), "REGISTRO SATISFACTORIO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(PosEncuentroActivity.this, "ERROR EN INSERCION", Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void borrarData() {
        listaDatosPos.clear(); //Borras la data con la que llenas el recyclerview
        adapter.notifyDataSetChanged(); //le notifico al adaptador que no hay nada para llenar la vista
    }


}