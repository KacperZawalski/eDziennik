package com.example.edziennik.logic;

import com.example.edziennik.models.Grade;
import com.example.edziennik.repositories.GradesRepository;

public class GradesLogic {
    private GradesRepository _repository = new GradesRepository();
    public Grade GetGrade(int id)
    {
        return _repository.GetGrade(id);
    }
}
