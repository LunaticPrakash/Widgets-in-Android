package com.lunatic.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import static java.lang.String.*;
public class FourthActivity extends AppCompatActivity {

    private TextView displayTime;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        displayTime = findViewById(R.id.timeDisplayTextView);
        timePicker = findViewById(R.id.timePicker);
    }

    public void onClickDisplayTime(View view) {
        displayTime.setText(format("Time : %s", getCurrentTime()));
    }

    //Getting Current Time
    private String getCurrentTime() {
        int hour=0,min=0;
        StringBuilder stringBuilder = new StringBuilder();
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            hour = timePicker.getHour();
        }
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            min = timePicker.getMinute();
        }

        stringBuilder.append(hour).append(" : ").append(min);
        return stringBuilder.toString();
    }
}
