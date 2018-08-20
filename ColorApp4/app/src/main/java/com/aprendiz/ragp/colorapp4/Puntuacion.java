package com.aprendiz.ragp.colorapp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Puntuacion extends AppCompatActivity {
    TextView txtPrimero, txtSegundo, txtTercero, txtCuarto, txtQuinto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuacion);
        inizialite();
        cleanV();
        inputData();

    }


    private void inputData() {
        GestorDB gestorDB = new GestorDB(this);
        List<Score> scoreList = gestorDB.scoreList();
        if (scoreList.size()>0){
            txtPrimero.setText("Puntaje: "+scoreList.get(0).getPuntaje()+ "Inoorrectas: "+scoreList.get(0).getIncorrectas());
        }else {
            cleanV();
            Toast.makeText(this, "No hay puntuaciones disponibles por favor juegue una partida", Toast.LENGTH_SHORT).show();
        }

        if (scoreList.size()>1){
            txtSegundo.setText("Puntaje: "+scoreList.get(1).getPuntaje()+ "Inoorrectas: "+scoreList.get(1).getIncorrectas());
        }


        if (scoreList.size()>2){
            txtTercero.setText("Puntaje: "+scoreList.get(2).getPuntaje()+ "Inoorrectas: "+scoreList.get(2).getIncorrectas());
        }

        if (scoreList.size()>3){
            txtCuarto.setText("Puntaje: "+scoreList.get(3).getPuntaje()+ "Inoorrectas: "+scoreList.get(3).getIncorrectas());
        }

        if (scoreList.size()>4){
            txtQuinto.setText("Puntaje: "+scoreList.get(4).getPuntaje()+ "Inoorrectas: "+scoreList.get(4).getIncorrectas());
        }
    }

    private void inizialite() {
        txtPrimero = findViewById(R.id.txtPrimero);
        txtSegundo = findViewById(R.id.txtSegundo);
        txtTercero = findViewById(R.id.txtTercero);
        txtCuarto = findViewById(R.id.txtCuarto);
        txtQuinto = findViewById(R.id.txtQuinto);
    }


    private void cleanV() {
        txtPrimero.setText("");
        txtSegundo.setText("");
        txtTercero.setText("");
        txtCuarto.setText("");
        txtQuinto.setText("");
    }
}
