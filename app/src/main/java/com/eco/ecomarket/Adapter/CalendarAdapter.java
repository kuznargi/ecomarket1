package com.eco.ecomarket.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eco.ecomarket.Model.CalendarUtils;
import com.eco.ecomarket.Interface.CalendarRecyclerViewInterface;
import com.eco.ecomarket.R;

import java.time.LocalDate;
import java.util.ArrayList;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.CalendarViewHolder>{

    private final ArrayList<LocalDate> days;
    private  final CalendarRecyclerViewInterface calendarRecyclerViewInterface;
    public CalendarAdapter( ArrayList<LocalDate> days,CalendarRecyclerViewInterface calendarRecyclerViewInterface) {
        this.days = days;
        this.calendarRecyclerViewInterface=calendarRecyclerViewInterface;
    }

    @NonNull
    @Override
    public CalendarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view =inflater.inflate(R.layout.calendar_cell,parent,false);
        ViewGroup.LayoutParams layoutParams=view.getLayoutParams();
        if(days.size()>15)
            layoutParams.height=(int)(parent.getHeight()*0.166666666);
        else
            layoutParams.height=(int) parent.getHeight();

        return new CalendarViewHolder(view,calendarRecyclerViewInterface,days);
    }

    @Override
    public void onBindViewHolder(@NonNull CalendarViewHolder holder, int position) {
        final LocalDate date = days.get(position);

        if (date == null) {
            holder.dayOfMonth.setText(""); // Handle null dates
            holder.parentView.setBackgroundColor(Color.TRANSPARENT); // Reset background for empty cells
        } else {
            holder.dayOfMonth.setText(String.valueOf(date.getDayOfMonth())); // Safely convert day to string
            if (date.equals(CalendarUtils.selectedDate)) {
                holder.parentView.setBackgroundColor(Color.LTGRAY); // Highlight selected date
            } else {
                holder.parentView.setBackgroundColor(Color.TRANSPARENT); // Reset background for non-selected dates
            }
        }
    }


    @Override
    public int getItemCount() {
        return days.size();
    }
    public  class CalendarViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{
        private final ArrayList<LocalDate> days;
        View parentView;
        TextView dayOfMonth;
        CalendarRecyclerViewInterface onItemListener;
        public CalendarViewHolder(@NonNull View itemView,CalendarRecyclerViewInterface onItemListener,ArrayList<LocalDate> days) {
            super(itemView);
            dayOfMonth=itemView.findViewById(R.id.cellDayText);
            parentView=itemView.findViewById(R.id.parentView);
            this.onItemListener=onItemListener;
            itemView.setOnClickListener(this);
            this.days=days;
        }


        @Override
        public void onClick(View v) {
            onItemListener.OnItemClick(getAdapterPosition(),days.get(getAdapterPosition()));
        }
    }
}
