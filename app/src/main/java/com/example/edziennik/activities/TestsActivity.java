package com.example.edziennik.activities;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.edziennik.R;
import com.example.edziennik.daos.TestDao;
import com.example.edziennik.database.AppDatabase;
import com.example.edziennik.database.AppDatabaseFactory;
import com.example.edziennik.models.Test;

import java.util.List;

public class TestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        // TODO: PoC - to be removed
        AppDatabase db = AppDatabaseFactory.GetDatabase(getApplicationContext());
        TestDao testDao = db.testDao();
        List<Test> tests = testDao.getAll();

        if (tests.size() == 0) {
            testDao.insertAll(new Test(1,12,29,false,"german"));
            tests = testDao.getAll();
        }

        Toast.makeText(this, tests.get(0).Subject + " (" + tests.get(0).Result + "/" + tests.get(0).MaxResult + ")", Toast.LENGTH_SHORT).show();
    }
}