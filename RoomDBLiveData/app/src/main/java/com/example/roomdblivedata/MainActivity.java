package com.example.roomdblivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
    static MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyler);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        viewModel.getData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv.setAdapter(new MyDataAdapter(MainActivity.this,users));
            }
        });

    }

    public void insert(View view) {
        Intent i = new Intent(this,InsertActivity.class);
        startActivity(i);
    }

}