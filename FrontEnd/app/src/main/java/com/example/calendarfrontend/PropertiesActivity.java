package com.example.calendarfrontend;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PropertiesActivity extends AppCompatActivity {

    private static final String TAG = "PropertiesActivity";

    private TextView theDate;
    private Button btnAddToCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_properties);
        theDate = (TextView) findViewById(R.id.date);
        btnAddToCalendar = (Button) findViewById(R.id.btnSaveToCalendar);


        btnAddToCalendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PropertiesActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

    }
}