package com.example.roomdatabasedemo;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MainDao {

//Insert Query
    @Insert(onConflict = REPLACE)
    void insert(MainData mainData);

// Delete Query
    @Delete
    void delete(MainData mainData);

// Delete All Query
    @Delete
    void reset(List<MainData> mainData);

// Update Query
    @Query("UPDATE table_name SET text = :sText WHERE ID = :sID")
    void  update(int sID, String sText);

// Get All Data Query
    @Query("SELECT * FROM table_name")
    List<MainData> getAll();


}
