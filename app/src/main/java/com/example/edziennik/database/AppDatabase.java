package com.example.edziennik.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.edziennik.daos.TestDao;
import com.example.edziennik.models.Test;

@Database(entities = {Test.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TestDao testDao();
}