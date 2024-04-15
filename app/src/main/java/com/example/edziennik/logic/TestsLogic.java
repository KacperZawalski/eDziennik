package com.example.edziennik.logic;

import com.example.edziennik.models.Test;
import com.example.edziennik.repositories.TestsRepository;

public class TestsLogic {
    private TestsRepository _repository = new TestsRepository();
    public Test GetTest(int id)
    {
        return _repository.GetTest(id);
    }
}
