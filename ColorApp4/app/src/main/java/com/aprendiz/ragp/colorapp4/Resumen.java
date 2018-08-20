package com.aprendiz.ragp.colorapp4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

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
    }

    public void twi(View view) {
    }
}
