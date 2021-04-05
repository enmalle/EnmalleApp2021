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

import com.example.enmalleapp.adaptadores.AdaptadorRecyclerTurnos;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.CreyenteTurnos;
import com.example.enmalleapp.claseGlobal;

public class TurnosActivity extends AppCompatActivity{
    private Toolbar toolbar;
    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    Date fecha = new Date();
    RecyclerView recyclerTurnos;
    ArrayList <CreyenteTurnos> listaDatosTurnos;
    AdaptadorRecyclerTurnos adapter;
    private Toast mToast;
    //String VariableControl = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turnos);
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        recyclerTurnos = findViewById(R.id.recyclerTurnos);
        recyclerTurnos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        llenarListaTurnos();
        adapter = new AdaptadorRecyclerTurnos(listaDatosTurnos);
        recyclerTurnos.setAdapter(adapter);
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

    public void llenarListaTurnos(){
        try {
            String parametro1, parametro2;
            claseGlobal objLectura = (claseGlobal)getApplicationContext();
            parametro1 = objLectura.getIdLider();
            parametro2 = objLectura.getVariableControl();
            PreparedStatement pst = cc.stConsulta("exec sp_consulta_turnos ?,?");
            //variable Global del id lider
            pst.setString(1, parametro1);
            pst.setString(2, parametro2);
            //pst.setString(2, "U");
            ResultSet rs = pst.executeQuery();
            listaDatosTurnos = new ArrayList<CreyenteTurnos>();
            while (rs.next()){
                CreyenteTurnos creyenteTurnos = new CreyenteTurnos();
                creyenteTurnos.setFechaTurno(rs.getString(1));
                creyenteTurnos.setAccionTurno(rs.getString(2));
                listaDatosTurnos.add(creyenteTurnos);
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
