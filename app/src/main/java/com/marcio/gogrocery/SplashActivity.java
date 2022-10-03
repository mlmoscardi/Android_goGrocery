package com.marcio.gogrocery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    // Variables
    Handler handler = new Handler();
    ImageView logo;
    ProgressBar pBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Views
        logo = findViewById(R.id.logoView);
        pBar = findViewById(R.id.progressBar);

        // Hides Action Bar
        Objects.requireNonNull(getSupportActionBar()).hide();

        CountDownTimer countDownTimer =
            new CountDownTimer(10000, 100) {
                public void onTick(long millisUntilFinished) {
                    pBar.setProgress(Math.abs((int) millisUntilFinished / 100 - 100));
                }
                @Override
                public void onFinish() {
                    // do nothing
                }
            };
        countDownTimer.start();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        logo.startAnimation(animation);

        Intent mainPage = new Intent(this, MainActivity.class);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(mainPage);
            }
        }, 5000);
    }
}