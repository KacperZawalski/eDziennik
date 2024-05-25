package com.example.edziennik.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.edziennik.models.Test;

import java.util.List;

@Dao
public interface TestDao {
    @Query("SELECT * FROM test")
    List<Test> getAll();

    @Insert
    void insertAll(Test... tests);

    @Update
    void updateAll(Test... tests);

    @Delete
    void deleteAll(Test... tests);
}