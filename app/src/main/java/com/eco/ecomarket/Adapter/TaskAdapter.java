package com.eco.ecomarket.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.eco.ecomarket.Model.CalendarUtils;
import com.eco.ecomarket.Model.TaskModel;
import com.eco.ecomarket.R;

import java.util.List;

public class TaskAdapter extends ArrayAdapter<TaskModel> {
    public TaskAdapter(@NonNull Context context, List<TaskModel> tasks) {
        super(context, 0,tasks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        TaskModel task=getItem(position);
        if(convertView==null)
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.task_cell,parent,false);
        TextView eventCellTV=convertView.findViewById(R.id.eventCellTv);
        String eventTitle=task.getName()+ " "+ CalendarUtils.formattedTime(task.getTime()) ;
        eventCellTV.setText(eventTitle);
        return convertView;




    }
}
