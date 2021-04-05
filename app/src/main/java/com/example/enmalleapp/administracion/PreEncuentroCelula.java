package com.example.enmalleapp.administracion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.enmalleapp.R;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.CreyentePreCelula;
import com.example.enmalleapp.adaptadores.AdaptadorRecyclerPreCelula;
import com.example.enmalleapp.claseGlobal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreEncuentroCelula extends AppCompatActivity {
    RecyclerView recyclerPreEncuentroCelula;
    ArrayList <CreyentePreCelula> listaDatosPreCelula;
    AdaptadorRecyclerPreCelula adapter;
    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    private Toolbar toolbar;
    String PrePantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_encuentro_celula);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        recyclerPreEncuentroCelula = findViewById(R.id.recyclerPreEncuentroCelula);
        recyclerPreEncuentroCelula.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        llenarListaPreEncuentroCelula();

       adapter = new AdaptadorRecyclerPreCelula(listaDatosPreCelula);
       recyclerPreEncuentroCelula.setAdapter(adapter);

    }


    @Override protected  void onStart() {
        super.onStart();
    }
    @Override protected  void onResume() {
        super.onResume();
    }
    @Override protected  void onPause() {
        super.onPause();
    }
    @Override protected  void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop PreEncuentroCelula", Toast.LENGTH_LONG).show();
        finish();
    }
    @Override protected  void onRestart() {
        super.onRestart();
    }
    @Override protected  void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menus,menu); //Se cambia aqui "menue"
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {

             case R.id.MenuSalirs:
                finish();
                break;
        }
        return true;
    }

    public void llenarListaPreEncuentroCelula(){
        try {
            String sx;
            claseGlobal objLectura = (claseGlobal)getApplicationContext();
            sx = objLectura.getId_sexo();


            PreparedStatement pst = cc.stConsulta("exec sp_consulta_listado_supervision_pre ?, ?");

            pst.setString(1, "PRE");
            pst.setString(2, sx);
            ResultSet rs = pst.executeQuery();
            listaDatosPreCelula = new ArrayList<CreyentePreCelula>();
            while (rs.next()){
                CreyentePreCelula creyenteprecelula = new CreyentePreCelula();
                creyenteprecelula.setLider(rs.getString(1));
                creyenteprecelula.setCandidatos(rs.getString(2));
                creyenteprecelula.setNominados(rs.getString(3));
                creyenteprecelula.setAsistentes(rs.getString(4));
                creyenteprecelula.setIdLider(rs.getString(5));


                listaDatosPreCelula.add(creyenteprecelula);
            }

        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
