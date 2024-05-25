package com.example.edziennik.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edziennik.R;

public class MainActivity extends AppCompatActivity {
    private Button gradesButton;
    private Button testsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssignValuesToButtons();
        AddButtonsEventListeners();
    }
    private void AssignValuesToButtons() {
        gradesButton = (Button)findViewById(R.id.gradesButton);
        testsButton = (Button)findViewById(R.id.testsButton);
    }
    private void AddButtonsEventListeners() {
        gradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GradesActivity.class));
            }
        });
        testsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestsActivity.class));
            }
        });
    }
}