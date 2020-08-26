package com.example.roomdblivedata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    public void insert(User user);

    @Delete
    public void delete(User user);

    @Query("SELECT * FROM UserInfo")
    public LiveData<List<User>> readData();

}
