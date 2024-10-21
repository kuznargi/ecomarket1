package com.eco.ecomarket.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.eco.ecomarket.Model.CalendarUtils;
import com.eco.ecomarket.Model.TaskModel;
import com.eco.ecomarket.R;

import java.time.LocalTime;


public class AddEventFragment extends Fragment {

    EditText eventNameET;
    TextView eventDateTV,eventTimeTV;
    LocalTime time;
    Button save;

    public AddEventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_add_event, container, false);
        initWidget(view);
        time=LocalTime.now();
        eventDateTV.setText("Date: "+ CalendarUtils.formattedDate(CalendarUtils.selectedDate));
        eventTimeTV.setText("Time: "+CalendarUtils.formattedTime(time));
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName=eventNameET.getText().toString();
                TaskModel newTask=new TaskModel(taskName,CalendarUtils.selectedDate,time);
                TaskModel.taskList.add(newTask);


            }
        });
        return view;
    }
    private void initWidget(View view){
        eventNameET=view.findViewById(R.id.eventNameET);
        eventDateTV=view.findViewById(R.id.eventDate);
        eventTimeTV=view.findViewById(R.id.eventTime);
        save=view.findViewById(R.id.save);
    }

}