package com.example.ddalton.randomnum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText minInput;
    EditText maxInput;
    TextView result;
    Button randomizeButton;
    int minNumber;
    int maxNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        minInput = findViewById(R.id.minInput);
        maxInput = findViewById(R.id.maxInput);
        randomizeButton = findViewById(R.id.randomizeButton);

        randomizeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!minInput.getText().toString().equals("") && !maxInput.getText().toString().equals("")) {
                    if (!maxInput.getText().toString().equals("")) {
                        maxNumber = Integer.parseInt(maxInput.getText().toString());
                        minNumber = Integer.parseInt(minInput.getText().toString());
                        runGenerator(minNumber, maxNumber);
                    }
                }
            }
        });
    }

    public void runGenerator(int min, int max) {

        Random r = new Random();
        if (min != 0 && max != 0) {
            r.nextInt((min + 1) + max);
        }

        result.setText(Integer.toString(getRandomNumberInRange(min, max)));

    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
