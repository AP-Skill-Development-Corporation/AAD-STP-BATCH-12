package com.example.dialogspickers;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int c_day,c_month,c_year;

    int c_hour,c_minuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void alert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Alert Dialog");
        builder.setMessage("Are you want close the App?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setCancelable(false);
        builder.show();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void openDatePicker(View view) {
        Calendar c = Calendar.getInstance();
        c_year = c.get(Calendar.YEAR);
        c_month = c.get(Calendar.MONTH);
        c_day = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                String myDate = ""+i2+"-"+(i1+1)+"-"+i;
                Toast.makeText(MainActivity.this,
                        myDate, Toast.LENGTH_SHORT).show();

            }
        },c_year,c_month,c_day);

        datePickerDialog.show();

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void openTimePicker(View view) {
        Calendar c = Calendar.getInstance();
        c_hour = c.get(Calendar.HOUR);
        c_minuite = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                String myTime = ""+i+":"+i1;
                Toast.makeText(MainActivity.this,
                        myTime, Toast.LENGTH_SHORT).show();

            }
        },c_hour,c_minuite,false);
        timePickerDialog.show();

    }
}