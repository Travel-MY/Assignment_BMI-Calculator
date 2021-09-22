package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SeekBar height;
    private SeekBar weight;
    private Button calculate;
    private TextView currentHeight;
    private TextView currentWeight;
    private TextView totalResult;


    private double bmi;
    private double valueHeight;
    private double valueWeight;
    private String resultTotal;


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI Components ID
        height = findViewById(R.id.heightseekbar);
        weight = findViewById(R.id.wightseekbar);
        calculate = findViewById(R.id.calculatebmi);
        currentHeight = findViewById(R.id.current_height);
        currentWeight = findViewById(R.id.current_weight);
        totalResult = findViewById(R.id.result);

        //function seekbar for height with the max
        height.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentHeight.setText(String.valueOf(height.getProgress()));
                height.setMax(200);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        //function seekbar for weight with the max
        weight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                currentWeight.setText(String.valueOf(weight.getProgress()));
                weight.setMax(300);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });

        //Calculate BMI
        calculate.setOnClickListener(v -> {
            valueHeight = Double.parseDouble(currentHeight.getText().toString());
            valueWeight = Double.parseDouble(currentWeight.getText().toString());
            Double valueHeightMeters;

            //BMI Formula

            valueHeightMeters = valueHeight / 100;
            bmi = (valueWeight / (valueHeightMeters * valueHeightMeters));


            if (bmi >= 30) { /* obese */
                resultTotal = String.format("%.2f", bmi) + "\nOBESE";
                totalResult.setText(resultTotal);
            } else if (bmi >= 25) {
                resultTotal = String.format("%.2f", bmi) + "\nOVERWEIGHT";
                totalResult.setText(resultTotal);
            } else if (bmi >= 18.5) {
                resultTotal = String.format("%.2f", bmi) + "\nIDEAL";
                totalResult.setText(resultTotal);
            } else {
                resultTotal = String.format("%.2f", bmi) + "\nUNDERWEIGHT";
                totalResult.setText(resultTotal);
            }
        });
    }
}