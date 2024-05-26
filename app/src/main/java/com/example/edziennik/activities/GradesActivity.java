package com.example.edziennik.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private ArrayList<Grade> listGrades = new ArrayList<Grade>();
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Grade grade = listGrades.get(position);

                Intent intent = new Intent(getApplicationContext(), GradeDetailsActivity.class);
                intent.putExtra("grade", grade);
                //based on item add info to intent
                startActivity(intent);
            }
        });

        //listView.setOnClickListener(l -> Toast.makeText(this, "test: " + l.getId(), (int)1));

        List<Grade> grades = _gradesLogic.GetAllGrades();

        for (Grade grade : grades) {
            listGrades.add(grade);
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