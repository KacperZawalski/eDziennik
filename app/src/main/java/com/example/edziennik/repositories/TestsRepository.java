package com.example.edziennik.repositories;

import android.content.Context;

import com.example.edziennik.daos.TestDao;
import com.example.edziennik.database.AppDatabase;
import com.example.edziennik.database.AppDatabaseFactory;
import com.example.edziennik.models.Test;

import java.util.List;
import java.util.Optional;

public class TestsRepository {
    private TestDao _testDao;

    public TestsRepository(Context context) {
        _testDao = AppDatabaseFactory.GetDatabase(context).testDao();
    }

    public boolean SaveTest(Test test) {
        _testDao.insertAll(test);
        return true;
    }

    public boolean DeleteTest(int id) {
        Optional<Test> test = _testDao.getAll().stream().filter(t -> t.Id == id).findFirst();
        if (!test.isPresent()) {
            return false;
        }

        _testDao.deleteAll(test.get());
        return true;
    }

    public boolean UpdateTest(Test test) {
        _testDao.updateAll(test);
        return true;
    }

    public List<Test> GetAllTests() {
        return _testDao.getAll();
    }

    public Test GetTest(int id) {
        Optional<Test> test = _testDao.getAll().stream().filter(t -> t.Id == id).findFirst();
        return test.get();
    }
}
