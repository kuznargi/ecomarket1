package com.eco.ecomarket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.utils.Utils;
import com.eco.ecomarket.Model.CalendarUtils;
import com.eco.ecomarket.Model.TaskModel;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddTaskActivity extends AppCompatActivity {
    EditText eventNameET;
    TextView eventDateTV,eventTimeTV;
    LocalTime time;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        initWidget();
        time=LocalTime.now();
        eventDateTV.setText("Date:"+ CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time:"+ CalendarUtils.formattedTime(time));

    }  private void initWidget(){
        eventNameET=findViewById(R.id.eventNameET);
        eventDateTV=findViewById(R.id.eventDate);
        eventTimeTV=findViewById(R.id.eventTime);
        save=findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String eventName=eventNameET.getText().toString();
                LocalDate date=CalendarUtils.selectedDate;
                TaskModel newEvent=new TaskModel(eventName,date,time);
                TaskModel.taskList.add(newEvent);
                finish();
            }
        });
    }

}