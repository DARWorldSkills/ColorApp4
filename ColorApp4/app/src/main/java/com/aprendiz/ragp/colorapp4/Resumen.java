package com.aprendiz.ragp.colorapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Resumen extends AppCompatActivity {
    TextView txtCorrectas, txtIncorrectas;
    int correctas, incorrectas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        inizialite();
        inputData();
    }

    private void inizialite() {
        txtCorrectas= findViewById(R.id.txtCorrectas);
        txtIncorrectas = findViewById(R.id.txtIncorrectas);
    }

    private void inputData() {
        if (MenuT.guardar==1){
            correctas = Juego.correctas;
            incorrectas =Juego.incorrectas;
            Score score = new Score(correctas,incorrectas);
            txtCorrectas.setText(Integer.toString(correctas));
            txtIncorrectas.setText(Integer.toString(incorrectas));
            GestorDB gestorDB = new GestorDB(this);
            gestorDB.inputData(score);

        }else {
            correctas = JuegoC.correctas;
            incorrectas =JuegoC.incorrectas;
            txtCorrectas.setText(Integer.toString(correctas));
            txtIncorrectas.setText(Integer.toString(incorrectas));

        }
    }

    public void home(View view) {
        finish();
    }

    public void face(View view) {


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "https://www.facebook.com/SENACaucaOficial/");
        intent.setPackage("com.facebook.katana");
        startActivity(intent);

    }

    public void twi(View view) {

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        String mensaje = "Correctas:" + txtCorrectas + "Incorrectas" +txtIncorrectas;
        intent.putExtra(Intent.EXTRA_TEXT, mensaje);
        intent.setPackage("com.twitter.android");

        try {
            startActivity(intent);
        }catch (Exception e){
            Toast.makeText(this, "No cuentas con está App", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
