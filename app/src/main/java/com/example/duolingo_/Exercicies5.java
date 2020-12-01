package com.example.duolingo_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercicies5 extends AppCompatActivity {

    private int count = 1;
    private int totalActivities = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicies5);

        Button nextButton = findViewById(R.id.next_button);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView counter_change = (TextView) findViewById(R.id.counter);

                if (count < totalActivities){
                    count++;
                    counter_change.setText("Pregunta: "+count);
                }
                else{
                    finish();
                }



            }
        });

    }
}