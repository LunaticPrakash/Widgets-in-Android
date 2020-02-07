# Widgets-in-Android
This repo contains implementation of all widgets in Android with clean and modular source code.

## Purpose :- 

To undesrtand the code of each widget or just simply Ctrl+c and Ctrl+v to use it in your project.

## Widgets available :-

1. Toggle Button
2. Check Box
3. Radio Button
4. Rating Bar
5. Floating Action Button
6. Alert Dialog
7. Spinner
8. SeekBar
9. Date Picker
10. Time Picker

## Description :-

### 1. Toggle Button Usage 
 
#### In XML File :- 

```
 <ToggleButton
        android:id="@+id/toggleButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textOff="OFF"
        android:textOn="ONN"
        android:layout_marginTop="20dp"
        />
```

#### In Java File :-
```
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
   ```
   
   

### 2. CheckBox Usage 
 
### In XML File :- 

```
<CheckBox
        android:id="@+id/checkBox1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="20dp"
        android:text="Check Box 1"
        />
```

#### In Java File :-
Use below function to get checked item.
```
isChecked() : To check if CheckBox is ticked or not
   ```   
   
 
### 3. RadioButton Usage 
 
#### In XML File :- 

**Radio Group** ensures that only one radio butoon get selected at a time.

```
 <RadioGroup
        android:id="@+id/rg1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        >

        <RadioButton
            android:id="@+id/radioButton1"
            android:layout_marginTop="10dp"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Radio Button 1" />

        <RadioButton
            android:id="@+id/radioButton2"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Radio Button 2" />
    </RadioGroup>>
```

#### In Java File :-
```
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
   ```    
  
  
### 4. RatingBar Usage 
 
#### In XML File :- 

```
    <RatingBar
        android:id="@+id/ratingBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        />
```

#### In Java File :-
To get the rating in String format below code can be used.
```
     String rating = String.valueOf(ratingBar.getRating());
   ```  
   
   
### 5. Floating Action Button Usage 
 
#### In XML File :- 

```
   com.google.android.material.floatingactionbutton.FloatingActionButton
        android:id="@+id/floatingActionButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="480dp"
        android:layout_marginStart="280dp"
        android:onClick="onClickFloatButton1"
        android:clickable="true"
        android:src="@drawable/ic_stat_name"
        android:focusable="true" />
```

#### In Java File :-

Just Use onClick attribute of XML to handle click event.

```
    public void onClickFloatButton1(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
   ```    
   
   
   
  
  
### 6. Alert Dialog Usage 
 
#### In XML File :- 
No code needed .

#### In Java File :-
**AlertDialog.Builder** is used to create the the dialog while **AlertDialog** is used to show it.
```
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
   ```   
   
   
 ### 7. Spinner Usage 
 
#### In XML File :- 

Replace the entries with your desired array.
```
  <Spinner
        android:id="@+id/spinner"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="160dp"
        android:entries="@array/cars"
        />
```

#### In Java File :-
To get the selected item in spinner we have to use the below code.
```
  String item = (String) spinner.getSelectedItem();
```

 ### 8. SeekBar Usage 
 
#### In XML File :- 
```
 <androidx.appcompat.widget.AppCompatSeekBar
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="80dp"
        android:layout_marginEnd="80dp"
        android:id="@+id/seekBar"
        android:layout_marginTop="20dp"
        />
  ```

#### In Java File :-

```
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
    
```


 ### 9. Date Picker 
 
#### In XML File :- 
```
<DatePicker
        android:layout_marginLeft="20dp"
        android:layout_marginRight="20dp"
        android:layout_marginTop="20dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/datePicker"
        />
  ```

#### In Java File :-

```
private String getCurrentDate() {
        StringBuilder stringBuilder = new StringBuilder();
        int month = datePicker.getMonth() + 1;  //As it counts month from 0
        int  day = datePicker.getDayOfMonth() ;
        int year = datePicker.getYear();

        stringBuilder.append(day).append("/").append(month).append("/").append(year);
        return  stringBuilder.toString();
    
```

 ### 10. Time Picker 
 
#### In XML File :- 
```
<TimePicker
        android:id="@+id/timePicker"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="20dp"
        android:layout_marginRight="20dp" />
  ```

#### In Java File :-

```
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
    
```


        
    
