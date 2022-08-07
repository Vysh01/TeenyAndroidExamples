package com.thecodecity.teenyexamples;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActivityDateTimePickers extends AppCompatActivity {

    private void showTimePicker(Button btnPickTime) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                btnPickTime.setText(i + ":" + i1);
            }
        }, Calendar.HOUR_OF_DAY, Calendar.MINUTE, false);
        timePickerDialog.show();

    }

    private void showDatePicker(Button btn) {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(i, i1, i2);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-d");
                btn.setText(format.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
}
