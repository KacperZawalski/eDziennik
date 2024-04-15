package com.example.edziennik.database;

import android.content.Context;

import androidx.room.Room;

public class AppDatabaseFactory {
    private static AppDatabase _database = null;

    public static AppDatabase GetDatabase(Context context) {
        if (_database != null) {
            return _database;
        }

        _database = Room
                .databaseBuilder(
                        context,
                        AppDatabase.class,
                        "edziennik-db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        return _database;
    }
}
