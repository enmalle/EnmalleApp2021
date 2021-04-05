package com.example.enmalleapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.enmalleapp.adaptadores.AdaptadorRecyclerSupervision;
import com.example.enmalleapp.conexion.ConnectionClass;
//import com.example.enmalleapp.loadingalertdialog.LoadingDialog;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.CreyenteSupervision;

public class SupervisionActivity extends AppCompatActivity {
    private Toolbar toolbar;
    RecyclerView recyclerViewSupervision;
    ArrayList <CreyenteSupervision> listaDatosSupervision;
    AdaptadorRecyclerSupervision adapter;
    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    Date fecha = new Date();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supervision);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        recyclerViewSupervision = findViewById(R.id.recyclerSupervision);
        recyclerViewSupervision.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }

    @Override protected  void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop SupervisionActivity", Toast.LENGTH_LONG).show();
        finish();
    }
    @Override protected  void onStart() {
        super.onStart();
        //Toast.makeText(this, "onStart SupervisionActivity", Toast.LENGTH_LONG).show();
    }
    @Override protected  void onResume() {
        super.onResume();
        //Toast.makeText(this, "onResume SupervisionActivity", Toast.LENGTH_LONG).show();
    }
    @Override protected  void onPause() {
        super.onPause();
        //Toast.makeText(this, "onPause SupervisionActivity", Toast.LENGTH_LONG).show();
    }
    @Override protected  void onRestart() {
        super.onRestart();
        //Toast.makeText(this, "onRestart SupervisionActivity", Toast.LENGTH_LONG).show();
    }
    @Override protected  void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "onDestroy SupervisionActivity", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menua,menu); //Se cambia aqui "menue"
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        //final LoadingDialog loadingDialog = new LoadingDialog(SupervisionActivity.this);
        switch (menuItem.getItemId()) {
            case R.id.MenuBuscara:
                    llenarListaSupervision();
                    adapter = new AdaptadorRecyclerSupervision(listaDatosSupervision, this);
                    recyclerViewSupervision.setAdapter(adapter);
                    adapter.setOnItemClickListener(new AdaptadorRecyclerSupervision.OnItemClickListener() {
                        @Override
                        public void onItemClick(int position) {
                            Toast.makeText(getApplicationContext(), "Abrir sub Pantalla", Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onDeleteClick(int position) {
                        }
                    });
            break;
            case R.id.MenuSalira:
                finish();
                break;
        }
        return true;
    }

    public void llenarListaSupervision(){
        try {
            String parametro2;
            claseGlobal objLectura = (claseGlobal)getApplicationContext();
            parametro2 = objLectura.getIdLider();

            PreparedStatement pst = cc.stConsulta("exec sp_consulta_listado_supervision ?, ?");
            //variable Global del id lider
            pst.setString(1, "PRE");
            pst.setString(2, parametro2);
            ResultSet rs = pst.executeQuery();
            listaDatosSupervision = new ArrayList<CreyenteSupervision>();
            while (rs.next()){
                CreyenteSupervision creyentesupervision = new CreyenteSupervision();
                creyentesupervision.setEtapaCrecimiento(rs.getString(1));
                creyentesupervision.setNumeroRedes(rs.getString(2));
                creyentesupervision.setNumeroCelulas(rs.getString(3));
                creyentesupervision.setNumeroNominados(rs.getString(4));
                creyentesupervision.setNumeroCandidatos(rs.getString(5));
                creyentesupervision.setNumeroAsistentes(rs.getString(6));
                creyentesupervision.setNumeroPendientes(rs.getString(7));
                creyentesupervision.setSexo(rs.getString(8));

                creyentesupervision.setEtapaCrecimiento2(rs.getString(9));
                creyentesupervision.setNumeroRedes2(rs.getString(10));
                creyentesupervision.setNumeroCelulas2(rs.getString(11));
                creyentesupervision.setNumeroNominados2(rs.getString(12));
                creyentesupervision.setNumeroCandidatos2(rs.getString(13));
                creyentesupervision.setNumeroAsistentes2(rs.getString(14));
                creyentesupervision.setNumeroPendientes2(rs.getString(15));
                creyentesupervision.setSexo2(rs.getString(16));

                creyentesupervision.setEtapaCrecimiento3(rs.getString(17));
                creyentesupervision.setNumeroRedes3(rs.getString(18));
                creyentesupervision.setNumeroCelulas3(rs.getString(19));
                creyentesupervision.setNumeroNominados3(rs.getString(20));
                creyentesupervision.setNumeroCandidatos3(rs.getString(21));
                creyentesupervision.setNumeroAsistentes3(rs.getString(22));
                creyentesupervision.setNumeroPendientes3(rs.getString(23));
                creyentesupervision.setSexo3(rs.getString(24));

                listaDatosSupervision.add(creyentesupervision);
            }



        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }



}
