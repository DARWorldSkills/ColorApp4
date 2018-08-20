package com.aprendiz.ragp.colorapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class MenuT extends AppCompatActivity {
    public static int guardar=0;
    TextView TxtInicio;
    private static final int DURACION = 700;
    private static final int DURACION_DESPUES = 700;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_t);

        TxtInicio = findViewById(R.id.TxtInicio);

        final AlphaAnimation fade = new AlphaAnimation(0.0f, 1.0f);
        fade.setDuration(DURACION);
        fade.setStartOffset(DURACION_DESPUES);
        fade.setFillAfter(true);

        final AlphaAnimation fadeout = new AlphaAnimation(1.0f, 0.0f);
        fadeout.setDuration(DURACION);
        fadeout.setStartOffset(DURACION_DESPUES);
        fadeout.setFillAfter(true);

        fade.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                TxtInicio.startAnimation(fadeout);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        fadeout.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                TxtInicio.startAnimation(fade);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        TxtInicio.startAnimation(fade);

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
