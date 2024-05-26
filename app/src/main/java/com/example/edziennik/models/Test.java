package com.example.edziennik.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Test {
    @PrimaryKey
    public int Id;
    public int Result;
    public int MaxResult;
    public boolean IsPassed;
    public String Subject;

    public Test()
    {
    }

    public Test(int id, int result, int maxResult, boolean isPassed, String subject)
    {
        Id = id;
        Result = result;
        MaxResult = maxResult;
        IsPassed = isPassed;
        Subject = subject;
    }
}
