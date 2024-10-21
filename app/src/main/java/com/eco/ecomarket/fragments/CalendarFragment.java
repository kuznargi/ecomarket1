package com.eco.ecomarket.fragments;

import static com.eco.ecomarket.Model.CalendarUtils.daysInMonthArray;
import static com.eco.ecomarket.Model.CalendarUtils.monthYearFromDate;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.eco.ecomarket.Adapter.CalendarAdapter;
import com.eco.ecomarket.Model.CalendarUtils;
import com.eco.ecomarket.Interface.CalendarRecyclerViewInterface;
import com.eco.ecomarket.R;
import com.eco.ecomarket.Controller.WeekViewActivity;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarFragment extends Fragment implements CalendarRecyclerViewInterface {
    TextView monthYearText;
    RecyclerView calendarRecyclerView;

    Button next,back,weeklyCalendar;
    Intent intent;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        initWidgets(view);
        CalendarUtils.selectedDate = LocalDate.now();
        setMonthView();

        weeklyCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              intent=new Intent(getContext(), WeekViewActivity.class);
              startActivity(intent);

            }
            });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.plusMonths(1);
                setMonthView();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalendarUtils.selectedDate = CalendarUtils.selectedDate.minusMonths(1);
                setMonthView();
            }
        });
        return view;
    }

    public void initWidgets(View view) {
        calendarRecyclerView = view.findViewById(R.id.calendarRecyclerView);
        monthYearText = view.findViewById(R.id.monthYearTV);
        next=view.findViewById(R.id.btnNext);
        back=view.findViewById(R.id.btnBack);
        weeklyCalendar=view.findViewById(R.id.weekly);
    }

    private void setMonthView() {
        monthYearText.setText(monthYearFromDate(CalendarUtils.selectedDate));
        ArrayList<LocalDate> daysInMonth = daysInMonthArray(CalendarUtils.selectedDate);
        CalendarAdapter calendarAdapter = new CalendarAdapter(daysInMonth, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 7);
        calendarRecyclerView.setLayoutManager(layoutManager); // Set the layout manager
        calendarRecyclerView.setAdapter(calendarAdapter);
    }





    @Override
    public void OnItemClick(int position, LocalDate date) {
      if(date!=null) {
          CalendarUtils.selectedDate = date;
          setMonthView();
      }

    }



}
