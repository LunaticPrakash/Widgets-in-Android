package com.lunatic.widgets;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class SecondActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView spinnerStatus, seekBarStatus;
    private SeekBar seekBar;
    protected FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(LayoutParams.FLAG_SECURE, LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_second);

        spinner = findViewById(R.id.spinner);
        spinnerStatus = findViewById(R.id.statusSpinner);
        seekBar = findViewById(R.id.seekBar);
        seekBarStatus = findViewById(R.id.statusSeekBar);
        floatingActionButton = findViewById(R.id.floatingActionButton2);


        seekBarProgressDisplay();
        floatingButton_OnClick();
    }


    //SeekBar Progress Display Method
    private void seekBarProgressDisplay() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarStatus.setText(String.format(getString(R.string.statusProgress), progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }


    //Button OnClick for Alert Dialog
    public void showAlertDialog(View view) {
        creatingAlertDialog();
    }

    //Creating Alert Dialog
    private void creatingAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("EXIT");
        builder.setMessage("Do you want to close this activity?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    //Spinner OnClick method
    public void spinnerOnClick(View view) {
        spinnerStatus.setText(String.format("Status : %s", spinner.getSelectedItem()));
    }


    private void floatingButton_OnClick() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

}