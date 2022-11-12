package com.example.roomdatabasedemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

// define table name
@Entity(tableName= "table_name")

public class MainData implements Serializable {

// create id Column
    @PrimaryKey(autoGenerate = true)
    private int id;

// Create Text Column
    @ColumnInfo(name = "text")
    private String text;

// Getter Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
