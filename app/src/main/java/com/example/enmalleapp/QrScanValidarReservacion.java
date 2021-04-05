 package com.example.enmalleapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class QrScanValidarReservacion extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView nScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan_validar_reservacion);
    }

    public void btnEscanear(View v){

        nScannerView = new ZXingScannerView(this);
        setContentView(nScannerView);
        nScannerView.setResultHandler(this);
        nScannerView.startCamera();

    }

    @Override
    public void handleResult(Result result) {
        Log.v("HandleResult", result.getText());
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado del Escaneado");
        builder.setMessage(result.getText());
        AlertDialog alertDialog = builder.create();
        alertDialog.show();



        //nScannerView.resumeCameraPreview(this);
    }

}