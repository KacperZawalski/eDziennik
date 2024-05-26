package com.example.edziennik.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edziennik.R;
import com.example.edziennik.models.Grade;
import com.example.edziennik.models.Test;

public class TestDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_details);

        Button button = findViewById(R.id.gradesReturnButton);
        button.setOnClickListener(x -> finish());

        Intent intent = getIntent();
        Test test = (Test)intent.getSerializableExtra("test");

        TextView textViewSubject = findViewById(R.id.textViewSubject);
        textViewSubject.setText("Przedmiot: " + test.Subject);

        TextView textViewGrade = findViewById(R.id.textViewGrade);
        textViewGrade.setText("Wynik: " + test.Result);

        TextView textViewMax = findViewById(R.id.textViewMax);
        textViewMax.setText("Max punkty: " + test.MaxResult);

        TextView textViewPassed = findViewById(R.id.textViewPassed);
        textViewPassed.setText("Zdany? " + (test.IsPassed ? "TAK" : "NIE"));
    }
}