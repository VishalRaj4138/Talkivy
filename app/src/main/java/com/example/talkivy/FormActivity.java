package com.example.talkivy;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class FormActivity extends AppCompatActivity {

    EditText date,category,time;
    DatePickerDialog.OnDateSetListener setListener;
    Button electricity,medicine, other;

    int hr, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        category = findViewById(R.id.category);
        time = findViewById(R.id.time_id);

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        FormActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        hr = i;
                        min = i1;
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(0,0,0,hr,min);
                        time.setText(DateFormat.format("hh:mm aa",calendar));
                    }
                },12,0,false);
                timePickerDialog.updateTime(hr,min);
                timePickerDialog.show();
            }
        });


        electricity = findViewById(R.id.btn_elec);
        medicine = findViewById(R.id.btn_medicines);
        other = findViewById(R.id.btn_others);

        electricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category.setText("Electrical Gadget");
            }
        });

        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category.setText("Medicines");
            }
        });

        other.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category.setText("Others");
            }
        });

        date = findViewById(R.id.date_id);

        Calendar calendar = Calendar.getInstance();
        final  int year = calendar.get(Calendar.YEAR);
        final  int month = calendar.get(Calendar.MONTH);
        final  int day = calendar.get(Calendar.DAY_OF_MONTH);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        FormActivity.this,android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {
                month = month +1;
                String dt = day + "/" + month + "/" + year;
                date.setText(dt);
            }
        };
    }
}




















