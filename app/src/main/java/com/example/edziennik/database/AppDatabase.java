package com.example.edziennik.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.edziennik.daos.GradeDao;
import com.example.edziennik.daos.TestDao;
import com.example.edziennik.models.Grade;
import com.example.edziennik.models.Test;

@Database(entities = {Test.class, Grade.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TestDao testDao();
    public abstract GradeDao gradeDao();
}