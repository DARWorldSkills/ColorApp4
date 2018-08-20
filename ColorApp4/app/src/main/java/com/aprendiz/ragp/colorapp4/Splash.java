package com.aprendiz.ragp.colorapp4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    ImageView ImgSplash;
    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImgSplash = findViewById(R.id.ImgSplash);
        viewFlipper = findViewById(R.id.view);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation our = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(our);

        viewFlipper.showNext();


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MenuT.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,2000);
    }
}
