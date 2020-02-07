package com.lunatic.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;



public class MainActivity extends AppCompatActivity {

    private ToggleButton mToggleButton;
    private TextView mStatusToggleButton, mStatusCheckBox, mStatusRadioGroup, mStatusRatingBar;
    private CheckBox cb1,cb2;
    private RadioGroup rg1;
    private RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializingFields();
        toggleButton_OnCLickEvent();
        radioButton_OnClickEvent();
    }



    private void initializingFields() {

        mToggleButton = findViewById(R.id.toggleButton);
        mStatusToggleButton = findViewById(R.id.statusToggleButton);
        cb1 = findViewById(R.id.checkBox1);
        cb2 = findViewById(R.id.checkBox2);
        mStatusCheckBox = findViewById(R.id.statusCheckBox);
        rg1 = findViewById(R.id.rg1);
        mStatusRadioGroup = findViewById(R.id.statusRadioButton);
        ratingBar = findViewById(R.id.ratingBar);
        mStatusRatingBar = findViewById(R.id.statusRatingBar);

    }


    private void toggleButton_OnCLickEvent() {

        mToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mToggleButton.isChecked())
                    mStatusToggleButton.setText(R.string.statusToggleOn);

                else
                    mStatusToggleButton.setText(R.string.statusToggleOff);


            }
        });
    }

    private void radioButton_OnClickEvent() {
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){

                    case R.id.radioButton1:
                        mStatusRadioGroup.setText(R.string.RadioButton1Selected);
                        break;

                    case R.id.radioButton2:
                        mStatusRadioGroup.setText(R.string.RadioButton2Selected);
                        break;
                }
            }
        });
    }




    //Check Box status after submit button is clicked
    public void checkBoxClick(View view) {

        if(cb1.isChecked() && cb2.isChecked())
            mStatusCheckBox.setText(R.string.BothTickedCheckBox);

        else if(cb1.isChecked() && !cb2.isChecked())
            mStatusCheckBox.setText(R.string.statusCheckBox1Ticked);

        else if(!cb1.isChecked() && cb2.isChecked())
            mStatusCheckBox.setText(R.string.statusCheckBox2Ticked);

        else
            mStatusCheckBox.setText(R.string.BothNotTickedCheckbox);

    }


    //Rating Bar status after submit button is clicked
    public void ratingBarClick(View view) {
      String rating = String.valueOf(ratingBar.getRating());
      mStatusRatingBar.setText(String.format("%s%s", getString(R.string.StatusRatingBar), rating));

    }

    public void onClickFloatButton1(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}

