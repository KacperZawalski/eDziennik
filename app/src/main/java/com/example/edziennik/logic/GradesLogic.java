package com.example.edziennik.logic;

import android.content.Context;

import com.example.edziennik.models.Grade;
import com.example.edziennik.repositories.GradesRepository;

import java.util.List;

public class GradesLogic {
    private GradesRepository _repository;

    public GradesLogic(Context context) {
        _repository = new GradesRepository(context);
    }

    public List<Grade> GetAllGrades()
    {
        return _repository.GetAllGrades();
    }

    public Grade GetGrade(int id)
    {
        return _repository.GetGrade(id);
    }

    public boolean AddGrade(Grade grade)
    {
        return _repository.SaveGrade(grade);
    }

    public boolean UpdateGrade(Grade grade)
    {
        return _repository.UpdateGrade(grade);
    }

    public boolean DeleteGrade(int id)
    {
        return _repository.DeleteGrade(id);
    }
}
