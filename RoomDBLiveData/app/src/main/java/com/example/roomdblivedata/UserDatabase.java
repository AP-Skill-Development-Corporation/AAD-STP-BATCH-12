package com.example.roomdblivedata;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = User.class,version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDAO myDao();

    public static UserDatabase database;

    public static synchronized UserDatabase getDatabase(Context context){

        if (database == null){
            database = Room.databaseBuilder(context,UserDatabase.class,"MyDb")
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        }
        return database;
    }
}
