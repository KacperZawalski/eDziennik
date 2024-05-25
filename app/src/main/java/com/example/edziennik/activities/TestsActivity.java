package com.example.edziennik.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edziennik.R;
import com.example.edziennik.daos.TestDao;
import com.example.edziennik.database.AppDatabase;
import com.example.edziennik.database.AppDatabaseFactory;
import com.example.edziennik.logic.TestsLogic;
import com.example.edziennik.models.Test;

import java.util.ArrayList;
import java.util.List;

public class TestsActivity extends AppCompatActivity {
    private TestsLogic _testsLogic;
    private ArrayList<String> listItems = new ArrayList<String>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        Button button = findViewById(R.id.testsReturnButton);
        button.setOnClickListener(x -> finish());

        // TODO: Mocks. Remove after implementing business logic.
        clearTestsFromDb();
        addTestsToDb();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        ListView listView = findViewById(R.id.testsList);
        listView.setAdapter(adapter);

        _testsLogic = new TestsLogic(getApplicationContext());
        List<Test> tests = _testsLogic.GetAllTests();

        for (Test test : tests) {
            String passedInfo = test.IsPassed ? "[PASS] " : "[FAIL] ";
            listItems.add(passedInfo + test.Subject + " (" + test.Result + "/" + test.MaxResult + ")");
        }
    }

    private void addTestsToDb() {
        _testsLogic = new TestsLogic(getApplicationContext());

        _testsLogic.AddTest(new Test(1, 39, 100, false, "matematyka"));
        _testsLogic.AddTest(new Test(2, 51, 100, true, "matematyka"));
        _testsLogic.AddTest(new Test(3, 6, 8, true, "matematyka"));
        _testsLogic.AddTest(new Test(4, 15, 90, false, "polski"));
        _testsLogic.AddTest(new Test(5, 0, 200, false, "niemiecki"));
    }

    private void clearTestsFromDb() {
        _testsLogic = new TestsLogic(getApplicationContext());
        List<Test> tests = _testsLogic.GetAllTests();

        for (Test test : tests) {
            _testsLogic.DeleteTest(test.Id);
        }
    }
}