package com.example.enmalleapp.posclases;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.enmalleapp.R;
import com.example.enmalleapp.adaptadores.AdaptadorRecyclerClasesPosEncuentro;
import com.example.enmalleapp.adaptadores.AdaptadorRecyclerSupervision;
import com.example.enmalleapp.claseGlobal;
import com.example.enmalleapp.conexion.ConnectionClass;
import com.example.enmalleapp.login.LoginClass;
import com.example.enmalleapp.modelos.ClasesPosEncuentro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class PosEncuentroClasesActivity extends AppCompatActivity {

    private androidx.appcompat.widget.Toolbar toolbar;

    RecyclerView recyclerClasePos;
    ArrayList<ClasesPosEncuentro> listaDatosClasesPosEncuentro;
    AdaptadorRecyclerClasesPosEncuentro adapter;
    ConnectionClass cc = new ConnectionClass();
    LoginClass lc = new LoginClass();
    Date fecha = new Date();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pos_encuentro_clases);

        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);

        recyclerClasePos= findViewById(R.id.recyclerClasePos);
        recyclerClasePos.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    }


    @Override protected  void onStop() {
        super.onStop();
        //Toast.makeText(this, "onStop SupervisionActivity", Toast.LENGTH_LONG).show();
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menua,menu); //Se cambia aqui "menue"
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.MenuBuscara:
                llenarListaSupervision();
                adapter = new AdaptadorRecyclerClasesPosEncuentro(listaDatosClasesPosEncuentro, this);
                recyclerClasePos.setAdapter(adapter);
                adapter.setOnItemClickListener(new AdaptadorRecyclerClasesPosEncuentro.OnItemClickListener() {
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
            String parametro1;
            claseGlobal objLectura = (claseGlobal)getApplicationContext();
            parametro1 = objLectura.getIdLider();


            PreparedStatement pst = cc.stConsulta("exec sp_consulta_clases_pos_encuentro ?");
            //variable Global del id lider
            pst.setString(1, parametro1);
            ResultSet rs = pst.executeQuery();

            listaDatosClasesPosEncuentro = new ArrayList<ClasesPosEncuentro>();
            while (rs.next()){
                ClasesPosEncuentro claseposencuentro = new ClasesPosEncuentro();
                claseposencuentro.setNumeroRedes1(rs.getString(1));
                claseposencuentro.setNumeroCelulas1(rs.getString(2));
                claseposencuentro.setTema1(rs.getString(3));
                claseposencuentro.setNumeroHombres1(rs.getString(4));
                claseposencuentro.setNumeroMujeres1(rs.getString(5));
                claseposencuentro.setNumeroAlumnos1(rs.getString(6));
                claseposencuentro.setNumeroAsistentesAnterior1(rs.getString(7));
                claseposencuentro.setEstadoClase1(rs.getString(8));

                claseposencuentro.setNumeroRedes2(rs.getString(9));
                claseposencuentro.setNumeroCelulas2(rs.getString(10));
                claseposencuentro.setTema2(rs.getString(11));
                claseposencuentro.setNumeroHombres2(rs.getString(12));
                claseposencuentro.setNumeroMujeres2(rs.getString(13));
                claseposencuentro.setNumeroAlumnos2(rs.getString(14));
                claseposencuentro.setNumeroAsistentesAnterior2(rs.getString(15));
                claseposencuentro.setEstadoClase2(rs.getString(16));

                claseposencuentro.setNumeroRedes3(rs.getString(17));
                claseposencuentro.setNumeroCelulas3(rs.getString(18));
                claseposencuentro.setTema3(rs.getString(19));
                claseposencuentro.setNumeroHombres3(rs.getString(20));
                claseposencuentro.setNumeroMujeres3(rs.getString(21));
                claseposencuentro.setNumeroAlumnos3(rs.getString(22));
                claseposencuentro.setNumeroAsistentesAnterior3(rs.getString(23));
                claseposencuentro.setEstadoClase3(rs.getString(24));

                claseposencuentro.setNumeroRedes4(rs.getString(25));
                claseposencuentro.setNumeroCelulas4(rs.getString(26));
                claseposencuentro.setTema4(rs.getString(27));
                claseposencuentro.setNumeroHombres4(rs.getString(28));
                claseposencuentro.setNumeroMujeres4(rs.getString(29));
                claseposencuentro.setNumeroAlumnos4(rs.getString(30));
                claseposencuentro.setNumeroAsistentesAnterior4(rs.getString(31));
                claseposencuentro.setEstadoClase4(rs.getString(32));

                claseposencuentro.setNumeroRedes5(rs.getString(33));
                claseposencuentro.setNumeroCelulas5(rs.getString(34));
                claseposencuentro.setTema5(rs.getString(35));
                claseposencuentro.setNumeroHombres5(rs.getString(36));
                claseposencuentro.setNumeroMujeres5(rs.getString(37));
                claseposencuentro.setNumeroAlumnos5(rs.getString(38));
                claseposencuentro.setNumeroAsistentesAnterior5(rs.getString(39));
                claseposencuentro.setEstadoClase5(rs.getString(40));

                claseposencuentro.setNumeroRedes6(rs.getString(41));
                claseposencuentro.setNumeroCelulas6(rs.getString(42));
                claseposencuentro.setTema6(rs.getString(43));
                claseposencuentro.setNumeroHombres6(rs.getString(44));
                claseposencuentro.setNumeroMujeres6(rs.getString(45));
                claseposencuentro.setNumeroAlumnos6(rs.getString(46));
                claseposencuentro.setNumeroAsistentesAnterior6(rs.getString(47));
                claseposencuentro.setEstadoClase6(rs.getString(48));

                claseposencuentro.setNumeroRedes7(rs.getString(49));
                claseposencuentro.setNumeroCelulas7(rs.getString(50));
                claseposencuentro.setTema7(rs.getString(51));
                claseposencuentro.setNumeroHombres7(rs.getString(52));
                claseposencuentro.setNumeroMujeres7(rs.getString(53));
                claseposencuentro.setNumeroAlumnos7(rs.getString(54));
                claseposencuentro.setNumeroAsistentesAnterior7(rs.getString(55));
                claseposencuentro.setEstadoClase7(rs.getString(56));

                claseposencuentro.setNumeroRedes8(rs.getString(57));
                claseposencuentro.setNumeroCelulas8(rs.getString(58));
                claseposencuentro.setTema8(rs.getString(59));
                claseposencuentro.setNumeroHombres8(rs.getString(60));
                claseposencuentro.setNumeroMujeres8(rs.getString(61));
                claseposencuentro.setNumeroAlumnos8(rs.getString(62));
                claseposencuentro.setNumeroAsistentesAnterior8(rs.getString(63));
                claseposencuentro.setEstadoClase8(rs.getString(64));

                claseposencuentro.setNumeroRedes9(rs.getString(65));
                claseposencuentro.setNumeroCelulas9(rs.getString(66));
                claseposencuentro.setTema9(rs.getString(67));
                claseposencuentro.setNumeroHombres9(rs.getString(68));
                claseposencuentro.setNumeroMujeres9(rs.getString(69));
                claseposencuentro.setNumeroAlumnos9(rs.getString(70));
                claseposencuentro.setNumeroAsistentesAnterior9(rs.getString(71));
                claseposencuentro.setEstadoClase9(rs.getString(72));





                listaDatosClasesPosEncuentro.add(claseposencuentro);
            }



        }catch (SQLException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }
}