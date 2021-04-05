package com.example.enmalleapp.posclases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.enmalleapp.R;
import com.example.enmalleapp.adaptadores.AdaptadorRecyclerClaseAlumnoPosEncuentro;
import com.example.enmalleapp.claseGlobal;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.Creyente;
import com.example.enmalleapp.modelos.CreyentePreDetalle;
import com.example.enmalleapp.claseGlobal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.enmalleapp.R;

public class PosEncuentroClaseAlumnos extends AppCompatActivity {
    private Toolbar toolbar;
    RecyclerView recyclerPosEncuentroClaseAlumnos;
    ArrayList <CreyentePreDetalle> listaDatosPreDetalle;
    AdaptadorRecyclerClaseAlumnoPosEncuentro adapter;
    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    private String NumeroClase;
    String trama = "";
    String PrePantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_encuentro_clase_alumnos);
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        recyclerPosEncuentroClaseAlumnos = findViewById(R.id.recyclerPosEncuentroClaseAlumnos);
        recyclerPosEncuentroClaseAlumnos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            NumeroClase = extras.getString("NumeroClase");
        }

        llenarListaPreDetalle();
        adapter = new AdaptadorRecyclerClaseAlumnoPosEncuentro(listaDatosPreDetalle);
        recyclerPosEncuentroClaseAlumnos.setAdapter(adapter);

    }

    @Override protected  void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop PreDetalleActivity", Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menui,menu); //Se cambia aqui "menue"
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.MenuGuardare:
                Toast.makeText(getApplicationContext(), "Guardar", Toast.LENGTH_SHORT).show();
                guardarAsistencia();
                registrarAsistenciaPreEncuentro();
                Intent intent=new Intent(getApplicationContext(),PosEncuentroClasesActivity.class);
                startActivity(intent);
                break;
            case R.id.MenuSalire:
                finish();
                break;
        }
        return true;
    }



    public void llenarListaPreDetalle(){
        try {
            PreparedStatement pst = cc.stConsulta("exec sp_consulta_listado_clase_pos_encuentro ?");
            pst.setString(1, NumeroClase);
            ResultSet rs = pst.executeQuery();
            listaDatosPreDetalle = new ArrayList<CreyentePreDetalle>();
            while (rs.next()){
                CreyentePreDetalle creyentePreDetalle = new CreyentePreDetalle();
                creyentePreDetalle.setIdCreyentePreDetalle(rs.getString(1));
                creyentePreDetalle.setNombresLiderPreDetalle(rs.getString(2));
                creyentePreDetalle.setNombresPreDetalle(rs.getString(3));
                creyentePreDetalle.setApellidosPreDetalle(rs.getString(4));
                creyentePreDetalle.setEdadPreDetalle(rs.getString(5));
                listaDatosPreDetalle.add(creyentePreDetalle);
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public String guardarAsistencia(){
        trama = "";
        claseGlobal objLectura = (claseGlobal)getApplicationContext();

        for(int i = 0; i < listaDatosPreDetalle.size() ; i++){
            CreyentePreDetalle s = listaDatosPreDetalle.get(i);
            if (true==s.isSelected()) {
                trama = trama + s.getIdCreyentePreDetalle()+",";
            }
        }
        //Toast.makeText(getApplicationContext(), trama, Toast.LENGTH_SHORT).show();
        return trama;
    }

    public void registrarAsistenciaPreEncuentro() {
        try {
            PreparedStatement pst = cc.stConsulta("exec sp_registro_asistencia_clase_pos_encuentro ?, ?");
            pst.setString(1, trama);
            pst.setString(2, NumeroClase);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Toast.makeText(getApplicationContext(), "REGISTRO SATISFACTORIO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "ERROR: EN INSERCION", Toast.LENGTH_SHORT).show();
            }
        } catch (SQLException e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }





}