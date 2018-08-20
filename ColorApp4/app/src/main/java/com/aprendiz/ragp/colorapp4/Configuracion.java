package com.aprendiz.ragp.colorapp4;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class Configuracion extends AppCompatActivity {
    RadioButton rbtnTiempo, rbtnIntentos;
    EditText txtTiempo, txtIntentos;
    SharedPreferences juegoC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        inizialite();
        inputData();
    }

    private void inizialite() {
        rbtnIntentos = findViewById(R.id.rbtnIntentos);
        rbtnTiempo = findViewById(R.id.rbtnTiempo);
        txtIntentos = findViewById(R.id.txtIncorrectas);
        txtTiempo = findViewById(R.id.txtPalabras);

    }

    private void inputData() {
        juegoC = getSharedPreferences("juegoC",MODE_PRIVATE);
        int modo= juegoC.getInt("modo",1);
        int tiempo = juegoC.getInt("tiempo",3);
        int cantidad = juegoC.getInt("cantidad",3);
        if (modo==1){
            
        }
    }

    public void jugar(View view) {
        guardar();
        Intent intent = new Intent(Configuracion.this,JuegoC.class);
        startActivity(intent);
        finish();
    }

    private void guardar() {
    }
}
