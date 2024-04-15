package com.example.edziennik.repositories;

import com.example.edziennik.models.Test;

public class TestsRepository {
    public boolean SaveTest(Test test) {
        return true;
    }
    public boolean DeleteTest(int id) {
        return true;
    }
    public boolean UpdateTest(Test test) {
        return true;
    }
    public Test GetTest(int id) {
        return new Test();
    }
}
