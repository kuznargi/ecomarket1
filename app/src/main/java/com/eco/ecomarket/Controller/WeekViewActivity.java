package com.eco.ecomarket.Controller;

import static com.eco.ecomarket.Model.CalendarUtils.daysInWeekArray;
import static com.eco.ecomarket.Model.CalendarUtils.monthYearFromDate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.eco.ecomarket.Adapter.CalendarAdapter;
import com.eco.ecomarket.Adapter.TaskAdapter;
import com.eco.ecomarket.Model.CalendarUtils;
import com.eco.ecomarket.Interface.CalendarRecyclerViewInterface;
import com.eco.ecomarket.Model.TaskModel;
import com.eco.ecomarket.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class WeekViewActivity extends AppCompatActivity implements CalendarRecyclerViewInterface {
    TextView monthYearText;
    RecyclerView calendarRecyclerView;
    Button next,back;
    ListView taskListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_week_view);
        initWidgets();
        CalendarUtils.selectedDate = LocalDate.now();
        setWeekView();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusWeeks(1);
                setWeekView();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusWeeks(1);
                setWeekView();
            }
        });


    }
    public void initWidgets() {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
        next=findViewById(R.id.btnNext);
        back=findViewById(R.id.btnBack);
        taskListView=findViewById(R.id.taskListView);
    }

    private void setWeekView() {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager); // Set the layout manager
        calendarRecyclerView.setAdapter(calendarAdapter);
        setTaskAdapter();
    }

    @Override
    public void onResume() {
        super.onResume();
        setTaskAdapter();
    }

    private void setTaskAdapter() {
        ArrayList<TaskModel> dailyTasks=TaskModel.taskForDate(CalendarUtils.selectedDate);
        TaskAdapter taskAdapter=new TaskAdapter(getApplicationContext(), dailyTasks);
        taskListView.setAdapter(taskAdapter);
    }

    @Override
    public void OnItemClick(int position, LocalDate date) {
        CalendarUtils.selectedDate=date;
        setWeekView();
    }
}