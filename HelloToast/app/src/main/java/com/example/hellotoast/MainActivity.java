package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.resultTextview);
    }

    public void displayToast(View view) {
        //Toast Meassage: There is a predefined class called Toast.makeText(context objcet,
        // "",Duration)

        Toast.makeText(this,"Welcome To Android Application development workshop",
                Toast.LENGTH_LONG).show();


    }

    public void incrementCount(View view) {
        count++;
        tv.setText(String.valueOf(count));
    }
}