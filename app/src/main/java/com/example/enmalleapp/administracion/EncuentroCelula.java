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
import com.example.enmalleapp.modelos.CreyenteEncuentroCelula;
import com.example.enmalleapp.modelos.CreyentePreCelula;
import com.example.enmalleapp.adaptadores.AdaptadorRecyclerEncuentroCelula;
import com.example.enmalleapp.claseGlobal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EncuentroCelula extends AppCompatActivity {
    RecyclerView recyclerEncuentroCelula;
    ArrayList <CreyenteEncuentroCelula> listaDatosEncuentroCelula;
    AdaptadorRecyclerEncuentroCelula adapter;
    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    private Toolbar toolbar;
    String PrePantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentro_celula);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        recyclerEncuentroCelula = findViewById(R.id.recyclerEncuentroCelula);
        recyclerEncuentroCelula.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        llenarListaEncuentroCelula();

        adapter = new AdaptadorRecyclerEncuentroCelula(listaDatosEncuentroCelula);
        recyclerEncuentroCelula.setAdapter(adapter);

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

    public void llenarListaEncuentroCelula(){
        try {
            String sx;
            claseGlobal objLectura = (claseGlobal)getApplicationContext();
            sx = objLectura.getId_sexo();
            PreparedStatement pst = cc.stConsulta("exec sp_consulta_listado_supervision_encuentro ?, ?");
            pst.setString(1, "ENC");
            pst.setString(2, sx);
            ResultSet rs = pst.executeQuery();
            listaDatosEncuentroCelula = new ArrayList<CreyenteEncuentroCelula>();
            while (rs.next()){
                CreyenteEncuentroCelula creyenteencuentrocelula = new CreyenteEncuentroCelula();
                creyenteencuentrocelula.setLider(rs.getString(1));
                creyenteencuentrocelula.setCandidatos(rs.getString(2));
                creyenteencuentrocelula.setNominados(rs.getString(3));
                creyenteencuentrocelula.setAsistentes(rs.getString(4));
                creyenteencuentrocelula.setIdLider(rs.getString(5));


                listaDatosEncuentroCelula.add(creyenteencuentrocelula);
            }

        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}
