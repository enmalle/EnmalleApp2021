package com.example.enmalleapp.login;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.enmalleapp.R;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.example.enmalleapp.MainActivity;
import com.example.enmalleapp.claseGlobal;
import com.example.enmalleapp.conexion.ConnectionClass;

public class LoginClass  extends AppCompatActivity {
    EditText edtCorreo, edtPassword, edtXIDLider, edtXIDCelula, edtXIDNivelAcceso, edtXIDNivelAccesoFecha, edtXIDNivelAccesoEstado, edtXIDSexo;
    TextView tvRegistrar;
    Button btnLogin;
    String correo, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtCorreo = findViewById(R.id.edtCorreo);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        edtXIDLider = findViewById(R.id.edtXIDLider);
        tvRegistrar = findViewById(R.id.tvRegistrar);
        edtXIDCelula = findViewById(R.id.edtXIDCelula);
        edtXIDNivelAcceso = findViewById(R.id.edtXIDNivelAcceso);
        edtXIDNivelAccesoFecha = findViewById(R.id.edtXIDNivelAccesoFecha);
        edtXIDNivelAccesoEstado = findViewById(R.id.edtXIDNivelAccesoEstado);
        edtXIDSexo = findViewById(R.id.edtXIDSexo);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correo = edtCorreo.getText().toString();
                password = edtPassword.getText().toString();
                if (!correo.isEmpty() && !password.isEmpty()) {
                    validarLogin();
                } else {
                    Toast.makeText(LoginClass.this, "No se permite campos vacios", Toast.LENGTH_LONG).show();
                }
            }
        });


        tvRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(LoginClass.this, "Click Registro", Toast.LENGTH_LONG).show();
                edtCorreo.setText("");
                edtPassword.setText("");
                Intent intent = new Intent(getApplicationContext(), RegistroLoginActivity.class);
                startActivity(intent);
            }
        });
    }

    // conexcionBD
    ConnectionClass cc = new ConnectionClass();

    public void validarLogin() {
        try {
            claseGlobal objGlobal = (claseGlobal)getApplicationContext();
            String id_lider;
            String id_celula;
            String id_nivel_acceso;
            String id_nivel_acceso_estado;
            String id_sexo;

            edtXIDLider.setText("");
            edtXIDCelula.setText("");
            PreparedStatement pst = cc.stConsulta("exec sp_validacion_login ?,?");
            pst.setString(1, edtCorreo.getText().toString());
            pst.setString(2, edtPassword.getText().toString());

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                //retorno de informacion
                edtXIDLider.setText(rs.getString(1));
                edtXIDCelula.setText(rs.getString(2));
                edtXIDNivelAcceso.setText(rs.getString(3));
                edtXIDNivelAccesoEstado.setText(rs.getString(4));
                edtXIDSexo.setText(rs.getString(5));
                id_lider=(edtXIDLider.getText().toString());
                id_celula=(edtXIDCelula.getText().toString());
                id_nivel_acceso=(edtXIDNivelAcceso.getText().toString());
                id_nivel_acceso_estado=(edtXIDNivelAccesoEstado.getText().toString());
                id_sexo=(edtXIDSexo.getText().toString());


                objGlobal.setIdLider(id_lider);
                objGlobal.setIdCelula(id_celula);
                objGlobal.setId_nivel_acceso(id_nivel_acceso);
                objGlobal.setId_nivel_acceso_estado(id_nivel_acceso_estado);
                objGlobal.setId_sexo(id_sexo);

                Toast.makeText(getApplicationContext(), "SALUDOS Y BENDICIONES", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                edtCorreo.setText("");
                edtPassword.setText("");
            } else {
                Toast.makeText(LoginClass.this, "Usuario o Contraseña incorecta", Toast.LENGTH_LONG).show();
            }
        } catch (SQLException e) {

            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}