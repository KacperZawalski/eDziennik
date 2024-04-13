package com.example.edziennik.repositories;

import com.example.edziennik.models.Grade;

public class GradesRepository {
    public boolean SaveGrade(Grade grade) {
        return true;
    }
    public boolean DeleteGrade(int id) {
        return true;
    }
    public boolean UpdateGrade(Grade grade) {
        return true;
    }
    public Grade GetGrade(int id) {
        return new Grade();
    }
}
