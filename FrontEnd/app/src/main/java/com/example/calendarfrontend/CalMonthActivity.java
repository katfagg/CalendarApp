package com.example.calendarfrontend;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class CalMonthActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CalMonthActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cal_month_layout);
    }

//    Buttons
    @Override
    public void onClick(View view)
    {
        switch (view.getId()) {
            case R.id.previousMonth:
                // Do something
            case R.id.nextMonth:
                // Do something
        }
    }


}
