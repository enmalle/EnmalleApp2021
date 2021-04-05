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

import com.example.enmalleapp.adaptadores.AdaptadorRecyclerEncuentro;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.CreyenteEncuentro;

public class EncuentroActivity extends AppCompatActivity {
    private Toolbar toolbar;

    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    Date fecha = new Date();
    RecyclerView recyclerViewEncuentro;
    ArrayList <CreyenteEncuentro> listaDatosEncuentro;
    AdaptadorRecyclerEncuentro adapter;
    private Toast mToast;
    String trama = "";
    String VariableControl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentro);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        recyclerViewEncuentro = findViewById(R.id.recyclerEncuentro);
        recyclerViewEncuentro.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
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
                    adapter = new AdaptadorRecyclerEncuentro(listaDatosEncuentro);
                    recyclerViewEncuentro.setAdapter(adapter);
                    adapter.setOnItemClickListener(new AdaptadorRecyclerEncuentro.OnItemClickListener() {
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
                    registrarCandidatosEncuentro();
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
        listaDatosEncuentro.remove(position);
        adapter.notifyItemRemoved(position);
    }

    public String guardarCandidatos(){
        trama = "";
        claseGlobal objLectura = (claseGlobal)getApplicationContext();
        trama = trama + objLectura.getIdLider() + ";";
        trama = trama + objLectura.getIdCelula() + ":";
        for(int i = 0; i < listaDatosEncuentro.size() ; i++){
            CreyenteEncuentro s = listaDatosEncuentro.get(i);
            if(i==listaDatosEncuentro.size()-1){
                trama = trama + s.getIdCreyenteEncuentro()+",";
            }else{
                trama = trama + s.getIdCreyenteEncuentro()+",";
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
            PreparedStatement pst = cc.stConsulta("exec sp_consulta_candidatos_encuentro ?, ?");
            //variable Global del id lider
            pst.setString(1, parametro1);
            pst.setString(2, parametro2);
            ResultSet rs = pst.executeQuery();
            listaDatosEncuentro = new ArrayList<CreyenteEncuentro>();
            while (rs.next()){
                existe = true;
                CreyenteEncuentro creyenteEncuentro = new CreyenteEncuentro();
                creyenteEncuentro.setIdCreyenteEncuentro(rs.getString(1));
                creyenteEncuentro.setNombresEncuentro(rs.getString(2));
                creyenteEncuentro.setApellidosEncuentro(rs.getString(3));
                creyenteEncuentro.setEdadEncuentro(rs.getString(4));

                listaDatosEncuentro.add(creyenteEncuentro);
            }
            if(existe == false) {
                Toast.makeText(EncuentroActivity.this, "No hay candidatos o aun no hay Encuentro", Toast.LENGTH_LONG).show();
            }
            if (listaDatosEncuentro.size()==0){
                VariableControl="EXISTE"; //borrar si se habilita la linea anterior
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void registrarCandidatosEncuentro() {
        try {
            String parametro2;
            claseGlobal objLectura = (claseGlobal)getApplicationContext();
            parametro2 = objLectura.getId_sexo();
            PreparedStatement pst = cc.stConsulta("exec sp_registro_candidatos_encuentro ?, ?");
            pst.setString(1, trama);
            pst.setString(2, parametro2);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Toast.makeText(getApplicationContext(), "REGISTRO SATISFACTORIO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(EncuentroActivity.this, "ERROR EN INSERCION", Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    public void borrarData() {
        listaDatosEncuentro .clear(); //Borras la data con la que llenas el recyclerview
        adapter.notifyDataSetChanged(); //le notifico al adaptador que no hay nada para llenar la vista
    }


}