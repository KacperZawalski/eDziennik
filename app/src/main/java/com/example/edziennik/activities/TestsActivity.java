package com.example.edziennik.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edziennik.R;
import com.example.edziennik.daos.TestDao;
import com.example.edziennik.database.AppDatabase;
import com.example.edziennik.database.AppDatabaseFactory;
import com.example.edziennik.logic.TestsLogic;
import com.example.edziennik.models.Test;

import java.util.List;

public class TestsActivity extends AppCompatActivity {
    private TestsLogic _testsLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        _testsLogic = new TestsLogic(getApplicationContext());

        // TODO: PoC - to be removed
        Test test1 = new Test(123, 42, 50, true, "polski");
        _testsLogic.AddTest(test1);
        Test test = _testsLogic.GetTest(123);

        Toast.makeText(this, test.Subject + " (" + test.Result + "/" + test.MaxResult + ") PASSED? " + test.IsPassed, Toast.LENGTH_SHORT).show();
    }
}