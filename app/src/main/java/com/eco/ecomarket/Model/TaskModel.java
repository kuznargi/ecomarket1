package com.eco.ecomarket.Model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class TaskModel {

    public static ArrayList<TaskModel> taskList= new ArrayList<>();
    public static ArrayList<TaskModel> taskForDate(LocalDate date){
        ArrayList<TaskModel> tasks=new ArrayList<>();
        for(TaskModel task:taskList){
            if(task.getDate().equals(date)){
                tasks.add(task);
            }
        }
        return  tasks;

    }
    private String name;
    private LocalDate date;
    private LocalTime time;

    public TaskModel(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
