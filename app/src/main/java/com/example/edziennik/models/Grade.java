package com.example.edziennik.models;

public class Grade {
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
