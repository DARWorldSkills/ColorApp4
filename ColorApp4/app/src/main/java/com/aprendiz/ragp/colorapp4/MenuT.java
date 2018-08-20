package com.aprendiz.ragp.colorapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuT extends AppCompatActivity {
    public static int guardar=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_t);
    }

    public void jugar(View view) {
        guardar=1;
        Intent intent = new Intent(MenuT.this,Juego.class);
        startActivity(intent);
    }

    public void puntuacion(View view) {
        guardar=0;
        Intent intent = new Intent(MenuT.this,Puntuacion.class);
        startActivity(intent);
    }

    public void configuracion(View view) {
        guardar=0;
        Intent intent = new Intent(MenuT.this,Configuracion.class);
        startActivity(intent);
    }
}
