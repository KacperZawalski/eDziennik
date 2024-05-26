package com.example.edziennik.repositories;

import android.content.Context;

import com.example.edziennik.daos.GradeDao;
import com.example.edziennik.database.AppDatabaseFactory;
import com.example.edziennik.models.Grade;

import java.util.List;
import java.util.Optional;

public class GradesRepository {
    private GradeDao _gradeDao;

    public GradesRepository(Context context) {
        _gradeDao = AppDatabaseFactory.GetDatabase(context).gradeDao();
    }

    public boolean SaveGrade(Grade grade) {
        _gradeDao.insertAll(grade);
        return true;
    }

    public boolean DeleteGrade(int id) {
        Optional<Grade> grade = _gradeDao.getAll().stream().filter(t -> t.Id == id).findFirst();
        if (!grade.isPresent()) {
            return false;
        }

        _gradeDao.deleteAll(grade.get());
        return true;
    }

    public boolean UpdateGrade(Grade grade) {
        _gradeDao.updateAll(grade);
        return true;
    }

    public List<Grade> GetAllGrades() {
        return _gradeDao.getAll();
    }

    public Grade GetGrade(int id) {
        Optional<Grade> grade = _gradeDao.getAll().stream().filter(t -> t.Id == id).findFirst();
        return grade.get();
    }
}
