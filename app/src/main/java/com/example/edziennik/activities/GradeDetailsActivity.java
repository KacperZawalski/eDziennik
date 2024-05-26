package com.example.edziennik.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edziennik.R;
import com.example.edziennik.models.Grade;

public class GradeDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_details);

        Button button = findViewById(R.id.gradesReturnButton);
        button.setOnClickListener(x -> finish());

        Intent intent = getIntent();
        Grade grade = (Grade)intent.getSerializableExtra("grade");

        TextView textViewSubject = findViewById(R.id.textViewSubject);
        textViewSubject.setText("Przedmiot: " + grade.Subject);

        TextView textViewGrade = findViewById(R.id.textViewGrade);
        textViewGrade.setText("Ocena: " + grade.Value);
    }
}