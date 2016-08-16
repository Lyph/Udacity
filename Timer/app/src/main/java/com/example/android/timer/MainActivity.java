package com.example.android.timer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void interval(View view) {
        new CountDownTimer(21600000, 1800000) { // 30 minutes 1800000 6 hours 21600000

            public void onTick(long millisUntilFinished) {
                Time();
            }

            public void onFinish() {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }

        }.start();
    }

    public void Time() {
        final MediaPlayer cough = MediaPlayer.create(this, R.raw.cough);
        final MediaPlayer sniff = MediaPlayer.create(this, R.raw.sniff);


        Random rand = new Random();
        int n = rand.nextInt(3) + 1;
        if (n == 3) {
            cough.start();
        }
        if (n == 1 || n == 2) {
            sniff.start();
        }
    }


}
