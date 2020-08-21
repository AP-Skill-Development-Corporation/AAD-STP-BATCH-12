package com.example.roomdblivedata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    EditText et1,et2,et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        et1 = findViewById(R.id.username);
        et2 = findViewById(R.id.usermailid);
        et3 = findViewById(R.id.userphone);

    }

    public void save(View view) {
        String name = et1.getText().toString();
        String mailid = et2.getText().toString();
        String phone = et3.getText().toString();
        User user = new User();
        user.setName(name);
        user.setMailid(mailid);
        user.setNumber(phone);
        MainActivity.database.myDao().insert(user);
        Toast.makeText(this, "Data Saved Sucessfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}