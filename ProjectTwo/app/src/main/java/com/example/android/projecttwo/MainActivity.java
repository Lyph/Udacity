package com.example.android.projecttwo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int rScore = 0;
    int lScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void select(View v) {
        Button selectedButton = (Button) v;
        switch (selectedButton.getId()) {
            case R.id.oneLeft:
                lScore += 1;
                break;
            case R.id.twoLeft:
                lScore += 2;
                break;
            case R.id.threeLeft:
                lScore += 3;
                break;
            case R.id.oneRight:
                rScore += 1;
                break;
            case R.id.twoRight:
                rScore += 2;
                break;
            case R.id.threeRight:
                rScore += 3;
                break;
            case R.id.reset:
                rScore = 0;
                lScore = 0;
                break;
        }

        TextView quantityTextView = (TextView) findViewById(R.id.scoreLeft);
        quantityTextView.setText("" + lScore);
        TextView quantityTextView2 = (TextView) findViewById(R.id.scoreRight);
        quantityTextView2.setText("" + rScore);

    }
}