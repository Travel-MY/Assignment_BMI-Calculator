package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar height;
    private SeekBar weight;
    private Button calculate;
    private TextView currentheight;
    private TextView currentweight;
    private TextView totalresult;


    private double bmi;
    private double valueheight;
    private double valueweight;
    private String resulttotal;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = findViewById(R.id.heightseekbar);
        weight = findViewById(R.id.wightseekbar);
        calculate = findViewById(R.id.calculatebmi);
        currentheight = findViewById(R.id.current_height);
        currentweight = findViewById(R.id.current_weight);
        totalresult = findViewById(R.id.result);

        //function seekbar for height with the max
        height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentheight.setText(String.valueOf(height.getProgress()));
                height.setMax(300);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //function seekbar for weight with the max
        weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentweight.setText(String.valueOf(weight.getProgress()));
                weight.setMax(300);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //BMiCalculator
        calculate.setOnClickListener(v -> {
            valueheight = Double.parseDouble(currentheight.getText().toString());
            valueweight = Double.parseDouble(currentweight.getText().toString());
            Double valueheightmeters;

            //BMI Formula

            valueheightmeters = valueheight / 100;
            bmi = (valueweight / (valueheightmeters * valueheightmeters));


            if (bmi >= 30) { /* obese */
                resulttotal = String.format("%.2f", bmi) + "\nOBESE";
                totalresult.setText(resulttotal);
            } else if (bmi >= 25) {
                resulttotal = String.format("%.2f", bmi) + "\nOVERWEIGHT";
                totalresult.setText(resulttotal);
            } else if (bmi >= 18.5) {
                resulttotal = String.format("%.2f", bmi) + "\nIDEAL";
                totalresult.setText(resulttotal);
            } else {
                resulttotal = String.format("%.2f", bmi) + "\nUNDERWEIGHT";
                totalresult.setText(resulttotal);
            }
        });
    }
}