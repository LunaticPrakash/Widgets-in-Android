package com.lunatic.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    private TextView displayDate;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        displayDate = findViewById(R.id.dateDisplayTextView);
        datePicker = findViewById(R.id.datePicker);
    }

    public void onClickDisplayDate(View view) {
        displayDate.setText(String.format("Date : %s", getCurrentDate()));
    }

    //Getting Current Date
    private String getCurrentDate() {
        StringBuilder stringBuilder = new StringBuilder();
        int month = datePicker.getMonth() + 1;  //As it counts month from 0
        int  day = datePicker.getDayOfMonth() ;
        int year = datePicker.getYear();

        stringBuilder.append(day).append("/").append(month).append("/").append(year);
        return  stringBuilder.toString();

    }

    //Floating Action Button
    public void onClickFloatButton3(View view) {
        Intent intent = new Intent(ThirdActivity.this,FourthActivity.class);
        startActivity(intent);
    }

}
