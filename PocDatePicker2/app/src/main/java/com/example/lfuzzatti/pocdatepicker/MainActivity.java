package com.example.lfuzzatti.pocdatepicker;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDatePicker(View view) {
        DialogFragment dateFragment = new DialogDateFragment();
        dateFragment.show(getSupportFragmentManager(), "datePicker");
    }
}
