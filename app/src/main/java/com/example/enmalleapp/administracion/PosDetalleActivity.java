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
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.enmalleapp.R;
import com.example.enmalleapp.adaptadores.AdaptadorRecyclerPre;
import com.example.enmalleapp.adaptadores.AdaptadorRecyclerPosDetalle;
import com.example.enmalleapp.claseGlobal;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.Creyente;
import com.example.enmalleapp.modelos.CreyentePosDetalle;
import com.example.enmalleapp.claseGlobal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PosDetalleActivity extends AppCompatActivity {
    private Toolbar toolbar;
    RecyclerView recyclerPosDetalle;
    ArrayList <CreyentePosDetalle> listaDatosPosDetalle;
    AdaptadorRecyclerPosDetalle adapter;
    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    private String idLiderDesdeAdapter;
    String trama = "";
    String PrePantalla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_detalle);
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        recyclerPosDetalle = findViewById(R.id.recyclerPosDetalle);
        recyclerPosDetalle.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            idLiderDesdeAdapter = extras.getString("idLiderDesdeAdapter");
        }
        llenarListaPosDetalle();
        adapter = new AdaptadorRecyclerPosDetalle(listaDatosPosDetalle);
        recyclerPosDetalle.setAdapter(adapter);
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
        //Toast.makeText(this, "onStop PosDetalleActivity", Toast.LENGTH_LONG).show();
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
                registrarAsistenciaPosEncuentro();
                //finish();
//                finishActivity(PreEncuentroCelula.class);
                Intent intent=new Intent(getApplicationContext(),PosEncuentroCelula.class);
                startActivity(intent);
                break;
            case R.id.MenuSalire:
                finish();
                break;
        }
        return true;
    }

//    private void finishActivity(Class<PreEncuentroCelula> preEncuentroCelulaClass) { }

    public void llenarListaPosDetalle(){
        try {
            String parametro1 = idLiderDesdeAdapter;
            PreparedStatement pst = cc.stConsulta("exec sp_consulta_detalle_pos_encuentro ?");
            pst.setString(1, parametro1);
            ResultSet rs = pst.executeQuery();
            listaDatosPosDetalle = new ArrayList<CreyentePosDetalle>();
            while (rs.next()){
                CreyentePosDetalle CreyentePosDetalle = new CreyentePosDetalle();
                CreyentePosDetalle.setIdCreyentePosDetalle(rs.getString(1));
                CreyentePosDetalle.setNombresLiderPosDetalle(rs.getString(2));
                CreyentePosDetalle.setNombresPosDetalle(rs.getString(3));
                CreyentePosDetalle.setApellidosPosDetalle(rs.getString(4));
                CreyentePosDetalle.setEdadPosDetalle(rs.getString(5));
                listaDatosPosDetalle.add(CreyentePosDetalle);
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public String guardarAsistencia(){
        trama = "";
        claseGlobal objLectura = (claseGlobal)getApplicationContext();

        for(int i = 0; i < listaDatosPosDetalle.size() ; i++){
            CreyentePosDetalle s = listaDatosPosDetalle.get(i);
            if (true==s.isSelected()) {
                trama = trama + s.getIdCreyentePosDetalle()+",";
            }
        }
        //Toast.makeText(getApplicationContext(), trama, Toast.LENGTH_SHORT).show();
        return trama;
    }

    public void registrarAsistenciaPosEncuentro() {
        try {
            PreparedStatement pst = cc.stConsulta("exec sp_registo_asistencia_pos_encuentro ?");
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
