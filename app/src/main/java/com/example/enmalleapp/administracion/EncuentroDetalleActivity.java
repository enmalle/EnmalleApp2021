package com.example.enmalleapp.administracion;

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
import android.widget.Toast;

import com.example.enmalleapp.R;
import com.example.enmalleapp.adaptadores.AdaptadorRecyclerEncuentroDetalle;
import com.example.enmalleapp.claseGlobal;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.CreyenteEncuentroDetalle;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EncuentroDetalleActivity extends AppCompatActivity {
    private Toolbar toolbar;
    RecyclerView recyclerEncuentroDetalle;
    ArrayList <CreyenteEncuentroDetalle> listaDatosEncuentroDetalle;
    AdaptadorRecyclerEncuentroDetalle adapter;
    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    private String idLiderDesdeAdapter;
    String trama = "";
    String PrePantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encuentro_detalle);
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        recyclerEncuentroDetalle = findViewById(R.id.recyclerEncuentroDetalle);
        recyclerEncuentroDetalle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            idLiderDesdeAdapter = extras.getString("idLiderDesdeAdapter");
        }
        llenarListaEncuentroDetalle();
        adapter = new AdaptadorRecyclerEncuentroDetalle(listaDatosEncuentroDetalle);
        recyclerEncuentroDetalle.setAdapter(adapter);
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
        //Toast.makeText(this, "onStop EncuentroDetalleActivity", Toast.LENGTH_LONG).show();
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
        inflater.inflate(R.menu.menui,menu); //Se cambia aqui "menue"
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.MenuGuardare:
                Toast.makeText(getApplicationContext(), "Guardar", Toast.LENGTH_SHORT).show();
                guardarAsistencia();
                registrarAsistenciaEncuentro();
                //finish();
//                finishActivity(PreEncuentroCelula.class);
                Intent intent=new Intent(getApplicationContext(),EncuentroCelula.class);
                startActivity(intent);
                break;
            case R.id.MenuSalire:
                finish();
                break;
        }
        return true;
    }

//    private void finishActivity(Class<PreEncuentroCelula> preEncuentroCelulaClass) { }

    public void llenarListaEncuentroDetalle(){
        try {
            String parametro1 = idLiderDesdeAdapter;
            PreparedStatement pst = cc.stConsulta("exec sp_consulta_detalle_encuentro ?");
            pst.setString(1, parametro1);
            ResultSet rs = pst.executeQuery();
            listaDatosEncuentroDetalle = new ArrayList<CreyenteEncuentroDetalle>();
            while (rs.next()){
                CreyenteEncuentroDetalle CreyenteEncuentroDetalle = new CreyenteEncuentroDetalle();
                CreyenteEncuentroDetalle.setIdCreyenteEncuentroDetalle(rs.getString(1));
                CreyenteEncuentroDetalle.setNombresLiderEncuentroDetalle(rs.getString(2));
                CreyenteEncuentroDetalle.setNombresEncuentroDetalle(rs.getString(3));
                CreyenteEncuentroDetalle.setApellidosEncuentroDetalle(rs.getString(4));
                CreyenteEncuentroDetalle.setEdadEncuentroDetalle(rs.getString(5));
                listaDatosEncuentroDetalle.add(CreyenteEncuentroDetalle);
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public String guardarAsistencia(){
        trama = "";
        claseGlobal objLectura = (claseGlobal)getApplicationContext();

        for(int i = 0; i < listaDatosEncuentroDetalle.size() ; i++){
            CreyenteEncuentroDetalle s = listaDatosEncuentroDetalle.get(i);
            if (true==s.isSelected()) {
                trama = trama + s.getIdCreyenteEncuentroDetalle()+",";
            }
        }
        //Toast.makeText(getApplicationContext(), trama, Toast.LENGTH_SHORT).show();
        return trama;
    }

    public void registrarAsistenciaEncuentro() {
        try {
            PreparedStatement pst = cc.stConsulta("exec sp_registo_asistencia_encuentro ?");
            pst.setString(1, trama);
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
