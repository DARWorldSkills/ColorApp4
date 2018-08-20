package com.aprendiz.ragp.colorapp4;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Juego extends AppCompatActivity implements View.OnClickListener{
    TextView txtCantidad, txtCorrectas, txtFaltantes, txtTiempo, txtPalabra;
    ImageButton btnColor1,btnColor2,btnColor3,btnColor4;
    FloatingActionButton btnPausa;
    ProgressBar pbTiempo;
    List<String> listaPalabras = new ArrayList<>();
    List<Integer> listaColores = new ArrayList<>();
    List<Integer> listaColoresTmp = new ArrayList<>();
    int ipR,icR;
    public static int cantidad, correctas, incorrectas, faltantes;
    int [] segundos = {0,30};
    boolean bandera=true;
    boolean bandera1=true;
    int ab=0;
    int valorcito=0,pausas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        inizialite();
        listar();
        inputValues();
        inputData();
        ramdomizar();
        goGame();

    }

    private void inizialite() {
        txtCantidad = findViewById(R.id.txtCantidad);
        txtCorrectas = findViewById(R.id.txtCorrectas);
        txtFaltantes = findViewById(R.id.txtFaltante);
        txtTiempo = findViewById(R.id.txtTiempo);
        txtPalabra = findViewById(R.id.txtPalabra);
        pbTiempo = findViewById(R.id.pbTiempo);

        btnColor1= findViewById(R.id.btnColor1);
        btnColor2= findViewById(R.id.btnColor2);
        btnColor3= findViewById(R.id.btnColor3);
        btnColor4= findViewById(R.id.btnColor4);
        btnPausa = findViewById(R.id.btnPause);

        btnColor1.setOnClickListener(this);
        btnColor2.setOnClickListener(this);
        btnColor3.setOnClickListener(this);
        btnColor4.setOnClickListener(this);
        btnPausa.setOnClickListener(this);

    }

    private void listar() {
        listaPalabras = new ArrayList<>();
        listaColores = new ArrayList<>();
        listaPalabras.add("AMARILLO");
        listaColores.add(getColor(R.color.colorAmarilloJ));
        listaPalabras.add("AZUL");
        listaColores.add(getColor(R.color.colorAzulJ));
        listaPalabras.add("ROJO");
        listaColores.add(getColor(R.color.colorRojoJ));
        listaPalabras.add("VERDE");
        listaColores.add(getColor(R.color.colorVerdeJ));

    }

    private void inputValues() {
        cantidad =0;
        correctas=0;
        incorrectas=0;
        faltantes=3;
        pbTiempo.setMax(segundos[1]);
        pbTiempo.setProgress(segundos[1]);

    }

    private void inputData() {
        txtTiempo.setText("Tiempo: "+segundos[1]);
        txtFaltantes.setText(Integer.toString(faltantes));
        txtCorrectas.setText(Integer.toString(correctas));
        txtCantidad.setText(Integer.toString(cantidad));
    }

    private void ramdomizar() {
        listaColoresTmp = listaColores;
        ipR = (int) (Math.random() *4);
        icR = (int) (Math.random() *4);
        Collections.shuffle(listaColoresTmp);
        txtPalabra.setText(listaPalabras.get(ipR));
        txtPalabra.setTextColor(listaColores.get(icR));
        btnColor1.setColorFilter(listaColoresTmp.get(0));
        btnColor2.setColorFilter(listaColoresTmp.get(1));
        btnColor3.setColorFilter(listaColoresTmp.get(2));
        btnColor4.setColorFilter(listaColoresTmp.get(3));
    }

    private void goGame() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (bandera){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (bandera1) {
                                segundos[0]++;
                                segundos[1]--;
                                txtTiempo.setText("Tiempo: "+segundos[1]);
                                pbTiempo.setProgress(segundos[1]);
                                if (segundos[0]==3){
                                    segundos[0]=0;
                                    faltantes--;
                                    incorrectas++;
                                    cantidad++;
                                    ramdomizar();
                                    inputData();
                                }
                                endGame();
                            }

                        }
                    });
                }
            }
        });
        thread.start();
    }

    private void endGame() {
        if (ab==0 && (segundos[1]==30 || faltantes==0)){
            ab=1;
            bandera=false;
            bandera1=false;
            Intent intent = new Intent(Juego.this,Resumen.class);
            startActivity(intent);
            finish();


        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnColor1:
                valorcito=1;
                validar();
                break;
            case R.id.btnColor2:
                valorcito=2;
                validar();
                break;
            case R.id.btnColor3:
                valorcito=3;
                validar();
                break;
            case R.id.btnColor4:
                valorcito=4;
                validar();
                break;
            case R.id.btnPause:
                pausar();
                break;
        }
    }

    private void pausar() {
        pausas++;
        if (pausas<2){
            bandera1=false;
        }else {
            Toast.makeText(this, "No puedes tener más pausas", Toast.LENGTH_SHORT).show();
        }
    }

    private void validar() {
        cantidad++;
        segundos[0]=0;
        if (valorcito==1){
            if (icR==0){
                correctas++;
            }else {
                incorrectas++;
                faltantes--;
            }
        }

        if (valorcito==2){
            if (icR==0){
                correctas++;
            }else {
                incorrectas++;
                faltantes--;
            }
        }


        if (valorcito==3){
            if (icR==0){
                correctas++;
            }else {
                incorrectas++;
                faltantes--;
            }
        }

        if (valorcito==4){
            if (icR==0){
                correctas++;
            }else {
                incorrectas++;
                faltantes--;
            }
        }
        ramdomizar();
        inputData();
        endGame();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bandera=false;

    }
}

