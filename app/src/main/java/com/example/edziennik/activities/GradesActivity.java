package com.example.edziennik.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edziennik.R;
import com.example.edziennik.logic.GradesLogic;
import com.example.edziennik.models.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradesActivity extends AppCompatActivity {
    private GradesLogic _gradesLogic;
    private ArrayList<String> listItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        Button button = findViewById(R.id.gradesReturnButton);
        button.setOnClickListener(x -> finish());

        _gradesLogic = new GradesLogic(getApplicationContext());

        // TODO: Mocks. Remove after implementing business logic.
        clearGradesFromDb();
        addGradesToDb();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        ListView listView = findViewById(R.id.gradesList);
        listView.setAdapter(adapter);

        List<Grade> grades = _gradesLogic.GetAllGrades();

        for (Grade grade : grades) {
            listItems.add("[" + grade.Value + "] " + grade.Subject);
        }
    }

    private void addGradesToDb() {
        _gradesLogic.AddGrade(new Grade(1, 5, "polski"));
        _gradesLogic.AddGrade(new Grade(2, 4, "polski"));
        _gradesLogic.AddGrade(new Grade(3, 2, "polski"));
        _gradesLogic.AddGrade(new Grade(4, 4, "matematyka"));
        _gradesLogic.AddGrade(new Grade(5, 1, "angielski"));
        _gradesLogic.AddGrade(new Grade(6, 6, "wf"));
    }

    private void clearGradesFromDb() {
        List<Grade> grades = _gradesLogic.GetAllGrades();

        for (Grade grade : grades) {
            _gradesLogic.DeleteGrade(grade.Id);
        }
    }
}