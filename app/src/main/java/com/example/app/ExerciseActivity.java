package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseActivity extends AppCompatActivity {

    int count;
    int totalActivities;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        count = 0;
        totalActivities = (int) (Math.random() * 9) + 1;

        Intent intent = getIntent();

        setContentView(R.layout.activity_exercise);

        Button btnNext = findViewById(R.id.next_button);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView counter = (TextView) findViewById(R.id.counter);

                if (count < totalActivities ) {

                    count++;
                    counter.setText("Pregunta: " + count);

                } else {

                    finish();

                }

            }
        });
    }
}
