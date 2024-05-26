package com.example.edziennik.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.edziennik.models.Grade;

import java.util.List;

@Dao
public interface GradeDao {
    @Query("SELECT * FROM grade")
    List<Grade> getAll();

    @Insert
    void insertAll(Grade... grades);

    @Update
    void updateAll(Grade... grades);

    @Delete
    void deleteAll(Grade... grades);
}