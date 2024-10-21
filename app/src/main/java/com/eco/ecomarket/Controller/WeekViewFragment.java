package com.eco.ecomarket.Controller;

import static com.eco.ecomarket.Model.CalendarUtils.daysInWeekArray;
import static com.eco.ecomarket.Model.CalendarUtils.monthYearFromDate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.eco.ecomarket.Adapter.CalendarAdapter;
import com.eco.ecomarket.Adapter.TaskAdapter;
import com.eco.ecomarket.Model.CalendarUtils;
import com.eco.ecomarket.Interface.CalendarRecyclerViewInterface;
import com.eco.ecomarket.Model.TaskModel;
import com.eco.ecomarket.R;

import java.time.LocalDate;
import java.util.ArrayList;


public class WeekViewFragment extends Fragment implements CalendarRecyclerViewInterface {

    TextView monthYearText;
    RecyclerView calendarRecyclerView;
    Button next,back;
    ListView taskListView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_week_view, container, false);
        initWidgets(view);
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
        return view;
    }
    public void initWidgets(View view) {
        calendarRecyclerView = view.findViewById(R.id.calendarRecyclerView);
        monthYearText = view.findViewById(R.id.monthYearTV);
        next=view.findViewById(R.id.btnNext);
        back=view.findViewById(R.id.btnBack);
        taskListView=view.findViewById(R.id.taskListView);
    }

    private void setWeekView() {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> days = daysInWeekArray(CalendarUtils.selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(days, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7);
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
        TaskAdapter taskAdapter=new TaskAdapter(getContext().getApplicationContext(), dailyTasks);
        taskListView.setAdapter(taskAdapter);
    }

    @Override
    public void OnItemClick(int position, LocalDate date) {
        CalendarUtils.selectedDate=date;
        setWeekView();
    }

}