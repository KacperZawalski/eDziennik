package com.example.edziennik.logic;

import android.content.Context;

import com.example.edziennik.database.AppDatabase;
import com.example.edziennik.database.AppDatabaseFactory;
import com.example.edziennik.models.Test;
import com.example.edziennik.repositories.TestsRepository;

import java.util.List;

public class TestsLogic {
    private TestsRepository _repository;

    public TestsLogic(Context context) {
        _repository = new TestsRepository(context);
    }

    public List<Test> GetAllTests()
    {
        return _repository.GetAllTests();
    }

    public Test GetTest(int id)
    {
        return _repository.GetTest(id);
    }

    public boolean AddTest(Test test)
    {
        return _repository.SaveTest(test);
    }

    public boolean UpdateTest(Test test)
    {
        return _repository.UpdateTest(test);
    }

    public boolean DeleteTest(int id)
    {
        return _repository.DeleteTest(id);
    }
}
