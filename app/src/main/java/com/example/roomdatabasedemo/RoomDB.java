package com.example.roomdatabasedemo;

// Add database entities

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {MainData.class}, version = 1,exportSchema = false)
public abstract class RoomDB extends RoomDatabase {
    //Create database instance

    private static RoomDB  database;
    private static String DATABASE_NAME = "database";

    public synchronized static RoomDB getInstance( Context context) {
        if (database == null){
            //Initialize Database
            database = Room.databaseBuilder(context.getApplicationContext()
                    ,RoomDB.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    //Create Dao
    public abstract MainDao mainDao();
}



