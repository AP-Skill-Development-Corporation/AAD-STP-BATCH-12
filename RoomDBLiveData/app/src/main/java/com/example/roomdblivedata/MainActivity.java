package com.example.roomdblivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    static UserDatabase database;
    RecyclerView rv;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyler);

        database = Room.databaseBuilder(this,UserDatabase.class,"MyDb")
                .allowMainThreadQueries().fallbackToDestructiveMigration().build();

        userList = database.myDao().readData();

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new MyDataAdapter(this,userList));

    }

    public void insert(View view) {
        Intent i = new Intent(this,InsertActivity.class);
        startActivity(i);
    }

}