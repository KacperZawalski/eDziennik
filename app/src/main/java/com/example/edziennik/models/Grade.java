package com.example.edziennik.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Grade implements Serializable {
    @PrimaryKey
    public int Id;
    public int Value;
    public String Subject;

    public Grade()
    {
    }

    public Grade(int id, int value, String subject)
    {
        Id = id;
        Value = value;
        Subject = subject;
    }
}