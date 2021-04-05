package com.example.enmalleapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

import com.example.enmalleapp.posclases.PosEncuentroClasesActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class MainActivity extends AppCompatActivity {
    String VariableControl = "";
    String Acceso = "N";


    Button bntCelula, btnPreEncuentro, btnEncuentro, btnPosEncuentro, btnEscuela;
    //SeekBar seekbarSalir;
    FloatingActionButton fab1, fab2, fab3, fab4, fab5, fab6, fab7, fab8;
    Animation fabOpen, fabClose, rotateForward, rotateBackward;
    Boolean isOpen= false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final claseGlobal objGlobal = (claseGlobal)getApplicationContext();

        bntCelula=findViewById(R.id.btnCelula);
        btnPreEncuentro=findViewById(R.id.btnPreEncuentro);
        btnEncuentro=findViewById(R.id.btnEncuentro);
        btnPosEncuentro=findViewById(R.id.btnPosEncuentro);
        btnEscuela=findViewById(R.id.btnEscuela);
        //seekbarSalir=findViewById(R.id.seekbarSalir);

        fab1 = (FloatingActionButton) findViewById(R.id.fab_1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab_2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab_3);
        fab4 = (FloatingActionButton) findViewById(R.id.fab_4);
        fab5 = (FloatingActionButton) findViewById(R.id.fab_5);
        fab6 = (FloatingActionButton) findViewById(R.id.fab_6);
        fab7 = (FloatingActionButton) findViewById(R.id.fab_7);
        fab8 = (FloatingActionButton) findViewById(R.id.fab_8);

        fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(this,R.anim.fab_close);
        rotateForward = AnimationUtils.loadAnimation(this,R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(this,R.anim.rotate_backward);


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                finish();
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                objGlobal.setVariableControl("C");
                Toast.makeText(getApplicationContext(),"Consolidacion", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),TurnosActivity.class);
                startActivity(intent);
            }
        });
        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                objGlobal.setVariableControl("O");
                Toast.makeText(getApplicationContext(),"Oracion", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),TurnosActivity.class);
                startActivity(intent);
            }
        });
        fab5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animateFab();
                objGlobal.setVariableControl("U");
                Toast.makeText(getApplicationContext(),"Ungir", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getApplicationContext(),TurnosActivity.class);
                startActivity(intent);
            }
        });
        fab6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                animateFab();
                final claseGlobal objGlobal = (claseGlobal)getApplicationContext();
                Acceso = objGlobal.getId_nivel_acceso_estado();

                if (Acceso.equals("V"))
                {
                    Intent intent = new Intent(getApplicationContext(), SupervisionActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Usted no cuenta con privilegios de Administrador", Toast.LENGTH_SHORT).show();
                }

            }
        });

        fab7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                animateFab();
                final claseGlobal objGlobal = (claseGlobal)getApplicationContext();
                Acceso = objGlobal.getId_nivel_acceso_estado();

                if (Acceso.equals("V"))
                {
                    Intent intent = new Intent(getApplicationContext(), PosEncuentroClasesActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Opcion unica para Maestro de Escuela", Toast.LENGTH_SHORT).show();
                }

            }
        });

        fab8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                animateFab();
                final claseGlobal objGlobal = (claseGlobal)getApplicationContext();
                Acceso = objGlobal.getId_nivel_acceso_estado();

                if (Acceso.equals("V"))
                {
                    Intent intent = new Intent(getApplicationContext(), QrScanValidarReservacion.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Opcion unica para Supervisores", Toast.LENGTH_SHORT).show();
                }

            }
        });

        bntCelula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MiCelulaActivity.class);
                startActivity(intent);
            }
        });

        btnPreEncuentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PreEncuentroActivity.class);
                startActivity(intent);
            }
        });

        btnEncuentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EncuentroActivity.class);
                startActivity(intent);
            }
        });

        btnPosEncuentro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),PosEncuentroActivity.class);
                startActivity(intent);
            }
        });

        btnEscuela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EscuelaActivity.class);
                startActivity(intent);
            }
        });


/*        seekbarSalir.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            Toast.makeText(getApplicationContext(),"EXIT SYSTEM", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                finish();
            }
        }); */

    }

    private void animateFab()
    {
        if(isOpen)
        {
            fab1.startAnimation(rotateForward);
            fab2.startAnimation(fabClose);
            fab3.startAnimation(fabClose);
            fab4.startAnimation(fabClose);
            fab5.startAnimation(fabClose);
            fab6.startAnimation(fabClose);
            fab7.startAnimation(fabClose);
            fab8.startAnimation(fabClose);
            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            fab5.setClickable(false);
            fab6.setClickable(false);
            fab7.setClickable(false);
            fab8.setClickable(false);
            isOpen=false;
        }else{
            fab1.startAnimation(rotateBackward);
            fab2.startAnimation(fabOpen);
            fab3.startAnimation(fabOpen);
            fab4.startAnimation(fabOpen);
            fab5.startAnimation(fabOpen);
            fab6.startAnimation(fabOpen);
            fab7.startAnimation(fabOpen);
            fab8.startAnimation(fabOpen);
            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            fab5.setClickable(true);
            fab6.setClickable(true);
            fab7.setClickable(true);
            fab8.setClickable(true);
            isOpen=true;
        }
    }



}
